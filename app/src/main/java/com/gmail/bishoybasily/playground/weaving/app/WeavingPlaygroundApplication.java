package com.gmail.bishoybasily.playground.weaving.app;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class WeavingPlaygroundApplication {

  public static void main(String[] args) {
    SpringApplication.run(WeavingPlaygroundApplication.class, args);
  }

  @Bean
  CommandLineRunner runner(DeploymentService deploymentService) {
    return args -> {
      System.out.println(deploymentService.print());
    };
  }
}
