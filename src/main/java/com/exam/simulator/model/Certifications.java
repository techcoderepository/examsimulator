package com.exam.simulator.model;

import java.io.Serializable;
import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Entity
@Table(name = "CERTIFICATIONS")
public class Certifications implements Serializable{
	@Id
    @GeneratedValue(strategy=GenerationType.SEQUENCE, generator = "Certifications_Squence")
    @SequenceGenerator(name = "Certifications_Squence", sequenceName = "CERTIFICATION_ID_SEQ", initialValue=1, allocationSize=1)
	@Column(name="CERTIFICATION_ID")
	private Integer certificationId;
	@Column(name="CERTIFICATION_CODE")
	private String certificationCode;
	@Column(name="CERTIFICATION_TITLE")
	private String certificationTitle;
	@Column(name="CERTIFICATION_BY_COMPANY")	
	private String certificationByCompany;
	@Column(name="CREATED_BY")
	private String createdBy;
	@Column(name="CREATED_DATE")
	private Date createdDate;
	@Column(name="MODIFIED_BY")
	private String modifiedBy;
	@Column(name="MODIFIED_DATE")
	private Date modifiedDate;
	
}
