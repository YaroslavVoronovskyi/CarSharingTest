package carsharing.processors.impl.main;

import carsharing.processors.IMainActionProcessor;

public class ExitApplicationProcessor implements IMainActionProcessor {
    @Override
    public boolean doAction() {
        return false;
    }

    @Override
    public String getSupportedActionTitle() {
        return "0";
    }
}
