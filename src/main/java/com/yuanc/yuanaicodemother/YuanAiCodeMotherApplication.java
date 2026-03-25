package com.yuanc.yuanaicodemother;

import dev.langchain4j.community.store.embedding.redis.spring.RedisEmbeddingStoreAutoConfiguration;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

@EnableCaching
@EnableAspectJAutoProxy(exposeProxy = true)
@SpringBootApplication(exclude = {RedisEmbeddingStoreAutoConfiguration.class})
@MapperScan("com.yuanc.yuanaicodemother.mapper")
public class YuanAiCodeMotherApplication {

	public static void main(String[] args) {
		SpringApplication.run(YuanAiCodeMotherApplication.class, args);
	}

}
