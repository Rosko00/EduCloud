package com.example.EduCloud.service;

import org.springframework.stereotype.Service;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

@Service
public class MathService {

    private final Random random = new Random();
    private int correctAnswers = 0;
    private int wrongAnswers = 0;

    public List<String> generateProblems() {
        List<String> problems = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            int num1 = random.nextInt(10);
            int num2 = random.nextInt(10);
            String operator = random.nextBoolean() ? "+" : "-";
            String problem = num1 + " " + operator + " " + num2;
            problems.add(problem);
        }
        return problems;
    }

    public String evaluateAnswer(String problem, int answer) {
        String[] parts = problem.split(" ");
        int num1 = Integer.parseInt(parts[0]);
        int num2 = Integer.parseInt(parts[2]);
        int correctAnswer = parts[1].equals("+") ? num1 + num2 : num1 - num2;

        if (answer == correctAnswer) {
            correctAnswers++;
            return "Správne!";
        } else {
            wrongAnswers++;
            return "Nesprávne!";
        }
    }

    public String getStatistics() {
        return "Správnych odpovedí: " + correctAnswers + ", Nesprávnych odpovedí: " + wrongAnswers;
    }
}
