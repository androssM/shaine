package com.shane;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan(basePackages = {"com.shane"}) // 🔹 Asegura que Spring escanee TODOS los paquetes
public class ShaneApplication {

	public static void main(String[] args) {
		SpringApplication.run(ShaneApplication.class, args);
	}

}
