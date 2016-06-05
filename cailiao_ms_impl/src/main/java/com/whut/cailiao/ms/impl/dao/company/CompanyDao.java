package com.whut.cailiao.ms.impl.dao.company;

import java.util.List;

import com.whut.cailiao.ms.api.model.company.Company;

public interface CompanyDao {
	public List<Company> getCompanyByAddress(String address) throws Exception;
	public List<Company> getAllCompany()throws Exception;
}
