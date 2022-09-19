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
    public boolean doAction() {
        List<Company> companiesList = companyService.getAll();
        if (companiesList.size() == 0 | companiesList.isEmpty()) {
            System.out.println("The company list is empty!");
            return true;
        }

//        System.out.println("Choose a company: ");
//        Company company = companiesList.get(recordNumber);
//        System.out.println("'" + company.getName() + "'" + "" +
//                " company:" );
        int index = 0;
        System.out.println("Choose a company: ");
        for (Company company : companiesList) {
            index++;
            System.out.println(index + Constants.DOT_SEPARATOR + company.getName());
//            System.out.println(company.getId() + Constants.DOT_SEPARATOR + company.getName());
        }
        System.out.println("0. Back");
        int recordNumber = ConsoleReader.getIntFromConsole();

        if (recordNumber == 0) {
            return true;
        } else {
            boolean needContinue = true;
            while (needContinue) {
                Company company = companyService.getById(recordNumber);
                String actionTitle = ConsoleReader.getStringFromConsole("'" + company.getName() + "' company:" + Constants.LINE_SEPARATOR
                        + "1. Car list" + Constants.LINE_SEPARATOR
                        + "2. Create a car" + Constants.LINE_SEPARATOR + "0. Back");
                ICarProcessors carsProcessors = carProcessorsFactory.getProcessorByAction(actionTitle);
//                carsProcessors.doAction(company);
                needContinue = carsProcessors.doAction(recordNumber);
//                if (recordNumber == 0) {
//                    return false;
//                }
            }
        }


//        if (recordNumber > 0) {

//        } else {
//            System.out.println("0. Back");
//        }

//        System.out.println("0. Back");
////
//       int recordNumber = ConsoleReader.getIntFromConsole();


//        System.out.println(companiesList.get(recordNumber));
////
//        Company company = companiesList.get(recordNumber);
//        System.out.println(company);


////        System.out.println("1. Car list" + Constants.LINE_SEPARATOR
////                + "2. Create a car" + Constants.LINE_SEPARATOR + "0. Back");
//////
////

//        boolean needContinue = true;
//        while (needContinue) {
//        String actionTitle = ConsoleReader.getStringFromConsole("'Company name' company:" + Constants.LINE_SEPARATOR
//                + "1. Car list" + Constants.LINE_SEPARATOR
//                + "2. Create a car" + Constants.LINE_SEPARATOR + "0. Back");
//        ICarProcessors carsProcessors = carProcessorsFactory.getProcessorByAction(actionTitle);
//        carsProcessors.doAction(company);
//            needContinue = carsProcessors.doAction(company);
//        }
        return true;
    }

    @Override
    public String getSupportedActionTitle() {
        return "1";
    }
}
