package com.whut.cailiao.impl.web.login;

import com.whut.cailiao.api.commons.ApiResponse;
import com.whut.cailiao.api.model.user.User;
import com.whut.cailiao.api.service.user.LoginService;
import com.whut.cailiao.impl.utils.http.HttpUtil;
import com.whut.cailiao.impl.web.BaseController;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

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
        ApiResponse response = this.loginService.login(user.getAccountId(), user.getPassword(), checkcode);
        return convertApiResponseToJSONString(response);
    }

}
