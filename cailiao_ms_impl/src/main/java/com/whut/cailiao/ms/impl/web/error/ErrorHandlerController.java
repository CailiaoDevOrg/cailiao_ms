package com.whut.cailiao.ms.impl.web.error;

import org.springframework.boot.autoconfigure.web.ErrorController;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * Created by gammaniu on 16/4/20.
 */
@Controller
public class ErrorHandlerController implements ErrorController {

    @RequestMapping(value="/error")
    public String handleError(){
        return "error/404";
    }

    @Override
    public String getErrorPath() {
        return "/error";
    }

}
