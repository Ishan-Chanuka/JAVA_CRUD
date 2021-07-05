<%-- 
    Document   : studentlist
    Created on : Apr 15, 2021, 7:20:28 PM
    Author     : admin
--%>

<%@page import="java.util.Iterator"%>
<%@page import="java.util.List"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@include file="session.jsp"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.0-beta3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-eOJMYsd53ii+scO/bJGFsiCZc+5NDVN2yr8+0RDqr0Ql0h+rP48ckxlpbzKgwra6" crossorigin="anonymous">
        <title>JSP Page</title>
    </head>
    <body>
        
    <center>
        <h2 class="text-center text-success mt-3">Search</h2>
        <form action="./filter" method="POST">
            <table>
                <tr>
                    <td>Degree</td>
                    <td>
                        <select name="degree">
                            <option>Degree</option>
                            <option>SE</option>
                            <option>CS</option>
                            <option>MIS</option>
                        </select>
                    </td>
                </tr>
                
                <tr>
                    <td>
                        <input type="submit" value="Search" class="btn btn-success mt-2">
                    </td>
                    <td>
                        <a href="home.html" class="btn btn-warning mt-2">Home</a>
                    </td>
                </tr>
                
            </table>
        </form>
    </center>
        
    </body>
</html>
