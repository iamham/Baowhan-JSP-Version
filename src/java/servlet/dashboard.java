/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import model.AppointmentLog;
import model.DiabetesLog;
import model.Hospital;
import model.Ranking;
import model.User;
import model.utility;

/**
 *
 * @author sarunpeetasai
 */
public class dashboard extends HttpServlet {

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
            SimpleDateFormat sf = new SimpleDateFormat("dd-MM");
            SimpleDateFormat sf1 = new SimpleDateFormat("dd-MM");
            response.setContentType("text/html;charset=UTF-8");
            HttpSession session = request.getSession(false);
            User u = (User) session.getAttribute("user");
            List<DiabetesLog> log = DiabetesLog.getAllUserRecord(u.getUserID());
            //System.out.println("LOG:"+log.isEmpty());
            AppointmentLog appointment = AppointmentLog.getNextCheckDate(u.getUserID());
            //System.out.println("APP:"+AppointmentLog.getNextCheckDate(u.getUserID()));
                   int position = Ranking.position(u.getUserID());
            //System.out.println("POS:"+position);
            List<Ranking> ranking = Ranking.showRanking();
            
            String result = "";
        for (int i = 0; i < ranking.size(); i++) {
            if (ranking.get(i).getUserId() == u.getUserID()) {
                position = ranking.get(i).getId();
                result = result.concat("คุณอยู่อันดับที่ " + position + "<br />ด้วยคะแนน " + ranking.get(i).getPoint());
            }
        }
            if(log.isEmpty()){
                request.setAttribute("lastRec", "ยังไม่มีการบันทึกค่า");
            }else{
                request.setAttribute("lastRec", log.get(log.size()-1).getValue());
            }
            if(appointment!=null){
               request.setAttribute("nextApp", sf.format(appointment.getChecktime())); 
            }else{
               request.setAttribute("nextApp", "ไม่มีการนัดหมาย");
            }
            if(position==0){
                 request.setAttribute("position", "ยังไม่มีการบันทึกค่าน้ำตาล");
            }else{
                request.setAttribute("position", position);
            }
            String chartValue = "[";
            String chartDate = "[";
            int itemp = 1;
            for(int i=0;i<log.size();i++){
                chartValue = chartValue.concat("[\""+itemp+"\", "+log.get(i).getValue()+"],");
                chartDate = chartDate.concat("[\""+itemp+"\", \'"+sf1.format(log.get(i).getChecktime())+"\'],");
                itemp++;
            }
            request.setAttribute("result", result);
            chartValue = chartValue.concat("];");
            chartDate = chartDate.concat("];");
            request.setAttribute("instruction", utility.genInstrustion(User.getUserEAG(u.getUserID())));
            request.setAttribute("eAG", User.getUserEAG(u.getUserID()));
            request.setAttribute("chartDate", chartDate);
            request.setAttribute("chartValue", chartValue);
            request.setAttribute("name", u.getFirstname()+" "+u.getLastname());
            request.setAttribute("profilepic", u.getProfilePIC());
            System.out.println("HOSPITAL:"+u.getHospitalID()+":"+Hospital.findById(u.getHospitalID()));
            request.setAttribute("hospital", Hospital.findById(u.getHospitalID()));
            //[[1, 1900], [2, 2300], [3, 3200], [4, 2500], [5, 4200], [6, 3100], [7, 3600], [8, 2500], [9, 4600], [10, 3700], [11, 4200], [12, 5200]];
        getServletContext().getRequestDispatcher("/dashboard.jsp").forward(request, response);
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
