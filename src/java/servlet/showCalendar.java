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
import model.AppointmentLog;
import model.User;

/**
 *
 * @author sarunpeetasai
 */
public class showCalendar extends HttpServlet {

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
        SimpleDateFormat sf = new SimpleDateFormat("yyyy, M, d");
        HttpSession session = request.getSession(false);
        User u = (User) session.getAttribute("user");
        List<AppointmentLog> req = AppointmentLog.getRequest(u.getUserID());
        System.out.println(req.isEmpty());
        if(!req.isEmpty()){
            String sreq="";
            for(int i=0;i<req.size();i++){
                sreq = sreq.concat("<div class=\"alert alert-info alert-dismissable animation-slideRight\">\n" +
"<button type=\"button\" class=\"close\" data-dismiss=\"alert\" aria-hidden=\"true\">&times;</button><p>คุณมีคำขอนัดใหม่</p><p><strong>วันที่ "+req.get(i).getChecktime().toString()+" พบกับคุณหมอ "+User.getUserName(req.get(i).getDoctorId())+"<br />รายละเอียด "+req.get(i).getDetail()+"<a href=\"calAcc?id="+req.get(i).getLogId()+"\"><br /><button class=\"btn btn-sm btn-effect-ripple btn-success\">เพิ่ม</button></a><a href=\"calDec?id="+req.get(i).getLogId()+"\"> <button class=\"btn btn-sm btn-effect-ripple btn-danger\">ลบ</button></a></div>");
            }
        request.setAttribute("req", sreq);
        }
        List<AppointmentLog> all = AppointmentLog.getCalendar(u.getUserID());
        System.out.println(all.isEmpty());
        if(!all.isEmpty()){
            String json = "[ ";
        int siz = all.size();
        for(int i=0;i<all.size();i++){
            json = json.concat("{ title: \'"+all.get(i).getDetail()+"\', start: new Date("+sf.format(all.get(i).getChecktime())+") } ");
            if(i!=(siz-1)){
                json = json.concat(" , ");
            }
        }
        json = json.concat(" ] ");
        request.setAttribute("cal", json);
        }
        getServletContext().getRequestDispatcher("/calendar.jsp").forward(request, response);
        /*[
                    {
                        title: 'Cinema',
                        start: new Date(4, 8, 2014),
                        allDay: true,
                        color: '#de815c'
                    },*/
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
