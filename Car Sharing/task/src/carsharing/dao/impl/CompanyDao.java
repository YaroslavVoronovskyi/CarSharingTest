package carsharing.dao.impl;

import carsharing.Constants;
import carsharing.dao.ICompanyDao;
import carsharing.model.Company;

import javax.sql.DataSource;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class CompanyDao implements ICompanyDao {

    @Override
    public Company getById(int id) {
        return null;
    }

    @Override
    public List<Company> getAll() {
        List<Company> companiesList = new ArrayList<>();
        Connection connection = null;
        PreparedStatement statement = null;
        try {
            Class.forName(Constants.DB_DRIVER);
            connection = DriverManager.getConnection(Constants.DB_URL);
            statement = connection.prepareStatement(Constants.COMPANY_GET_ALL_QUERY);
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()) {
                Company company = new Company();
                company.setId(resultSet.getInt(Constants.FIRST_COLUMN_INDEX));
                company.setName(resultSet.getString(Constants.SECOND_COLUMN_INDEX));
                companiesList.add(company);
            }
            statement.close();
            connection.close();
        } catch (Exception exception) {
            exception.printStackTrace();
        } finally {
            try {
                if (statement != null) statement.close();
            } catch (SQLException ignored) {
            }
            try {
                if (connection != null) connection.close();
            } catch (SQLException exception) {
                exception.printStackTrace();
            }
        }


        return companiesList;
    }

    @Override
    public void save(Company company) {

        Connection connection = null;
        PreparedStatement statement = null;
        try {
            Class.forName(Constants.DB_DRIVER);
            connection = DriverManager.getConnection(Constants.DB_URL);
            statement = connection.prepareStatement(Constants.COMPANY_INSERT_QUERY);
            statement.setString(Constants.FIRST_COLUMN_INDEX, company.getName());
//            statement.executeUpdate(Constants.INNIT_SQL_QUERY);
            statement.execute();
            statement.close();
            connection.close();
        } catch (Exception exception) {
            exception.printStackTrace();
        } finally {
            try {
                if (statement != null) statement.close();
            } catch (SQLException ignored) {
            }
            try {
                if (connection != null) connection.close();
            } catch (SQLException exception) {
                exception.printStackTrace();
            }
        }
    }


//        try (Connection connection = DataSource.getConnection()) {
//            try (PreparedStatement statement = connection.prepareStatement(Constants.COMPANY_INSERT_QUERY)) {
//                statement.setString(Constants.FIRST_COLUMN_INDEX, company.getName());
//                statement.executeBatch();
//            } catch (SQLException exception) {
//                throw new SQLException("SQLException exception in save(List<Student> studentList)", exception);
//            }


    @Override
    public void update(Company company) {

    }

    @Override
    public void delete(Company company) {

    }
}
