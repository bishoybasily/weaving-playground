package com.gmail.bishoybasily.playground.weaving.app;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class JobConfig {

  @Bean
  JobService jobService() {
    return new JobServiceImpl();
  }
}
