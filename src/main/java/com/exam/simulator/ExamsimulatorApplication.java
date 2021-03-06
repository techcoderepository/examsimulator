package com.exam.simulator;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

import springfox.documentation.swagger2.annotations.EnableSwagger2;

@EnableSwagger2
@SpringBootApplication
@EnableJpaRepositories(basePackages="com.exam.simulator.repository")
@EntityScan(basePackages="com.exam.simulator.model")
public class ExamsimulatorApplication {

	public static void main(String[] args) {
		SpringApplication.run(ExamsimulatorApplication.class, args);
	}

}
