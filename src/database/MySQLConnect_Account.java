package database;

import java.sql.Connection;
import java.sql.DriverManager;

public class MySQLConnect_Account {

    private static final String JDBCDriver = "com.mysql.cj.jdbc.Driver";
    private static final String DBURL = "jdbc:mysql://localhost/account?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC";
    private static final String USER = "root";
    private static final String PASSWORD = "";

    private static Connection conn;

    public static void connect() {
        try {
            Class.forName(JDBCDriver).newInstance();

            conn = DriverManager.getConnection(DBURL, USER, PASSWORD);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static Connection getConn() {
        return conn;
    }

}
