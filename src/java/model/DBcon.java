package model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;


public class DBcon {
    public Connection Connection(){ 
         String driver = "com.mysql.jdbc.Driver";
         String url = "jdbc:mysql://localhost:3306/studentreg";
         Connection con = null;
         try {
             Class.forName(driver);
             con = DriverManager.getConnection(url,"root","");
         } catch (ClassNotFoundException | SQLException ex) {
             Logger.getLogger(DBcon.class.getName()).log(Level.SEVERE, null, ex);
         }
         return con;
}
}
