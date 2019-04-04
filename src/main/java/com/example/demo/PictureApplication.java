package com.example.demo;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;


@EnableAutoConfiguration
@SpringBootApplication
@MapperScan(basePackages = "com.example.demo.dao" )
public class PictureApplication {

	public static void main(String[] args) {
		SpringApplication.run(PictureApplication.class, args);
	}

}
