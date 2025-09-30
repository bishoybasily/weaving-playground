package com.gmail.bishoybasily.playground.weaving.app;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.TestConfiguration;
import org.springframework.context.annotation.Bean;

@SpringBootTest
class WeavingPlaygroundApplicationTest {

  @Autowired JobService jobService;

  @Test
  void contextLoads() {
    Assertions.assertThat(jobService.getNumJobs()).isEqualTo(10);
  }

  @TestConfiguration
  public static class Config {

    @Bean
    DeploymentService deploymentService() {
      return new DeploymentService() {
        @Override
        public void print() {
          // dummy
        }
      };
    }
  }
}
