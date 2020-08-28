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
public class Users implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Id
	@Column(name="USER_ID")
	private String userId;
	@Column(name="FIRST_NAME")
	private String firstName;
	@Column(name="LAST_NAME")
	private String lastName;
	@Column(name="CREATED_BY")
	private String createdBy;
	@Column(name="CREATED_DATE" , insertable=false, nullable = false, columnDefinition = "Date default sysdate")	
	private Date createdDate;
	@Column(name="MODIFIED_BY")
	private String modifiedBy;
	@Column(name="MODIFIED_DATE")
	private Date modifiedDate;
		
}
