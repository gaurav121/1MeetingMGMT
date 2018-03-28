package com.app.controller;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.ViewResolver;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.view.InternalResourceViewResolver;

@Configuration
@EnableWebMvc
@ComponentScan("com")

public class MeetingConfiguration {
	
	{
		
		System.out.println("in config");
	}
	
	/*
		@Bean
		public ViewResolver viewres() {
			System.out.println("In View Resolver MMS");
			
			InternalResourceViewResolver view =new InternalResourceViewResolver();
			
			//view.setPrefix("WEB-INF/view/");
			//view.setSuffix(".jsp");
			return view;
		
		}
		
	
	
*/}
