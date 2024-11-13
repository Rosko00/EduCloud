package com.example.EduCloud.model;

public class UserAnswer {

    private int problemId;
    private int userAnswer;
    private boolean isCorrect;

    public UserAnswer(int problemId, int userAnswer) {
        this.problemId = problemId;
        this.userAnswer = userAnswer;
        this.isCorrect = (this.userAnswer == problemId);
    }

    public int getProblemId() {
        return problemId;
    }

    public void setProblemId(int problemId) {
        this.problemId = problemId;
    }

    public int getUserAnswer() {
        return userAnswer;
    }

    public void setUserAnswer(int userAnswer) {
        this.userAnswer = userAnswer;
    }

    public boolean isCorrect() {
        return isCorrect;
    }

    public void setCorrect(boolean correct) {
        isCorrect = correct;
    }
}

