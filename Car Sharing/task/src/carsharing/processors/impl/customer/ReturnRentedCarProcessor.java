package carsharing.processors.impl.customer;

import carsharing.model.Customer;
import carsharing.processors.ICustomerProcessors;
import carsharing.service.ICarService;
import carsharing.service.ICustomerService;

import java.util.List;

public class ReturnRentedCarProcessor implements ICustomerProcessors {

    private final ICustomerService customerService;
    public final ICarService carService;

    public ReturnRentedCarProcessor(ICustomerService customerService, ICarService carService) {
        this.customerService = customerService;
        this.carService = carService;
    }

    @Override
    public boolean doAction(int customerId) {
        List<Customer> customersList = customerService.getAll();
        Customer customer = customersList.get(customerId - 1);
        if (customer.getRentedCarId() <= 0) {
            System.out.println("You didn't rent a car!");
            return true;
        } else if (customer.getRentedCarId() > 0) {
            customer.setRentedCarId(null);
            customerService.delete(customer);
            System.out.println("You've returned a rented car!");
        }
//        System.out.println("You've returned a rented car!");
        return true;
    }

    @Override
    public String getSupportedActionTitle() {
        return "2";
    }
}
