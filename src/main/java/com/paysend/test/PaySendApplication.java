package com.paysend.test;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.jdbc.datasource.SimpleDriverDataSource;

@SpringBootApplication
public class PaySendApplication {

	@Bean
	public SimpleDriverDataSource dataSource() throws ClassNotFoundException {

		SimpleDriverDataSource dataSource = new SimpleDriverDataSource();

		Class.forName("org.h2.Driver");

		dataSource.setUsername("sa");
		dataSource.setUrl("jdbc:h2:mem");
		dataSource.setPassword("");

		return dataSource;
	}

	public static void main(final String[] args) {
		SpringApplication.run(PaySendApplication.class, args);
	}

}
