package com.project.springpro.selfbean;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;

/**
 * @author steven
 *
 */

/**
 * @Configuration vs @Component
 * If you use @Configuration, all methods marked as @Bean will be wrapped into a CGLIB wrapper 
 * which works as if it’s the first call of this method, then the original method’s body will be executed 
 * and the resulting object will be registered in the spring context. 
 * All further calls just return the bean retrieved from the context.

 * If you use @Component, simpleBean()) just calls a pure java method. (that means, will create new SimpleBean object
 * 
 * More details: http://dimafeng.com/2015/08/29/spring-configuration_vs_component/
 *
 */

//@Configuration
@Component
public class MyConfigBean {
	
	@Bean
	public SimpleBean getSimpleBean() {
		return new SimpleBean();
	}
	
	@Bean
	public SimpleBeanConsumer getSimpleBeanConsumer() {
		return new SimpleBeanConsumer(getSimpleBean());
	}
	

}
