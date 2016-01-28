package com.whut.cailiao.web;

import org.apache.log4j.Logger;
import org.slf4j.LoggerFactory;
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
        Logger logger = Logger.getLogger(HelloController.class);
        logger.error("error :[log4j testing]");
        logger.warn("warn : {hello warning}");
        return "test message";
    }


    @RequestMapping("/hellopage.html")
    public String hellopage() {
        return "hello";
    }
}
