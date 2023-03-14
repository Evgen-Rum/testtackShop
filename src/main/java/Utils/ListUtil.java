package Utils;

import java.util.ArrayList;

import static Utils.ScannerUtil.readIntFromConsole;

public class ListUtil {

    private static final ArrayList<Integer> list = new ArrayList<Integer>();

    private static final int DEFAULT_ORDER_NUMBER = 10;

    public static ArrayList<Integer> getDataFromConsoleAsList() {
        list.add(readIntFromConsole(DEFAULT_ORDER_NUMBER));
        list.add(readIntFromConsole(DEFAULT_ORDER_NUMBER));
        list.add(readIntFromConsole(DEFAULT_ORDER_NUMBER));
        list.add(readIntFromConsole(DEFAULT_ORDER_NUMBER));
        return list;
    }
}
