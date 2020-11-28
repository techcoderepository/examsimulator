package com.exam.simulator.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.exam.simulator.model.Company;

@Repository
public interface CompanyRepositiory extends JpaRepository<Company, Integer>{

}
