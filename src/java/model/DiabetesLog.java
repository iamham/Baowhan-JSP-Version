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
import java.sql.Timestamp;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author LudjaPae
 */
public class DiabetesLog {
    static Connection con = ConnectionAgent.getConnection();
    private int logId;
    private int userId;
    private double value;
    private String note;
    private Date checktime;
    private Date logtime;

    public DiabetesLog() {
    }

    public DiabetesLog(int logId, int userId, double value, String note, Date checktime, Date logtime) {
        this.logId = logId;
        this.userId = userId;
        this.value = value;
        this.note = note;
        this.checktime = checktime;
        this.logtime = logtime;
    }

    public int getLogId() {
        return logId;
    }

    public void setLogId(int logId) {
        this.logId = logId;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public double getValue() {
        return value;
    }

    public void setValue(double value) {
        this.value = value;
    }

    public String getNote() {
        return note;
    }

    public void setNote(String note) {
        this.note = note;
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

    @Override
    public String toString() {
        return "DiabetesLog{" + "logId=" + logId + ", userId=" + userId + ", value=" + value + ", note=" + note + ", checktime=" + checktime + ", logtime=" + logtime + '}';
    }
    
    private static java.sql.Timestamp getCurrentTimeStamp() {
	java.util.Date today = new java.util.Date();
	return new java.sql.Timestamp(today.getTime());
    }
     private static java.sql.Timestamp getThatTimestamp(long militime){
        java.util.Date thatDate = new java.util.Date(militime);
         System.out.println(thatDate.getTime());
        return new java.sql.Timestamp(thatDate.getTime()); 
     }
    
    public static DiabetesLog showGraph(String graph){
        Connection con = ConnectionAgent.getConnection();
        String sql = "SELECT value,checktime FROM DiabetesLog WHERE userID = ? AND checktime BETWEEN SYSDATE( ) - INTERVAL 30 DAY AND SYSDATE( ) LIMIT 0 , 30";
        PreparedStatement ps ;
        DiabetesLog dl= null;
        try{
            ps = con.prepareStatement(sql);
            ps.setString(1, graph);
            ResultSet rs = ps.executeQuery();
            while(rs.next()){
                dl = new DiabetesLog();
                dl.setValue(rs.getDouble(1));
                dl.setChecktime(rs.getDate(2));
            }
        }catch (SQLException ex){
            Logger.getLogger(DiabetesLog.class.getName()).log(Level.SEVERE, null, ex);
        }finally{
            try {
                con.close();
            } catch (SQLException ex) {
                Logger.getLogger(DiabetesLog.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return dl;
    }
    
    public static int addValue(DiabetesLog dbl){
        String sqlCmd = "INSERT INTO DiabetesLog(value) VALUES (?)";
        int values = 0;
        try {
            PreparedStatement pstm = ConnectionAgent.getConnection().prepareStatement(sqlCmd);
            pstm.setDouble(1, dbl.getValue());
            values = pstm.executeUpdate();
        } catch (SQLException ex) {
            System.out.println(ex);
        }
        return values;  
    }
    
    public static int updateValue(DiabetesLog dbl) { 
        Connection con = ConnectionAgent.getConnection(); 
        String sql = "UPDATE DiabetesLog SET value = ?:"; 
        int value = 0; 
        try { 
            PreparedStatement pst = con.prepareStatement(sql); 
            pst.setDouble(1, dbl.getValue());
            value = pst.executeUpdate(); 
        } catch (SQLException ex) { 
            Logger.getLogger(DiabetesLog.class.getName()).log(Level.SEVERE, null, ex); 
        } 
        return value; 
  
    } 
    
    public static int addNote(DiabetesLog dbl){
        String sqlCmd = "INSERT INTO DiabetesLog(note) VALUES (?)";
        int values = 0;
        try {
            PreparedStatement pstm = ConnectionAgent.getConnection().prepareStatement(sqlCmd);
            pstm.setString(1, dbl.getNote());
            values = pstm.executeUpdate();
        } catch (SQLException ex) {
            System.out.println(ex);
        }
        return values;  
    }
    
    public static int updateNote(DiabetesLog dbl) { 
        Connection con = ConnectionAgent.getConnection(); 
        String sql = "UPDATE DiabetesLog SET note = ?:"; 
        int note = 0; 
        try { 
            PreparedStatement pst = con.prepareStatement(sql); 
            pst.setString(1, dbl.getNote());
            note = pst.executeUpdate(); 
        } catch (SQLException ex) { 
            Logger.getLogger(DiabetesLog.class.getName()).log(Level.SEVERE, null, ex); 
        } 
        return note; 
  
    } 
    
    public static int addCheckTime(DiabetesLog dbl){
        String sqlCmd = "INSERT INTO DiabetesLog(checktime) VALUES (?)";
        int chTime = 0;
        try {
            PreparedStatement pstm = ConnectionAgent.getConnection().prepareStatement(sqlCmd);
            pstm.setDate(1, (java.sql.Date) dbl.getChecktime());
            chTime = pstm.executeUpdate();
        } catch (SQLException ex) {
            System.out.println(ex);
        }
        return chTime;  
    }
    
    public static int updateCheckTime(DiabetesLog dbl) { 
        Connection con = ConnectionAgent.getConnection(); 
        String sql = "UPDATE DiabetesLog SET checktime = ?:"; 
        int chTime = 0; 
        try { 
            PreparedStatement pst = con.prepareStatement(sql); 
            pst.setDate(1, (java.sql.Date) dbl.getChecktime());
            chTime = pst.executeUpdate(); 
        } catch (SQLException ex) { 
            Logger.getLogger(DiabetesLog.class.getName()).log(Level.SEVERE, null, ex); 
        } 
        return chTime; 
  
    } 
    
    public static int addLogTime(DiabetesLog dbl){
        String sqlCmd = "INSERT INTO DiabetesLog(logtime) VALUES (?)";
        int logTime = 0;
        try {
            PreparedStatement pstm = ConnectionAgent.getConnection().prepareStatement(sqlCmd);
            pstm.setDate(1, (java.sql.Date) dbl.getLogtime());
            logTime = pstm.executeUpdate();
        } catch (SQLException ex) {
            System.out.println(ex);
        }
        return logTime;  
    }
    
    public static int updateLogTime(DiabetesLog dbl) { 
        Connection con = ConnectionAgent.getConnection(); 
        String sql = "UPDATE DiabetesLog SET logtime = ?:"; 
        int logTime = 0; 
        try { 
            PreparedStatement pst = con.prepareStatement(sql); 
            pst.setDate(1, (java.sql.Date) dbl.getLogtime());
            logTime = pst.executeUpdate(); 
        } catch (SQLException ex) { 
            Logger.getLogger(DiabetesLog.class.getName()).log(Level.SEVERE, null, ex); 
        } 
        return logTime; 
  
    } 
    
    public static double getEAG(int userID){
        double result = 0;
        Connection con = ConnectionAgent.getConnection();
        String sql = "SELECT SUM( value ) / COUNT( * ) eAG\n" + "FROM DiabetesLog\n" +"WHERE userID =?";
        PreparedStatement ps ;
        try{
            ps = con.prepareStatement(sql);
            ps.setInt(1, userID);
            ResultSet rs = ps.executeQuery();
            while(rs.next()){
                result = rs.getDouble(1);
            }
        }catch (SQLException ex){
            Logger.getLogger(DiabetesLog.class.getName()).log(Level.SEVERE, null, ex);
        }finally{
            try {
                con.close();
            } catch (SQLException ex) {
                Logger.getLogger(DiabetesLog.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return result;
    }
    public static boolean addRecord(int userID,double value,String note,Date recordTime,Date timestamp){
        boolean success = false;
        java.sql.Timestamp srecordTime = new java.sql.Timestamp(recordTime.getTime());
        java.sql.Timestamp stimestamp = new java.sql.Timestamp(timestamp.getTime());
        try {
            Connection con = ConnectionAgent.getConnection();
            String sql = "INSERT INTO DiabetesLog (userID,value,note,checktime,logtime) VALUES (?,?,?,?,?)";
            PreparedStatement ps ;
            ps = con.prepareStatement(sql);
            ps.setInt(1, userID);
            ps.setDouble(2, value);
            ps.setString(3, utility.toUTF8(note));
            ps.setTimestamp(4,  srecordTime);
            ps.setTimestamp(5,  stimestamp);
            ps.executeUpdate();
            success=true;
        } catch (SQLException ex) {
            Logger.getLogger(DiabetesLog.class.getName()).log(Level.SEVERE, null, ex);
        }finally{
            try {
                con.close();
            } catch (SQLException ex) {
                Logger.getLogger(DiabetesLog.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return success;
    }
    public static boolean editRecord(int ID,double value,String note,Date recordTime,Date timestamp){
        boolean success = false;
        java.sql.Timestamp srecordTime = new java.sql.Timestamp(recordTime.getTime());
        java.sql.Timestamp stimestamp = new java.sql.Timestamp(timestamp.getTime());
        try {
            Connection con = ConnectionAgent.getConnection();
            String sql = "UPDATE DiabetesLog SET value  =  ?, note =  ?, checktime =  ?, logtime = ? WHERE logID = ?";
            PreparedStatement ps ;
            ps = con.prepareStatement(sql);
            ps.setDouble(1, value);
            ps.setString(2, utility.toUTF8(note));
            ps.setTimestamp(3,  srecordTime);
            ps.setTimestamp(4,  stimestamp);
            ps.setInt(5, ID);
            ps.executeUpdate();
            success=true;
        } catch (SQLException ex) {
            Logger.getLogger(DiabetesLog.class.getName()).log(Level.SEVERE, null, ex);
        }finally{
            try {
                con.close();
            } catch (SQLException ex) {
                Logger.getLogger(DiabetesLog.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return success;
    }
    public static DiabetesLog recentChecked(String rCheck){
        Connection con = ConnectionAgent.getConnection();
        String sql = "SELECT value,note,checktime.value FROM 'DiabetesLog' WHERE userID =? ORDER BY checktime DESC LIMIT 0 , 1";
        PreparedStatement ps ;
        DiabetesLog dl= null;
        try{
            ps = con.prepareStatement(sql);
            ps.setString(1, rCheck);
            ResultSet rs = ps.executeQuery();
            while(rs.next()){
                dl = new DiabetesLog();
                dl.setValue(rs.getInt(1));
                dl.setNote(rs.getString(2));
                dl.setChecktime(rs.getDate(3));
            }
        }catch (SQLException ex){
            Logger.getLogger(DiabetesLog.class.getName()).log(Level.SEVERE, null, ex);
        }finally{
            try {
                con.close();
            } catch (SQLException ex) {
                Logger.getLogger(DiabetesLog.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return dl;
    }
    
      public static List<DiabetesLog> showValueList() {
        String sqlCmd = "SELECT * FROM DiabetesLog";
        Connection con = ConnectionAgent.getConnection();
        DiabetesLog dl = null;
        List<DiabetesLog> ul = new ArrayList<DiabetesLog>();
        try {
            PreparedStatement ps = con.prepareStatement(sqlCmd);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                dl = new DiabetesLog();
                rToO(dl, rs);
                ul.add(dl);
            }
        } catch (SQLException ex) {
            Logger.getLogger(DiabetesLog.class.getName()).log(Level.SEVERE, null, ex);
        }finally{
            try {
                con.close();
            } catch (SQLException ex) {
                Logger.getLogger(DiabetesLog.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return ul;
    }
    public static int getAllLogCount(){
        Connection con = ConnectionAgent.getConnection();
        int amount=0;
        String sql = "SELECT COUNT(logid) FROM DiabetesLog";
        PreparedStatement pstm;
        try {
            pstm=con.prepareStatement(sql);
             ResultSet rs = pstm.executeQuery();
        while(rs.next()){
            amount = rs.getInt(1);
        }
        } catch (SQLException ex) {
            Logger.getLogger(Message.class.getName()).log(Level.SEVERE, null, ex);
        }finally{
            try {
                con.close();
            } catch (SQLException ex) {
                Logger.getLogger(Message.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return amount;
    }
      public static List<DiabetesLog> getAllUserRecord(int userID) {
        Connection con = ConnectionAgent.getConnection();
        String sql = "select value,note,checktime,logtime,logID from DiabetesLog where userid = ? order by checktime ASC";
        PreparedStatement ps;
        DiabetesLog dl = null;
        List<DiabetesLog> ls = new ArrayList<DiabetesLog>();
        try {
            ps = con.prepareStatement(sql);
            ps.setInt(1, userID);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                dl = new DiabetesLog();
                dl.setValue(rs.getDouble(1));
                dl.setNote(rs.getString(2));
                dl.setChecktime(rs.getTimestamp(3));
                dl.setLogtime(rs.getDate(4));
                dl.setLogId(rs.getInt(5));
                ls.add(dl);
            }
        } catch (SQLException ex) {
            Logger.getLogger(DiabetesLog.class.getName()).log(Level.SEVERE, null, ex);
        }finally{
            try {
                con.close();
            } catch (SQLException ex) {
                Logger.getLogger(DiabetesLog.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return ls;
    }
      
      public static boolean deleteRecord(int id){
          boolean success=false;
          Connection con = ConnectionAgent.getConnection();
          String sql = "DELETE FROM DiabetesLog WHERE logID = ?";
          PreparedStatement ps;
        try {
            ps = con.prepareStatement(sql);
            ps.setInt(1, id);
            ps.executeUpdate();
            success=true;
        } catch (SQLException ex) {
            Logger.getLogger(DiabetesLog.class.getName()).log(Level.SEVERE, null, ex);
        }finally{
              try {
                  con.close();
              } catch (SQLException ex) {
                  Logger.getLogger(DiabetesLog.class.getName()).log(Level.SEVERE, null, ex);
              }
        }
        return success;
      }
      public static List<DiabetesLog> getBloodRecord(int userID,Date from,Date to) {
        java.sql.Timestamp sfrom = new java.sql.Timestamp(from.getTime());
        java.sql.Timestamp sto = new java.sql.Timestamp(to.getTime());
        Connection con = ConnectionAgent.getConnection();
        String sql = "SELECT checktime, value,logID,Note FROM DiabetesLog WHERE userid =? \n"+
                     "AND checktime BETWEEN ? AND ? ORDER BY checktime ASC";
        PreparedStatement ps;
        DiabetesLog dl = null;
        List<DiabetesLog> ls = new ArrayList<DiabetesLog>();
        try {
            ps = con.prepareStatement(sql);
            ps.setInt(1, userID);
            ps.setTimestamp(2, sfrom);
            ps.setTimestamp(3, sto);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                dl = new DiabetesLog();
                dl.setChecktime(rs.getDate(1));
                dl.setValue(rs.getDouble(2));
                dl.setLogId(rs.getInt(3));
                dl.setNote(rs.getString(4));
                ls.add(dl);
            }
        } catch (SQLException ex) {
            Logger.getLogger(DiabetesLog.class.getName()).log(Level.SEVERE, null, ex);
        }finally{
            try {
                con.close();
            } catch (SQLException ex) {
                Logger.getLogger(DiabetesLog.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return ls;
    }
      
    private static void rToO(DiabetesLog dl, ResultSet rs) {
        try {
            dl.setLogId(rs.getInt("logID"));
            dl.setUserId(rs.getInt("userID"));
            dl.setValue(rs.getDouble("value"));
            dl.setNote(rs.getString("note"));
            dl.setChecktime(rs.getDate("checktime"));
            dl.setLogtime(rs.getDate("logtime"));
            
        } catch (SQLException ex) {
            Logger.getLogger(DiabetesLog.class.getName()).log(Level.SEVERE, null, ex);
        }

    }
    public static void main(String[] args) {
        Date dat = new Date();
        addRecord(1,125.4,"Hello",dat,dat);
    }
}
