package carsharing.processors.impl.role;

import carsharing.processors.IRoleActionProcessor;

public class ExitApplicationProcessor implements IRoleActionProcessor {
    @Override
    public boolean doAction() {
        return false;
    }

    @Override
    public String getSupportedActionTitle() {
        return "0";
    }
}
