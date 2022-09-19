package carsharing.service;

import carsharing.model.Car;

import java.util.List;

public interface ICarService {

    Car getById(int id);

    List<Car> getAll();

    void save(Car car);

    void update(Car car);

    void delete(Car car);
}
