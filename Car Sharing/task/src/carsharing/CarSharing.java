package carsharing;

import carsharing.processors.IRoleActionProcessor;
import carsharing.processors.IRoleProcessorFactory;

public class CarSharing {

    private final IRoleProcessorFactory processorFactory;

    public CarSharing(IRoleProcessorFactory processorFactory) {
        this.processorFactory = processorFactory;
    }

    public void runCarSharing() {
        try {
            boolean needContinue = true;
            while (needContinue) {
                String actionTitle = ConsoleReader.getStringFromConsole("1. Log in as a manager" +
                        Constants.LINE_SEPARATOR + "0. Exit");
                IRoleActionProcessor processor = processorFactory.getProcessorByAction(actionTitle);
                needContinue = processor.doAction();
            }
        } catch (Exception exception) {
            System.out.println(exception.getMessage());
        }
    }
}
