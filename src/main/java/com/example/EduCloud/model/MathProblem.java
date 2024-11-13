package com.example.EduCloud.model;

public class MathProblem {

    private int operand1;
    private int operand2;
    private String operator;
    private int answer;

    public MathProblem(int operand1, int operand2, String operator, int answer) {
        this.operand1 = operand1;
        this.operand2 = operand2;
        this.operator = operator;
        this.answer = answer;
    }

    public int getOperand1() {
        return operand1;
    }

    public void setOperand1(int operand1) {
        this.operand1 = operand1;
    }

    public int getOperand2() {
        return operand2;
    }

    public void setOperand2(int operand2) {
        this.operand2 = operand2;
    }

    public String getOperator() {
        return operator;
    }

    public void setOperator(String operator) {
        this.operator = operator;
    }

    public int getAnswer() {
        return answer;
    }

    public void setAnswer(int answer) {
        this.answer = answer;
    }
}
