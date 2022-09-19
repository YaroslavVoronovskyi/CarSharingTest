package carsharing.processors.impl.customer;

import carsharing.model.Customer;
import carsharing.processors.ICustomerProcessors;
import carsharing.service.ICustomerService;

import java.util.List;

public class ShowCustomerRentedCarProcessor implements ICustomerProcessors {

    private final ICustomerService customerService;

    public ShowCustomerRentedCarProcessor(ICustomerService customerService) {
        this.customerService = customerService;
    }

    @Override
    public boolean doAction(int rentedCarId) {
        List<Customer> customersList = customerService.getAll();
        if (customersList.size() == 0) {
            System.out.println("You didn't rent a car!");
            return true;
        }
        return true;
    }


    @Override
    public String getSupportedActionTitle() {
        return "3";
    }
}
