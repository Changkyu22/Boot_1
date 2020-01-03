package com.iu.b1.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.SchedulingConfigurer;
import org.springframework.scheduling.concurrent.ThreadPoolTaskScheduler;
import org.springframework.scheduling.config.ScheduledTaskRegistrar;

//@Configuration
public class ScheduleConfig implements SchedulingConfigurer{
	
	@Override
	public void configureTasks(ScheduledTaskRegistrar taskRegistrar) {
		ThreadPoolTaskScheduler taskScheduler = new ThreadPoolTaskScheduler();
		
		taskScheduler.setPoolSize(8);
		
		taskScheduler.setThreadNamePrefix("My Thread-");
		
		taskScheduler.initialize();
		
		taskRegistrar.setTaskScheduler(taskScheduler);
	}
}
