package com.example.technomakers.springbatch.exercice.config;

import org.springframework.batch.item.file.FlatFileItemReader;
import org.springframework.batch.item.file.mapping.BeanWrapperFieldSetMapper;
import org.springframework.batch.item.file.mapping.DefaultLineMapper;
import org.springframework.batch.item.file.transform.DelimitedLineTokenizer;
import org.springframework.core.io.ClassPathResource;

import com.example.technomakers.springbatch.exercice.model.Student;

public class StudentItemReader extends FlatFileItemReader<Student> {
    public StudentItemReader() {
        setResource(new ClassPathResource("students.csv"));
        setLinesToSkip(1);
        setLineMapper(new DefaultLineMapper<Student>() {{
            setLineTokenizer(new DelimitedLineTokenizer() {{
                setNames("id","name", "marks", "hours");
            }});
            setFieldSetMapper(new BeanWrapperFieldSetMapper<Student>() {{
                setTargetType(Student.class);
            }});
        }});
    }
}
