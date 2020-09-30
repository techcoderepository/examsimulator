package com.exam.simulator.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.exam.simulator.model.Certification;

@Repository
public interface CertificationsRepositiory extends JpaRepository<Certification, Integer>{

	List<Certification> findByCertificationId(Integer certificationId);
}
