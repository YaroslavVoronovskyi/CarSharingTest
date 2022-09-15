package carsharing.processors;

public interface ICrudCompanyProcessorsFactory {

    ICrudCompanyProcessors getProcessorByAction(String actionTitle);
}
