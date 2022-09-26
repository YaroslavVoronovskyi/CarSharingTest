package carsharing.processors.impl.company;

import carsharing.ConsoleReader;
import carsharing.Constants;
import carsharing.model.Company;
import carsharing.processors.ICarProcessors;
import carsharing.processors.ICarProcessorsFactory;
import carsharing.processors.ICompanyProcessors;
import carsharing.service.ICompanyService;

import java.util.List;

public class ShowCompaniesListProcessor implements ICompanyProcessors {

    private final ICompanyService companyService;

    private final ICarProcessorsFactory carProcessorsFactory;

    public ShowCompaniesListProcessor(ICompanyService companyService, ICarProcessorsFactory carProcessorsFactory) {
        this.companyService = companyService;
        this.carProcessorsFactory = carProcessorsFactory;
    }

    @Override
    public boolean doActionWithCompany() {
        List<Company> companiesList = companyService.getAll();
        if (companiesList.size() == 0) {
            System.out.println("The company list is empty!");
            return true;
        }

        int index = 0;
        System.out.println("Choose a company: ");
        for (Company company : companiesList) {
            index++;
            System.out.println(index + Constants.DOT_SEPARATOR + company.getName());
        }
        System.out.println("0. Back");

        int companyId = ConsoleReader.getIntFromConsole();

        if (companyId == 0) {
            return true;
        }
        boolean needContinue = true;
        while (needContinue) {
            Company company = companiesList.get(companyId - 1);
            String actionTitle = ConsoleReader.getStringFromConsole("'" + company.getName() + "' company:" + Constants.LINE_SEPARATOR
                    + "1. Car list" + Constants.LINE_SEPARATOR
                    + "2. Create a car" + Constants.LINE_SEPARATOR
                    + "0. Back");
            ICarProcessors carProcessors = carProcessorsFactory.getCarProcessorByAction(actionTitle);
            needContinue = carProcessors.doActionWithCar(company.getId());
        }
        return true;
    }

    @Override
    public String getSupportedCompanyActionTitle() {
        return "1";
    }
}
