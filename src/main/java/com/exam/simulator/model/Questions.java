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
@Table(name = "QUESTIONS")
public class Questions implements Serializable {

	@Id
    @GeneratedValue(strategy=GenerationType.SEQUENCE, generator = "Questions_Squence")
    @SequenceGenerator(name = "Questions_Squence", sequenceName = "QUESTION_ID_SEQ", initialValue=1, allocationSize=1)
	@Column(name="QUESTION_ID")
	private Integer questionId;
	
	@Column(name="QUESTION")
	private String question;	
	
	
	  @OneToMany(targetEntity=Answers.class,cascade = CascadeType.ALL)	  
	  @JoinColumn(name="QUESTION_ID",referencedColumnName = "QUESTION_ID") 
	  private  List<Answers> answers;
	 
	
}
