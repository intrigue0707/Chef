package com.epam.DB;
import java.sql.*;
    /**
     * Created by Maryia on 11/16/2015.
     */
    public class DeleteDB {
        public static void main( String args[] )
        {
            Connection c = null;
            Statement stmt = null;
            try {
                Class.forName("org.sqlite.JDBC");
                c = DriverManager.getConnection("jdbc:sqlite:src/com/epam/DB/test.db");
                c.setAutoCommit(false);
                System.out.println("Opened database successfully");

                stmt = c.createStatement();
                String sql = "DROP TABLE MYSALAD;";
                stmt.executeUpdate(sql);
                c.commit();


                stmt.close();
                c.close();
            } catch ( Exception e ) {
                System.err.println( e.getClass().getName() + ": " + e.getMessage() );
                System.exit(0);
            }
            System.out.println("Operation done successfully");
        }
}
