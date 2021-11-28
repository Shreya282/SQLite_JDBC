package net.sqlite_jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class CreateTable {

    /**
     * 
     *
     */
    public static void createNewTable() {
        // SQLite connection string
        String url = "jdbc:sqlite:C://sqlite/db/sqlite_proj.db";

        // SQL statement for creating a new table
        String sql = "CREATE TABLE movies (\n"
                + "	id integer PRIMARY KEY AUTOINCREMENT,\n"
                + "	name varchar NOT NULL,\n"
                + "	actor varchar NOT NULL,\n"
                + " 	actress varchar NOT NULL,\n"
                + " 	director varchar NOT NULL,\n"
                + " 	release_year varchar NOT NULL\n"
                + ");";

        try (Connection conn = DriverManager.getConnection(url);
             Statement stmt = conn.createStatement()) {
            // create a new table
            stmt.execute(sql);
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        createNewTable();
    }

}
