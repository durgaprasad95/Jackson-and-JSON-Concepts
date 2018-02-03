package com.demo.jackson;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

public class JSONWrite {
	public static void main(String[] args) {
		ObjectMapper objectMapper = new ObjectMapper();

		Student car = new Student();
		car.setName("POSCHE");
		car.setAge(99);
		String json;
		try {
			json = objectMapper.writeValueAsString(car);
			System.out.print(json);
		} catch (JsonProcessingException e) {
			e.printStackTrace();
		}
	}
}
