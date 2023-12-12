package com.icwd.electronic.store;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication

public class ElectronicStoreApplication {



	public static void main(String[] args) {
		SpringApplication.run(ElectronicStoreApplication.class, args);
		System.out.println("Electronics Store Open.....");
		new ElectronicStoreApplication();

	}


}
