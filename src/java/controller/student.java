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
@WebServlet(name = "student", urlPatterns = {"/student"})
public class student extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        
    }


    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
        PrintWriter out = response.getWriter();
        
        String name = request.getParameter("name");
        String id = request.getParameter("id");
        String email = request.getParameter("email");
        String tele = request.getParameter("tele");
        String gend = request.getParameter("gender");
        String deg = request.getParameter("degree");
        
        
        studentbean stb = new studentbean();
        
        if(stb.studentReg(name , id, email, tele, gend, deg)){
            out.println("Regitration Successfull!!");
            RequestDispatcher rd = request.getRequestDispatcher("student.jsp");
            rd.include(request, response);
        }
        else{
            out.println("Regitration Fail!!");
            RequestDispatcher rd = request.getRequestDispatcher("index.html");
            rd.include(request, response);
        }
    }
}
