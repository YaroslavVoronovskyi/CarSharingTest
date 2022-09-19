package carsharing.processors.impl.company;

import carsharing.processors.ICompanyProcessors;

public class BackFromCompanyMenuToPreviousMenuProcessor implements ICompanyProcessors {
    @Override
    public boolean doAction() {
        return false;
    }

    @Override
    public String getSupportedActionTitle() {
        return "0";
    }
}
