package net.sqlite_jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 * Connecting to a sample database
 */
public class Connect {

    public static void connect() {
        Connection conn = null;
        try {
            // db parameters - declaring a variable that holds a connecting string to the sqlite database
            String url = "jdbc:sqlite:C:/sqlite/db/sample.db";
            // create a connection to the database
            conn = DriverManager.getConnection(url);

            System.out.println("Connection to SQLite successfull.");

        } catch (SQLException e) {
            System.out.println(e.getMessage());
        } finally {
            try {
                if (conn != null) {
                    // closing connection
                    conn.close();
                }
            } catch (SQLException ex) {
                System.out.println(ex.getMessage());
            }
        }
    }
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        connect();
    }
}