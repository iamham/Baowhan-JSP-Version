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
import model.DiabetesLog;
import model.User;

/**
 *
 * @author sarunpeetasai
 */
public class addme extends HttpServlet {

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
        response.setContentType("text/html;charset=UTF-8");
        HttpSession session = request.getSession(false);
        User u = (User) session.getAttribute("user");
        String msg = "";
        String bvalue =request.getParameter("bvalue");
        double dbvalue = 0;
        String note =request.getParameter("note");
        String date =request.getParameter("date");
        String time =request.getParameter("time");
        String irdate = date.concat(" "+time);
        Date ts = new Date();
        Date rdate=null;
        try {
            dbvalue = Double.parseDouble(bvalue);
            rdate = new SimpleDateFormat("dd/MM/yy HH:mm:ss").parse(irdate);
            success = true;
        } catch (ParseException ex) {
            Logger.getLogger(addme.class.getName()).log(Level.SEVERE, null, ex);
        }if(success){
        success = DiabetesLog.addRecord(u.getUserID(), dbvalue, note, rdate, ts);
        }
        if(success){
            getServletContext().getRequestDispatcher("/checkRecord").forward(request, response);
        }else{
            msg = "เกิดข้อผิดพลาด กรุณาลองใหม่อีกครั้ง";
            getServletContext().getRequestDispatcher("/addRecord").forward(request, response);
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
