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
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import model.DiabetesLog;
import model.User;
import model.utility;

/**
 *
 * @author sarunpeetasai
 */
public class checkRecord extends HttpServlet {

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
        String from =request.getParameter("from");
        String to =request.getParameter("to");
        SimpleDateFormat sf = new SimpleDateFormat("dd/MM/yy");
        SimpleDateFormat sf1 = new SimpleDateFormat("dd-MM");
        Date date = new Date();
        Calendar cal = Calendar.getInstance();
        cal.add(Calendar.MONTH, -1);
        Date result = cal.getTime();
        if(from==null){
            from = sf.format(result);
            to = sf.format(date);
        }
        String time = " 00:00:00";
        from = from.concat(time);
        to = to.concat(time);
        Date fd=null;
        Date td=null;
        String chartValue = "[";
        String chartDate = "[";
        int itemp=1;
        try {
            fd = new SimpleDateFormat("dd/MM/yy HH:mm:ss").parse(from);
            td = new SimpleDateFormat("dd/MM/yy HH:mm:ss").parse(to);
        } catch (ParseException ex) {
            Logger.getLogger(checkRecord.class.getName()).log(Level.SEVERE, null, ex);
        }
        List<DiabetesLog> record = DiabetesLog.getBloodRecord(u.getUserID(), fd, td);
        String table="";
        for(int i=0;i<record.size();i++){
            table = table.concat("<tr><td class=\"text-center\">"+record.get(i).getLogId()+"</td> <td>"+record.get(i).getChecktime().toString()+"</td> <td>"+record.get(i).getValue()+"<td>"+record.get(i).getNote()+"</td> <td class=\"text-center\"> <a href=\"editRecord?id="+record.get(i).getLogId()+"\" data-toggle=\"tooltip\" title=\"แก้ไขบันทึก\" class=\"btn btn-effect-ripple btn-xs btn-success\"> <i class=\"fa fa-pencil\"></i></a><a href=\"deleteRecord?id="+record.get(i).getLogId()+"\" data-toggle=\"tooltip\" title=\"ลบบันทึก\" class=\"btn btn-effect-ripple btn-xs btn-danger\"><i class=\"fa fa-times\"></i></a></td></tr>");
            chartValue = chartValue.concat("[\""+itemp+"\", "+record.get(i).getValue()+"],");
            chartDate = chartDate.concat("[\""+itemp+"\", \'"+sf1.format(record.get(i).getChecktime())+"\'],");
            itemp++;
        }
        chartValue = chartValue.concat("];");
        chartDate = chartDate.concat("];");
        request.setAttribute("eAG", DiabetesLog.getEAG(u.getUserID()));
        request.setAttribute("detail", utility.genInstrustion(DiabetesLog.getEAG(u.getUserID())));
        request.setAttribute("chartDate", chartDate);
        request.setAttribute("chartValue", chartValue);
        request.setAttribute("table", table);
        request.setAttribute("from", sf.format(fd));
        request.setAttribute("to", sf.format(td));
        getServletContext().getRequestDispatcher("/showRecord.jsp").forward(request, response);
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
