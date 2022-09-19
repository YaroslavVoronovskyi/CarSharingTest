package carsharing.processors.impl.user;

import carsharing.processors.IUsersRoleActionProcessor;

public class ExitApplicationProcessor implements IUsersRoleActionProcessor {
    @Override
    public boolean doAction() {
        return false;
    }

    @Override
    public String getSupportedActionTitle() {
        return "0";
    }
}
