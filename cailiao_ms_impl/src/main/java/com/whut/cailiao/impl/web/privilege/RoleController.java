package com.whut.cailiao.impl.web.privilege;

import com.whut.cailiao.api.commons.ApiResponse;
import com.whut.cailiao.api.model.privilege.Role;
import com.whut.cailiao.api.service.privilege.RoleService;
import com.whut.cailiao.impl.web.BaseController;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

/**
 * Created by gammaniu on 16/4/21.
 */
@Controller
@RequestMapping("/role")
public class RoleController extends BaseController {

    @Autowired
    private RoleService roleService;

    @RequestMapping(value = "/create.html", method = RequestMethod.GET)
    public String navigateToCreatePage() {
        return "role/create";
    }

    @RequestMapping(value = "/create.html", method = RequestMethod.POST)
    @ResponseBody
    public String create(@RequestBody Role role) {
        ApiResponse response = this.roleService.createNewRole(role);
        return convertApiResponseToJSONString(response);
    }

    @RequestMapping(value = "/list.html", method = RequestMethod.GET)
    public String navigateToListPage() {
        return "role/list";
    }

    @RequestMapping(value = "/getList.html", method = RequestMethod.GET)
    @ResponseBody
    public String getList() {
        ApiResponse response = this.roleService.getRoleList();
        return convertApiResponseToJSONString(response);
    }

    @RequestMapping(value = "/delete/{id}.html", method = RequestMethod.DELETE)
    @ResponseBody
    public String delete(@PathVariable int id) {
        ApiResponse response = this.roleService.deleteRoleById(id);
        return convertApiResponseToJSONString(response);
    }

    @RequestMapping(value = "/edit/{id}.html", method = RequestMethod.GET)
    public String edit(@PathVariable int id, Model model) {
        model.addAttribute("roleId", id);
        return "role/edit";
    }

    @RequestMapping(value = "/getRoleEditData/{id}.html", method = RequestMethod.GET)
    @ResponseBody
    public String getRoleEditData(@PathVariable int id) {
        ApiResponse response = this.roleService.getRoleEditData(id);
        return convertApiResponseToJSONString(response);
    }

    @RequestMapping(value = "/update.html", method = RequestMethod.PUT)
    @ResponseBody
    public String updateRole(@RequestBody Role role) {
        ApiResponse response = this.roleService.updateRole(role);
        return convertApiResponseToJSONString(response);
    }
}
