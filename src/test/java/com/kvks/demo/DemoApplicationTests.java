package com.kvks.demo;

import org.junit.jupiter.api.Test;
import com.kvks.demo.controller.MyController;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.junit.Assert.assertEquals;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

@WebMvcTest
class MyControllerTests {

	@Autowired
	private MockMvc mockMvc;

	@Test
	public void testGetDateAndTime() throws Exception{

		LocalDateTime now = LocalDateTime.now();
		DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss");
		String strNow = dtf.format(now);

		MvcResult response = mockMvc.perform(get("/getNow")).andExpect(status().isOk()).andReturn();
		String res = response.getResponse().getContentAsString();
		assertEquals(strNow, res);
	}

}
