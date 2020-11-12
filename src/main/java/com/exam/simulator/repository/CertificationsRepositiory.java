package com.exam.simulator.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.exam.simulator.model.Certification;

@Repository
public interface CertificationsRepositiory extends JpaRepository<Certification, Integer>{

	Certification findByCertificationId(Integer certificationId);
}
