package carsharing.processors.impl.role;

import carsharing.ConsoleReader;
import carsharing.Constants;
import carsharing.processors.ICrudCompanyProcessors;
import carsharing.processors.ICrudCompanyProcessorsFactory;
import carsharing.processors.IRoleActionProcessor;

public class RoleManagerProcessor implements IRoleActionProcessor {

    public RoleManagerProcessor(ICrudCompanyProcessorsFactory crudCompanyProcessorsFactory) {
        this.crudCompanyProcessorsFactory = crudCompanyProcessorsFactory;
    }

    private final ICrudCompanyProcessorsFactory crudCompanyProcessorsFactory;

    @Override
    public boolean doAction() {
        boolean needContinue = true;
        while (needContinue) {
            String actionTitle = ConsoleReader.getStringFromConsole("1. Company list" + Constants.LINE_SEPARATOR
                    + "2. Create a company" + Constants.LINE_SEPARATOR + "0. Back");
            ICrudCompanyProcessors crudCompanyProcessors = crudCompanyProcessorsFactory.getProcessorByAction(actionTitle);
            needContinue = crudCompanyProcessors.doAction();
        }
        return true;
    }

    @Override
    public String getSupportedActionTitle() {
        return "1";
    }
}
