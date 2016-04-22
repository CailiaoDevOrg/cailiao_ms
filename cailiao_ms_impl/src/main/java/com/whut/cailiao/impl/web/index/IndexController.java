package com.whut.cailiao.impl.web.index;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * Created by niuyang on 16/4/1.
 */
@Controller
public class IndexController {

    @RequestMapping(value = "/", method = RequestMethod.GET)
    public String index() {
        return "index/index";
    }

    @RequestMapping(value = { "/main/home.html"}, method = RequestMethod.GET)
    public String home() {
        return "home/home";
    }
    
    @RequestMapping(value = "/main/dashboard.html", method = RequestMethod.GET)
    public String dashboard() {
        return "home/dashboard";
    }

}
