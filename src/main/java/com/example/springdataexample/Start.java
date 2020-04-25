package com.example.springdataexample;

import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.event.EventListener;
import org.springframework.http.converter.json.GsonBuilderUtils;
import org.springframework.stereotype.Component;

@Component
public class Start {

    public CarRepository carRepository;


    public Start(CarRepository carRepository) {
        this.carRepository = carRepository;
    }

    @EventListener(ApplicationReadyEvent.class)
    public void runExample(){

        Car car1 = new Car("Honda", "Jazz", Color.BLACK);
        carRepository.save(car1);

        Car car2 = new Car("Fiat", "Siena", Color.RED);
        carRepository.save(car2);

        Car car3 = new Car("Audi", "A3", Color.RED);
        carRepository.save(car3);

        Car car4 = new Car("BMW", "M6", Color.RED);
        carRepository.save(car4);

        Car car5 = new Car("Fiat", "Multipla", Color.BLUE);
        carRepository.save(car5);

        //carRepository.deleteById(1L);

        getAll().forEach(System.out::println);


    }

    private Iterable<Car> getAll() {
        return carRepository.findAllByColor(Color.RED);
    }
}
