/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import model.AppointmentLog;
import model.User;
import model.utility;

/**
 *
 * @author sarunpeetasai
 */
public class addCal extends HttpServlet {

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
        String typ = request.getParameter("type");
        String dat = request.getParameter("date");
        String time = request.getParameter("time");
        String note = request.getParameter("note");
        Date ndate = new Date();
        String irdate = dat.concat(" " + time);
        Date rdate = null;
        try {
            rdate = new SimpleDateFormat("dd/MM/yy HH:mm:ss").parse(irdate);
        } catch (ParseException ex) {
            Logger.getLogger(addCal.class.getName()).log(Level.SEVERE, null, ex);
        }
        if (typ.equals("1")) {
            int docID = u.getRelatedUserID();
            AppointmentLog.addRecord(u.getUserID(), docID, rdate, ndate, note, u.getUserID(), 1, 1);
        }
        if (typ.equals("2")) {
            AppointmentLog.addRecord(u.getUserID(), 0, rdate, ndate, note, u.getUserID(), 2, 2);
        }
        getServletContext().getRequestDispatcher("/calendar").forward(request, response);
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
