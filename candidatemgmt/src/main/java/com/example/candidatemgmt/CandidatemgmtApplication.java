package com.example.candidatemgmt;

import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@Slf4j
public class CandidatemgmtApplication {

	public static void main(String[] args) {
		SpringApplication.run(CandidatemgmtApplication.class, args);
		log.info("Application Running......");
	}

}
