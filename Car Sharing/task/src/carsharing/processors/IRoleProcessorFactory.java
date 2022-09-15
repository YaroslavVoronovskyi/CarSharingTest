package carsharing.processors;

public interface IRoleProcessorFactory {

    IRoleActionProcessor getProcessorByAction(String actionTitle);
}
