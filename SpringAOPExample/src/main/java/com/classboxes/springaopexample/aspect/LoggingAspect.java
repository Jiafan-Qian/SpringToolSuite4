package com.classboxes.springaopexample.aspect;

import java.util.Arrays;

import javax.naming.spi.DirStateFactory.Result;

import org.aopalliance.intercept.Joinpoint;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import net.bytebuddy.asm.Advice.This;

@Aspect
@Component
public class LoggingAspect {
	
	private final Logger log = LoggerFactory.getLogger(this.getClass());
	
	/*
	 * PointCut that matches all repositories, services and WEB REST endpoints
	 */
	@Pointcut("within(@org.springframework.stereotype.Repository *)"
	 +"|| within(@org.springframework.stereotype.Service *)"
	 + "|| within(@org.springframework.web.bind.annotation.RestController *)")
	public void springBeanPointCut()
	{
		//Method is empty as this is a just a point cut, t
		//he implementations are in the advices
	}
	
	/*
	 * PointCut that matches all repositories, services and WEB REST endpoints
	 */
	@Pointcut("within(@com.classboxes.springaopexample.repository *)"
	 +"|| within(@com.classboxes.springaopexample.service *)"
	 + "|| within(@com.classboxes.springexample.controller *)")
	public void applicationPackagePointCut()
	{
		//Method is empty as this is a just a point cut, t
		//he implementations are in the advices
	}
	
	/**
	 * Advice that logs methods throwing exception
	 * 
	 * @param joinPoint point for advice
	 * @param e exception
	 */

	@AfterThrowing(pointcut="allicationPackagePointCut()&&springBeanPointCut()", throwing = "e")
	public void logAfterThrowing(JoinPoint joinPoint, Throwable e)
	{
		log.error("Exception is {},{}() with cause = {}",joinPoint.getSignature().getDeclaringTypeName(),
				joinPoint.getSignature().getName(),Arrays.toString(joinPoint.getArgs()));
	}
	
	/**
	 * Advice that logs when a method is entered and exited
	 * 
	 * @param joinPoint join point for advice
	 * @return result
	 * @throws Throwable throws IllegalArgumentException
	 */
	 @Around("applicationPackagePointcut()&&springBeanPointCut()")
	 public Object logAround(ProceedingJoinPoint joinPoint) throws Throwable
	 {
		 if (log.isDebugEnabled())
		 {
			 log.debug("Enter:{}.{}() with result = {}",joinPoint.getSignature().getDeclaringTypeName(),
					 joinPoint.getSignature().getName(), Arrays.toString(joinPoint.getArgs()));
		 }
		 
		 
		 
		 try 
		 {
			 Object result = joinPoint.proceed();
			 if (log.isDebugEnabled())
			 {
				 log.debug("Enter:{}.{}() with result = {}",joinPoint.getSignature().getDeclaringTypeName(),
						 joinPoint.getSignature().getName(), result);
			 }
			 return result;
		 }
		 catch(IllegalArgumentException e)
		 {
			 log.error("Illegal argument: {} in {}.{}()", Arrays.toString(joinPoint.getArgs()),
					 joinPoint.getSignature().getDeclaringTypeName(), joinPoint.getSignature().getName());
			 throw e;
		 }
	 }
}
