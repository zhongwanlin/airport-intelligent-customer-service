package com.dingfeng.airportintelligentcustomerservice;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
//@ComponentScan(basePackages = "com.dingfeng.airportintelligentcustomerservice.*")
//@MapperScan(basePackages = { "om.dingfeng.airportintelligentcustomerservice.mapper" })
public class AirportIntelligentCustomerServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(AirportIntelligentCustomerServiceApplication.class, args);
	}

}
