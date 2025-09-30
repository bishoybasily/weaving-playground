package com.gmail.bishoybasily.playground.weaving.app.dist;

import com.gmail.bishoybasily.playground.weaving.app.DeploymentService;
import com.gmail.bishoybasily.playground.weaving.app.JobService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;

@Configuration
public class DeploymentDistConfig {

  @Primary
  @Bean
  DeploymentService deploymentService(JobService jobService) {
    return new DeploymentServiceDistImpl(jobService);
  }
}
