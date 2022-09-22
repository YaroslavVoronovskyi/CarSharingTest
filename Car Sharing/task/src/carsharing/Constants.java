package carsharing;

public class Constants {
    public static final String LINE_SEPARATOR = System.lineSeparator();
    public static final String DATA_BASE_FILE_NAME = "./src/carsharing/db/carsharing";
    public static final String DB_DRIVER = "org.h2.Driver";
    public static final String DB_URL = "jdbc:h2:./src/carsharing/db/carsharing";
    public static final String DB_USER_NAME = "sa";
    public static final String DB_PASSWORD = "";
    public static final String CREATE_TABLE_COMPANY_SQL_QUERY =
            "CREATE TABLE IF NOT EXISTS company (" + LINE_SEPARATOR +
                    "    id INT NOT NULL AUTO_INCREMENT," + LINE_SEPARATOR +
                    "    name VARCHAR(20) UNIQUE NOT NULL," + LINE_SEPARATOR +
                    "    PRIMARY KEY(id));";

    public static final String CREATE_TABLE_CAR_SQL_QUERY =
            "CREATE TABLE IF NOT EXISTS car (" + LINE_SEPARATOR +
                    "    id INT NOT NULL AUTO_INCREMENT," + LINE_SEPARATOR +
                    "    name VARCHAR(30) UNIQUE NOT NULL," + LINE_SEPARATOR +
                    "    company_id INT NOT NULL," + LINE_SEPARATOR +
                    "    rented BOOLEAN," + LINE_SEPARATOR +
                    "    PRIMARY KEY(id)," + LINE_SEPARATOR +
                    "    CONSTRAINT car_company_id_fkey FOREIGN KEY (company_id) REFERENCES company (id));";

    public static final String CREATE_TABLE_CUSTOMER_SQL_QUERY =
            "CREATE TABLE IF NOT EXISTS customer (" + LINE_SEPARATOR +
                    "    id INT NOT NULL AUTO_INCREMENT," + LINE_SEPARATOR +
                    "    name VARCHAR(30) UNIQUE NOT NULL," + LINE_SEPARATOR +
                    "    rented_car_id INT DEFAULT NULL," + LINE_SEPARATOR +
                    "    PRIMARY KEY(id)," + LINE_SEPARATOR +
                    "    CONSTRAINT customer_car_id_fkey FOREIGN KEY (rented_car_id) REFERENCES car (id));";

    public static final String READ_FROM_CONSOLE_ERROR_MESSAGE = "Sorry, something went wrong while reading from the console ... ";
    public static final int FIRST_COLUMN_INDEX = 1;
    public static final int SECOND_COLUMN_INDEX = 2;
    public static final int THIRD_COLUMN_INDEX = 3;
    public static final int FOURTH_COLUMN_INDEX = 4;
    public static final String COMPANY_INSERT_QUERY = "INSERT INTO company (name) VALUES (?)";
    public static final String COMPANY_GET_QUERY = "SELECT * FROM company WHERE id = ?";
    public static final String COMPANY_GET_ALL_QUERY = "SELECT * FROM company";
    public static final String CAR_INSERT_QUERY = "INSERT INTO car (name, company_id, rented) VALUES (?, ?, ?)";
    public static final String CAR_GET_QUERY = "SELECT * FROM car WHERE id = ?";
    public static final String CAR_GET_ALL_QUERY = "SELECT * FROM car";
    public static final String CAR_UPDATE_QUERY = "UPDATE car SET rented = ? WHERE id = ?";
    public static final String CAR_GET_ALL_QUERY_BY_COMPANY_ID = "SELECT * FROM car WHERE rented = false AND company_id = ?";
    public static final String CUSTOMER_INSERT_QUERY = "INSERT INTO customer (name) VALUES (?)";
    public static final String CUSTOMER_GET_QUERY = "SELECT * FROM customer WHERE id = ?";
    public static final String CUSTOMER_GET_ALL_QUERY = "SELECT * FROM customer";
    public static final String CUSTOMER_UPDATE_QUERY = "UPDATE customer SET rented_car_id = ? WHERE id = ?";
    public static final String CUSTOMER_DELETE_QUERY = "UPDATE customer SET rented_car_id = ? WHERE id = ?";

//    public static final String CUSTOMER_GET_ALL_QUERY_BY_CAR_ID = "SELECT customer.id, customer.name, customer.rented_car_id FROM customer LEFT JOIN " +
//            "car ON car.id = customer.rented_car_id WHERE customer.id = ?";

    public static final String CUSTOMER_GET_ALL_QUERY_BY_CUSTOMER_ID = "SELECT * FROM customer WHERE id = ?";

    public static final String CUSTOMER_GET_RENTED_CAR_QUERY = "SELECT car.id, car.name, car.company_id FROM car " +
            "LEFT JOIN customer ON car.id = customer.rented_car_id WHERE company_id = ? AND customer.rented_car_id is null";
    public static final String DOT_SEPARATOR = ". ";

    public static final String DELIMETER = " ";



//    private final String notRentedCarByCompanyId = "SELECT CAR.id as id, CAR.name as name, CAR.company_id as company_id " +
//            "FROM CAR LEFT JOIN CUSTOMER ON CAR.id = CUSTOMER.rented_car_id WHERE company_id = ? AND CUSTOMER.rented_car_id is null;";
}
