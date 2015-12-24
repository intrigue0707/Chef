package com.epam.DB;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
/**
Created by Maryia on 11/16/2015.
 */


public class ReadFromDB
     {
        private static final String ToDB = "jdbc:sqlite:src/com/epam/DB/test.db";
        public static void main( String args[] )
        {
            Connection c = null;
            Statement stmt = null;
            try {
                Class.forName("org.sqlite.JDBC");
                c = DriverManager.getConnection(ToDB);
                c.setAutoCommit(false);
                System.out.println("Opened database successfully");

                stmt = c.createStatement();
                ResultSet rs = stmt.executeQuery( "SELECT * FROM MYSALAD;" );
                while ( rs.next() ) {
                    int id = rs.getInt("id");
                    String  name = rs.getString("name");
                    String category= rs.getString("category");
                    int weight  = rs.getInt("weight");
                    int calories  = rs.getInt("calories");
                    System.out.println( "ID = " + id );
                    System.out.println( "NAME = " + name );
                    System.out.println( "CATEGORY = " + category );
                    System.out.println( "WEIGHT = " + weight );
                    System.out.println( "CALORIES = " + calories );
                    System.out.println();
                }
                rs.close();
                stmt.close();
                c.close();
            } catch ( Exception e ) {
                System.err.println( e.getClass().getName() + ": " + e.getMessage() );
                System.exit(0);
            }
            System.out.println("Operation was done successfully");
        }
    }

