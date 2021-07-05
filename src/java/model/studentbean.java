package model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

public class studentbean {
    DBcon db = new DBcon();
    int state = 0;
    private String name;
    private String id;
    private String email;
    private String tele;
    private String gender;
    private String degree;
    Statement stmt = null;
    Connection con = null;
    ResultSet rs = null;
    
    public boolean studentReg(String name, String id, String email, String tele, String gend, String deg){
        
        try {
            PreparedStatement pr = db.Connection().prepareStatement("INSERT INTO details(name, id, email, tele, gender, degree) VALUES(?, ?, ?, ?, ?, ?)");
            
            pr.setString(1, name);
            pr.setString(2, id);
            pr.setString(3, email);
            pr.setString(4, tele);
            pr.setString(5, gend);
            pr.setString(6, deg);
            
            state = pr.executeUpdate();
            
        } catch (SQLException ex) {
            Logger.getLogger(studentbean.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return state == 1;
        
    }
    
    public boolean studentUpdt(String name, String email, String tele, String id){
        
        try{
           PreparedStatement ps = db.Connection().prepareStatement("UPDATE details SET name=?, email=?, tele=? WHERE id=?"); 
           ps.setString(1, name);
           ps.setString(2, email);
           ps.setString(3, tele);
           ps.setString(4, id);
           
           state = ps.executeUpdate();
        }
        catch(SQLException ex){
            Logger.getLogger(studentbean.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return state ==1;
    }
    
    public boolean studentDel(String id){
        
        try{
            PreparedStatement ps = db.Connection().prepareStatement("DELETE FROM details WHERE id=?");
            ps.setString(1, id);
            
            state = ps.executeUpdate();
        }
        catch(SQLException ex){
            Logger.getLogger(studentbean.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return state == 1;
    }
    
    public List getStudent() throws SQLException{
        List studentlist = new ArrayList();
        
        stmt = db.Connection().createStatement();
        String sql = "SELECT * FROM details";
        rs = stmt.executeQuery(sql);
        while(rs.next()){
            studentlist.add(rs.getString("name"));
            studentlist.add(rs.getString("id"));
            studentlist.add(rs.getString("email"));
            studentlist.add(rs.getString("tele"));
            studentlist.add(rs.getString("gender"));
            studentlist.add(rs.getString("degree") + "<br><br>");
        }
        
        return studentlist;
    }
    
    public List searchStudent(String degree) throws SQLException{
        List studentlist = new ArrayList();
        stmt = db.Connection().createStatement();
        String sql = "SELECT * FROM details WHERE degree LIKE '%"+degree+"%'";
        rs = stmt.executeQuery(sql);
        while(rs.next()){
            studentlist.add(rs.getString("name"));
            studentlist.add(rs.getString("id"));
            studentlist.add(rs.getString("email"));
            studentlist.add(rs.getString("tele"));
            studentlist.add(rs.getString("gender") + "<br><br>");
        }
        
        return studentlist;
    }
}