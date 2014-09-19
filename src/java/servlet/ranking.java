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
import model.Ranking;
import model.User;

/**
 *
 * @author sarunpeetasai
 */
public class ranking extends HttpServlet {

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
        List<Ranking> ranking = Ranking.showRanking();
        int position;
        String result="",table="";
        for(int i=0;i<ranking.size();i++){
            if(ranking.get(i).getUserId()==u.getUserID()){
                position = ranking.get(i).getId();
                result = result.concat("คุณอยู่อันดับที่ "+ position +" ด้วยค่าเฉลี่ยน้ำตาลที่ (eAG) "+ranking.get(i).geteAG());
                break;
            }
        }
        for(int i=0;i<ranking.size();i++){
            table = table.concat("<tr><td class=\"text-center\">"+ranking.get(i).getId()+"</td><td>"+User.getUserName(ranking.get(i).getUserId())+"</td><td>"+ranking.get(i).geteAG()+"</td></tr>");
        }
        request.setAttribute("table", table);
        request.setAttribute("result", result);
        request.setAttribute("name", u.getFirstname()+" "+u.getLastname());
        request.setAttribute("profilepic", u.getProfilePIC());
        getServletContext().getRequestDispatcher("/ranking.jsp").forward(request, response);
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
