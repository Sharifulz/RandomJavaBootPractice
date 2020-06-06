package com.ctrends;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import springfox.documentation.swagger2.annotations.EnableSwagger2;

/*
 * @author Shariful Islam
 */

@SpringBootApplication
@EnableSwagger2
public class KYCAppRun {

	//----------- server.port= 9001
	// sweagger path for postman http://localhost:9001/v2/api-docs
	// 
	public static void main(String[] args) {
		SpringApplication.run(KYCAppRun.class, args);
	}    
 
}
 