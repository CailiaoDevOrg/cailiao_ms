package com.whut.cailiao.ms.impl.web.company;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.alibaba.dubbo.common.utils.CollectionUtils;
import com.alibaba.fastjson.JSON;
import com.whut.cailiao.ms.api.model.company.Company;
import com.whut.cailiao.ms.api.model.company.CompanyFacade;
import com.whut.cailiao.ms.api.service.company.CompanyService;
import com.whut.cailiao.ms.impl.web.BaseController;

@Controller
@RequestMapping("/company")
public class CompanyController extends BaseController{
	@Autowired
	private CompanyService companyService;
	
	@RequestMapping(value = "/getCompanyByAddress.html", method=RequestMethod.GET)	
	@ResponseBody
	public String getCompanyByAddress(@RequestParam("address") String address) throws Exception {
		System.out.println(this.companyService.getCompanyByAddress(address));
		return JSON.toJSONString(this.companyService.getCompanyByAddress(address));
	}	
//	private List<CompanyFacade> convertBaseClazzToFacade(List<Company> companyList) {
//		if (CollectionUtils.isNotEmpty(companyList)) {
//			List<CompanyFacade> companyFacadeList = new ArrayList<>();
//			for (Company c : companyList) {
//				if (c != null) {
//					companyFacadeList.add(new CompanyFacade(c));
//				}
//			}
//			return companyFacadeList;
//		}
//		return Collections.emptyList();
//	}
	
	@RequestMapping(value = "/getAllCompany.html", method=RequestMethod.GET)	
	public String getAllCompany(Model model) throws Exception {
		model.addAttribute("Companys", companyService.getAllCompany());		
		System.out.println(companyService.getAllCompany());
		return "wjInvite/list";
	}
}
