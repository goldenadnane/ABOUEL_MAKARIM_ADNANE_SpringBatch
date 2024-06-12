package com.example.technomakers.springbatch.exercice.config;

import com.example.technomakers.springbatch.exercice.model.Car;
import org.springframework.batch.item.ItemProcessor;

public class CarItemProcessor implements ItemProcessor<Car, Car> {

    @Override
    public Car process(Car car) throws Exception {
        if (car.getYear() > 2010) {
            car.setYear(car.getYear() + 1);
        }
        return car;
    }
}
