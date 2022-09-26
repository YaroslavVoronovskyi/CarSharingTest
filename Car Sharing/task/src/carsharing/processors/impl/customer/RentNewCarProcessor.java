package carsharing.processors.impl.customer;

import carsharing.ConsoleReader;
import carsharing.Constants;
import carsharing.model.Car;
import carsharing.model.Company;
import carsharing.model.Customer;
import carsharing.processors.ICustomerProcessors;
import carsharing.service.ICarService;
import carsharing.service.ICompanyService;
import carsharing.service.ICustomerService;

import java.util.List;

public class RentNewCarProcessor implements ICustomerProcessors {

    private final ICompanyService companyService;
    private final ICarService carService;
    private final ICustomerService customerService;

    public RentNewCarProcessor(ICompanyService companyService, ICarService carService, ICustomerService customerService) {
        this.companyService = companyService;
        this.carService = carService;
        this.customerService = customerService;
    }

    @Override
    public boolean doActionWithCustomer(int customerId) {
        List<Company> companiesList = companyService.getAll();
        if (companiesList.size() == 0) {
            System.out.println("The company list is empty!");
            return true;
        }
        Customer customer = customerService.getById(customerId);

        if (customer.getRentedCarId() > 0) {
            System.out.println("You've already rented a car!");
            return true;
        }

        System.out.println("Choose a company: ");
        for (Company company : companiesList) {
            System.out.println(company.getId() + Constants.DOT_SEPARATOR + company.getName());
        }
        System.out.println("0. Back");

        int companyId = ConsoleReader.getIntFromConsole();
        Company company = companyService.getById(companyId);

        List<Car> carsList = carService.getAllCarsByCompanyId(company.getId());

        if (carsList.size() == 0) {
            System.out.println("The car list is empty!");
            int index = 0;
            for (Company company1 : companiesList) {
                index++;
                System.out.println(index+ Constants.DOT_SEPARATOR + company1.getName());
            }
            System.out.println("0. Back");
            int companyId1 = ConsoleReader.getIntFromConsole();
            return true;
        }
        System.out.println("Choose a car: ");

        int indexCar = 0;
        for (Car car : carsList) {
            indexCar++;
            System.out.println(indexCar + Constants.DOT_SEPARATOR + car.getName());
        }
        System.out.println("0. Back");

        int carId = ConsoleReader.getIntFromConsole();
        Car car = carsList.get(carId - 1);

        customer.setRentedCarId(car.getId());
        car.setRented(true);
        carService.update(car);
        customerService.update(customer);
        System.out.println("You rented '" + car.getName() + "'");
        return true;
    }

    @Override
    public String getSupportedCustomerActionTitle() {
        return "1";
    }
}
