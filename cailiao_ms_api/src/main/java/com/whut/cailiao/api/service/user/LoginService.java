package com.whut.cailiao.api.service.user;

import com.whut.cailiao.api.commons.ApiResponse;

/**
 * Created by gammaniu on 16/4/18.
 */
public interface LoginService {

    ApiResponse login(String accountId, String md5password);

}
