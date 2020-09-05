package autoria.services;

import autoria.entities.Car;
import autoria.repositories.CarRepository;

public interface CarService {
    Car finByName(String name);
    Car save(CarRepository repository);
}
