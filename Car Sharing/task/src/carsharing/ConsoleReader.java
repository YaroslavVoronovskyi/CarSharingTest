package carsharing;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class ConsoleReader {
    private static final BufferedReader READER = new BufferedReader(new InputStreamReader(System.in));
    public static String getStringFromConsole(String message) {
        System.out.println(message);
        String value;
        try {
            value = READER.readLine();
        } catch (IOException exception) {
            throw new RuntimeException(Constants.READ_FROM_CONSOLE_ERROR_MESSAGE);
        }
        checkExpressionByNull(value);
        return value;
    }

    private static void checkExpressionByNull(String value) {
        while (value == null) {
            System.out.println("expression can not be null or empty");
            try {
                value = READER.readLine();
            } catch (IOException exception) {
                throw new RuntimeException(Constants.READ_FROM_CONSOLE_ERROR_MESSAGE);
            }
        }
    }
}
