package com.epam.DB;
import com.epam.Ingridients.Products;

import java.sql.*;
import java.util.ArrayList;

/**
 * Created by Maryia on 11/15/2015.
 */

    public class ConnectToSQLLite {
        private static Connection c = null;
        private static Statement stmt = null;
        private static final String ToDB= "jdbc:sqlite:src/com/epam/DB/test.db";

        public static void createTable() {
            try {
                Class.forName("org.sqlite.JDBC");
                c = DriverManager.getConnection(ToDB);
                System.out.println("Opened database successfully");

                stmt = c.createStatement();
                String sql = new StringBuilder().append("CREATE TABLE MYSALAD").append("(ID INTEGER PRIMARY KEY AUTOINCREMENT, ").append("NAME TEXT,").append("CATEGORY TEXT,").append(" WEIGHT    INT,").append(" CALORIES  INT);").toString();
                    stmt.executeUpdate(sql);
                    stmt.close();
                    c.close();
                } catch (Exception e) {
                        System.err.println(e.getClass().getName() + ": " + e.getMessage());
                        System.exit(0);
                    }
                    System.out.println("Table was created successfully");
                }

    public static void insertTable(ArrayList<Products> mix) {
        try {
            Class.forName("org.sqlite.JDBC");
            c = DriverManager.getConnection(ToDB);
            c.setAutoCommit(false);
            System.out.println("Opened database successfully");

            stmt = c.createStatement();
            for (Products p : mix) {
                    String sql = String.format("INSERT INTO MYSALAD (NAME,CATEGORY,WEIGHT,CALORIES) VALUES ('%s','%s',%s,%s);", p.getName(), p.getCategory(), p.getWeight(), p.getCalories());
                    stmt.executeUpdate(sql);
                }

                        stmt.close();
                c.commit();
                c.close();
            } catch (Exception e) {
                System.err.println(e.getClass().getName() + ": " + e.getMessage());
                System.exit(0);
            }
            System.out.println("Records were created successfully");
        }


        public static void main(String[] args) {
            new ConnectToSQLLite();

        }
    }
