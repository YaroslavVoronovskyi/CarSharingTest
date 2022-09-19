package carsharing.processors.impl.company;

import carsharing.ConsoleReader;
import carsharing.model.Company;
import carsharing.processors.ICompanyProcessors;
import carsharing.service.ICompanyService;

public class CreateNewCompanyProcessor implements ICompanyProcessors {

    private final ICompanyService companyService;

    public CreateNewCompanyProcessor(ICompanyService companyService) {
        this.companyService = companyService;
    }

    @Override
    public boolean doAction() {
        String name = ConsoleReader.getStringFromConsole("Enter the company name:");
        Company company = new Company(name);
        companyService.save(company);
        System.out.println("The company was created!");
        return true;
    }

    @Override
    public String getSupportedActionTitle() {
        return "2";
    }
}
