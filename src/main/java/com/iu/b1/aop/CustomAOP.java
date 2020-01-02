package com.iu.b1.aop;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

@Component
@Aspect
public class CustomAOP {
	
	//@Before("execution(* com.iu.b1.member.MemberService.memberLogin	(..))")
	public void before() throws Exception{
		System.out.println("Before Member Join");
	}
	
	@AfterReturning("execution(* com.iu.b1.member.MemberService.memberLogin(..))")
	public void afterReturning() throws Exception{
		System.out.println("After Returning");
	}
	
	@AfterThrowing("execution(* com.iu.b1.member.MemberService.memberJoin(..))")
	public void afterThrowing() throws Exception{
		System.out.println("After Throwing");
	}
	
	@After("execution(* com.iu.b1.member.MemberService.memberJoin(..))")
	public void after() throws Exception{
		System.out.println("AAAAAAAAAAAAAAAfter");
	}
	@Around("execution(* com.iu.b1.member.MemberService.memberJoin(..))")
	public Object arround(ProceedingJoinPoint proceedingJoinPoint)throws Throwable{
		System.out.println("Arrrrrrrrrrrrrrround");
		Object object = proceedingJoinPoint.proceed();
		
		System.out.println("Arounddddddddddddddddddd");
		
		return object;
	}

}
