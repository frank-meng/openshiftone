package com.sample.app;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

import com.sample.UserRepository;

@SpringBootApplication
@EnableJpaRepositories("com.sample")
@EntityScan("com.sample")
public class Application implements CommandLineRunner {

	@Autowired
	DataSource dataSource;

	@Autowired
	UserRepository systemRepository;

	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		System.out.println("Our DataSource is = " + dataSource);
		Iterable<com.sample.model.LoginUser> systemlist = systemRepository.findAll();
		for(com.sample.model.LoginUser systemmodel:systemlist){
			System.out.println("Here is a system: " + systemmodel.toString());
		}


	}

}
