package carsharing.dao.impl;

import carsharing.Constants;
import carsharing.connection.H2DbManager;
import carsharing.dao.ICompanyDao;
import carsharing.model.Company;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class CompanyDao implements ICompanyDao {

    @Override
    public Company getById(int id) {
        Company company = null;
        Connection connection = null;
        PreparedStatement statement = null;
        try {
            Class.forName(Constants.DB_DRIVER);
            connection = DriverManager.getConnection(Constants.DB_URL);
            connection.setAutoCommit(true);
            statement = connection.prepareStatement(Constants.COMPANY_GET_QUERY);
            statement.setInt(Constants.FIRST_COLUMN_INDEX, id);
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()) {
                company = new Company();
                company.setId(resultSet.getInt(Constants.FIRST_COLUMN_INDEX));
                company.setName(resultSet.getString(Constants.SECOND_COLUMN_INDEX));
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
        return company;
    }

    @Override
    public List<Company> getAll() {
        List<Company> companiesList = new ArrayList<>();
        Connection connection = null;
        PreparedStatement statement = null;
        try {
            Class.forName(Constants.DB_DRIVER);
            connection = DriverManager.getConnection(Constants.DB_URL);
            connection.setAutoCommit(true);
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
            connection.setAutoCommit(true);
            statement = connection.prepareStatement(Constants.COMPANY_INSERT_QUERY);
            statement.setString(Constants.FIRST_COLUMN_INDEX, company.getName());
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
}
