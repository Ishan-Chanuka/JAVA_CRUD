<%-- 
    Document   : searchresult
    Created on : Apr 16, 2021, 10:27:13 AM
    Author     : admin
--%>

<%@page import="model.DBcon"%>
<%@page import="java.sql.ResultSet"%>
<%@page import="java.sql.Statement"%>
<%@page import="java.sql.Connection"%>
<%@page import="java.util.Iterator"%>
<%@page import="java.util.List"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<%
    Connection conn = null;
    Statement stmt = null;
    ResultSet rs = null;

%>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.0-beta3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-eOJMYsd53ii+scO/bJGFsiCZc+5NDVN2yr8+0RDqr0Ql0h+rP48ckxlpbzKgwra6" crossorigin="anonymous">
        <title>Search Result</title>
    </head>
    <body>
        <div class="container" style="margin-top: 50px">
        
            <h2 class="text-center text-success mt-3">Search Results</h2>
            
            <table class="table table-dark" style="margin-top: 50px">
                
                    <thead>
                        <tr>
                            <th scope="col">Name</th>
                            <th scope="col">ID</th>
                            <th scope="col">Email</th>
                            <th scope="col">Tele</th>
                            <th scope="col">Gender</th>
                            <th scope="col">Degree</th>
                        </tr>
                    </thead>
            
            <%
                        try{
                        DBcon con = new DBcon();
                        stmt = con.Connection().createStatement();
                        String sql = "SELECT * FROM details WHERE degree LIKE '%"+request.getParameter("degree")+"%'"; 
                        rs = stmt.executeQuery(sql);
                        while(rs.next()){
            %>
            
            <thead>
                        <tr>
                            <td><%= rs.getString("name")%></td>
                            <td><%= rs.getString("id")%></td>
                            <td><%= rs.getString("email")%></td>
                            <td><%= rs.getString("tele")%></td>
                            <td><%= rs.getString("gender")%></td>
                            <td><%= rs.getString("degree")%></td>
                        </tr>
            </thead>
            
            <%
                        }
                      conn.close();
                      }
                        catch(Exception e){
                            e.printStackTrace();
                      }

                    %>
            </table>
        <a href="studentlist.jsp" class="btn btn-warning mt-2">Back</a>
        </div>
    </body>
</html>
