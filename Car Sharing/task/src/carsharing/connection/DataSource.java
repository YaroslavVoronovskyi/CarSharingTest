package carsharing.connection;

import carsharing.Constants;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class DataSource {
    public static void innitDataBase() {
        Connection connection = null;
        Statement statement = null;
        try {
            Class.forName(Constants.DB_DRIVER);
            connection = DriverManager.getConnection(Constants.DB_URL);
            statement = connection.createStatement();
            statement.executeUpdate(Constants.CREATE_TABLE_COMPANY_SQL_QUERY);
            statement.executeUpdate(Constants.CREATE_TABLE_CAR_SQL_QUERY);
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

