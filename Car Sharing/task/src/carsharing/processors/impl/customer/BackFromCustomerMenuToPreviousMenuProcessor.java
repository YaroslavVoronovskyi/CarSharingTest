package carsharing.processors.impl.customer;

import carsharing.processors.ICustomerProcessors;

public class BackFromCustomerMenuToPreviousMenuProcessor implements ICustomerProcessors {
    @Override
    public boolean doAction(int customerId) {
        return false;
    }

    @Override
    public String getSupportedActionTitle() {
        return "0";
    }
}
