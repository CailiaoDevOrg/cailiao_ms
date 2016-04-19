package com.whut.cailiao.api.service.user;

import com.whut.cailiao.api.commons.ApiResponse;
import com.whut.cailiao.api.model.user.User;

/**
 * Created by gammaniu on 16/4/18.
 */
public interface LoginService {

    ApiResponse login(User user, String checkcode);

}
