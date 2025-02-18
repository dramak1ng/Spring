package web.service;

import model.Car;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Service
public class CarServiceImpl implements CarService {
    List<Car> cars = Arrays.asList(
            new Car("toyota", 1.5, "yellow"),
            new Car("arak", 2.5, "red"),
            new Car("lada", 1.6, "white"),
            new Car("priora", 5.0, "black"),
            new Car("Niva", 3.0, "green")
    );

    public  List<Car> getCars(int count) {
        List<Car> cars1 = new ArrayList<Car>();
        if (count > 0) {
            if (count > 5) {
                count = 5;
            }
            for (int i = 0; i < count; i++) {
                cars1.add(cars.get(i));

            }
            return cars1;
        } else {
            return null;
        }


    }

}
