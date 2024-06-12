package com.example.technomakers.springbatch.exercice.model;

public class Student {
    private String name;
    private int marks;
    private int hours;

    public String getName() { return name; }
    public void setName(String name) { this.name = name; }

    public int getMarks() { return marks; }
    public void setMarks(int marks) { this.marks = marks; }

    public int getHours() { return hours; }
    public void setHours(int hours) { this.hours = hours; }

    @Override
    public String toString() {
        return "Student{" + "name='" + name + '\'' + ", marks=" + marks + ", hours=" + hours + '}';
    }
}