package com.exam.simulator.model;

import java.io.Serializable;
import java.sql.Date;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
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
@Table(name = "USER_QUESTION_RESPONSE")
public class UserQuestionResponse implements Serializable {

	@OneToOne(targetEntity=Users.class,cascade = CascadeType.ALL)	  
	@JoinColumn(name="USER_ID",referencedColumnName = "USER_ID") 
	private  Users user;
	
	@OneToOne(targetEntity=Certifications.class,cascade = CascadeType.ALL)	  
	@JoinColumn(name="CERTIFICATION_ID",referencedColumnName = "CERTIFICATION_ID") 
	private  Certifications certification;
	
	@OneToOne(targetEntity=Questions.class,cascade = CascadeType.ALL)	  
	@JoinColumn(name="QUESTION_ID",referencedColumnName = "QUESTION_ID") 
	private  Questions question;
	
	@Column(name="CREATED_BY")
	private String createdBy;
	@Column(name="CREATED_DATE")
	private Date createdDate;
	@Column(name="MODIFIED_BY")
	private String modifiedBy;
	@Column(name="MODIFIED_DATE")
	private Date modifiedDate;
}
