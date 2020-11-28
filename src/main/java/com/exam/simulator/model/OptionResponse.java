package com.exam.simulator.model;

import java.io.Serializable;

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
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode
@ToString
@Entity
@Table(name = "OPTION_RESPONSE")
public class OptionResponse implements Serializable {	
	
	@Id
    @GeneratedValue(strategy=GenerationType.SEQUENCE, generator = "OptionResponse_Squence")
    @SequenceGenerator(name = "OptionResponse_Squence", sequenceName = "OPTION_RESPONSE_SEQ", initialValue=1, allocationSize=1)
	@Column(name="OPTION_RESPONSE_ID")
	private Integer OptionResponseId;
		
	 @ManyToOne(targetEntity=Answer.class, cascade = CascadeType.PERSIST )	  
	 @JoinColumn(name="ANSWER_ID", referencedColumnName = "ANSWER_ID") 
	 private Answer answer; 
	 	
	@Column(name="USER_RESPONSE") 
	private Boolean userResponse;	

	@Column(name="USER_QUESTION_RESPONSE_ID") 
	private Integer	userQuestionResponseId;
	
}
