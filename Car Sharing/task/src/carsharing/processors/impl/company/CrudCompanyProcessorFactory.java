package carsharing.processors.impl.company;

import carsharing.processors.ICompanyProcessors;
import carsharing.processors.ICompanyProcessorsFactory;

import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

public class CrudCompanyProcessorFactory implements ICompanyProcessorsFactory {

    private final Map<String, ICompanyProcessors> processorsMap;

    public CrudCompanyProcessorFactory(List<ICompanyProcessors> crudCompanyProcessorsList) {
        processorsMap = crudCompanyProcessorsList.stream()
                .collect(Collectors.toMap(ICompanyProcessors::getSupportedActionTitle, Function.identity()));
    }

    @Override
    public ICompanyProcessors getProcessorByAction(String actionTitle) {
        return processorsMap.get(actionTitle);
    }
}
