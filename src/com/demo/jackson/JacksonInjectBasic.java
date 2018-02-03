package com.demo.jackson;

import java.io.File;
import java.io.IOException;

import com.fasterxml.jackson.annotation.JacksonInject;
import com.fasterxml.jackson.databind.InjectableValues;
import com.fasterxml.jackson.databind.ObjectMapper;

public class JacksonInjectBasic {

	static class PersonInject {

		public long id = 0;
		public String name = null;

		@JacksonInject
		public String source = null;

		public String toString() {
			return this.id + "  :- " + this.name;

		}
	}

	public static void main(String[] args) {

		// Injecting for a person class
		InjectableValues inject = new InjectableValues.Std().addValue(String.class, "jenkov.com");
		try {
			PersonInject personInject = new ObjectMapper().reader(inject).forType(PersonInject.class)
					.readValue(new File(
							"C:\\Users\\SankarD\\Documents\\Java\\Jackson Functions\\src\\com\\demo\\jackson\\JSONString.JSON"));
			System.out.println(personInject.source);
			System.out.println(personInject);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		// Injecting for a student class
		InjectableValues inject2 = new InjectableValues.Std().addValue(String.class, "prasad.com");
		try {
			PersonInject personInject2 = new ObjectMapper().reader(inject2).forType(PersonInject.class)
					.readValue(new File(
							"C:\\Users\\SankarD\\Documents\\Java\\Jackson Functions\\src\\com\\demo\\jackson\\JSONString.JSON"));
			System.out.println(personInject2.source);
			System.out.println(personInject2);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
