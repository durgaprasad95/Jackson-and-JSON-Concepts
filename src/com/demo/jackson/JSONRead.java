package com.demo.jackson;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.Reader;
import java.io.StringReader;
import java.net.URL;
import java.nio.file.Files;
import java.nio.file.Paths;

import com.fasterxml.jackson.databind.ObjectMapper;

public class JSONRead {

	public static void main(String[] args) {

		// Reading a JSON from a reader
		ObjectMapper objectMapper = new ObjectMapper();

		String carJson = "{ \"name\" : \"Mercedes\", \"age\" : 4 }";
		Reader reader = new StringReader(carJson);

		try {
			Student s1 = objectMapper.readValue(reader, Student.class);
			System.out.println(s1);
		} catch (IOException e) {
			e.printStackTrace();
		}

		// Reading a JSON from a file
		try {
			BufferedReader file = Files.newBufferedReader(Paths.get(
					"C:\\Users\\SankarD\\Documents\\Java\\Jackson Functions\\src\\com\\demo\\jackson\\JSONString.JSON"));
			Student s2 = objectMapper.readValue(file, Student.class);
			System.out.println(s2);
		} catch (IOException e) {
			e.printStackTrace();
		}

		// Reading a JSON from a URL
		try {
			URL url = new URL(
					"file:C:\\Users\\SankarD\\Documents\\Java\\Jackson Functions\\src\\com\\demo\\jackson\\JSONString.JSON");
			Student s2 = objectMapper.readValue(url, Student.class);
			System.out.println(s2);
		} catch (IOException e) {
			e.printStackTrace();
		}

		// Reading a JSON from a BYTE Array
		String car = "{ \"name\" : \"Hero\", \"age\" : 25 }";
		byte[] bytes;
		try {
			bytes = car.getBytes("UTF-8");
			Student s3 = objectMapper.readValue(bytes, Student.class);
			System.out.println(s3);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
