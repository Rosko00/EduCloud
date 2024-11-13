package com.example.EduCloud.service;

import com.example.EduCloud.model.MathProblem;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

@Service
public class MathService {

    public List<MathProblem> generateProblems() {
        List<MathProblem> problems = new ArrayList<>();
        Random random = new Random();

        for (int i = 0; i < 10; i++) {
            int operand1 = random.nextInt(10);
            int operand2 = random.nextInt(10);
            String operator = random.nextBoolean() ? "+" : "-";
            int answer = operator.equals("+") ? operand1 + operand2 : operand1 - operand2;

            // Zabezpečiť, že odpoveď nebude záporná
            if (answer < 0) {
                operand1 = Math.max(operand1, operand2);
                operand2 = Math.min(operand1, operand2);
                answer = operand1 - operand2;
            }

            MathProblem problem = new MathProblem(operand1, operand2, operator, answer);
            problems.add(problem);
        }

        return problems;
    }
}
