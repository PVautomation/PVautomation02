package JavaMavenTestNG.JavaMavenTestNG;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class SQLServerConnectionTest {
    public static void main(String[] args) {

        String connectionUrl = "jdbc:sqlserver://10.1.20.170:1433;"
                + "databaseName=prequal;"
                + "user=pvenkatarajan@republicfinance.com;"
                + "password=P@ssword123mm123##;"
                + "encrypt=true;trustServerCertificate=true;";
        
        try (Connection connection = DriverManager.getConnection(connectionUrl)) {
            if (connection != null) {
                System.out.println("Connection to SQL Server was successful!");
            }
        } catch (SQLException e) {
            System.out.println("Failed to connect to SQL Server: " + e.getMessage());
            e.printStackTrace();
        }
    }
}
