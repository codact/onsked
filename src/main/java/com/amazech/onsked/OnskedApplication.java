package com.amazech.onsked;

import org.apache.ibatis.annotations.Mapper;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan(basePackages = { "com.amazech.onsked.dao.mapper" }, annotationClass = Mapper.class)
public class OnskedApplication {

	public static void main(String[] args) {
		SpringApplication.run(OnskedApplication.class, args);
	}

}
