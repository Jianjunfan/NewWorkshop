package com.project.springpro.selfbean;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Component;

import lombok.extern.slf4j.Slf4j;

/**
 * @author steven
 *
 */


/**
 * if want a bean to be laze (initilize later), need @Lazy annotation above both bean class, and above @Autowried key word like in AppStarRunner.java
 * 
 * @Lazy
	@Autowired
	private MyLazyBean myLazyBean;
 *
 */
@Slf4j
@Lazy
@Component
public class MyLazyBean {
	
	public MyLazyBean() {
		log.debug("In MyBean construction");
	}
	
	public void getUserInfo() {
		log.debug("in MyLazyBean getUserInfo");
	}

}
