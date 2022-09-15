package carsharing.dao;

import carsharing.model.Company;

import java.sql.SQLException;
import java.util.List;

public interface ICompanyDao {

    Company getById(int id);

    List<Company> getAll();

    void save(Company company);

    void update(Company company);

    void delete(Company company);
}
