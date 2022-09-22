package carsharing.dao;

import carsharing.model.Car;
import carsharing.model.Customer;

import java.util.List;

public interface ICustomerDao {

    Customer getById(int id);

    List<Customer> getAll();

    List<Customer> getAllByCompanyId(int customerId);

    void save(Customer customer);

    void update(Customer customer);

    void delete(Customer customer);
}
