package com.project.springpro.controller;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.http.server.ServerHttpRequest;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.WebUtils;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@RestController
@RequestMapping("/v1")
public class CustomerController {
	

	@RequestMapping(method = RequestMethod.GET, value = "/get-userinfo")
	@ResponseBody
	public ResponseEntity<String> retriveUserInfo(HttpServletRequest httpServletRequest,HttpServletResponse httpServletResponse,String test) throws Exception {

		String token = "user is test";
		
		/**
		 * Read Cookie
		 */
		String cookieValue = WebUtils.getCookie(httpServletRequest, "Cookie_1").getValue();
        log.debug("In CustomerController, the cookie value is {}",cookieValue);
           
        
        /**
		 * Set Cookie
		 */
        Cookie uiColorCookie = new Cookie("color", "red");
        httpServletResponse.addCookie(uiColorCookie);
        
        ResponseEntity<String> res = new ResponseEntity<String>(token, HttpStatus.OK);
        
        
		return new ResponseEntity<String>(token, HttpStatus.OK);
	}

}
