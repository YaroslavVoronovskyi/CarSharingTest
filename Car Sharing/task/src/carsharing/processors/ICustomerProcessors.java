package carsharing.processors;

public interface ICustomerProcessors {

    boolean doAction(int customerId);

    String getSupportedActionTitle();
}
