package carsharing.processors.impl.customer;

import carsharing.processors.ICustomerProcessors;

public class RentNewCarProcessor implements ICustomerProcessors {
    @Override
    public boolean doAction(int rentedCarId) {
        return true;
    }

    @Override
    public String getSupportedActionTitle() {
        return "1";
    }
}
