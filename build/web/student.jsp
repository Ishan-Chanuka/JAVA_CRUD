<%-- 
    Document   : student
    Created on : Mar 26, 2021, 10:34:30 AM
    Author     : admin
--%>

<%@page import="java.sql.ResultSet"%>
<%@page import="java.sql.Statement"%>
<%@page import="java.sql.Connection"%>
<%@page import="model.DBcon"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@include file="session.jsp"%>
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

        <title>Student</title>
    </head>
    <body>
        <div class="container">
            <h2 class="text-center text-primary mt-4">Student Details</h2>
            <table class="table table-dark" style="margin-top: 50px">
                
                    <thead>
                        <tr>
                            <th scope="col">Name</th>
                            <th scope="col">ID</th>
                            <th scope="col">Email</th>
                            <th scope="col">Tele</th>
                            <th scope="col">Gender</th>
                            <th scope="col">Degree</th>
                            <th scope="col">Update</th>
                            <th scope="col">Delete</th>
                        </tr>
                    </thead>

                    <%
                        try{
                        DBcon con = new DBcon();
                        stmt = con.Connection().createStatement();
                        String sql = "SELECT * FROM details"; 
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
                            <td>
                                <form action="updateStudent.jsp" method="GET">
                                    <input type="hidden" name="id" value="<%= rs.getString("id")%>">
                                    <input type="submit" value="Update" class="btn btn-warning">
                                </form>
                            </td>
                            <td>
                                <form action="delete" method="POST">
                                    <input type="hidden" name="id" value="<%= rs.getString("id")%>">
                                    <input type="submit" value="Delete" class="btn btn-danger">
                                </form>
                            </td>
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
            <a href="home.html" class="btn btn-success mt-5">Home</a>
            <a href="register.html" class="btn btn-warning mt-5">Register</a>
        </div>     
    </body>
</html>
