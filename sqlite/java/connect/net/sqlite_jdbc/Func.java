package net.sqlite_jdbc;

import java.util.Scanner;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class Func{

    /**
     * 
     *
     * @return the Connection object
     */
    private Connection connect() {
        // SQLite connection string
        String url = "jdbc:sqlite:C://sqlite/db/sqlite_proj.db";
        Connection conn = null;
        try {
            conn = DriverManager.getConnection(url);
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return conn;
    }

    /**
     * Insert a new row into the movies table
     *
     * @param name
     * @param capacity
     */
    public void insert(String name, String actor, String actress, String director, String release_year) {

        String sql = "INSERT INTO movies(name,actor,actress,director,release_year) VALUES(?,?,?,?,?)";

        try (Connection conn = this.connect();
             PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setString(1, name);
            ps.setString(2, actor);
            ps.setString(3, actress);
            ps.setString(4, director);
            ps.setString(5, release_year);
            ps.executeUpdate();
            System.out.println("Data inserted successfully!");
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    /**
     * 
     */
    public void selectAll(){
        String sql = "SELECT * FROM movies";

        try (Connection conn = this.connect();
             Statement stmt  = conn.createStatement();
             ResultSet rs    = stmt.executeQuery(sql)){

            // loop through the result set
            while (rs.next()) {
                System.out.println(rs.getInt("id") +  "\t" +
                        rs.getString("name") + "\t" +
                        rs.getString("actor") + "\t" +
                        rs.getString("actress") + "\t" +
                        rs.getString("director") + "\t" +
                        rs.getString("release_year"));
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    public void selectQuery(String actor_name) {
        String sql = "SELECT * FROM movies WHERE actor = ?";

        try (Connection conn = this.connect();
             PreparedStatement pstmt  = conn.prepareStatement(sql)){

            // set the value
            pstmt.setString(1,actor_name);
            //
            ResultSet rs  = pstmt.executeQuery();

            // loop through the result set
            while (rs.next()) {
                System.out.println(rs.getInt("id") +  "\t" +
                        rs.getString("name") + "\t" +
                        rs.getString("actor") + "\t" +
                        rs.getString("actress") + "\t" +
                        rs.getString("director") + "\t" +
                        rs.getString("release_year"));
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Func data = new Func();
        int choice;

        System.out.println("Options:\n1. Insert\n2. Display all\n3. Select(based on actor's name)\n");
        Scanner in = new Scanner(System.in);
        do{
            System.out.print("Enter your choice: ");
            choice = in.nextInt();
            in.nextLine();
            switch(choice)
            {
                case 1: System.out.print("Enter movie name: ");
                    String name = in.next();
                    System.out.print("\nEnter the name of actor: ");
                    String actor = in.next();
                    System.out.print("\nEnter the name of actress: ");
                    String actress = in.next();
                    System.out.print("\nEnter the name of director: ");
                    String director = in.next();
                    System.out.print("\nEnter the year of release: ");
                    String release_year = in.next();
                    data.insert(name, actor, actress, director, release_year);
                    break;
                case 2: data.selectAll();
                    break;
                case 3: System.out.print("\nEnter the name of actor: ");
                    String actor_name=in.next();
                    data.selectQuery(actor_name);
                    break;
                default: System.out.println("Invalid input");
            }
        }while(choice != 4);
    }

}