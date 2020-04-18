package com.southgis.demo;

import com.southgis.demo.config.DynamicDataSourceRegister;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Import;

/**
 * 启动类
 * @author caihua
 * @date 2020-2-27
 * @version 1.0
 */
@SpringBootApplication
@Import(DynamicDataSourceRegister.class)
public class DynamicDatasourceApplication {

	public static void main(String[] args) {
		SpringApplication.run(DynamicDatasourceApplication.class, args);
	}

}
