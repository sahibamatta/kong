package com.example.kong.aspect;

import javax.servlet.http.HttpServletRequest;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.aspectj.lang.reflect.MethodSignature;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;


@Aspect
@Component
public class GatewayAspect {

	private static final org.slf4j.Logger log = LoggerFactory.getLogger(GatewayAspect.class);


	@Pointcut("execution(* com.example.kong.controller.PublicController.getKong(..))")
	public void controllerMethods() {}
	
	
	@Around("controllerMethods()")
	public Object profileAllMethods(ProceedingJoinPoint proceedingJoinPoint) throws Throwable 
	{
		MethodSignature methodSignature = (MethodSignature) proceedingJoinPoint.getSignature();

		//Get intercepted method details
		String className = methodSignature.getDeclaringType().getSimpleName();
		String methodName = methodSignature.getName();

		HttpServletRequest request = ((ServletRequestAttributes) RequestContextHolder.currentRequestAttributes()).getRequest();

		System.out.println("execution started className"+className+" methodName ["+methodName+"]"+"request:"+request.getHeader("rest"));

		Object result = proceedingJoinPoint.proceed();

		//Log method execution time

		log.info("execution complete methodName ["+methodName+"]");

		return result;
	}
}


