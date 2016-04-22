package com.whut.cailiao.impl.sevice.impl.ctrl;

import com.whut.cailiao.api.commons.ApiResponse;
import com.whut.cailiao.api.service.ctrl.SysParamService;
import com.whut.cailiao.impl.dao.privilege.PrivilegeDao;
import com.whut.cailiao.impl.helper.PrivilegeHelper;
import org.apache.commons.collections4.MapUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by gammaniu on 16/4/22.
 */
@Service("sysParamService")
public class SysParamServiceImpl implements SysParamService {

    @Autowired
    private PrivilegeDao privilegeDao;

    @Override
    public ApiResponse refreshACL() {
        ApiResponse response = ApiResponse.createDefaultApiResponse();
        PrivilegeHelper.setPrivilegeMap(this.privilegeDao.getPrivilegeList());
        return response;
    }
}
