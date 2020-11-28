package com.exam.simulator.model;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class Company {

@Id
//@GeneratedValue(strategy = GenerationType.SEQUENCE)
private Integer companyId;

private String name;

@OneToMany(targetEntity=Branch.class,cascade = CascadeType.ALL , fetch = FetchType.LAZY, mappedBy = "company")
private List<Branch> branches = new ArrayList<>();

public void addBranches(Branch branch){
   branches.add(branch);
   branch.setCompany(this);
}

public void removeBranches(Branch branch){
   branches.remove(branch);
   branch.setCompany(null);
}

public Integer getCompanyId() {
	return companyId;
}

public void setCompanyId(Integer companyId) {
	this.companyId = companyId;
}

public String getName() {
	return name;
}

public void setName(String name) {
	this.name = name;
}

public List<Branch> getBranches() {
	return branches;
}

public void setBranches(List<Branch> branches) {
	this.branches = branches;
}

}
