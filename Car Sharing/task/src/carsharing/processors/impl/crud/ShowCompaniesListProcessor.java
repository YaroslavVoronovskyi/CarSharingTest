package carsharing.processors.impl.crud;

import carsharing.model.Company;
import carsharing.processors.ICrudCompanyProcessors;
import carsharing.service.ICompanyService;

import java.util.List;

public class ShowCompaniesListProcessor implements ICrudCompanyProcessors {

    private final ICompanyService companyService;

    public ShowCompaniesListProcessor(ICompanyService companyService) {
        this.companyService = companyService;
    }

    @Override
    public boolean doAction() {
        List<Company> companiesList = companyService.getAll();
        if (companiesList.size() == 0) {
            System.out.println("The company list is empty");
            return true;
        }

        for (Company company : companiesList) {
            System.out.println(company);
        }

        return true;
    }

    @Override
    public String getSupportedActionTitle() {
        return "1";
    }
}
