package com.whut.cailiao.impl.web.user;

import com.alibaba.fastjson.JSON;
import com.whut.cailiao.api.model.user.User;
import com.whut.cailiao.impl.web.BaseController;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * Created by gammaniu on 16/4/19.
 */
@Controller
@RequestMapping("/user")
public class UserController extends BaseController {

    @RequestMapping(value = "/info.html", method = RequestMethod.GET)
    @ResponseBody
    public String getUser() {
        User user = getUserInfo();
        return JSON.toJSONString(user);
    }
}
