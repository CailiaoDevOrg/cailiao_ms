package com.whut.cailiao.ms.api.service.privilege;

import com.whut.cailiao.ms.api.commons.ApiResponse;
import com.whut.cailiao.ms.api.model.privilege.Privilege;

import java.util.List;

/**
 * Created by gammaniu on 16/4/20.
 */
public interface PrivilegeService {

    ApiResponse create(List<Privilege> privilege);

    ApiResponse getList();

    ApiResponse deleteById(int id);

}
