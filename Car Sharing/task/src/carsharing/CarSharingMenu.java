package carsharing;

import carsharing.processors.IMainActionProcessor;
import carsharing.processors.IMainProcessorFactory;

public class CarSharingMenu {

    private final IMainProcessorFactory processorFactory;

    public CarSharingMenu(IMainProcessorFactory processorFactory) {
        this.processorFactory = processorFactory;
    }

    public void runCarSharingMenu() {
        try {
            boolean needContinue = true;
            while (needContinue) {
                String actionTitle = ConsoleReader.getStringFromConsole(
                        "1. Log in as a manager" + Constants.LINE_SEPARATOR +
                        "2. Log in as a customer" + Constants.LINE_SEPARATOR +
                        "3. Create a customer" + Constants.LINE_SEPARATOR +
                        "0. Exit");
                IMainActionProcessor processor = processorFactory.getProcessorByAction(actionTitle);
                needContinue = processor.doAction();
            }
        } catch (Exception exception) {
            System.out.println(exception.getMessage());
        }
    }
}
