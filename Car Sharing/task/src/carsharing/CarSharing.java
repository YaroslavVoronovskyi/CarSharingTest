package carsharing;

import carsharing.processors.IUsersRoleActionProcessor;
import carsharing.processors.IUsersRoleProcessorFactory;

public class CarSharing {

    private final IUsersRoleProcessorFactory processorFactory;

    public CarSharing(IUsersRoleProcessorFactory processorFactory) {
        this.processorFactory = processorFactory;
    }

    public void runCarSharing() {
        try {
            boolean needContinue = true;
            while (needContinue) {
                String actionTitle = ConsoleReader.getStringFromConsole(
                        "1. Log in as a manager" + Constants.LINE_SEPARATOR +
                        "2. Log in as a customer" + Constants.LINE_SEPARATOR +
                        "3. Create a customer" + Constants.LINE_SEPARATOR +
                        "0. Exit");
                IUsersRoleActionProcessor processor = processorFactory.getProcessorByAction(actionTitle);
                needContinue = processor.doAction();
            }
        } catch (Exception exception) {
            System.out.println(exception.getMessage());
        }
    }
}
