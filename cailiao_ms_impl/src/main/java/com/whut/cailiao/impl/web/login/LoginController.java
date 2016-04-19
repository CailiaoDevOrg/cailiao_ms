package com.whut.cailiao.impl.web.login;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * Created by niuyang on 16/4/1.
 */
@Controller
public class LoginController {

    @RequestMapping(value = "/login.html", method = RequestMethod.POST)
    public String navigateToLoginPage() {
        return "login/login";
    }
    
    @RequestMapping(value = "/checkcode.html", method = RequestMethod.GET)
    public String navigateToCheckcode() {
        return "login/checkcode";
    }

}
