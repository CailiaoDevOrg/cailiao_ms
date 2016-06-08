package com.whut.cailiao.ms.api.service.company;

import java.util.List;

import com.whut.cailiao.ms.api.commons.ApiResponse;
import com.whut.cailiao.ms.api.model.company.Company;

public interface CompanyService {
	public ApiResponse getCompanyByAddress(String address) throws Exception; 
	public ApiResponse getAllCompany() throws Exception; 
	public ApiResponse remarkInvited(int id) throws Exception;
}
