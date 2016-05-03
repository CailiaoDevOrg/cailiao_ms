package com.whut.cailiao.ms.impl.dao.user;

import com.whut.cailiao.ms.api.model.user.User;

import java.util.List;

/**
 * Created by gammaniu on 16/4/18.
 */
public interface UserDao {

    User getUserByAccount(String accountId);
    
    List<User> getUserList(int factoryId);
    
    List<User> getAllUserList();

    void deleteUserByAccountId(String accountId);

    void createNewUser(User user);

    void updateUser(User user);
    
    void updateUserStatus(User user);
}
