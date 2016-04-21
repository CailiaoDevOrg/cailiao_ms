package com.whut.cailiao.impl.sevice.impl.privilege;

import com.whut.cailiao.api.commons.ApiResponse;
import com.whut.cailiao.api.commons.ApiResponseCode;
import com.whut.cailiao.api.model.user.Privilege;
import com.whut.cailiao.api.model.user.Role;
import com.whut.cailiao.api.model.user.RolePrivilege;
import com.whut.cailiao.api.service.privilege.RoleService;
import com.whut.cailiao.impl.dao.privilege.RoleDao;
import com.whut.cailiao.impl.dao.privilege.RolePrivilegeDao;
import com.whut.cailiao.impl.exception.TransactionExecuteException;
import org.apache.commons.collections4.CollectionUtils;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Set;

/**
 * Created by gammaniu on 16/4/18.
 */
@Service("roleService")
public class RoleServiceImpl implements RoleService {

    @Autowired
    private RoleDao roleDao;

    @Autowired
    private RolePrivilegeDao rolePrivilegeDao;

    @Override
    public Set<Privilege> getPrivilegesByRoleId(Set<Role> roles) {
        return null;
    }

    @Transactional
    @Override
    public ApiResponse createNewRole(Role role) {
        ApiResponse response = ApiResponse.createDefaultApiResponse();
        if (role.getId() != null || StringUtils.isBlank(role.getName())) {
            response.setRetCode(ApiResponseCode.PARAM_ERROR);
            return response;
        }
        this.roleDao.createNewRole(role);
        System.out.println("role = " + role);
        Set<Integer> privilegeIds = role.getPrivilegeIds();
        if (CollectionUtils.isNotEmpty(privilegeIds)) {
            Role roleInDB = this.roleDao.selectRoleByName(role.getName());
            for (Integer privilegeId : privilegeIds) {
                if (privilegeId == null) {
                    throw new TransactionExecuteException();
                }
                this.rolePrivilegeDao.createNewRolePrivilegeMapEntry(new RolePrivilege(roleInDB.getId(), privilegeId));
            }
        }
        return response;
    }
}
