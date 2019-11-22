package com.project.springpro.jsonmapper;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

import org.springframework.core.io.ClassPathResource;
import org.springframework.stereotype.Component;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import lombok.extern.slf4j.Slf4j;

@Component
@Slf4j
public class JsonMapper {

	private ObjectMapper mapper = new ObjectMapper();

	public EndpoitData fromJsonStrToObject() throws JsonParseException, JsonMappingException, IOException {

		InputStream inputStream;
		inputStream = new ClassPathResource("static/input.json").getInputStream();

		return mapper.readValue(inputStream, EndpoitData.class);

	}
	
	public CommonClass fromJsonStrToObjectList() throws JsonParseException, JsonMappingException, IOException {

		InputStream inputStream;
		inputStream = new ClassPathResource("static/input_list.json").getInputStream();

		return mapper.readValue(inputStream, CommonClass.class);

	}
	
	public void jsonmapperConvert() throws JsonParseException, JsonMappingException, IOException {
		EndpoitData endpoitData = new EndpoitData();
		
		endpoitData = fromJsonStrToObject();
		
		log.debug("In jsonmapperConvert, endpoitData is {}",endpoitData.toString());
	}
	
	public void jsonmapperConvertList() throws JsonParseException, JsonMappingException, IOException {
		CommonClass commonClass = new CommonClass();
		
		commonClass = fromJsonStrToObjectList();
		
		log.debug("In jsonmapperConvertList, commonClass is {}",commonClass.toString());
		String jsonStrList =  mapper.writeValueAsString(commonClass.getItems());
		log.debug("In jsonmapperConvertList, jsonStrList is {}",jsonStrList);
		
		List<EndpoitData> endpointDataList = mapper.readValue(jsonStrList, List.class);
		log.debug("In jsonmapperConvertList, jsonStrList is {}",endpointDataList);
		
	}

}
