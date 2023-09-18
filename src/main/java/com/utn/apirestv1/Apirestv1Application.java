package com.utn.apirestv1;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class Apirestv1Application {

	public static void main(String[] args) {
		SpringApplication.run(Apirestv1Application.class, args);
		System.out.println("Aplicación funcionando (API Rest V1)");
	}

}
