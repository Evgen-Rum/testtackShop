package Project.DB;

import Utils.DBUtils;

public class Database {

    private static final String SQL_QUERY = "select shopTask.warehouse.*, " +
            "shopTask.ten.numberOfProducts, " +
            "shopTask.ten.orderNumber " +
            "from shopTask.warehouse  " +
            "inner join shopTask.ten on warehouse.id = ten.id " +
            "union " +
            "select shopTask.warehouse.*, " +
            "shopTask.eleven.numberOfProducts, " +
            "shopTask.eleven.orderNumber " +
            "from shopTask.warehouse " +
            "inner join shopTask.eleven on warehouse.id = eleven.id " +
            "union " +
            "select shopTask.warehouse.*, " +
            "shopTask.fourteen.numberOfProducts, " +
            "shopTask.fourteen.orderNumber " +
            "from shopTask.warehouse " +
            "inner join shopTask.fourteen on warehouse.id = fourteen.id " +
            "union " +
            "select shopTask.warehouse.*, " +
            "shopTask.fifteen.numberOfProducts, " +
            "shopTask.fifteen.orderNumber " +
            "from shopTask.warehouse " +
            "inner join shopTask.fifteen on warehouse.id = fifteen.id " +
            "order by rackName";

    public static String[][] getDataFromBD() {
        return DBUtils.getArrayTableFromDB(SQL_QUERY);
    }
}
