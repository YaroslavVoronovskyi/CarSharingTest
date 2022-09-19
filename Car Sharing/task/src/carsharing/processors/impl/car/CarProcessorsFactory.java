package carsharing.processors.impl.car;

import carsharing.processors.ICarProcessors;
import carsharing.processors.ICarProcessorsFactory;

import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

public class CarProcessorsFactory implements ICarProcessorsFactory {

    private final Map<String, ICarProcessors> processorsMap;

    public CarProcessorsFactory(List<ICarProcessors> carProcessorsList) {
        processorsMap = carProcessorsList.stream()
                .collect(Collectors.toMap(ICarProcessors::getSupportedActionTitle, Function.identity()));
    }

    @Override
    public ICarProcessors getProcessorByAction(String actionTitle) {
        return processorsMap.get(actionTitle);
    }
}
