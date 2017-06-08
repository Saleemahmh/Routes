package com.sag.routes;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.PropertySource;
import com.sag.routes.service.ServiceI;

@SpringBootApplication
@PropertySource("classpath:application.properties")
public class RoutesApplication {
	@Autowired
	ServiceI serviceI;
	public static void main(String[] args) {
		SpringApplication.run(RoutesApplication.class, args);
	}
}
