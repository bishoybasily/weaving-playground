package com.gmail.bishoybasily.playground.weaving.app;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class Config {

  @Bean
  JobService jobService() {
    return new JobServiceImpl();
  }

  @Bean
  DeploymentService deploymentService(JobService jobService) {
    return new DeploymentServiceImpl(jobService);
  }
}
