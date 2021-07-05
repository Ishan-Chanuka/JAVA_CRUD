<%-- 
    Document   : session
    Created on : Apr 15, 2021, 7:26:50 PM
    Author     : admin
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <%
            HttpSession s1 = request.getSession(false);
            if(s1.getAttribute("email") != null){
                
            }
            else{
                response.sendRedirect("login.jsp");
            }
        %>
    </head>
</html>
