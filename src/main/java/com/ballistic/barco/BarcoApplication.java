package com.ballistic.barco;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.scheduling.annotation.EnableScheduling;


@EnableAsync
@EnableCaching
@EnableScheduling
@SpringBootApplication
@ComponentScan(value = "com.ballistic.barco")
public class BarcoApplication {

	public static void main(String[] args) {
		SpringApplication.run(BarcoApplication.class, args);
	}
}
