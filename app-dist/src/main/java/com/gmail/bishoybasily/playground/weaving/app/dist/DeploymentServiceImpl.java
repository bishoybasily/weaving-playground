package com.gmail.bishoybasily.playground.weaving.app.dist;

import com.gmail.bishoybasily.playground.weaving.app.DeploymentService;
import com.gmail.bishoybasily.playground.weaving.app.JobService;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class DeploymentServiceImpl implements DeploymentService {

  private final JobService jobService;

  @Override
  public void print() {
    System.out.printf(
        "Deployment service from dist-app module, total jobs are: %d%n", jobService.getNumJobs());
  }
}
