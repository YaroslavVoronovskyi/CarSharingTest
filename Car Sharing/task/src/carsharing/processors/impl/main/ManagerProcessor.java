package carsharing.processors.impl.main;

import carsharing.ConsoleReader;
import carsharing.Constants;
import carsharing.processors.ICompanyProcessors;
import carsharing.processors.ICompanyProcessorsFactory;
import carsharing.processors.IMainActionProcessor;

public class ManagerProcessor implements IMainActionProcessor {

    public ManagerProcessor(ICompanyProcessorsFactory crudCompanyProcessorsFactory) {
        this.crudCompanyProcessorsFactory = crudCompanyProcessorsFactory;
    }

    private final ICompanyProcessorsFactory crudCompanyProcessorsFactory;

    @Override
    public boolean doAction() {
        boolean needContinue = true;
        while (needContinue) {
            String actionTitle = ConsoleReader.getStringFromConsole("1. Company list" + Constants.LINE_SEPARATOR
                    + "2. Create a company" + Constants.LINE_SEPARATOR + "0. Back");
            ICompanyProcessors crudCompanyProcessors = crudCompanyProcessorsFactory.getCompanyProcessorByAction(actionTitle);
            needContinue = crudCompanyProcessors.doActionWithCompany();
        }
        return true;
    }

    @Override
    public String getSupportedActionTitle() {
        return "1";
    }
}
