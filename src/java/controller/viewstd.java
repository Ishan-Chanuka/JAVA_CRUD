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


@WebServlet(name = "viewstd", urlPatterns = {"/viewstd"})
public class viewstd extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
        PrintWriter out = response.getWriter();
        
        studentbean sb = new studentbean();
        
        try{
            List student = sb.getStudent();
            request.setAttribute("studentList", student);
            RequestDispatcher rd = request.getRequestDispatcher("studentlist.jsp");
            rd.forward(request, response);
            
        } catch (SQLException ex) {
            Logger.getLogger(viewstd.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }



}
