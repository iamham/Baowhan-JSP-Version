/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package model;

import connectionDB.ConnectionAgent;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author LudjaPae
 */
public class AppointmentLog {
    private int logId;
    private int patientId;
    private int doctorId;
    private Date checktime; 
    private Date logtime;
    private String detail;

    public AppointmentLog(int logId, int patientId, int doctorId, Date checktime, Date logtime, String detail) {
        this.logId = logId;
        this.patientId = patientId;
        this.doctorId = doctorId;
        this.checktime = checktime;
        this.logtime = logtime;
        this.detail = detail;
    }

    public AppointmentLog() {
    }

    public int getLogId() {
        return logId;
    }

    public void setLogId(int logId) {
        this.logId = logId;
    }

    public int getPatientId() {
        return patientId;
    }

    public void setPatientId(int patientId) {
        this.patientId = patientId;
    }

    public int getDoctorId() {
        return doctorId;
    }

    public void setDoctorId(int doctorId) {
        this.doctorId = doctorId;
    }

    public Date getChecktime() {
        return checktime;
    }

    public void setChecktime(Date checktime) {
        this.checktime = checktime;
    }

    public Date getLogtime() {
        return logtime;
    }

    public void setLogtime(Date logtime) {
        this.logtime = logtime;
    }

    public String getDetail() {
        return detail;
    }

    public void setDetail(String detail) {
        this.detail = detail;
    }

    public static AppointmentLog getNextCheckDate(int userID) {
        Connection con = ConnectionAgent.getConnection();
        String sql = "SELECT doctorID,checktime FROM AppointmentLog WHERE patientID = ? AND checktime > Current_DATE LIMIT 0 , 1";
        PreparedStatement ps;
        AppointmentLog al = null;
        try {
            ps = con.prepareStatement(sql);
            ps.setInt(1, userID);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                al = new AppointmentLog();
                al.setDoctorId(rs.getInt(1));
                al.setChecktime(rs.getDate(2));
            }
        } catch (SQLException ex) {
            Logger.getLogger(Ranking.class.getName()).log(Level.SEVERE, null, ex);
        }finally{
            try {
                con.close();
            } catch (SQLException ex) {
                Logger.getLogger(AppointmentLog.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return al;
    }
    
    @Override
    public String toString() {
        return "AppointmentLog{" + "logId=" + logId + ", patientId=" + patientId 
                + ", doctorId=" + doctorId + ", checktime=" + checktime + ", logtime=" 
                + logtime + ", detail=" + detail + '}';
    }

  
    private static void rToO(AppointmentLog al, ResultSet rs) {
        try {
            al.setLogId(rs.getInt("logId"));
            al.setPatientId(rs.getInt("patientId"));
            al.setDoctorId(rs.getInt("doctorId"));
            al.setChecktime(rs.getDate("checktime"));
            al.setLogtime(rs.getDate("logtime"));
            al.setDetail(rs.getString("detail"));
            
        } catch (SQLException ex) {
            Logger.getLogger(AppointmentLog.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    
    
    
}
