package com.whut.cailiao.impl.web.user;

import com.alibaba.fastjson.JSON;
import com.whut.cailiao.api.commons.ApiResponse;
import com.whut.cailiao.api.commons.ApiResponseCode;
import com.whut.cailiao.api.model.user.User;
import com.whut.cailiao.api.service.user.UserService;
import com.whut.cailiao.impl.utils.bean.BeanHelper;
import com.whut.cailiao.impl.web.BaseController;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

/**
 * Created by gammaniu on 16/4/19.
 */
@Controller
@RequestMapping("/user")
public class UserController extends BaseController {

    @Autowired
    private UserService userService;

    @RequestMapping(value = "/info.html", method = RequestMethod.GET)
    @ResponseBody
    public String getUser() {
        User user = new User(getUserInfo());
        return JSON.toJSONString(user);
    }
    
    @RequestMapping(value = "/create.html", method = RequestMethod.GET)
    public String navigateToCreatePage() {
        return "user/create";
    }
    
    @RequestMapping(value = "/list.html", method = RequestMethod.GET)
    public String navigateToListPage() {
        return "user/list";
    }

    @RequestMapping(value = "/getList.html", method = RequestMethod.GET)
    @ResponseBody
    public String getList() {
        User user = getUserInfo();
        ApiResponse response = this.userService.getUserList(user.getFactoryId());
        return convertApiResponseToJSONString(response);
    }

    @RequestMapping(value = "/delete/{accountId}.html", method = RequestMethod.DELETE)
    @ResponseBody
    public String delete(@PathVariable String accountId) {
        ApiResponse response = this.userService.deleteUserByAccountId(accountId);
        return convertApiResponseToJSONString(response);
    }

    @RequestMapping(value = "/create.html", method = RequestMethod.POST)
    @ResponseBody
    public String create(@RequestBody User user) {
        ApiResponse response = this.userService.createNewUser(user);
        return convertApiResponseToJSONString(response);
    }

    @RequestMapping(value = "/edit/{accountId}.html", method = RequestMethod.GET)
    public String renderEditPage(@PathVariable String accountId, Model model) {
        model.addAttribute("accountId", accountId);
        return "user/edit";
    }

    @RequestMapping(value = "/getUserEditData/{accountId}.html", method = RequestMethod.GET)
    @ResponseBody
    public String getUserEditData(@PathVariable String accountId) {
        ApiResponse response = this.userService.getUserEditData(accountId);
        return convertApiResponseToJSONString(response);
    }

    @RequestMapping(value = "/update.html", method = RequestMethod.PUT)
    @ResponseBody
    public String update(@RequestBody User user) {
        ApiResponse response = this.userService.updateUser(user);
        return convertApiResponseToJSONString(response);
    }


}
