package com.exam.simulator.dto;

import com.exam.simulator.model.Questions;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class QARequest {
	private Questions question;
}
