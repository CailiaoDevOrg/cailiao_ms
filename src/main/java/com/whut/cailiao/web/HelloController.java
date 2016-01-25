package com.whut.cailiao.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * Created by niuyang on 16/1/26.
 */
@Controller
public class HelloController {

    @RequestMapping("/test.html")
    public @ResponseBody String hello() {
        return "test message";
    }
}
