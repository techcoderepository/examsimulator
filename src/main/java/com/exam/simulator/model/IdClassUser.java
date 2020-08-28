package com.exam.simulator.model;

import java.io.Serializable;

import org.springframework.stereotype.Component;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Component
public class IdClassUser implements Serializable {
	private  String user;
	private  Integer certification;
	private  Integer question;
	private  Integer answer;

}
