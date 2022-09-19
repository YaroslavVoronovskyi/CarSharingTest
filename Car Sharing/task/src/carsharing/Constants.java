package carsharing;

public class Constants {
    public static final String LINE_SEPARATOR = System.lineSeparator();
    public static final String DATA_BASE_FILE_NAME = "./src/carsharing/db/carsharing";
    public static final String DB_DRIVER = "org.h2.Driver";
    public static final String DB_URL = "jdbc:h2:./src/carsharing/db/carsharing";
    public static final String DB_USER_NAME = "sa";
    public static final String DB_PASSWORD = "";
    public static final String CREATE_TABLE_COMPANY_SQL_QUERY =
            "DROP TABLE IF EXISTS company CASCADE;" + LINE_SEPARATOR +
                    "CREATE TABLE company (" + LINE_SEPARATOR +
                    "    id SERIAL NOT NULL PRIMARY KEY," + LINE_SEPARATOR +
                    "    name CHARACTER VARYING(20) UNIQUE NOT NULL," + LINE_SEPARATOR +
                    "    CONSTRAINT company_pkey PRIMARY KEY (id));";

    public static final String CREATE_TABLE_CAR_SQL_QUERY =
            "DROP TABLE IF EXISTS car CASCADE;" + LINE_SEPARATOR +
                    "CREATE TABLE car (" + LINE_SEPARATOR +
                    "    id SERIAL NOT NULL PRIMARY KEY," + LINE_SEPARATOR +
                    "    name CHARACTER VARYING(30) UNIQUE NOT NULL," + LINE_SEPARATOR +
                    "    company_id INT NOT NULL," + LINE_SEPARATOR +
                    "    CONSTRAINT car_pkey PRIMARY KEY (id)," + LINE_SEPARATOR +
                    "    CONSTRAINT car_company_id_fkey FOREIGN KEY (company_id)" + LINE_SEPARATOR +
                    "    REFERENCES company (id));";

    public static final String READ_FROM_CONSOLE_ERROR_MESSAGE = "Sorry, something went wrong while reading from the console ... ";
    public static final int FIRST_COLUMN_INDEX = 1;
    public static final int SECOND_COLUMN_INDEX = 2;
    public static final int THIRD_COLUMN_INDEX = 3;
    public static final String COMPANY_INSERT_QUERY = "INSERT INTO company (name) VALUES (?)";
    public static final String COMPANY_GET_QUERY = "SELECT * FROM company WHERE id = ?";
    public static final String COMPANY_GET_ALL_QUERY = "SELECT * FROM company";
    public static final String CAR_INSERT_QUERY = "INSERT INTO car (name, company_id) VALUES (?, ?)";
    public static final String CAR_GET_QUERY = "SELECT * FROM car WHERE id = ?";
    public static final String CAR_GET_ALL_QUERY = "SELECT * FROM car";


    public static final String CAR_GET_ALL_QUERY_BY_ = "SELECT * FROM car WHERE company_id = ?";

    public static final String DOT_SEPARATOR = ". ";

    public static final String DELIMETER = " ";
}
