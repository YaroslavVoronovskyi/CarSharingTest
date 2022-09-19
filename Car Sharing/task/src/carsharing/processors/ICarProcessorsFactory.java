package carsharing.processors;

public interface ICarProcessorsFactory {

    ICarProcessors getProcessorByAction(String actionTitle);

}
