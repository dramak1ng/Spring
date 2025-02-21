package web.service;

import model.Car;
import org.springframework.stereotype.Service;

import java.util.List;
public interface CarService {
    List<Car> getCars(int count);
}
