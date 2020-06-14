package com.exam;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
/*
 * @Author Shariful Islam
 */
import org.springframework.boot.context.properties.EnableConfigurationProperties;

import com.exam.filehandler.FileStorageProperties;

@SpringBootApplication
@EnableConfigurationProperties({FileStorageProperties.class})
public class ApiFeatureTemplateApplication {
//------------- Application start from here
	public static void main(String[] args) {
		SpringApplication.run(ApiFeatureTemplateApplication.class, args);
	}

}
