package com.whut.cailiao;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * Created by niuyang on 16/1/24.
 */
@Controller
public class TestController {

    @RequestMapping("/test.html")
    public @ResponseBody String test() {
        return "test";
    }

}
