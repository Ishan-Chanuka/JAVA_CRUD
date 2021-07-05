/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
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
@WebServlet(name = "filter", urlPatterns = {"/filter"})
public class filter extends HttpServlet {


    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        
    }
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
        PrintWriter out = response.getWriter();
        
        String deg = request.getParameter("degree");
        
        studentbean sb = new studentbean();
        
        try{
            List studentd = sb.searchStudent(deg);
            request.setAttribute("studentList", studentd);
            RequestDispatcher rd = request.getRequestDispatcher("searchresult.jsp");
            rd.forward(request, response);
            
        } catch (SQLException ex) {
            Logger.getLogger(filter.class.getName()).log(Level.SEVERE, null, ex);
        }
    }


}
