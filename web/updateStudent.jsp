<%-- 
    Document   : updateStudent
    Created on : Mar 28, 2021, 12:26:34 PM
    Author     : admin
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.0-beta3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-eOJMYsd53ii+scO/bJGFsiCZc+5NDVN2yr8+0RDqr0Ql0h+rP48ckxlpbzKgwra6" crossorigin="anonymous">
        <title>Update Details</title>
    </head>
    <body>
    <center><h2 class="text-center text-success mt-3">Update Details</h2>
        <h3 class="mt-3"><%out.println("ID : "+request.getParameter("id"));%></h3>        
        <form action="./update" method="POST">
            <table class="mt-4">
                <tr>
                    <td>Name</td>
                    <td><input type="text" name="name"></td>
                </tr>
                
                <tr>
                    <td>Email</td>
                    <td><input type="text" name="email"></td>
                </tr>
                
                <tr>
                    <td>Contact no</td>
                    <td>
                        <input type="text" name="tele">
                        <input type="hidden" name="id" value="<%= request.getParameter("id") %>">
                    </td>
                </tr>
                <tr>
                    <td>
                        <input type="submit" value="Update" class="btn btn-success mt-2">
                    </td>
                    <td>
                        <a href="student.jsp" class="btn btn-warning mt-2">Back</a>
                    </td>
                </tr>
            </table>
        </form>
    </center>
    </body>
</html>
