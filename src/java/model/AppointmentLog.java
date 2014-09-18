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
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
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
    private int status;
    private int originID;
    public AppointmentLog(int logId, int patientId, int doctorId, Date checktime, Date logtime, String detail) {
        this.logId = logId;
        this.patientId = patientId;
        this.doctorId = doctorId;
        this.checktime = checktime;
        this.logtime = logtime;
        this.detail = detail;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public int getOriginID() {
        return originID;
    }

    public void setOriginID(int originID) {
        this.originID = originID;
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
    public static boolean addRecord(int patientID,int doctorID,Date date,Date logtime,String detail,int origin,int type,int status){
        Connection con = ConnectionAgent.getConnection();
        boolean success = false;
        String sqlCmd = "INSERT INTO AppointmentLog(patientID,doctorID,checktime,logtime,detail,originID,type,status) VALUES (?,?,?,?,?,?,?,?)";
        try {
            java.sql.Timestamp ctime = new java.sql.Timestamp(date.getTime());
            java.sql.Timestamp ltime = new java.sql.Timestamp(logtime.getTime());
            PreparedStatement pstm = con.prepareStatement(sqlCmd);
            pstm.setInt(1, patientID);
            pstm.setInt(2, doctorID);
            pstm.setTimestamp(3, ctime);
            pstm.setTimestamp(4, ltime);
            pstm.setString(5, utility.toUTF8(detail));
            System.out.println("3"+detail);
            pstm.setInt(6, origin);
            pstm.setInt(7, type);
            pstm.setInt(8, status);
            pstm.executeUpdate();
            success=true;
        } catch (SQLException ex) {
            System.out.println(ex);
        }finally{
            try {
                con.close();
            } catch (SQLException ex) {
                Logger.getLogger(AppointmentLog.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return success;  
    }
    public static AppointmentLog getNextCheckDate(int userID) {
        Connection con = ConnectionAgent.getConnection();
        String sql = "SELECT doctorID,checktime FROM AppointmentLog WHERE patientID = ? AND status=2 AND type = 1 AND checktime > Current_DATE LIMIT 0 , 1";
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
    public static boolean changeStatus(int id,int status){
        boolean success = false;
        Connection con = ConnectionAgent.getConnection();
        String sql = "UPDATE AppointmentLog SET status = ? WHERE  logID = ?";
        PreparedStatement ps;
        try {
            ps = con.prepareStatement(sql);
            ps.setInt(1, status);
            ps.setInt(2, id);
            ps.executeUpdate();
            success = true;
        } catch (SQLException ex) {
            Logger.getLogger(AppointmentLog.class.getName()).log(Level.SEVERE, null, ex);
        }finally{
            try {
                con.close();
            } catch (SQLException ex) {
                Logger.getLogger(AppointmentLog.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return success;
    }
    public static List<AppointmentLog> getAll(int userID) {
        Connection con = ConnectionAgent.getConnection();
        String sql = "SELECT doctorID,checktime,detail,status,originID,patientID,logID FROM AppointmentLog WHERE patientID = ?";
        PreparedStatement ps;
        AppointmentLog al = null;
        List<AppointmentLog> result = new ArrayList();
        try {
            ps = con.prepareStatement(sql);
            ps.setInt(1, userID);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                al = new AppointmentLog();
                al.setDoctorId(rs.getInt(1));
                al.setChecktime(rs.getDate(2));
                al.setDetail(rs.getString(3));
                al.setStatus(rs.getInt(4));
                al.setOriginID(rs.getInt(5));
                al.setPatientId(rs.getInt(6));
                al.setLogId(rs.getInt(7));
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
        return result;
    }
    public static List<AppointmentLog> getRequest(int userID) {
        Connection con = ConnectionAgent.getConnection();
        String sql = "SELECT doctorID,checktime,detail,status,originID,patientID,logID FROM AppointmentLog WHERE patientID = ? AND status = 1 AND originID != ?";
        PreparedStatement ps;
        AppointmentLog al = null;
        List<AppointmentLog> result = new ArrayList();
        try {
            ps = con.prepareStatement(sql);
            ps.setInt(1, userID);
            ps.setInt(2, userID);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                al = new AppointmentLog();
                al.setDoctorId(rs.getInt(1));
                al.setChecktime(rs.getDate(2));
                al.setDetail(rs.getString(3));
                al.setStatus(rs.getInt(4));
                al.setOriginID(rs.getInt(5));
                al.setPatientId(rs.getInt(6));
                al.setLogId(rs.getInt(7));
                result.add(al);
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
        return result;
    }
    public static List<AppointmentLog> getCalendar(int userID) {
        Connection con = ConnectionAgent.getConnection();
        String sql = "SELECT doctorID,checktime,detail,status,originID,patientID,logID FROM AppointmentLog WHERE patientID = ? AND status = 2";
        PreparedStatement ps;
        AppointmentLog al = null;
        List<AppointmentLog> result = new ArrayList();
        try {
            ps = con.prepareStatement(sql);
            ps.setInt(1, userID);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                al = new AppointmentLog();
                al.setDoctorId(rs.getInt(1));
                al.setChecktime(rs.getDate(2));
                al.setDetail(rs.getString(3));
                al.setStatus(rs.getInt(4));
                al.setOriginID(rs.getInt(5));
                al.setPatientId(rs.getInt(6));
                al.setLogId(rs.getInt(7));
                result.add(al);
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
        return result;
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

    }public static void main(String[] args) {
            Date s = new Date();
            System.out.println(AppointmentLog.getRequest(1));
    }

    
    
    
}
