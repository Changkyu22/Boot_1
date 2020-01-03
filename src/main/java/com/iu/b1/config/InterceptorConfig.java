package com.iu.b1.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import com.iu.b1.interceptor.CustomInterceptor;
import com.iu.b1.interceptor.MemberInterceptor;

@Configuration // xml file
public class InterceptorConfig implements WebMvcConfigurer{

	@Autowired
	private CustomInterceptor customInterceptor;
	
	@Autowired
	private MemberInterceptor memberInterceptor;
	
	
	@Override
	public void addInterceptors(InterceptorRegistry registry) {
		
		// Interceptor 등록
		registry.addInterceptor(customInterceptor)
		
		// Interceptor를 사용할 URL 패턴 등록
		.addPathPatterns("/member/*")
		// .addPathPatterns("/member/memberMypage")
		
		// 제외할 Interceptor 경로
		.excludePathPatterns("/member/memberLogin")	
		.excludePathPatterns("/member/memberJoin");
		
		// WebMvcConfigurer.super.addInterceptors(registry);	생략가능
		
		
		registry.addInterceptor(memberInterceptor).addPathPatterns("/member/memberMypage");
		
		
	}
	
	
	
}
