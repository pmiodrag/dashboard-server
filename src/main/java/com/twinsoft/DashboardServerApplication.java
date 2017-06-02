package com.twinsoft;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.boot.web.support.SpringBootServletInitializer;
import org.springframework.context.annotation.Configuration;

import com.twinsoft.service.storage.StorageProperties;

@SpringBootApplication
@Configuration
@EnableAutoConfiguration
@EnableConfigurationProperties(StorageProperties.class)
public class DashboardServerApplication  extends SpringBootServletInitializer {
	
	@Override
    protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
        return application.sources(DashboardServerApplication.class);
    }

	public static void main(String[] args) {
		SpringApplication.run(DashboardServerApplication.class, args);
	}
}
