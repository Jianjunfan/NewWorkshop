package com.project.springpro;

import java.util.Base64;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import com.project.springpro.jsonmapper.JsonMapper;

import lombok.extern.slf4j.Slf4j;

@Component
@Slf4j
@Order(value=0)
public class ApplicationCommandLineRunner implements CommandLineRunner{
	
	@Autowired
	private JsonMapper jsonMapper;
	
	@Override
	public void run(String... args) throws Exception {
		// TODO Auto-generated method stub
		
		log.debug("In Command Line runner");
		
		
		/**
		 * Below code is for check difference between base64 and base64url, 
		 */
		Base64.Encoder enc = Base64.getEncoder();
	    Base64.Encoder encURL = Base64.getUrlEncoder();

	    byte[] bytes = enc.encode("http://websecurityinfo.blogspot.com/test+123".getBytes());
	    byte[] bytesURL = encURL.encode("http://websecurityinfo.blogspot.com/test+123".getBytes());

	    System.out.println(new String(bytes)); // c3ViamVjdHM/X2Q=      notice the "/"
	    System.out.println(new String(bytesURL)); // c3ViamVjdHM_X2Q=   notice the "_"

	    Base64.Decoder dec = Base64.getDecoder();
	    Base64.Decoder decURL = Base64.getUrlDecoder();

	    byte[] decodedURL = decURL.decode(bytesURL);
	    byte[] decoded = dec.decode(bytes);

	    System.out.println(new String(decodedURL));
	    System.out.println(new String(decoded));
	    
	    jsonMapper.jsonmapperConvert();
	    jsonMapper.jsonmapperConvertList();;
	}

}
