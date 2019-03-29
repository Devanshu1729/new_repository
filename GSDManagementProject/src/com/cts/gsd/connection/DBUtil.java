package com.cts.gsd.connection;



import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBUtil 
{
                public static Connection getConnection()
                {
                                Connection c=null;
                                try {
                                                Class.forName("oracle.jdbc.driver.OracleDriver");
                                } catch (ClassNotFoundException e) {
                                                // TODO Auto-generated catch block
                                                e.printStackTrace();
                                }
                               try {
                                                c=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:XE","hr","hr");
                                } catch (SQLException e) {
                                                // TODO Auto-generated catch block
                                                e.printStackTrace();
                                }
                                return c;
                }

}
