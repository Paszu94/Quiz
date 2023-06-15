package org.example;

import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.Scanner;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;


public class Quiz {
	File file = new File("src/main/resources/quiz.json");
	//      Short path not working anyway

	public void displayQuestions() {
		ObjectMapper mapper = new ObjectMapper();

		try {
			List<Question> questions = mapper
					.readValue(file, new TypeReference<>() {
					});
			questions.stream()
					.map(Question::getPytanie)
					.forEach(System.out::println);
		} catch
		(IOException e) {
			e.printStackTrace();
		}
	}

		public void play() throws IOException {
			Scanner scanner = new Scanner(System.in);

			int points = 0;

			ObjectMapper mapper = new ObjectMapper();
			List<Question> questions = mapper
					.readValue(file, new TypeReference<>() {
					});
			for(Question question : questions){
				System.out.println(question.getPytanie());
				System.out.println("a: " + question.getA());
				System.out.println("b: " + question.getB());
				System.out.println("c: " + question.getC());
				System.out.println("d: " + question.getD());
				System.out.println();
				System.out.println("Podaj odpowiedź (a, b, c, d) : ");

				String answer = scanner.nextLine();

				if (question.getPrawidlowaOdpowiedz().equals(answer)){
					System.out.println("Odpoweidź poprawna!");
					System.out.println();
					points++;
				} else {
					System.out.println("Niestety to błędna odpowiedź. Prawidłowa odpowiedź to " +
							question.getPrawidlowaOdpowiedz());
					System.out.println();
				}
				if(points == 1){
					System.out.println("Udało Ci się uzyskać : " + points + " punkt");
				}
				else if(points == 0) {
					System.out.println("Udało Ci się uzyskać : " + points + " punktów");
				}
				else {
					System.out.println("Udało Ci się uzyskać : " + points + " punkty");
				}



			}
			scanner.close();

	}
}

