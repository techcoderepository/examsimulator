package com.exam.simulator.model;

import java.io.Serializable;
import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.ColumnDefault;

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
