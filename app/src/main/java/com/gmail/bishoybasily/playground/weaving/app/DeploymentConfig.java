package com.gmail.bishoybasily.playground.weaving.app;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class DeploymentConfig {

  @Bean
  DeploymentService deploymentService(JobService jobService) {
    return new DeploymentServiceImpl(jobService);
  }
}
