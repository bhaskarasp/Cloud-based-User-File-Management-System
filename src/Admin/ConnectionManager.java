/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Admin;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;



/**
 *
 * @author DELL_PC
 */
public class ConnectionManager {
  //private static String url = "jdbc:mysql://pesintershipdb.czcocksemuod.ap-south-1.rds.amazonaws.com:3306/pes_be_internship?characterEncoding=latin1";     
   private static String url = "jdbc:mysql://localhost:3308/pes_be_internship";   
    private static String driverName = "com.mysql.jdbc.Driver";   
    private static String username = "root";   
    private static String password = "root";
    private static Connection con;
    //private static String urlstring;

    public static Connection getConnection() {
        try {
            Class.forName(driverName);
            try {
                con = DriverManager.getConnection(url, username, password);
            } catch (SQLException ex) {
                // log an exception. fro example:
                System.out.println(ex); 
            }
        } catch (ClassNotFoundException ex) {
            // log an exception. for example:
            System.out.println("Driver not found."); 
        }
        return con;
    }
}
