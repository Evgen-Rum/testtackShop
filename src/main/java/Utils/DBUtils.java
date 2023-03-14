package Utils;

import java.sql.*;

public class DBUtils {

    private static Connection connection;
    private static Statement statement;

    private static final String DB_URL = "jdbc:mysql://localhost:3306/shopTask1";
    private static final String ROOT_NAME = "root";
    private static final String ROOT_PASSWORD = "Jeka09031999";

    private static void connectToDatabase() {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver").getDeclaredConstructor().newInstance();
            connection = DriverManager.getConnection(DB_URL, ROOT_NAME, ROOT_PASSWORD);
            statement = connection.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE,
                    ResultSet.CONCUR_READ_ONLY);
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    private static void disconnectFromDatabase() {
        try {
            connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static String[][] getArrayTableFromDB(String sqlScript){
        connectToDatabase();
        String[][] resultArray = null;
        try {
            ResultSet resultSet = statement.executeQuery(sqlScript);
            int columnAmount = resultSet.getMetaData().getColumnCount();
            resultSet.last();
            resultArray = new String[resultSet.getRow()][columnAmount];
            resultSet.beforeFirst();
            while (resultSet.next()){
                for (int i = 1; i <= columnAmount; i++) {
                    resultArray[resultSet.getRow()-1][i-1] = resultSet.getString(i);
                }
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        disconnectFromDatabase();
        return resultArray;
    }
}
