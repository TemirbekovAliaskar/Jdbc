package java12.config;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DataBaseConnection {
    private final static String url = "jdbc:postgresql://localhost:5432/postgres";
    private final static String username = "postgres";
    private final static String password = "1234";


    public static Connection getConnection (){
        Connection connection = null;
        try {
            return DriverManager.getConnection(url, username, password);

        }catch (SQLException e){
            System.out.println(e.getMessage());
        }
        return connection;
    }
}
