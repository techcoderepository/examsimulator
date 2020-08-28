package com.exam.simulator.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.exam.simulator.model.Certifications;

@Repository
public interface CertificationsRepositiory extends JpaRepository<Certifications, Integer>{

	List<Certifications> findByCertificationId(Integer certificationId);
}
