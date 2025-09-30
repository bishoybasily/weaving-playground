package com.gmail.bishoybasily.playground.weaving.app.dist;

import com.gmail.bishoybasily.playground.weaving.app.JobService;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class WeavingPlaygroundApplicationTests {

  @Autowired JobService jobService;

  @Test
  void contextLoads() {
    Assertions.assertThat(jobService.getNumJobs()).isEqualTo(50);
  }
}
