package com.whut.cailiao.ms.impl.web.user;

import com.whut.cailiao.ms.api.constant.UserConstant;
import com.whut.cailiao.ms.api.service.user.UserService;
import com.whut.cailiao.ms.impl.utils.http.HttpUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.whut.cailiao.ms.api.commons.ApiResponse;
import com.whut.cailiao.ms.api.model.user.User;
import com.whut.cailiao.ms.api.service.user.LoginService;
import com.whut.cailiao.ms.impl.web.BaseController;

import javax.servlet.http.HttpSession;

/**
 * Created by niuyang on 16/4/1.
 */
@Controller
public class LoginController extends BaseController {

    @Autowired
    private LoginService loginService;

    @Autowired
    private UserService userService;

    @RequestMapping(value = "/login.html", method = RequestMethod.GET)
    public String navigateToLoginPage() {
        return "login/login";
    }

    @RequestMapping(value = "/register.html", method = RequestMethod.GET)
    public String navigateToRegisterPage() {
        return "login/register";
    }
    
    @RequestMapping(value = "/checkcode.html", method = RequestMethod.GET)
    public String navigateToCheckcode() {
        return "login/checkcode";
    }

    @RequestMapping(value = "/doLogin.html", method = RequestMethod.POST)
    @ResponseBody
    public String login(@RequestBody User user, @RequestParam String checkcode) {
        ApiResponse response = this.loginService.login(user, checkcode);
        return convertApiResponseToJSONString(response);
    }

    @RequestMapping(value = "/signout.html", method = RequestMethod.GET)
    public String signout() {
        HttpSession session = HttpUtil.getSession();
        session.removeAttribute("user");
        session.invalidate();
        return "redirect:/";
    }

    @RequestMapping(value = "/doRegister.html", method = RequestMethod.POST)
    @ResponseBody
    public String register(@RequestBody User user) {
        user.setStatus(UserConstant.Status.DISABLED.value());
        ApiResponse response = this.userService.createNewUser(user);
        return convertApiResponseToJSONString(response);
    }

}
