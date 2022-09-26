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

//    public static int getIntFromConsole(String message, int maxIndex) {
//        System.out.println(message);
//        int recordNumber = 0;
//        boolean resultNotValid = false;
//        do {
//            if (resultNotValid) {
//                System.out.println("Please enter correct record number");
//            }
//            try {
//                recordNumber = Integer.parseInt(READER.readLine());
//                resultNotValid = recordNumber <= 0 || recordNumber > maxIndex;
//            } catch (NumberFormatException exception) {
//                resultNotValid = true;
//            } catch (IOException exception) {
//                throw new RuntimeException(Constants.READ_FROM_CONSOLE_ERROR_MESSAGE);
//            }
//        } while (resultNotValid);
//        return recordNumber;
//    }

    public static int getIntFromConsole() {
        int recordNumber;
        try {
            recordNumber = Integer.parseInt(READER.readLine());
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return recordNumber;
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
