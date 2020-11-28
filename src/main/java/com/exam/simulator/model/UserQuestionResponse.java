package com.exam.simulator.model;

import java.io.Serializable;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
@EqualsAndHashCode
@Entity
@Table(name = "USER_QUESTION_RESPONSE")
public class UserQuestionResponse implements Serializable {	
	
	@Id
    @GeneratedValue(strategy=GenerationType.SEQUENCE, generator = "UserQuestionResponse_Squence")
    @SequenceGenerator(name = "UserQuestionResponse_Squence", sequenceName = "USER_QUESTION_RESPONSE_SEQ", initialValue=1, allocationSize=1)
	@Column(name="USER_QUESTION_RESPONSE_ID")
	private Integer userQuestionResponseId;
	
	@ManyToOne(targetEntity=User.class, cascade = CascadeType.PERSIST) 
	@JoinColumn(name="APP_USER_ID",referencedColumnName = "APP_USER_ID") 
	private  User user;
		  
	@ManyToOne(targetEntity=Question.class, cascade = CascadeType.PERSIST)
	@JoinColumn(name="QUESTION_ID",referencedColumnName = "QUESTION_ID") 
	private  Question question;
		
	 @OneToMany(targetEntity=OptionResponse.class, cascade = CascadeType.ALL)	  
	 @JoinColumn(name="USER_QUESTION_RESPONSE_ID",referencedColumnName = "USER_QUESTION_RESPONSE_ID") 
	 private  List<OptionResponse> optionResponse;
}
