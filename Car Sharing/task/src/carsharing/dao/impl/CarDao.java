package carsharing.dao.impl;

import carsharing.Constants;
import carsharing.dao.ICarDao;
import carsharing.model.Car;

import java.sql.PreparedStatement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
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
            connection.setAutoCommit(true);
            statement = connection.prepareStatement(Constants.CAR_GET_QUERY);
            statement.setInt(Constants.FIRST_COLUMN_INDEX, id);
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()) {
                car = new Car();
                car.setId(resultSet.getInt(Constants.FIRST_COLUMN_INDEX));
                car.setName(resultSet.getString(Constants.SECOND_COLUMN_INDEX));
                car.setCompanyId(resultSet.getInt(Constants.THIRD_COLUMN_INDEX));
                car.setRented(resultSet.getBoolean(Constants.FOURTH_COLUMN_INDEX));
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
    public List<Car> getAllCarsByCompanyId(int companyId) {
        List<Car> carsList = new ArrayList<>();
        Connection connection = null;
        PreparedStatement statement = null;
        try {
            Class.forName(Constants.DB_DRIVER);
            connection = DriverManager.getConnection(Constants.DB_URL);
            connection.setAutoCommit(true);
            statement = connection.prepareStatement(Constants.CAR_GET_ALL_QUERY_BY_COMPANY_ID);
            statement.setInt(Constants.FIRST_COLUMN_INDEX, companyId);
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()) {
                Car car = new Car();
                car.setId(resultSet.getInt(Constants.FIRST_COLUMN_INDEX));
                car.setName(resultSet.getString(Constants.SECOND_COLUMN_INDEX));
                car.setCompanyId(resultSet.getInt(Constants.THIRD_COLUMN_INDEX));
                car.setRented(resultSet.getBoolean(Constants.FOURTH_COLUMN_INDEX));
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
            connection.setAutoCommit(true);
            statement = connection.prepareStatement(Constants.CAR_INSERT_QUERY);
            statement.setString(Constants.FIRST_COLUMN_INDEX, car.getName());
            statement.setInt(Constants.SECOND_COLUMN_INDEX, car.getCompanyId());
            statement.setBoolean(Constants.THIRD_COLUMN_INDEX, car.isRented());
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
        Connection connection = null;
        PreparedStatement statement = null;
        try {
            Class.forName(Constants.DB_DRIVER);
            connection = DriverManager.getConnection(Constants.DB_URL);
            connection.setAutoCommit(true);
            statement = connection.prepareStatement(Constants.CAR_UPDATE_QUERY);
            statement.setObject(Constants.FIRST_COLUMN_INDEX, car.isRented());
            statement.setInt(Constants.SECOND_COLUMN_INDEX, car.getId());
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
