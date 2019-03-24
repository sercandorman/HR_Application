package com.crudwithspring;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;


@ComponentScan ({"com.crudwithspring", "com.crudwithspring.controller", "com.crudwithspring.service"})
@SpringBootApplication
public class CRUD_With_Spring_Application {

	public static void main(String[] args) {
		SpringApplication.run(CRUD_With_Spring_Application.class, args);
	}
}
