package com.yuanc.yuanaicodemother;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

@EnableAspectJAutoProxy(exposeProxy = true)
@SpringBootApplication
public class YuanAiCodeMotherApplication {

	public static void main(String[] args) {
		SpringApplication.run(YuanAiCodeMotherApplication.class, args);
	}

}
