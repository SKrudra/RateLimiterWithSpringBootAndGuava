package com.example.demo;

import java.util.Date;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.google.common.util.concurrent.RateLimiter;

@SpringBootApplication
public class RateLimiterWithSpringBootAndGuava {

	public static void main(String[] args) {
		SpringApplication.run(RateLimiterWithSpringBootAndGuava.class, args);
		RateLimiter limiter = RateLimiter.create(2.0);
		for (int i = 0; i < 10; i++) {
			doIt(limiter);
		}
	}

	private static void doIt(RateLimiter limiter) {
		limiter.acquire();
		System.out.println(new Date() + " : done");

	}

}
