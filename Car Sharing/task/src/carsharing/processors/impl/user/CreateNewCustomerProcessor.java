package carsharing.processors.impl.user;

import carsharing.ConsoleReader;
import carsharing.model.Customer;
import carsharing.processors.IUsersRoleActionProcessor;
import carsharing.service.ICustomerService;

public class CreateNewCustomerProcessor implements IUsersRoleActionProcessor {

    private final ICustomerService customerService;

    public CreateNewCustomerProcessor(ICustomerService customerService) {
        this.customerService = customerService;
    }

    @Override
    public boolean doAction() {
        String name = ConsoleReader.getStringFromConsole("Enter the customer name:");
        Customer customer = new Customer(name);
        customerService.save(customer);
        System.out.println("The customer was created!");
        return true;
    }

    @Override
    public String getSupportedActionTitle() {
        return "3";
    }
}
