/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package servlet;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.servlet.http.Part;
import model.User;

/**
 *
 * @author LudjaPae
 */
@WebServlet("/upload")
@MultipartConfig
public class Register extends HttpServlet {

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
            HttpSession s = request.getSession();
            String username =request.getParameter("username");
            String pwd1 =request.getParameter("pwd1");
            String email =request.getParameter("email");
            Part filePart = request.getPart("pic");
            String firstname = request.getParameter("firstname");
            String lastname = request.getParameter("lastname");
            String telephone = request.getParameter("telephone");
            String province = request.getParameter("province");
            String doctor = request.getParameter("doctor");
            String hospital = request.getParameter("hospital");
            int idoctor = Integer.parseInt(doctor);
            int ihospital = Integer.parseInt(hospital);
            
            boolean success = false;
            //String profilePIC =request.getParameter("profilePIC");
            
            if(User.getUser(username)!=null){
                request.setAttribute("msg","ชื่อผู้ใช้นี้มีผู้ใช้แล้ว กรุณากรอกชื่อผู้ใช้ใหม่");
            }else{
                /*User u = new User(12,username ,pwd1 ,email ,firstname ,lastname ,profilePIC ,
                        telephone ,address ,province ,amphur ,zipcode);*/
                if(User.pRegister(username,pwd1,email,firstname,lastname,telephone,province,idoctor,ihospital,1)){
                    request.setAttribute("msg","ลงทะเบียนสำเร็จ กรุณากรอกข้อมูลส่วนตัว");
                    success = true;
                }else{
                    request.setAttribute("msg","เกิดข้อผิดพลาด กรูณาลองใหม่อีกครั้ง");
                }
                
            //}
        }
        if(success){
        User u = User.getUser(username);
        s.setAttribute("user", u);
        request.setAttribute("msg","ลงทะเบียนเรียบร้อย กรุณาทำการตั้งค่าการใช้งานครั้งแรก");
        getServletContext().getRequestDispatcher("/dashboard").forward(request, response);
        }else{
        getServletContext().getRequestDispatcher("/register1.jsp").forward(request, response);
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
