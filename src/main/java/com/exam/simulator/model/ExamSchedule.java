package com.exam.simulator.model;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
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
@Table(name = "EXAM_SCHEDULE")
public class ExamSchedule implements Serializable {

	@Id
    @GeneratedValue(strategy=GenerationType.SEQUENCE, generator = "EXAM_SCHEDULE")
    @SequenceGenerator(name = "EXAM_SCHEDULE", sequenceName = "EXAM_SCHEDULE_ID_SEQ", initialValue=1, allocationSize=1)
	@Column(name="EXAM_SCHEDULE_ID")
	private Integer examScheduleId;
	
	@ManyToOne
	@JoinColumn(name="CERTIFICATION_ID",referencedColumnName = "CERTIFICATION_ID", nullable=false) 
	private Certification certification;
	
	@Column(name = "EXAM_DATE", nullable=false)
	private Date examDate;	
	
	@Column(name="EXAM_TIME", nullable=false)
	private String examTime;		
	
	@ManyToOne(targetEntity = User.class, cascade = CascadeType.PERSIST)
	@JoinColumn(name="APP_USER_ID", referencedColumnName = "APP_USER_ID", nullable=false) 
	private  User user;	 	  
}
