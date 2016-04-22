package com.whut.cailiao.impl.web.ctrl;

import com.whut.cailiao.api.commons.ApiResponse;
import com.whut.cailiao.api.service.ctrl.SysParamService;
import com.whut.cailiao.impl.web.BaseController;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * Created by gammaniu on 16/4/22.
 */
@Controller
@RequestMapping("/sysparam")
public class SystemParamController extends BaseController {

    @Autowired
    private SysParamService sysParamService;

    @RequestMapping(value = "/ini.html",method = RequestMethod.GET)
    public String navigateToMainPage() {
        return "ctrl/sysparam";
    }

    @RequestMapping(value = "/refreshACL.html", method = RequestMethod.GET)
    @ResponseBody
    public String refreshACL() {
        ApiResponse response = this.sysParamService.refreshACL();
        return convertApiResponseToJSONString(response);
    }

    @RequestMapping(value = "/signOutAll.html", method = RequestMethod.GET)
    @ResponseBody
    public String signOutAll() {
        ApiResponse response = this.sysParamService.signOutAll();
        return convertApiResponseToJSONString(response);
    }

}
