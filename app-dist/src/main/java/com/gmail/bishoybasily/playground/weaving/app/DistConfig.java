package com.gmail.bishoybasily.playground.weaving.app;

// import org.springframework.context.annotation.Bean;
// import org.springframework.context.annotation.Configuration;
// import org.springframework.context.annotation.Primary;
//
// @Configuration
public class DistConfig {

  //  @Bean
  //  @Primary
  DeploymentService deploymentService() {
    return new DeploymentServiceDistImpl();
  }
}
