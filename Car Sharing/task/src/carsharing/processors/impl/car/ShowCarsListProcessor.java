package carsharing.processors.impl.car;

import carsharing.Constants;
import carsharing.model.Car;
import carsharing.model.Company;
import carsharing.processors.ICarProcessors;
import carsharing.service.ICarService;
import carsharing.service.ICompanyService;

import java.util.List;

public class ShowCarsListProcessor implements ICarProcessors {

    private final ICarService carService;
    private final ICompanyService companyService;

    public ShowCarsListProcessor(ICarService carService, ICompanyService companyService) {
        this.carService = carService;
        this.companyService = companyService;
    }

    @Override
    public boolean doAction(int companyId) {
        List<Car> carsList = carService.getAll();
        Company company = companyService.getById(companyId);
        int index = 0;
        System.out.println("'" + company.getName() + "' company:");
        for (Car car : carsList) {
            if (car.getCompanyId() == 0) {
                System.out.println("The car list is empty!");
            }
            index++;
            System.out.println(index + Constants.DOT_SEPARATOR + car.getName());

            if (carsList.size() == 0) {
                System.out.println("The car list is empty!");
                return true;
            }
//            System.out.println(car.getCompanyId() + Constants.DOT_SEPARATOR + car.getId()
//                    + Constants.FIRST_COLUMN_INDEX + car.getCompanyId());
//            index++;
//            System.out.println(index + Constants.DOT_SEPARATOR + car.getName());
        }
        return true;
    }

    @Override
    public String getSupportedActionTitle() {
        return "1";
    }
}
