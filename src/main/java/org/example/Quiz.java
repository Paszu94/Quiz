package org.example;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.Objects;

public class Quiz {

    File quizJson;
    public Quiz(String fileName){
        String file =Objects.requireNonNull(this.getClass().getClassLoader().getResource(fileName)).getFile();
        quizJson = new File(file);

    }

    public void displayQuestions() throws IOException {
        ObjectMapper mapper = new ObjectMapper();
        List<Question> questions = mapper.readValue(quizJson,
                new TypeReference<>() {});

        questions.stream()
                .map(Question::getPytanie)
                .forEach(System.out::println);

    }
}
