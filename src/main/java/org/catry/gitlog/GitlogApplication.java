package org.catry.gitlog;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class GitlogApplication {

	public static void main(String[] args) {
		SpringApplication.run(GitlogApplication.class, args);
		SpringApplication springApplication = new SpringApplication(GitlogApplication.class);
	}

}
