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
import model.Message;
import java.util.List;
import model.DiabetesLog;
/**
 *
 * @author sarunpeetasai
 */
public class docmessage extends HttpServlet {

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
        
        String result ="";
        HttpSession session = request.getSession(false);
        SimpleDateFormat sf = new SimpleDateFormat("d/M/yy HH:mm:ss");
        SimpleDateFormat sf1 = new SimpleDateFormat("d");
        User u = (User) session.getAttribute("user");
        List allCid = Message.getAllCID(u.getUserID());
        List<User> allP = User.showAccPatientList(u.getUserID());
        String allpa="";
        for(int i=0;i<allP.size();i++){
            allpa = allpa.concat("<tr><td class=\"text-center\" style=\"width: 100px;\"><img src=\"img/user/"+allP.get(i).getProfilePIC()+"\" alt=\"User Image\" width=\"50px\" class=\"img-circle\">\n" +
"                                                    </td><td><a href=\"showMessage?pid="+allP.get(i).getUserID()+"\" class=\"text-info\">"+allP.get(i).getFirstname()+" "+allP.get(i).getLastname()+"</a><br></td><td class=\"text-center\" style=\"width: 80px;\">" +
"                                                        <a href=\"showMessage?pid="+allP.get(i).getUserID()+" class=\"btn btn-effect-ripple btn-xs btn-danger\" data-toggle=\"tooltip\" title=\"Follow\"><i class=\"fa fa-share\"></i></a>\n" +
"                                                    </td>\n" +
"                                                </tr>");
        }
        request.setAttribute("allp", allpa);
        request.setAttribute("pno", allP.size());
        for(int i=0;i<allCid.size();i++){
        String val = (String) allCid.get(i);
        int pid = Message.getPatientID(Integer.parseInt(val), u.getUserID());
        User pu = User.getUserByID(pid);
        List last = Message.getLastMessage(Integer.parseInt(val));
        if(last.isEmpty()){
            last.add("");
            last.add("");
        }
        result = result.concat("<tr><td td-label td-label-danger class=\"text-center\" style=\"width: 100px;\"> <img src=\"img/user/"+pu.getProfilePIC()+"\" width=\"60px\" alt=\"avatar\" class=\"img-circle\"></td><td><h4><a href=\"showMessage?id="+val+"\" class=\"text-dark\"><strong>"+pu.getFirstname()+" "+pu.getLastname()+"</strong></a></h4><span class=\"text-muted\">"+last.get(0)+"</span></td><td class=\"hidden-xs text-center\" style=\"width: 30px;\">  </td> <td class=\"hidden-xs text-right text-muted\" style=\"width: 120px;\"></td><td class=\"hidden-xs text-right text-muted\" style=\"width: 120px;\"><em>"+last.get(1)+"</em></td> </tr>");
        }
        request.setAttribute("message", result);
        getServletContext().getRequestDispatcher("/docmessage.jsp").forward(request, response);
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
