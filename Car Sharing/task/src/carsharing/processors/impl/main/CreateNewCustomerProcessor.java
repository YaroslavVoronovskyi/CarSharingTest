package carsharing.processors.impl.main;

import carsharing.ConsoleReader;
import carsharing.model.Customer;
import carsharing.processors.IMainActionProcessor;
import carsharing.service.ICustomerService;

public class CreateNewCustomerProcessor implements IMainActionProcessor {

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
