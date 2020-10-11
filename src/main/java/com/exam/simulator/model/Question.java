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
import javax.persistence.OneToMany;
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
@Table(name = "QUESTION")
public class Question implements Serializable {

	@Id
    @GeneratedValue(strategy=GenerationType.SEQUENCE, generator = "Question_Squence")
    @SequenceGenerator(name = "Question_Squence", sequenceName = "QUESTION_ID_SEQ", initialValue=1, allocationSize=1)
	@Column(name="QUESTION_ID")
	private Integer questionId;
	
	@Column(name="QUESTION")
	private String question;	
	
	@Column(name="IS_MULTIPLE_CHHOICE")
	private Boolean multipleChoice;	
	
	  @OneToMany(targetEntity=Answer.class,cascade = CascadeType.ALL)	  
	  @JoinColumn(name="QUESTION_ID",referencedColumnName = "QUESTION_ID") 
	  private  List<Answer> answer;
	 
	
}