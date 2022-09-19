package carsharing.processors;

import carsharing.model.Company;

public interface ICarProcessors {

    boolean doAction(int companyId);

    String getSupportedActionTitle();
}
