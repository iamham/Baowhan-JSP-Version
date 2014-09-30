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
import model.Ranking;
import model.User;

/**
 *
 * @author sarunpeetasai
 */
public class req extends HttpServlet {

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
            HttpSession session = request.getSession(false);
            User u = (User) session.getAttribute("user");
            List<User> user = User.showAccRequest(u.getUserID());
            String userTable="";
            for (int i = 0; i < user.size(); i++) {
            userTable = userTable.concat("<tr><td>"+user.get(i).getUsername()+"</td><td>"+user.get(i).getFirstname()+" "+user.get(i).getLastname()+"</td><td>"+Hospital.findById(user.get(i).getHospitalID())+"</td><td>"+DiabetesLog.getEAG(user.get(i).getUserID())+"</td><td>"+Ranking.position(user.get(i).getUserID())+"</td><td class=\"text-center\">\n" +
"                                                <a href=\"acc?id="+user.get(i).getUserID()+"&status=2\" data-toggle=\"tooltip\" title=\"Accept User\" class=\"btn btn-effect-ripple btn-sm btn-success\"><i class=\"gi gi-user_add\"></i></a> <a href=\"acc?id="+user.get(i).getUserID()+"&status=3\" data-toggle=\"tooltip\" title=\"Denide User\" class=\"btn btn-effect-ripple btn-sm btn-danger\"><i class=\"gi gi-user_remove\"></i></a></tr>");
        }
            request.setAttribute("userTable", userTable);
            request.setAttribute("name", u.getFirstname() + " " + u.getLastname());
            request.setAttribute("profilepic", u.getProfilePIC());
            getServletContext().getRequestDispatcher("/request.jsp").forward(request, response);
            
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
    }// </editor-fold>

}
