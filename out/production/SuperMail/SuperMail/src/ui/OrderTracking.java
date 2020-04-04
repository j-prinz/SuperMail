package ui;

import delegates.OrderTrackingDelegate;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class OrderTracking {
    private static final String EXCEPTION_TAG = "[EXCEPTION]";
    private static final String WARNING_TAG = "[WARNING]";
    private static final int INVALID_INPUT = Integer.MIN_VALUE;
    private static final int EMPTY_INPUT = 0;

    private BufferedReader bufferedReader = null;
    private OrderTrackingDelegate delegate = null;

    public OrderTracking() {}

    public void setupDatabase(OrderTrackingDelegate delegate) {
        this.delegate = delegate;

        bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        int choice = INVALID_INPUT;

        while (choice != 1 && choice != 2) {
            System.out.println("Input 1 to setup database, 2 to quit.");

            choice = readInteger(false);

            if (choice != INVALID_INPUT) {
                switch (choice) {
                    case 1:
                        delegate.databaseSetup();
                        break;
                    case 2:

                }
            }

        }

    }

    private int readInteger(boolean allowEmpty) {
        String line = null;
        int input = INVALID_INPUT;
        try {
            line = bufferedReader.readLine();
            input = Integer.parseInt(line);
        } catch (IOException e) {
            System.out.println(EXCEPTION_TAG + " " + e.getMessage());
        } catch (NumberFormatException e) {
            if (allowEmpty && line.length() == 0) {
                input = EMPTY_INPUT;
            } else {
                System.out.println(WARNING_TAG + " Your input was not an integer");
            }
        }
        return input;
    }

    private void handleQuitOption() {
        System.out.println("Good Bye!");

        if (bufferedReader != null) {
            try {
                bufferedReader.close();
            } catch (IOException e) {
                System.out.println("IOException!");
            }
        }

        delegate.terminalTransactionsFinished();
    }

}
