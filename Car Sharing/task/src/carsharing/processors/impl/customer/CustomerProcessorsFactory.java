package carsharing.processors.impl.customer;

import carsharing.processors.ICustomerProcessors;
import carsharing.processors.ICustomerProcessorsFactory;

import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

public class CustomerProcessorsFactory implements ICustomerProcessorsFactory {

    private final Map<String, ICustomerProcessors> processorsMap;

    public CustomerProcessorsFactory(List<ICustomerProcessors> customerProcessorsList) {
        processorsMap = customerProcessorsList.stream()
                .collect(Collectors.toMap(ICustomerProcessors::getSupportedActionTitle, Function.identity()));
    }

    @Override
    public ICustomerProcessors getProcessorByAction(String actionTitle) {
        return processorsMap.get(actionTitle);
    }
}
