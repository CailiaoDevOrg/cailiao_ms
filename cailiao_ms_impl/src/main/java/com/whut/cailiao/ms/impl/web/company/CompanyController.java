package com.whut.cailiao.ms.impl.web.company;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.whut.cailiao.ms.api.model.company.Company;
import com.whut.cailiao.ms.api.service.company.CompanyService;
import com.whut.cailiao.ms.impl.web.BaseController;

@Controller
@RequestMapping("/company")
public class CompanyController extends BaseController{
	@Autowired
	private CompanyService companyService;
	
	@RequestMapping("/getCompanyByAddress")	
	@ResponseBody
	public List<Company> getCompanyByAddress(Model model,@RequestParam String address) throws Exception {		
		return companyService.getCompanyByAddress(address);
	}
	
	@RequestMapping("/getAllCompany")	
	public String getAllCompany(Model model) throws Exception {
		model.addAttribute("Companys", companyService.getAllCompany());		
		System.out.println(companyService.getAllCompany());
		return "wjInvite/list";
	}
}
