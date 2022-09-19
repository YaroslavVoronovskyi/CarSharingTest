package carsharing.processors;

public interface IUsersRoleProcessorFactory {

    IUsersRoleActionProcessor getProcessorByAction(String actionTitle);
}
