package Project.DB;

import Utils.DBUtils;

public class Database {

    private static final String SQL_QUERY = "select shopTask1.warehouse.*, " +
            "shopTask1.ten.numberOfProducts, " +
            "shopTask1.ten.orderNumber " +
            "from shopTask1.warehouse  " +
            "inner join shopTask1.ten on warehouse.id = ten.id " +
            "union " +
            "select shopTask1.warehouse.*, " +
            "shopTask1.eleven.numberOfProducts, " +
            "shopTask1.eleven.orderNumber " +
            "from shopTask1.warehouse " +
            "inner join shopTask1.eleven on warehouse.id = eleven.id " +
            "union " +
            "select shopTask1.warehouse.*, " +
            "shopTask1.fourteen.numberOfProducts, " +
            "shopTask1.fourteen.orderNumber " +
            "from shopTask1.warehouse " +
            "inner join shopTask1.fourteen on warehouse.id = fourteen.id " +
            "union " +
            "select shopTask1.warehouse.*, " +
            "shopTask1.fifteen.numberOfProducts, " +
            "shopTask1.fifteen.orderNumber " +
            "from shopTask1.warehouse " +
            "inner join shopTask1.fifteen on warehouse.id = fifteen.id " +
            "order by rackName";

    public static String[][] getDataFromBD() {
        return DBUtils.getArrayTableFromDB(SQL_QUERY);
    }
}
