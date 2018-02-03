package com.demo.jackson;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

public class JsonIncludeBasic {

	@JsonInclude(JsonInclude.Include.NON_EMPTY)
	static class PersonInclude {

		public long personId;

		public String name = "John";
		// will be included in JSON format when serialized

		// public String name=null;
		// will not be included in JSON format, not even property name is
		// displayed in JSON

		public String toString() {
			return this.personId + " - " + this.name;
		}
	}

	public static void main(String[] args) {
		ObjectMapper mapper = new ObjectMapper();
		PersonInclude person = new PersonInclude();
		try {
			String json = mapper.writeValueAsString(person);
			System.out.println(json);
		} catch (JsonProcessingException e) {
			e.printStackTrace();
		}
	}

}
