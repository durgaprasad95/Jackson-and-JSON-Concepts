package com.demo.jackson;

import java.io.File;
import java.io.IOException;

import com.fasterxml.jackson.core.JsonEncoding;
import com.fasterxml.jackson.core.JsonFactory;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonToken;

public class JSONParserGenerator {

	public static void main(String[] args) {

		String studentJson = "{ \"name\" : \"Lambhorgini\", \"age\" : 25 }";

		JsonFactory factory = new JsonFactory();

		// Creating and Using a Parser
		JsonParser parser;
		try {
			parser = factory.createParser(studentJson);
			while (!parser.isClosed()) {
				JsonToken jsonToken = parser.nextToken();
				System.out.println("jsonToken = " + jsonToken);
			}
		} catch (JsonParseException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}

		// Creating and Using Generator
		try {
			JsonGenerator generator = factory.createGenerator(
					new File(
							"C:\\Users\\SankarD\\Documents\\Java\\Jackson Functions\\src\\com\\demo\\jackson\\JSONOutput.JSON"),
					JsonEncoding.UTF8);

			generator.writeStartObject();
			generator.writeStringField("name", "Maruti");
			generator.writeNumberField("age", 105);
			generator.writeNumberField("contact", 456378);
			generator.writeEndObject();
			generator.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
