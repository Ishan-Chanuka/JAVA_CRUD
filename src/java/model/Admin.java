package model;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class Admin {


    private String email;
    private String passw;
    int state = 0;
    boolean logstate = false;
    
    DBcon db = new DBcon();
    
    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassw() {
        return passw;
    }

    public void setPassw(String pass) {
        this.passw = pass;
    }
  
    public boolean signup(){
        try{
            String sql = "INSERT INTO admin(email, password) VALUE(?, ?)";
            PreparedStatement ps = db.Connection().prepareStatement(sql);
            ps.setString(1, email);
            ps.setString(2, passw);
            
            state = ps.executeUpdate();
        }
        catch(Exception e){
            e.printStackTrace();
        }
        
        return state == 1;
    }
    
    public boolean login() throws SQLException{
        String sql = "SELECT * FROM admin WHERE email = ? and password = ?";
        PreparedStatement ps = db.Connection().prepareStatement(sql);
        ps.setString(1, email);
        ps.setString(2, passw);
        ResultSet rs = ps.executeQuery();
        logstate = rs.next();
        
        return logstate;
    }   
}
