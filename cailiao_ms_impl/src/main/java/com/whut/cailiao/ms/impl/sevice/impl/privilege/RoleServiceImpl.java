package com.whut.cailiao.ms.impl.sevice.impl.privilege;

import com.whut.cailiao.ms.api.commons.ApiResponse;
import com.whut.cailiao.ms.api.commons.ApiResponseCode;
import com.whut.cailiao.ms.api.model.privilege.Privilege;
import com.whut.cailiao.ms.api.model.privilege.Role;
import com.whut.cailiao.ms.api.model.privilege.RoleEditData;
import com.whut.cailiao.ms.api.model.privilege.RolePrivilege;
import com.whut.cailiao.ms.api.service.privilege.RoleService;
import com.whut.cailiao.ms.impl.dao.privilege.PrivilegeDao;
import com.whut.cailiao.ms.impl.dao.privilege.RoleDao;
import com.whut.cailiao.ms.impl.dao.privilege.RolePrivilegeDao;
import com.whut.cailiao.ms.impl.dao.privilege.UserRoleDao;
import org.apache.commons.collections4.CollectionUtils;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

/**
 * Created by gammaniu on 16/4/18.
 */
@Service("roleService")
public class RoleServiceImpl implements RoleService {

    @Autowired
    private RoleDao roleDao;

    @Autowired
    private RolePrivilegeDao rolePrivilegeDao;

    @Autowired
    private PrivilegeDao privilegeDao;

    @Autowired
    private UserRoleDao userRoleDao;


    @Override
    public ApiResponse getPrivilegeIdsByRoleId(Set<Integer> roleIds) {
        ApiResponse response = ApiResponse.createDefaultApiResponse();
        if (CollectionUtils.isEmpty(roleIds)) {
            response.setRetCode(ApiResponseCode.PARAM_ERROR);
            return response;
        }
        Set<Integer> privilegeIds = new HashSet<>();
        for (Integer roleId : roleIds) {
            List<RolePrivilege> rolePrivilegeList = this.rolePrivilegeDao.getRolePrivilegeMapEntryListByRoleId(roleId);
            if (CollectionUtils.isNotEmpty(rolePrivilegeList)) {
                privilegeIds.addAll(rolePrivilegeList.stream().map(RolePrivilege::getPrivilegeId).collect(Collectors.toList()));
            }
        }
        response.addBody("privilegeIds", privilegeIds);
        return response;
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
        Set<Integer> privilegeIds = role.getPrivilegeIds();
        if (CollectionUtils.isNotEmpty(privilegeIds)) {
            Role roleInDB = this.roleDao.selectRoleByName(role.getName());
            for (Integer privilegeId : privilegeIds) {
                this.rolePrivilegeDao.createNewRolePrivilegeMapEntry(new RolePrivilege(roleInDB.getId(), privilegeId));
            }
        }
        return response;
    }

    @Override
    public ApiResponse getRoleList() {
        ApiResponse response = ApiResponse.createDefaultApiResponse();
        response.addBody("roleList", this.roleDao.selectAllRole());
        return response;
    }

    @Transactional
    @Override
    public ApiResponse deleteRoleById(int id) {
        ApiResponse response = ApiResponse.createDefaultApiResponse();
        if (id <= 0) {
            response.setRetCode(ApiResponseCode.PARAM_ERROR);
            return response;
        }
        this.roleDao.deleteById(id);
        this.rolePrivilegeDao.deleteByRoleId(id);
        this.userRoleDao.deleteEntryByRoleId(id);
        return response;
    }

    @Override
    public ApiResponse getRoleEditData(int id) {
        ApiResponse response = ApiResponse.createDefaultApiResponse();
        if (id <= 0) {
            response.setRetCode(ApiResponseCode.PARAM_ERROR);
            return response;
        }
        Role role = this.roleDao.selectRoleById(id);
        if (role == null) {
            response.setRetCode(ApiResponseCode.PARAM_ERROR);
            return response;
        }
        List<RolePrivilege> rolePrivilegeMapEntryList = this.rolePrivilegeDao.getRolePrivilegeMapEntryListByRoleId(id);
        if (CollectionUtils.isNotEmpty(rolePrivilegeMapEntryList)) {
            Set<Integer> privilegeIds = rolePrivilegeMapEntryList.stream().map(RolePrivilege::getPrivilegeId).collect(Collectors.toSet());
            role.setPrivilegeIds(privilegeIds);
        }
        List<Privilege> privilegeList = this.privilegeDao.getPrivilegeList();
        RoleEditData roleEditData = new RoleEditData(role, privilegeList);
        response.addBody("roleEditData", roleEditData);
        return response;
    }

    @Transactional
    @Override
    public ApiResponse updateRole(Role role) {
        ApiResponse response = ApiResponse.createDefaultApiResponse();
        if (role == null || role.getId() == null || StringUtils.isBlank(role.getName())) {
            response.setRetCode(ApiResponseCode.PARAM_ERROR);
            return response;
        }
        // 更新角色基本信息
        this.roleDao.updateRole(role);
        // 删除角色关联的接口信息
        this.rolePrivilegeDao.deleteByRoleId(role.getId());
        // 建立接口的关联信息
        Set<Integer> privilegeIds = role.getPrivilegeIds();
        if (CollectionUtils.isNotEmpty(privilegeIds)) {
            for (Integer privilegeId : privilegeIds) {
                this.rolePrivilegeDao.createNewRolePrivilegeMapEntry(new RolePrivilege(role.getId(), privilegeId));
            }
        }
        return response;
    }


}
