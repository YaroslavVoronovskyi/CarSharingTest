package carsharing.processors;

public interface ICustomerProcessorsFactory {

    ICustomerProcessors getProcessorByAction(String actionTitle);
}
