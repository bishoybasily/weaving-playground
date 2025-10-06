package com.gmail.bishoybasily.playground.weaving.app.dist;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

class DeploymentServiceDistImplTest {

  @Test
  void print() {
    final var service = new DeploymentServiceDistImpl();
    Assertions.assertThat(service.print()).isEqualTo("I'm the custom deployment service");
  }
}
