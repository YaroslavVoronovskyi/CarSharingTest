package carsharing.dao.impl;

import carsharing.Constants;
import carsharing.dao.ICustomerDao;
import carsharing.model.Customer;

import java.sql.PreparedStatement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class CustomerDao implements ICustomerDao {
    @Override
    public Customer getById(int id) {
        Customer customer = null;
        Connection connection = null;
        PreparedStatement statement = null;
        try {
            Class.forName(Constants.DB_DRIVER);
            connection = DriverManager.getConnection(Constants.DB_URL);
            connection.setAutoCommit(true);
            statement = connection.prepareStatement(Constants.CUSTOMER_GET_QUERY);
            statement.setInt(Constants.FIRST_COLUMN_INDEX, id);
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()) {
                customer = new Customer();
                customer.setId(resultSet.getInt(Constants.FIRST_COLUMN_INDEX));
                customer.setName(resultSet.getString(Constants.SECOND_COLUMN_INDEX));
                customer.setRentedCarId(resultSet.getInt(Constants.THIRD_COLUMN_INDEX));
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
        return customer;
    }

    @Override
    public List<Customer> getAll() {
        List<Customer> customersList = new ArrayList<>();
        Connection connection = null;
        PreparedStatement statement = null;
        try {
            Class.forName(Constants.DB_DRIVER);
            connection = DriverManager.getConnection(Constants.DB_URL);
            connection.setAutoCommit(true);
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
    public void save(Customer customer) {
        Connection connection = null;
        PreparedStatement statement = null;
        try {
            Class.forName(Constants.DB_DRIVER);
            connection = DriverManager.getConnection(Constants.DB_URL);
            connection.setAutoCommit(true);
            statement = connection.prepareStatement(Constants.CUSTOMER_INSERT_QUERY);
            statement.setString(Constants.FIRST_COLUMN_INDEX, customer.getName());
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
        Connection connection = null;
        PreparedStatement statement = null;
        try {
            Class.forName(Constants.DB_DRIVER);
            connection = DriverManager.getConnection(Constants.DB_URL);
            connection.setAutoCommit(true);
            statement = connection.prepareStatement(Constants.CUSTOMER_UPDATE_QUERY);
            statement.setObject(Constants.FIRST_COLUMN_INDEX, customer.getRentedCarId());
            statement.setInt(Constants.SECOND_COLUMN_INDEX, customer.getId());
            statement.executeUpdate();
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
    public void updateRentedCar(Customer customer) {
        Connection connection = null;
        PreparedStatement statement = null;
        try {
            Class.forName(Constants.DB_DRIVER);
            connection = DriverManager.getConnection(Constants.DB_URL);
            connection.setAutoCommit(true);
            statement = connection.prepareStatement(Constants.CUSTOMER_UPDATE_RENTED_CAR_QUERY);
            statement.setObject(Constants.FIRST_COLUMN_INDEX, customer.getRentedCarId());
            statement.setInt(Constants.SECOND_COLUMN_INDEX, customer.getId());
            statement.executeUpdate();
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
