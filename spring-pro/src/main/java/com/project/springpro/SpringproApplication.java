package com.project.springpro;

import javax.annotation.PostConstruct;
import javax.sql.CommonDataSource;

import org.apache.catalina.core.ApplicationContext;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

import lombok.extern.slf4j.Slf4j;

/**
 * @author steven
 *
 */

@SpringBootApplication
@Slf4j
public class SpringproApplication{
	
	/**
	 * Four ways to run specific pieces of code when an application is fully started. 
	 * These interfaces get called just once SpringApplication completes.
	 * 1. CommandLineRunner
	 * 2. Using context to get Bean - > run Bean's method
	 * 3. Using ApplicationRunner
	 * 4. PostConstruct is different, when run PostConstruct, application is not fully started
	 *
	 */
    
	public static void main(String[] args) {
//		SpringApplication.run(SpringproApplication.class, args);
		log.debug("begin SpringproApplication main function");
		ConfigurableApplicationContext applicationContext = SpringApplication.run(SpringproApplication.class, args);
		SpringproApplication app = applicationContext.getBean(SpringproApplication.class);
		app.diagnoseDependency();
		
	}
	public void diagnoseDependency() {
		log.debug("in diagnose Dependency");
	}
//	@Override
//	public void run(String... args) throws Exception {
//		// TODO Auto-generated method stub
//		log.debug("In Command runner");
//	}
	
	@PostConstruct
	void postConstruct() {
		log.debug("in post Construct fucntion");
	}
	

}
