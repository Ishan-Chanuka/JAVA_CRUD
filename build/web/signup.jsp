<%-- 
    Document   : signup
    Created on : Apr 15, 2021, 8:15:09 PM
    Author     : admin
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.0-beta3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-eOJMYsd53ii+scO/bJGFsiCZc+5NDVN2yr8+0RDqr0Ql0h+rP48ckxlpbzKgwra6" crossorigin="anonymous">
        <title>JSP Page</title>
    </head>
    <body>
        <center>
        <div class="mt-5"></div>
        <h2 class="text-center text-success mt-3">Sign Up</h2>
        <form action="./signup" method="POST">
            <table class="mt-4">
                <tr>
                    <td>Email</td>
                    <td><input type="text" name="email"></td>
                </tr>
                
                <tr>
                    <td>Password</td>
                    <td>
                        <input type="password" name="pass">
                    </td>
                </tr>
                <tr>
                    <td>
                        <input type="submit" value="Sign Up" class="btn btn-success mt-2">
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
