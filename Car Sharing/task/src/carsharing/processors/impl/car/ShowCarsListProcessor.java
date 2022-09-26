package carsharing.processors.impl.car;

import carsharing.Constants;
import carsharing.model.Car;
import carsharing.processors.ICarProcessors;
import carsharing.service.ICarService;

import java.util.List;

public class ShowCarsListProcessor implements ICarProcessors {

    private final ICarService carService;

    public ShowCarsListProcessor(ICarService carService) {
        this.carService = carService;
    }

    @Override
    public boolean doActionWithCar(int companyId) {
        List<Car> carsList = carService.getAllCarsByCompanyId(companyId);
        if (carsList.size() == 0) {
            System.out.println("The car list is empty!");
            return true;
        }

        int index = 0;
        for (Car car : carsList) {
            if (companyId != car.getCompanyId()) {
                System.out.println("The car list is empty!");
                return true;
            }
            index++;
            System.out.println(index + Constants.DOT_SEPARATOR + car.getName());
        }
        return true;
    }

    @Override
    public String getSupportedCarActionTitle() {
        return "1";
    }
}
