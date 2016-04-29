package com.whut.cailiao.ms.impl.dao.user;

import java.util.List;

import com.whut.cailiao.ms.api.model.user.User;

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
