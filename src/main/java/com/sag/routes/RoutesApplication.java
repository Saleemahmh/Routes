package com.sag.routes;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.PropertySource;

import com.sag.routes.service.ImageService;
import com.sag.routes.service.ServiceI;

@SpringBootApplication(scanBasePackages={"com.sag.routes"})
@PropertySource("classpath:application.properties")
public class RoutesApplication {
	@Autowired
	ServiceI serviceI;
	@Autowired
	ImageService imageService;
	public static void main(String[] args) {
		SpringApplication.run(RoutesApplication.class, args);
	}
}
