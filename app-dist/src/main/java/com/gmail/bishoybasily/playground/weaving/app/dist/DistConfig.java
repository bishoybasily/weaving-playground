package com.gmail.bishoybasily.playground.weaving.app.dist;

import com.gmail.bishoybasily.playground.weaving.app.DeploymentService;
import com.gmail.bishoybasily.playground.weaving.app.JobService;
import com.gmail.bishoybasily.playground.weaving.app.JobServiceImpl;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class DistConfig {

  @Bean
  JobService jobService() {
    return new JobServiceImpl();
  }

  @Bean
  DeploymentService deploymentService(JobService jobService) {
    return new DeploymentServiceDistImpl(jobService);
  }
}
