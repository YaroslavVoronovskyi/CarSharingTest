package carsharing.dao;

import carsharing.model.Car;

import java.util.List;

public interface ICarDao {

    Car getById(int id);

    List<Car> getAllByCompanyId(int companyId);

//    List<Car> getAll();

    void save(Car car);

    void update(Car car);

    void delete(Car car);

    Car getCar(int companyId);
}
