package com.whut.cailiao.ms.impl.sevice.impl.company;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.whut.cailiao.ms.api.model.company.Company;
import com.whut.cailiao.ms.api.service.company.CompanyService;
import com.whut.cailiao.ms.impl.dao.company.CompanyDao;

@Service("companyService")
public class CompanyServiceImpl implements CompanyService {
	@Autowired
	private CompanyDao companyDao;

	@Override
	public List<Company> getCompanyByAddress(String address) throws Exception {
		// TODO Auto-generated method stub
		return this.companyDao.getCompanyByAddress(address);
	}

	@Override
	public List<Company> getAllCompany() throws Exception {
		// TODO Auto-generated method stub
		return this.companyDao.getAllCompany();
	}
	

}
