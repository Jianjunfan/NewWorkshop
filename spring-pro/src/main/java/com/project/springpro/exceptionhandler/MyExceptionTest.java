package com.project.springpro.exceptionhandler;

import java.text.ParseException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import lombok.extern.slf4j.Slf4j;

@Component
@Slf4j
public class MyExceptionTest {
	
	@Autowired
	private MyExceptionHandler MyExceptionHandler;
	
	public void testExample() {
		try {
			MyExceptionHandler.MyExceptionHandlerSample("hello");
		} catch (Exception e) {
			log.debug("In MyExceptionTest testExample");
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
