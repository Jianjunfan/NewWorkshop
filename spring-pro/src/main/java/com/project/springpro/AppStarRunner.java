package com.project.springpro;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.context.annotation.Lazy;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import com.project.springpro.exceptionhandler.MyExceptionTest;
import com.project.springpro.selfbean.MyConfigBean;
import com.project.springpro.selfbean.MyLazyBean;
import com.project.springpro.selfbean.SimpleBean;

import lombok.extern.slf4j.Slf4j;

@Component
@Slf4j
@Order(value=1)
public class AppStarRunner implements ApplicationRunner{
	
	@Lazy
	@Autowired
	private MyLazyBean myLazyBean;
	
	@Autowired
	private MyConfigBean myConfigBean;
	
	@Autowired
	private MyExceptionTest myExceptionTest;
	
	@Override
	public void run(ApplicationArguments args) throws Exception {
		// TODO Auto-generated method stub
		log.debug(" In Application runner with option names" + args.getOptionNames());
		myConfigBean.getSimpleBean();
//		myLazyBean.getUserInfo();
		
		myExceptionTest.testExample();
	}

}
