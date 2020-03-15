package com.Flashycards.Flashycards;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication(scanBasePackages = {"com.Flashycards*"})
public class FlashycardsApplication {

	public static void main(String[] args) {
		SpringApplication.run(FlashycardsApplication.class, args);
	}

}
