/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import model.DiabetesLog;
import model.User;

/**
 *
 * @author sarunpeetasai
 */
public class editRecord extends HttpServlet {

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
        boolean success = false;
        SimpleDateFormat sft = new SimpleDateFormat("HH:mm:ss");
        SimpleDateFormat sfd = new SimpleDateFormat("dd/MM/yyyy");
        
        HttpSession session = request.getSession(false);
        User u = (User) session.getAttribute("user");
        String id =request.getParameter("id");
        int iid = Integer.parseInt(id);
        List<DiabetesLog> record = DiabetesLog.getAllUserRecord(u.getUserID());
        for(int i=0;i<record.size();i++){
            
            if(record.get(i).getLogId()==iid){
                request.setAttribute("id", iid);
                request.setAttribute("value", record.get(i).getValue());
                request.setAttribute("note", record.get(i).getNote());
                request.setAttribute("date", sfd.format(record.get(i).getChecktime()));
                request.setAttribute("time", sft.format(record.get(i).getChecktime()));
                success = true;
            }
        }
        if(success){
            getServletContext().getRequestDispatcher("/editRecord.jsp").forward(request, response);
        }else{
            getServletContext().getRequestDispatcher("/checkRecord").forward(request, response);
        }
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
