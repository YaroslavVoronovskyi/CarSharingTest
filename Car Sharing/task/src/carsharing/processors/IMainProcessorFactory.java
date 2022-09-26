package carsharing.processors;

public interface IMainProcessorFactory {

    IMainActionProcessor getProcessorByAction(String actionTitle);
}
