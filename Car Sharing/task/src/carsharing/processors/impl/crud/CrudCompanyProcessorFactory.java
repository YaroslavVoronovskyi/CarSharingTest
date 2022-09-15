package carsharing.processors.impl.crud;

import carsharing.processors.ICrudCompanyProcessors;
import carsharing.processors.ICrudCompanyProcessorsFactory;
import carsharing.processors.IRoleActionProcessor;

import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

public class CrudCompanyProcessorFactory implements ICrudCompanyProcessorsFactory {

    private final Map<String, ICrudCompanyProcessors> processorsMap;

    public CrudCompanyProcessorFactory(List<ICrudCompanyProcessors> crudCompanyProcessorsList) {
        processorsMap = crudCompanyProcessorsList.stream()
                .collect(Collectors.toMap(ICrudCompanyProcessors::getSupportedActionTitle, Function.identity()));
    }

    @Override
    public ICrudCompanyProcessors getProcessorByAction(String actionTitle) {
        return processorsMap.get(actionTitle);
    }
}
