package com.exam.simulator.model;

import java.io.Serializable;
import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.MapsId;
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
@IdClass(IdClassUser.class)
public class UserQuestionResponse implements Serializable {
	
	@Id
	@MapsId("USER_ID")
	@ManyToOne(optional = false)	  
	@JoinColumn(name="USER_ID",referencedColumnName = "USER_ID") 
	private  Users user;
	@Id
	@MapsId("CERTIFICATION_ID")
	@ManyToOne(optional = false)	  
	@JoinColumn(name="CERTIFICATION_ID",referencedColumnName = "CERTIFICATION_ID") 
	private  Certifications certification;

	@Id
	@MapsId("QUESTION_ID")
	@ManyToOne(optional = false)
	@JoinColumn(name="QUESTION_ID",referencedColumnName = "QUESTION_ID") 
	private  Questions question;
	
	@Id
	@MapsId("ANSWER_ID")
	@ManyToOne(optional = false)
	@JoinColumn(name="ANSWER_ID",referencedColumnName = "ANSWER_ID") 
	private  Answers answer;
	@Column(name="USER_RESPONSE") 
	private Boolean userResponse;
	@Column(name="CREATED_BY")
	private String createdBy;
	@Column(name="CREATED_DATE")
	private Date createdDate;
	@Column(name="MODIFIED_BY")
	private String modifiedBy;
	@Column(name="MODIFIED_DATE")
	private Date modifiedDate;
}
