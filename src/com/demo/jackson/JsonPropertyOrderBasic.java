package com.demo.jackson;

import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

public class JsonPropertyOrderBasic {

	@JsonPropertyOrder({ "personId", "name" })
	static class Person {

		public long personId = 0;
		public int age = 0;
		public String name = null;

	}

	public static void main(String[] args) {
		ObjectMapper mapper = new ObjectMapper();
		Person person = new Person();
		String json;
		try {
			json = mapper.writeValueAsString(person);
			System.out.print(json);
		} catch (JsonProcessingException e) {
			e.printStackTrace();
		}
	}

}
