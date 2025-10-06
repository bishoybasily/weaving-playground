package com.gmail.bishoybasily.playground.weaving.app;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class DeploymentServiceImpl implements DeploymentService {

  private final JobService jobService;

  @Override
  public String print() {
    return "Total jobs are: %d%n".formatted(jobService.getNumJobs());
  }
}
