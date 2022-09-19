package carsharing.processors.impl.user;

import carsharing.ConsoleReader;
import carsharing.Constants;
import carsharing.model.Customer;
import carsharing.processors.ICustomerProcessors;
import carsharing.processors.ICustomerProcessorsFactory;
import carsharing.processors.IUsersRoleActionProcessor;
import carsharing.service.ICustomerService;

import java.util.List;

public class CustomerRoleProcessor implements IUsersRoleActionProcessor {

    private final ICustomerService customerService;
    private final ICustomerProcessorsFactory customerProcessorsFactory;

    public CustomerRoleProcessor(ICustomerService customerService, ICustomerProcessorsFactory customerProcessorsFactory) {
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

        int index = 0;
        System.out.println("Choose a customer:");
        for (Customer customer : customersList) {
            index++;
            System.out.println(index + Constants.DOT_SEPARATOR + customer.getName());
        }

        int recordNumber = ConsoleReader.getIntFromConsole();

        boolean needContinue = true;
        while (needContinue) {
//            Company company = companyService.getById(recordNumber);
            String actionTitle = ConsoleReader.getStringFromConsole(
                            "1. Rent a car" + Constants.LINE_SEPARATOR +
                            "2. Return a rented car" + Constants.LINE_SEPARATOR +
                            "3. My rented car" + Constants.LINE_SEPARATOR +
                            "0. Back");

            ICustomerProcessors customerProcessors = customerProcessorsFactory.getProcessorByAction(actionTitle);
            needContinue = customerProcessors.doAction(recordNumber);
//            ICarProcessors carsProcessors = carProcessorsFactory.getProcessorByAction(actionTitle);
//                carsProcessors.doAction(company);
//            needContinue = carsProcessors.doAction(recordNumber);
        }
        return true;
    }

    @Override
    public String getSupportedActionTitle() {
        return "2";
    }
}
