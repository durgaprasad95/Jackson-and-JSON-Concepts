package com.demo.jackson;

import com.fasterxml.jackson.annotation.JsonGetter;
import com.fasterxml.jackson.annotation.JsonSetter;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

public class JsonGetterBasic {

	static class PersonGetter {

		public long personId = 0;

		// Comments te annotations to see the change

		@JsonGetter("id")
		public long personId() {
			return this.personId;
		}

		@JsonSetter("id")
		public void personId(long personId) {
			this.personId = personId;
		}

	}

	public static void main(String[] args) {
		ObjectMapper mapper = new ObjectMapper();
		PersonGetter person = new PersonGetter();
		try {
			String json = mapper.writeValueAsString(person);
			System.out.println(json);
		} catch (JsonProcessingException e) {
			e.printStackTrace();
		}
	}

}
