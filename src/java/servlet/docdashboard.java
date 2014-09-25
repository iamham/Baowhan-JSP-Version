/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import model.User;
import java.util.List;
import model.AppointmentLog;
import model.DiabetesLog;
import model.Hospital;
import model.Ranking;

/**
 *
 * @author sarunpeetasai
 */
public class docdashboard extends HttpServlet {

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
        SimpleDateFormat sf = new SimpleDateFormat("dd-MM");
        HttpSession session = request.getSession(false);
        User u = (User) session.getAttribute("user");
        List<User> allP = User.showAccPatientList(u.getUserID());
        AppointmentLog appointment = AppointmentLog.getNextCheckDate(u.getUserID());
        List<User> allR = User.showAccRequest(u.getUserID());
        String userList = "";
        for (int i = 0; i < allP.size(); i++) {
            userList = userList.concat("<div class=\"col-lg-4 col-lg-pull-4\"><a href=\"showUser?id=" + allP.get(i).getUsername() + "\" class=\"widget\"><div class=\"widget-content text-center\">\n<img src=\"img/user/" + allP.get(i).getProfilePIC() + "\" alt=\"avatar\" class=\"img-circle img-thumbnail img-thumbnail-avatar-2x\">\n"
                    + "                                        <h2 class=\"widget-heading h3 text-muted\">" + allP.get(i).getFirstname() + " " + allP.get(i).getLastname() + "</h2></div><div class=\"widget-content themed-background-muted text-dark text-center\"><strong>" + Hospital.findById(allP.get(i).getHospitalID()) + "</strong>"
                    + "                                    </div><div class=\"widget-content\"><div class=\"row text-center\"><div class=\"col-xs-6\"><h3 class=\"widget-heading\"><i class=\"gi gi-tint text-info\"></i> <br><small> eAG : " + DiabetesLog.getEAG(allP.get(i).getUserID()) + "</small></h3>\n"
                    + "                                            </div><div class=\"col-xs-6\"><h3 class=\"widget-heading\"><i class=\"gi gi-sorting text-danger\"></i> <br><small>" + Ranking.position(allP.get(i).getUserID()) + "</small></h3></div>\n"
                    + "                                        </div></div></a></div>");
        }
        if(appointment!=null){
               request.setAttribute("nextApp", sf.format(appointment.getChecktime())); 
            }else{
               request.setAttribute("nextApp", "ไม่มีการนัดหมาย");
            }
        request.setAttribute("userList", userList);
        int noreq = 0;
        noreq = allR.size();
        request.setAttribute("pno", allP.size());
        request.setAttribute("name", u.getFirstname() + " " + u.getLastname());
        request.setAttribute("noreq", noreq);
        request.setAttribute("profilepic", u.getProfilePIC());
        getServletContext().getRequestDispatcher("/docdashboard.jsp").forward(request, response);
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
