package carsharing.processors.impl.car;

import carsharing.model.Company;
import carsharing.processors.ICarProcessors;

public class BackFromCarMenuToPreviousMenuProcessor implements ICarProcessors {
    @Override
    public boolean doAction(int companyId) {
        return false;
    }

    @Override
    public String getSupportedActionTitle() {
        return "0";
    }
}
