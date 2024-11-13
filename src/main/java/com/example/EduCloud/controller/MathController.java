package com.example.EduCloud.controller;

import com.example.EduCloud.service.MathService; // Správny import

import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/math")
public class MathController {

    private final MathService mathService;

    public MathController(MathService mathService) {
        this.mathService = mathService;
    }

    // Endpoint na generovanie 10 príkladov
    @GetMapping("/generate")
    public List<String> generateProblems() {
        return mathService.generateProblems();
    }

    // Endpoint na vyhodnotenie odpovede
    @PostMapping("/evaluate")
    public String evaluateAnswer(@RequestParam String problem, @RequestParam int answer) {
        return mathService.evaluateAnswer(problem, answer);
    }

    // Endpoint na zobrazenie štatistík
    @GetMapping("/statistics")
    public String getStatistics() {
        return mathService.getStatistics();
    }
}
