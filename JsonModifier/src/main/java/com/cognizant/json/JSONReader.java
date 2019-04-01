package com.cognizant.json;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.codehaus.jackson.JsonGenerationException;
import org.codehaus.jackson.map.JsonMappingException;
import org.codehaus.jackson.map.ObjectMapper;

public class JSONReader {
	public static void main(String[] args) throws Exception {
		String json = null;
		
		json = FileUtils.readFileToString(new File("StudentDetails.json"));

		parse(json);

	}

	private static void parse(String json) throws Exception {

		ObjectMapper mapper = new ObjectMapper();
		StudentDetails studentDetails=null;
		try {
			// Read the StudentDetails.json

			// Read and map data to studentDetails object
			studentDetails = mapper.readValue(json, StudentDetails.class);
			// Print the student details
			System.out.println("*** StudentDetails Details ***");
			System.out.println("Student Name        : " + studentDetails.getName());
			System.out.println("Student Id          : " + studentDetails.getId());
			System.out.println("Student Department  : " + studentDetails.getDepartment());
			System.out.println("Favourite Sports : ");

			for (String fav : studentDetails.getFavoriteSports()) {
				System.out.print(fav + " | ");
			}
			System.out.println("**************Adding extra fav Sports**********************");
			studentDetails.getFavoriteSports().add("BasketBall");
			studentDetails.getFavoriteSports().add("Rugby");
			studentDetails.getFavoriteSports().add("Hockey");
		} catch (Exception e) {
			// Logger
			e.printStackTrace();
		}
		
		jsonWriter(studentDetails);
	}
	
	
	private static void jsonWriter(StudentDetails studentDetails) throws JsonGenerationException, JsonMappingException, IOException {

		ClassLoader classLoader = JSONReader.class.getClass().getClassLoader();
		File file = new File(classLoader.getResource("StudentDetailsUpdated.json").getFile());
		ObjectMapper mapper = new ObjectMapper();

		mapper.writerWithDefaultPrettyPrinter();

		mapper.writeValue(file, studentDetails);
		System.out.println("JSON Write successful!!");
	}
	
}
