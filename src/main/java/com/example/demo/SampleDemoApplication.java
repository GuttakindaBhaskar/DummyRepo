package com.example.demo;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class SampleDemoApplication {
public static Logger log=LoggerFactory.getLogger(SampleDemoApplication.class);
	public static void main(String[] args) {

		SpringApplication.run(SampleDemoApplication.class, args);
		log.info("STARTED");
		int a=10;
		System.out.println("SampleDemoApplication.main()");
		log.info("ENDED");
	}

}
