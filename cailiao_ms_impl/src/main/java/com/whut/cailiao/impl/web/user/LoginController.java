package com.whut.cailiao.impl.web.user;

import com.whut.cailiao.impl.utils.http.HttpUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.whut.cailiao.api.commons.ApiResponse;
import com.whut.cailiao.api.model.user.User;
import com.whut.cailiao.api.service.user.LoginService;
import com.whut.cailiao.impl.web.BaseController;

import javax.servlet.http.HttpSession;

/**
 * Created by niuyang on 16/4/1.
 */
@Controller
public class LoginController extends BaseController {

    @Autowired
    private LoginService loginService;

    @RequestMapping(value = "/login.html", method = RequestMethod.GET)
    public String navigateToLoginPage() {
        return "login/login";
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
        return "redirect:/login.html";
    }

}
