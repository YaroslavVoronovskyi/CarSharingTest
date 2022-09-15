package carsharing;

public class Constants {
    public static final String LINE_SEPARATOR = System.lineSeparator();
    public static final String DATA_BASE_FILE_NAME = "./src/carsharing/db/carsharing";
    public static final String DB_DRIVER = "org.h2.Driver";
    public static final String DB_URL = "jdbc:h2:./src/carsharing/db/carsharing";
    public static final String DB_USER_NAME = "sa";
    public static final String DB_PASSWORD = "";
    public static final String INNIT_SQL_QUERY = "DROP TABLE IF EXISTS company CASCADE;" + LINE_SEPARATOR +
            "CREATE TABLE company (" + LINE_SEPARATOR +
            "    id SERIAL NOT NULL," + LINE_SEPARATOR +
            "    name CHARACTER VARYING(15) NOT NULL," + LINE_SEPARATOR +
            "    CONSTRAINT company_pkey PRIMARY KEY (id));";
}
