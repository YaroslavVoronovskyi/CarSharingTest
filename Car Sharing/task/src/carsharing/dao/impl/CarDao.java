package carsharing.dao.impl;

import carsharing.Constants;
import carsharing.dao.ICarDao;
import carsharing.model.Car;
import carsharing.model.Company;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class CarDao implements ICarDao {

    @Override
    public Car getById(int id) {
        Car car = null;
        Connection connection = null;
        PreparedStatement statement = null;
        try {
            Class.forName(Constants.DB_DRIVER);
            connection = DriverManager.getConnection(Constants.DB_URL);
            statement = connection.prepareStatement(Constants.CAR_GET_QUERY);
            statement.setInt(Constants.FIRST_COLUMN_INDEX, id);
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()) {
                car = new Car();
                car.setId(resultSet.getInt(Constants.FIRST_COLUMN_INDEX));
                car.setName(resultSet.getString(Constants.SECOND_COLUMN_INDEX));
                car.setCompanyId(resultSet.getInt(Constants.THIRD_COLUMN_INDEX));
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
        return car;
    }

    @Override
    public List<Car> getAll() {
        List<Car> carsList = new ArrayList<>();
        Connection connection = null;
        PreparedStatement statement = null;
        try {
            Class.forName(Constants.DB_DRIVER);
            connection = DriverManager.getConnection(Constants.DB_URL);
            statement = connection.prepareStatement(Constants.CAR_GET_ALL_QUERY);
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()) {
                Car car = new Car();
                car.setId(resultSet.getInt(Constants.FIRST_COLUMN_INDEX));
                car.setName(resultSet.getString(Constants.SECOND_COLUMN_INDEX));
                car.setCompanyId(resultSet.getInt(Constants.THIRD_COLUMN_INDEX));
                carsList.add(car);
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
        return carsList;
    }

    @Override
    public void save(Car car) {
        Connection connection = null;
        PreparedStatement statement = null;
        try {
            Class.forName(Constants.DB_DRIVER);
            connection = DriverManager.getConnection(Constants.DB_URL);
            statement = connection.prepareStatement(Constants.CAR_INSERT_QUERY);
            statement.setString(Constants.FIRST_COLUMN_INDEX, car.getName());
            statement.setInt(Constants.SECOND_COLUMN_INDEX, car.getCompanyId());
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
    public void update(Car car) {

    }

    @Override
    public void delete(Car car) {

    }
}
