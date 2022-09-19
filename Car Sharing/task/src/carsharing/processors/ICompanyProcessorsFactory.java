package carsharing.processors;

public interface ICompanyProcessorsFactory {

    ICompanyProcessors getProcessorByAction(String actionTitle);
}
