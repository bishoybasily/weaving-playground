package com.gmail.bishoybasily.playground.weaving.app;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;

@Aspect
public class JobServiceAspect {

  @Around("call(public int com.gmail.bishoybasily.playground.weaving.app.JobService.getNumJobs())")
  public Object getNumJobs(ProceedingJoinPoint joinPoint) {
    return 50;
  }
}
