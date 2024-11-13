package com.example.EduCloud.model;

public class ResultResponse {

    private int correctCount;
    private long totalTime;

    public ResultResponse(int correctCount, long totalTime) {
        this.correctCount = correctCount;
        this.totalTime = totalTime;
    }

    public int getCorrectCount() {
        return correctCount;
    }

    public void setCorrectCount(int correctCount) {
        this.correctCount = correctCount;
    }

    public long getTotalTime() {
        return totalTime;
    }

    public void setTotalTime(long totalTime) {
        this.totalTime = totalTime;
    }
}
