package com.revature.hydra.marketingstatus.application;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.stereotype.Controller;

@EnableJpaRepositories("com.revature.hydra.marketingstatus.data")
@EntityScan("com.revature.beans")
@EnableAutoConfiguration
@ComponentScan(basePackages = {"com.revature.hydra.marketingstatus.controller", "com.revature.hydra.marketingstatus.service"})
public class MarketingStatusRepositoryServiceApplication {
	public static void main(String[] args) {
		SpringApplication.run(MarketingStatusRepositoryServiceApplication.class, args);
	}
}
