package Utils;

import java.util.Scanner;

public class ScannerUtil {

    private static final Scanner scanner = new Scanner(System.in);

    public static int readIntFromConsole(int defaultValue) {
        System.out.println("Please enter whole order number!");
        int num;
        for (int i = 0; true; i++) {
            if (scanner.hasNextInt()) {
                num = scanner.nextInt();
                return num;
            } else if (i < 2) {
                System.out.println("Incorrect value! Please re-enter!");
                scanner.next();
            } else {
                num = defaultValue;
                return num;
            }
        }
    }
}
