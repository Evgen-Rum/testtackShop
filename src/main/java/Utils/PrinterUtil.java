package Utils;

import Project.DB.Database;

import java.util.ArrayList;

public class PrinterUtil {

    private static final ArrayList<Integer> list = ListUtil.getDataFromConsoleAsList();
    private static final String[][] arr = Database.getDataFromBD();

    private static final int RACK_COLUMN_NUMBER = 2;
    private static final int ADDITIONAL_RACK_COLUMN_NUMBER = 3;
    private static final int NUMBER_OF_PRODUCTS_COLUMN_NUMBER = 4;
    private static final int ORDER_COLUMN_NUMBER = 5;

    public static void printPageHeader() {
            System.out.printf("=+=+=+=\n" + "Order assembly page: %s, %s, %s, %s\n\n" ,
                    list.get(0), list.get(1), list.get(2), list.get(3));
    }

    public static void printData() {
        for (String[] strings : arr) {
            String rack = strings[RACK_COLUMN_NUMBER];
            int orderNumber = Integer.parseInt(strings[ORDER_COLUMN_NUMBER]);
            if (orderNumber == list.get(0)) {
                switch (rack) {
                    case "A", "B", "J" -> {
                        printTable(rack);
                    }
                }
            }
        }
    }

    private static void printTable(String rackName) {
        System.out.println("===Rack " + rackName + ": ");
        for (String[] strings : arr) {
            int orderNumber = Integer.parseInt(strings[ORDER_COLUMN_NUMBER]);
            if (strings[RACK_COLUMN_NUMBER].equals(rackName) && (orderNumber == list.get(0)
                    || orderNumber == list.get(1) || orderNumber == list.get(2) || orderNumber == list.get(3))) {
                System.out.println(strings[0] + "(id=" + strings[1] + ") \n" +
                        "Order " + strings[ORDER_COLUMN_NUMBER] + ", " +
                        strings[NUMBER_OF_PRODUCTS_COLUMN_NUMBER] +
                        " pieces \n" + "Additional racks: " +
                        strings[ADDITIONAL_RACK_COLUMN_NUMBER] + "\n");
            }
        }
    }
}
