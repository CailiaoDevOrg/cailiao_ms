package com.whut.cailiao.ms.impl.dao.privilege;

import com.whut.cailiao.ms.api.model.privilege.Privilege;

import java.util.List;

/**
 * Created by gammaniu on 16/4/20.
 */
public interface PrivilegeDao {

    void createNewPrivilege(Privilege privilege);

    List<Privilege> getPrivilegeList();

    void deleteById(int id);
}
