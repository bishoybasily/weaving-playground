package com.gmail.bishoybasily.playground.weaving.app.dist;

import com.gmail.bishoybasily.playground.weaving.app.DeploymentService;
import com.gmail.bishoybasily.playground.weaving.app.JobService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class DeploymentConfig {

  @Bean
  DeploymentService deploymentService(JobService jobService) {
    return new DeploymentServiceImpl(jobService);
  }
}
