package carsharing.connection;

import carsharing.Constants;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class H2DbManager {

    private static H2DbManager INSTANCE;
    private static String DB_PATH;
    private final Connection CONNECTION;

    public H2DbManager() throws ClassNotFoundException, SQLException {
        Class.forName(Constants.DB_DRIVER);
        this.CONNECTION = DriverManager.getConnection(Constants.DB_URL);
        CONNECTION.setAutoCommit(true);
        this.initializeDb();
    }

    public static void initializeDbPath(String path) {
        if (DB_PATH == null) {
            DB_PATH = path;
        }
    }

    public static H2DbManager getInstance() {
        try {
            if (INSTANCE == null) {
                INSTANCE = new H2DbManager();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return INSTANCE;
    }

    public Connection getConnection() {
        return CONNECTION;
    }

    public void closeConnection() {
        try {
            this.CONNECTION.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    private void initializeDb() {
        createCompanyTableIfNotExist();
        createCarTableIfNotExist();
        createCustomerTableIfNotExist();
    }

    private void createCompanyTableIfNotExist() {
        try (Statement statement = this.CONNECTION.createStatement()) {
            statement.executeUpdate(Constants.CREATE_TABLE_COMPANY_SQL_QUERY);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    private void createCarTableIfNotExist() {
        try (Statement statement = this.CONNECTION.createStatement()) {
            statement.executeUpdate(Constants.CREATE_TABLE_CAR_SQL_QUERY);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    private void createCustomerTableIfNotExist() {
        try (Statement statement = this.CONNECTION.createStatement()) {
            statement.executeUpdate(Constants.CREATE_TABLE_CUSTOMER_SQL_QUERY);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
