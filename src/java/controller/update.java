/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import model.studentbean;

/**
 *
 * @author admin
 */
@WebServlet(name = "update", urlPatterns = {"/update"})
public class update extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        PrintWriter out = response.getWriter();
        
        String name = request.getParameter("name");
        String email = request.getParameter("email");
        String tele = request.getParameter("tele");
        String id = request.getParameter("id");
        
        studentbean std = new studentbean();
        
        
        
        if(std.studentUpdt(name, email, tele, id)){
            RequestDispatcher rd = request.getRequestDispatcher("student.jsp");
            rd.include(request, response);
        }
        else{
            RequestDispatcher rd = request.getRequestDispatcher("updateStudent.jsp");
            rd.include(request, response);
        }
    }
}
