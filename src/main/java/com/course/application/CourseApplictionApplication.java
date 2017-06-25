package com.course.application;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
@ComponentScan(basePackages="com.course.controller")
@EntityScan("com.course.beans")
@EnableJpaRepositories("com.course.repository")
@EnableAutoConfiguration
@SpringBootApplication()
public class CourseApplictionApplication {

	public static void main(String[] args) {
		SpringApplication.run(CourseApplictionApplication.class, args);
	}
}
