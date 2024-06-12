package com.example.technomakers.springbatch.exercice.config;

import com.example.technomakers.springbatch.exercice.model.Car;
import org.springframework.batch.item.file.mapping.BeanWrapperFieldSetMapper;
import org.springframework.batch.item.file.mapping.DefaultLineMapper;
import org.springframework.batch.item.file.transform.DelimitedLineTokenizer;
import org.springframework.core.io.ClassPathResource;
import org.springframework.batch.item.file.FlatFileItemReader;


public class CarItemReader extends FlatFileItemReader<Car> {

    public CarItemReader() {
        setResource(new ClassPathResource("cars.csv"));
        setLinesToSkip(1);
        setLineMapper(new DefaultLineMapper<Car>() {{
            setLineTokenizer(new DelimitedLineTokenizer() {{
                setNames("id","brand", "model", "year");
            }});
            setFieldSetMapper(new BeanWrapperFieldSetMapper<Car>() {{
                setTargetType(Car.class);
            }});
        }});
    }
}
