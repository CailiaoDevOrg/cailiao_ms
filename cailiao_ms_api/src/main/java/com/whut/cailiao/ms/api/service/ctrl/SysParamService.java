package com.whut.cailiao.ms.api.service.ctrl;

import com.whut.cailiao.ms.api.commons.ApiResponse;

/**
 * Created by gammaniu on 16/4/22.
 */
public interface SysParamService {

    ApiResponse refreshACL();

    ApiResponse signOutAll();

}
