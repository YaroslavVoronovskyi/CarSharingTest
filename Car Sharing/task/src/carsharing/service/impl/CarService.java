package carsharing.service.impl;

import carsharing.dao.ICarDao;
import carsharing.model.Car;
import carsharing.service.ICarService;

import java.util.List;

public class CarService implements ICarService {

    private final ICarDao carDao;

    public CarService(ICarDao carDao) {
        this.carDao = carDao;
    }

    @Override
    public Car getById(int id) {

        return carDao.getById(id);
    }

//    @Override
//    public List<Car> getAll() {
//        return carDao.getAll();
//    }

    @Override
    public List<Car> getAllByCompanyId(int companyId) {
        return carDao.getAllByCompanyId(companyId);
    }

        @Override
    public void save(Car car) {
        carDao.save(car);
    }

    @Override
    public void update(Car car) {
        carDao.update(car);
    }

    @Override
    public void delete(Car car) {
        carDao.delete(car);
    }
}
