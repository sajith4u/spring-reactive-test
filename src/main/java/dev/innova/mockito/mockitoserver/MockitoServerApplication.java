package dev.innova.mockito.mockitoserver;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.mongodb.config.EnableMongoAuditing;
import org.springframework.data.mongodb.repository.config.EnableReactiveMongoRepositories;

@SpringBootApplication
@EnableMongoAuditing
@EnableReactiveMongoRepositories
@ComponentScan(basePackages = "dev.innova.mockito.mockitoserver")
public class MockitoServerApplication {

	public static void main(String[] args) {
		SpringApplication.run(MockitoServerApplication.class, args);
	}

}
