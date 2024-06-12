package com.example.technomakers.springbatch.exercice.config;

import org.springframework.batch.item.ItemProcessor;

import com.example.technomakers.springbatch.exercice.model.Student;

public class StudentItemProcessor implements ItemProcessor<Student, Student> {
    @Override
    public Student process(Student student) throws Exception {
        if (student.getHours() > 30) {
            student.setMarks(student.getMarks() + 1);
        }
        return student;
    }
}
