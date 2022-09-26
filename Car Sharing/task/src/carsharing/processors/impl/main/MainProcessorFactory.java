package carsharing.processors.impl.main;

import carsharing.processors.IMainActionProcessor;
import carsharing.processors.IMainProcessorFactory;

import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

public class MainProcessorFactory implements IMainProcessorFactory {

    private final Map<String, IMainActionProcessor> processorsMap;

    public MainProcessorFactory(List<IMainActionProcessor> mainActionProcessorFactoriesList) {
        processorsMap = mainActionProcessorFactoriesList.stream()
                .collect(Collectors.toMap(IMainActionProcessor::getSupportedActionTitle, Function.identity()));
    }

    @Override
    public IMainActionProcessor getProcessorByAction(String actionTitle) {
        return processorsMap.get(actionTitle);
    }
}
