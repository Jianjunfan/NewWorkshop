package com.project.springpro.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import com.project.springpro.config.interceptor.BusynessInterceptor;
import com.project.springpro.config.interceptor.ClientInterceptor;

@Configuration
@EnableWebMvc
public class MyWebMvcConfig implements WebMvcConfigurer {

	@Autowired
	private BusynessInterceptor busynessInterceptor;

	@Autowired
	private ClientInterceptor clientInterceptor;

	@Override
	public void addInterceptors(InterceptorRegistry registry) {

		registry.addInterceptor(clientInterceptor).addPathPatterns(CommonConstant.PATTEN_STR2);
		registry.addInterceptor(busynessInterceptor).addPathPatterns(CommonConstant.PATTEN_STR1);
	}

}
