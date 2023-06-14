package org.example;

import java.io.File;
import java.io.IOException;

import java.util.List;


import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

public class Quiz {

	public void displayQuestions() throws IOException {
		ObjectMapper mapper = new ObjectMapper();
//		File file = new File("G:/!JAVA 4 projekty w godzine/Quiz/src/main/resources/quiz.json");
		File file = new File("quiz.json");
		try {
			List<Question> questions = mapper.readValue(file, new TypeReference<>() {
			});

			questions.stream()
					.map(Question::getPytanie)
					.forEach(System.out::println);
		}catch
			(IOException e){
				e.printStackTrace();
			}


	}
}

