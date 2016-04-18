package com.whut.cailiao.impl.dao.user;

import com.whut.cailiao.api.model.user.User;

/**
 * Created by gammaniu on 16/4/18.
 */
public interface UserDao {

    User getUserByAccount(String accountId);
}
