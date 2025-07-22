package com.example.jpa_h2_example;

import com.example.jpa_h2_example.model.Billionaire;
import com.example.jpa_h2_example.repository.BillionaireRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.List;

@SpringBootApplication
public class JpaH2ExampleApplication implements CommandLineRunner {

	public static void main(String[] args) {
		SpringApplication.run(JpaH2ExampleApplication.class, args);
	}

	@Autowired
	BillionaireRepository billionaireRepository;


	@Override
	public void run(String... args) throws Exception {
		// 1. INSERT
		Billionaire saved = billionaireRepository.save(Billionaire.builder()
				.firstName("marcus")
				.lastName("chiu")
				.career("software engineer")
				.build());
		System.out.println("1. " + saved);

		// 2. AUTO CUSTOM QUERY
		List<Billionaire> p = billionaireRepository.findByFirstName("marcus");
		System.out.println("2. " + p);

		// 3. MANUAL CUSTOM QUERY #1
		p = billionaireRepository.retrieveByName1("marcus");
		System.out.println("3. " + p);

		// 3. MANUAL CUSTOM QUERY #2
		p = billionaireRepository.retrieveByName2("marcus");
		System.out.println("4. " + p);
	}
}
