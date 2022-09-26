package carsharing.processors.impl.main;

import carsharing.ConsoleReader;
import carsharing.Constants;
import carsharing.model.Customer;
import carsharing.processors.ICustomerProcessors;
import carsharing.processors.ICustomerProcessorsFactory;
import carsharing.processors.IMainActionProcessor;
import carsharing.service.ICustomerService;

import java.util.List;

public class CustomerProcessor implements IMainActionProcessor {

    private final ICustomerService customerService;
    private final ICustomerProcessorsFactory customerProcessorsFactory;

    public CustomerProcessor(ICustomerService customerService, ICustomerProcessorsFactory customerProcessorsFactory) {
        this.customerService = customerService;
        this.customerProcessorsFactory = customerProcessorsFactory;
    }

    @Override
    public boolean doAction() {
        List<Customer> customersList = customerService.getAll();
        if (customersList.size() == 0) {
            System.out.println("The customer list is empty!");
            return true;
        }
        System.out.println("Choose a customer:");
        int index = 0;
        for (Customer customer : customersList) {
            index++;
            System.out.println(index + Constants.DOT_SEPARATOR + customer.getName()
                    + Constants.DELIMETER + "customer");
        }

        System.out.println("0. Back");
        int customerId = ConsoleReader.getIntFromConsole();

        if (customerId == 0) {
            return true;
        }
        boolean needContinue = true;
        while (needContinue) {
            Customer customer = customersList.get(customerId - 1);
            String actionTitle = ConsoleReader.getStringFromConsole(
                    "'" + customer.getName() + "' customer:" + Constants.LINE_SEPARATOR +
                            "1. Rent a car" + Constants.LINE_SEPARATOR +
                            "2. Return a rented car" + Constants.LINE_SEPARATOR +
                            "3. My rented car" + Constants.LINE_SEPARATOR +
                            "0. Back");
            ICustomerProcessors customerProcessors = customerProcessorsFactory.getCustomerProcessorByAction(actionTitle);
            needContinue = customerProcessors.doActionWithCustomer(customer.getId());
        }
        return true;
    }

    @Override
    public String getSupportedActionTitle() {
        return "2";
    }
}
