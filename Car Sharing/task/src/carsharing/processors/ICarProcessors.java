package carsharing.processors;

public interface ICarProcessors {

    boolean doAction(int companyId);

    String getSupportedActionTitle();
}
