package com.whut.cailiao.ms.impl.web.privilege;

import com.whut.cailiao.ms.api.commons.ApiResponse;
import com.whut.cailiao.ms.api.model.privilege.Privilege;
import com.whut.cailiao.ms.api.service.privilege.PrivilegeService;
import com.whut.cailiao.ms.impl.web.BaseController;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Created by gammaniu on 16/4/20.
 */
@Controller
@RequestMapping("/privilege")
public class PrivilegeController extends BaseController {

    @Autowired
    private PrivilegeService privilegeService;

    @RequestMapping(value = "/create.html", method = RequestMethod.GET)
    public String navigateToCreatePage() {
        return "privilege/create";
    }

    @RequestMapping(value = "/create.html", method = RequestMethod.POST)
    @ResponseBody
    public String create(@RequestBody List<Privilege> privileges) {
        ApiResponse response = this.privilegeService.create(privileges);
        return convertApiResponseToJSONString(response);
    }

    @RequestMapping(value = "/list.html", method = RequestMethod.GET)
    public String navigateToListPage() {
        return "privilege/list";
    }

    @RequestMapping(value = "/getList.html", method = RequestMethod.GET)
    @ResponseBody
    public String list() {
        ApiResponse response = this.privilegeService.getList();
        return convertApiResponseToJSONString(response);
    }

    @RequestMapping(value = "/delete/{id}.html", method = RequestMethod.DELETE)
    @ResponseBody
    public String delete(@PathVariable int id) {
        ApiResponse response = this.privilegeService.deleteById(id);
        return convertApiResponseToJSONString(response);
    }

}