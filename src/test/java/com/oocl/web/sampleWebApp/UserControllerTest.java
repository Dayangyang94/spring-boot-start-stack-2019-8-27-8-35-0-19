package com.oocl.web.sampleWebApp;

import java.util.List;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.apache.tomcat.util.http.parser.MediaType;
import org.junit.Test;
import org.junit.experimental.results.PrintableResult;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultActions;
import org.springframework.test.web.servlet.request.MockHttpServletRequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultHandlers;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import ch.qos.logback.core.status.Status;

@RunWith(SpringRunner.class)
@SpringBootTest
@AutoConfigureMockMvc
public class UserControllerTest {
	@Autowired
	private MockMvc mockMvc;
	@Test
	public void should_return_201_status_when_create_user()throws Exception{
		//Given
		MockHttpServletRequestBuilder input=post("/users").content("{\"name\":\"xiaoming\"}").contentType(org.springframework.http.MediaType.APPLICATION_JSON);
		//when
		ResultActions result=mockMvc.perform(input);
		//then
		result
		.andDo(MockMvcResultHandlers.print())
		.andExpect(status().isOk());
	}
	
	@Test
	public void should_return_ok_status_when_get_user() throws Exception{
		//Given
		MockHttpServletRequestBuilder input=get("/users");
		//when
		ResultActions result=mockMvc.perform(input);
		//then
		result.andDo(MockMvcResultHandlers.print())
		.andExpect(status().isOk()).
		andExpect(MockMvcResultMatchers.content().string("[{\"name\":\"xiaoliu\"}]"));
	}
	
	

}
