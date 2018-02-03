package com.demo.jackson;

import com.fasterxml.jackson.annotation.JsonRawValue;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

public class JsonRawValueBasic {

	static class Person {

		public long personId = 0;

		// Comment the annotation to see the change
		@JsonRawValue
		public String address = "{ \"street\" : \"Wall Street\", \"no\":1}";
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
