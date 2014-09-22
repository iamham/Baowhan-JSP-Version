/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import model.DiabetesLog;
import model.Hospital;
import model.Message;
import model.User;

/**
 *
 * @author sarunpeetasai
 */
public class admindashboard extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        
            HttpSession session = request.getSession(false);
            User u = (User) session.getAttribute("user");
            List<User> alluser = User.showPatientList();
            String table = "";
            for (int i = 0; i < alluser.size(); i++) {
                table = table.concat("<tr><td class=\"text-center\">" + alluser.get(i).getUserID() + "</td><td>" + alluser.get(i).getFirstname() + " " + alluser.get(i).getLastname() + "</td><td>" + User.getUserName(alluser.get(i).getRelatedUserID()) + "</td><td>" + Hospital.findById(alluser.get(i).getHospitalID()) + "</td><td class=\"text-center\"><a href=\"showUser?id=" + alluser.get(i).getUserID() + "\" data-toggle=\"tooltip\" title=\"แก้ไข\" class=\"btn btn-effect-ripple btn-sm btn-success\"><i class=\"fa fa-pencil\"></i></a><a href=\"delUser?id=" + alluser.get(i).getUserID() + "\" data-toggle=\"tooltip\" title=\"Delete User\" class=\"btn btn-effect-ripple btn-sm btn-danger\"> <i class=\"fa fa-times\"></i></a>");
            }
            request.setAttribute("msgno", Message.getAllMessageCount());
            request.setAttribute("logno", DiabetesLog.getAllLogCount());
            request.setAttribute("table", table);
            request.setAttribute("nouser", alluser.size());
            getServletContext().getRequestDispatcher("/admindashboard.jsp").forward(request, response);
    
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }
}
