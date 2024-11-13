package com.example.EduCloud.controller;

import com.example.EduCloud.model.MathProblem;
import com.example.EduCloud.model.ResultResponse;
import com.example.EduCloud.model.UserAnswer;
import com.example.EduCloud.service.MathService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/math")
public class MathController {

    private final MathService mathService;

    public MathController(MathService mathService) {
        this.mathService = mathService;
    }

    @GetMapping("/generate")
    public List<MathProblem> generateProblems() {
        return mathService.generateProblems();
    }

    @PostMapping("/submit")
    public ResultResponse submitAnswers(@RequestBody List<UserAnswer> answers) {
        int correctCount = 0;
        long totalTime = 0;

        for (UserAnswer answer : answers) {
            if (answer.isCorrect()) {
                correctCount++;
            } else {
                totalTime += 60000; // pridá 1 minútu za nesprávnu odpoveď
            }
        }

        return new ResultResponse(correctCount, totalTime);
    }
}
