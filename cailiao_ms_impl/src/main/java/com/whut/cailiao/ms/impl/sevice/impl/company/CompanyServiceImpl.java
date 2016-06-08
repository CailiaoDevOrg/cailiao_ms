package com.whut.cailiao.ms.impl.sevice.impl.company;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.alibaba.dubbo.common.utils.CollectionUtils;
import com.whut.cailiao.ms.api.commons.ApiResponse;
import com.whut.cailiao.ms.api.commons.ApiResponseCode;
import com.whut.cailiao.ms.api.model.company.Company;
import com.whut.cailiao.ms.api.model.company.CompanyFacade;
import com.whut.cailiao.ms.api.service.company.CompanyService;
import com.whut.cailiao.ms.impl.dao.company.CompanyDao;

@Service("companyService")
public class CompanyServiceImpl implements CompanyService {
	@Autowired
	private CompanyDao companyDao;

	@Override
	public ApiResponse getCompanyByAddress(String address) throws Exception {
		ApiResponse response = ApiResponse.createDefaultApiResponse();
		response.addBody("companys", convertBaseClazzToFacade(this.companyDao.getCompanyByAddress(address)));
		return response;
	}

	@Override
	public ApiResponse getAllCompany() throws Exception {
		// TODO Auto-generated method stub
		return null;
	}
	
	private List<CompanyFacade> convertBaseClazzToFacade(List<Company> companyList) {
		if (CollectionUtils.isNotEmpty(companyList)) {
			List<CompanyFacade> companyFacadeList = new ArrayList<>();
			for (Company c : companyList) {
				if (c != null) {
					companyFacadeList.add(new CompanyFacade(c));
				}
			}
			return companyFacadeList;
		}
		return Collections.emptyList();
	}

	@Override
	public ApiResponse remarkInvited(int id) throws Exception {
		ApiResponse response = ApiResponse.createDefaultApiResponse();
		if (id <= 0) {
            response.setRetCode(ApiResponseCode.PARAM_ERROR);
            return response;
        }
		this.companyDao.markInvited(id);
		return response;
	}

}
