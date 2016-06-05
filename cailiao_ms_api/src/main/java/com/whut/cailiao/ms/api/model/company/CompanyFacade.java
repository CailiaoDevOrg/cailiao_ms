package com.whut.cailiao.ms.api.model.company;

import java.io.Serializable;

public class CompanyFacade implements Serializable{

	private static final long serialVersionUID = 1L;
	
	public CompanyFacade(Company company) {
		if (company == null) {
			throw new IllegalArgumentException();
		}
		this.id = company.getId();
		this.name = company.getName();
	}
	
	private Integer id;
	
	private String name;
	
	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
}
