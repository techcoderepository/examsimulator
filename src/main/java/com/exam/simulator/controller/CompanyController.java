package com.exam.simulator.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.exam.simulator.model.Company;
import com.exam.simulator.repository.CompanyRepositiory;

@RestController @CrossOrigin(origins = "*")
//@RestController @CrossOrigin(origins = "http://localhost:4200")
public class CompanyController {	
	@Autowired
	private CompanyRepositiory companyRepositiory;
	  
	  @PostMapping(value="/saveCompany") 
	  public void saveCompany(@RequestBody Company company){ 
		  companyRepositiory.save(company);
	  } 
	  
	  @GetMapping(value="/getCompany") 
	  public List<Company> getCompany(){ 
		  return companyRepositiory.findAll();
	  }
}
