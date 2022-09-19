package carsharing.processors.impl.company;

import carsharing.processors.ICompanyProcessors;
import carsharing.processors.ICompanyProcessorsFactory;

import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

public class CompanyProcessorFactory implements ICompanyProcessorsFactory {

    private final Map<String, ICompanyProcessors> processorsMap;

    public CompanyProcessorFactory(List<ICompanyProcessors> companyProcessorsList) {
        processorsMap = companyProcessorsList.stream()
                .collect(Collectors.toMap(ICompanyProcessors::getSupportedActionTitle, Function.identity()));
    }

    @Override
    public ICompanyProcessors getProcessorByAction(String actionTitle) {

        return processorsMap.get(actionTitle);
    }
}
