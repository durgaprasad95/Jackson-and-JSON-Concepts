package com.demo.jackson;

import com.fasterxml.jackson.annotation.JsonValue;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

public class JsonValueBasic {

	static class Person {

		public long personId = 0;
		public String name = null;

		// this annotation changes the format of the actual JSON object
		@JsonValue
		public String toJson() {
			return this.personId + "," + this.name;
		}

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
