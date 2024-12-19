package com.aws_project.aws_project;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.ConfigurationPropertiesScan;

@SpringBootApplication
@ConfigurationPropertiesScan
public class AwsProjectApplication {

    public static void main(String[] args) {
        SpringApplication.run(AwsProjectApplication.class, args);
    }

}
