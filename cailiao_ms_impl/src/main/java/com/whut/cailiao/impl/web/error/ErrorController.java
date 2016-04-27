package com.whut.cailiao.impl.web.error;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping("/error")
public class ErrorController {
	
	@RequestMapping(value="/low.html", method = RequestMethod.GET)
    public String handle405() {
        return "error/405";
    }

}
