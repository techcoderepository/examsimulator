package com.exam.simulator.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
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
@Table(name = "USERS")
@Repository
public class User implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Id
	@Column(name="EMAIL_ID")
	private String emailId;
	@Column(name="FULL_NAME")
	private String fullName;		
	@Column(name="PASSSWORD")
	private String password;
	
	public User(String emailId) {
		this.emailId=emailId;
	}
		
}
