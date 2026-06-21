package Model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Connector {

    private static Connection MySQLConfig;

    public static Connection configDB() throws SQLException {
        try {
            String url = "jdbc:mysql://localhost:3306/projekpbo"; //url database
            String user = "root"; //user database
            String pass = ""; //password database

            DriverManager.registerDriver(new com.mysql.jdbc.Driver());
            MySQLConfig = DriverManager.getConnection(url, user, pass);

        } catch (SQLException e) {
            System.err.println("koneksi gagal " + e.getMessage()); //perintah menampilkan error pada koneksi
        }

        return MySQLConfig;
    }
}
