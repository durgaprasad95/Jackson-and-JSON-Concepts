package com.demo.jackson;

import java.io.File;
import java.io.IOException;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;

public class JsonDeserializeBasic {

	static class Example {
		public long id = 0;
		public String name = null;

		@JsonDeserialize(using = OptimizedBooleanDeserializer.class)
		public boolean enabled = false;

		public String toString() {
			return this.name + " : " + this.id + " : " + this.enabled;
		}
	}

	public static void main(String[] args) {
		ObjectMapper mapper = new ObjectMapper();
		try {
			Example person = mapper.reader().forType(Example.class).readValue(new File(
					"C:\\Users\\SankarD\\Documents\\Java\\Jackson Functions\\src\\com\\demo\\jackson\\JSONString2.JSON"));
			System.out.println(person);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
