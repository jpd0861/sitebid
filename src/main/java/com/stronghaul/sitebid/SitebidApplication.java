package com.stronghaul.sitebid;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.ConfigurationPropertiesScan;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestClient;

@SpringBootApplication
@ConfigurationPropertiesScan
public class SitebidApplication {

	@Bean
	RestClient.Builder restClientBuilder() {
		return RestClient.builder();
	}

	public static void main(String[] args) {
		SpringApplication.run(SitebidApplication.class, args);
	}

}
