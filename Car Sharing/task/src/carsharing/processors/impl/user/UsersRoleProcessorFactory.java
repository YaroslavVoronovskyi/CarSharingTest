package carsharing.processors.impl.user;

import carsharing.processors.IUsersRoleActionProcessor;
import carsharing.processors.IUsersRoleProcessorFactory;

import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

public class UsersRoleProcessorFactory implements IUsersRoleProcessorFactory {

    private final Map<String, IUsersRoleActionProcessor> processorsMap;

    public UsersRoleProcessorFactory(List<IUsersRoleActionProcessor> usersRoleActionProcessorFactoriesList) {
        processorsMap = usersRoleActionProcessorFactoriesList.stream()
                .collect(Collectors.toMap(IUsersRoleActionProcessor::getSupportedActionTitle, Function.identity()));
    }

    @Override
    public IUsersRoleActionProcessor getProcessorByAction(String actionTitle) {
        return processorsMap.get(actionTitle);
    }
}
