package com.exam;

import java.io.File;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
/*
 * @Author Shariful Islam
 */
import org.springframework.boot.context.properties.EnableConfigurationProperties;

import com.exam.filehandler.FileController;
import com.exam.filehandler.FileStorageProperties;

@SpringBootApplication
@EnableConfigurationProperties({FileStorageProperties.class})
public class ApiFeatureTemplateApplication {
//------------- Application start from here
	public static void main(String[] args) {
		new File(FileController.uploadDirectory).mkdir();
		SpringApplication.run(ApiFeatureTemplateApplication.class, args);
	} 

}
