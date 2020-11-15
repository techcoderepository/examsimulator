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
@Table(name = "ANSWER")
@Repository
public class Answer implements Serializable{
	@Id
    @GeneratedValue(strategy=GenerationType.SEQUENCE, generator = "Answers_Squence")
    @SequenceGenerator(name = "Answers_Squence", sequenceName = "ANSWER_ID_SEQ", initialValue=1, allocationSize=1)
	@Column(name="ANSWER_ID")
	private Integer answerId;
	@Column(name="ANSWER", nullable=false)
	private String answer;
	@Column(name="IS_CORRECT", nullable=false)
	private Boolean correct;	
	@Column(name="QUESTION_ID")
	private Integer question;	
}
