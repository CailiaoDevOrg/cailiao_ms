package com.whut.cailiao.impl.web.privilege;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * Created by gammaniu on 16/4/20.
 */
@Controller
@RequestMapping("/privilege")
public class PrivilegeController {

    @RequestMapping(value = "/create.html", method = RequestMethod.GET)
    public String navigateToCreatePage() {
        return "privilege/create";
    }
}
