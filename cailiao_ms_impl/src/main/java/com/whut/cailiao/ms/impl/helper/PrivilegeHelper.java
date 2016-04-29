package com.whut.cailiao.ms.impl.helper;

import com.whut.cailiao.ms.api.model.privilege.Privilege;
import org.apache.commons.collections4.CollectionUtils;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by gammaniu on 16/4/22.
 */
public class PrivilegeHelper {

    private static Map<Privilege, Integer> map = new HashMap<>();

    public static void setPrivilegeMap(List<Privilege> privilegeList) {
        if (CollectionUtils.isNotEmpty(privilegeList)) {
            for (Privilege privilege : privilegeList) {
                map.put(privilege, privilege.getId());
            }
        }
    }

    public static Map<Privilege, Integer> getPrivilegeMap() {
        return map;
    }
}
