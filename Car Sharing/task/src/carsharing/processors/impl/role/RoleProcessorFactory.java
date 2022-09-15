package carsharing.processors.impl.role;

import carsharing.processors.IRoleActionProcessor;
import carsharing.processors.IRoleProcessorFactory;

import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

public class RoleProcessorFactory implements IRoleProcessorFactory {

    private final Map<String, IRoleActionProcessor> processorsMap;

    public RoleProcessorFactory(List<IRoleActionProcessor> roleActionProcessorFactoriesList) {
        processorsMap = roleActionProcessorFactoriesList.stream()
                .collect(Collectors.toMap(IRoleActionProcessor::getSupportedActionTitle, Function.identity()));
    }

    @Override
    public IRoleActionProcessor getProcessorByAction(String actionTitle) {
        return processorsMap.get(actionTitle);
    }
}
