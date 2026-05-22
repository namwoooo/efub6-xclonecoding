package com.practice.xclonecoding;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@SpringBootApplication
@EnableJpaAuditing
public class XclonecodingApplication {
	public static void main(String[] args) {
		SpringApplication.run(XclonecodingApplication.class, args);
	}
}