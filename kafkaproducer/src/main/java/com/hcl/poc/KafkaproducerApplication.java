package com.hcl.poc;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

@EnableScheduling
@SpringBootApplication
public class KafkaproducerApplication {

	public static void main(String[] args) {
		SpringApplication.run(KafkaproducerApplication.class, args);
	}

}
