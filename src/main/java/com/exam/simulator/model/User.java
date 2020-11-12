package com.exam.simulator.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import org.springframework.stereotype.Repository;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Entity
@Table(name = "APP_USER")
@Repository
public class User implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Id
    @GeneratedValue(strategy=GenerationType.SEQUENCE, generator = "AppUser_Squence")
    @SequenceGenerator(name = "AppUser_Squence", sequenceName = "APP_USER_ID_SEQ", initialValue=1, allocationSize=1)
	@Column(name="APP_USER_ID")
	private Integer userId;
	@Column(name="EMAIL_ID", nullable=false, unique=true)
	private String emailId;
	@Column(name="FULL_NAME", nullable=false)
	private String fullName;		
	@Column(name="PASSSWORD")
	private String password;		
}
