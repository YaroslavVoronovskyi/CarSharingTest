package carsharing.dao.impl;

import carsharing.Constants;
import carsharing.dao.ICustomerDao;
import carsharing.model.Customer;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class CustomerDao implements ICustomerDao {
    @Override
    public Customer getById(int id) {
        return null;
    }

    @Override
    public List<Customer> getAll() {
        List<Customer> customersList = new ArrayList<>();
        Connection connection = null;
        PreparedStatement statement = null;
        try {
            Class.forName(Constants.DB_DRIVER);
            connection = DriverManager.getConnection(Constants.DB_URL);
            statement = connection.prepareStatement(Constants.CUSTOMER_GET_ALL_QUERY);
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()) {
                Customer customer = new Customer();
                customer.setId(resultSet.getInt(Constants.FIRST_COLUMN_INDEX));
                customer.setName(resultSet.getString(Constants.SECOND_COLUMN_INDEX));
                customer.setRentedCarId(resultSet.getInt(Constants.THIRD_COLUMN_INDEX));
                customersList.add(customer);
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
        return customersList;
    }

    @Override
    public List<Customer> getAllByCompanyId(int carId) {
        List<Customer> customersList = new ArrayList<>();
        Connection connection = null;
        PreparedStatement statement = null;
        try {
            Class.forName(Constants.DB_DRIVER);
            connection = DriverManager.getConnection(Constants.DB_URL);
            statement = connection.prepareStatement(Constants.CUSTOMER_GET_ALL_QUERY_BY_CAR_ID);
            statement.setInt(Constants.FIRST_COLUMN_INDEX, carId);
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()) {
                Customer customer = new Customer();
                customer.setId(resultSet.getInt(Constants.FIRST_COLUMN_INDEX));
                customer.setName(resultSet.getString(Constants.SECOND_COLUMN_INDEX));
                customer.setRentedCarId(resultSet.getInt(Constants.THIRD_COLUMN_INDEX));
                customersList.add(customer);
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
        return null;
    }

    @Override
    public void save(Customer customer) {
        Connection connection = null;
        PreparedStatement statement = null;
        try {
            Class.forName(Constants.DB_DRIVER);
            connection = DriverManager.getConnection(Constants.DB_URL);
            statement = connection.prepareStatement(Constants.CUSTOMER_INSERT_QUERY);
            statement.setString(Constants.FIRST_COLUMN_INDEX, customer.getName());
//            statement.setInt(Constants.SECOND_COLUMN_INDEX, customer.getRentedCarId());
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


    @Override
    public void update(Customer customer) {

    }

    @Override
    public void delete(Customer customer) {

    }
}
