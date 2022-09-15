package carsharing.processors.impl.crud;

import carsharing.processors.ICrudCompanyProcessors;

public class BackToPreviousMenuProcessor implements ICrudCompanyProcessors {
    @Override
    public boolean doAction() {
        return false;
    }

    @Override
    public String getSupportedActionTitle() {
        return "0";
    }
}
