package carsharing.processors;

public interface ICustomerProcessors {

    boolean doAction(int rentedCarId);

    String getSupportedActionTitle();
}
