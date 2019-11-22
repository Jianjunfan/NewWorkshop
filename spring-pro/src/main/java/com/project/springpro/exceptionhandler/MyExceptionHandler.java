package com.project.springpro.exceptionhandler;

import java.text.ParseException;

import org.springframework.stereotype.Component;

import lombok.extern.slf4j.Slf4j;

@Component
@Slf4j
public class MyExceptionHandler {
	
	public void MyExceptionHandlerSample(String str) throws Exception
	{
		log.debug("In MyExceptionHandler");
//		String str1 = null;
//		int len = str1.length();
//		log.debug("In MyExceptionHandler, the len is {}",len);
		
	}

}
