package controller;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import model.Admin;


@WebServlet(name = "signup", urlPatterns = {"/signup"})
public class signup extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
     
    }


    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
        PrintWriter out = response.getWriter();
        
        String email = request.getParameter("email");
        String pass = request.getParameter("pass");
        
        Admin admin = new Admin();
        admin.setEmail(email);
        admin.setPassw(pass);
        
       
        if(admin.signup()){
            RequestDispatcher rd = request.getRequestDispatcher("home.html");
            rd.include(request, response);
        }
        else{
            out.println("Error");
            RequestDispatcher rd = request.getRequestDispatcher("signup.jsp");
            rd.include(request, response);
        }
    }

}
