package carsharing.service;

import carsharing.model.Customer;

import java.util.List;

public interface ICustomerService {
    Customer getById(int id);

    List<Customer> getAll();

    List<Customer> getAllByCarId(int customerId);

    void save(Customer customer);

    void update(Customer customer);

    void delete(Customer customer);
}
