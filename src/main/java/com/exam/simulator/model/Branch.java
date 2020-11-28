package com.exam.simulator.model;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
public class Branch {

@Id
@GeneratedValue(strategy = GenerationType.AUTO)
private Integer id;

private String name;
@ManyToOne(targetEntity=Company.class, fetch = FetchType.LAZY)
@JoinColumn(name="company_id", nullable = false)//Optional
private Company company;

 @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Branch )) return false;
        return id != null && id.equals(((Branch) o).getId());
    }
    @Override
    public int hashCode() {
        return 31;
    }
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
	public Company getCompany() {
		return company;
	}
	public void setCompany(Company company) {
		this.company = company;
	}
}
