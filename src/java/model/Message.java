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
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author sarunpeetasai
 */
public class Message {
    String message;
    int user_id_fk,c_id_fk,cid,mid;
    Date time;

    public String getMessage() {
        return message;
    }

    public int getMid() {
        return mid;
    }

    public void setMid(int mid) {
        this.mid = mid;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public int getUser_id_fk() {
        return user_id_fk;
    }

    public void setUser_id_fk(int user_id_fk) {
        this.user_id_fk = user_id_fk;
    }

    public int getC_id_fk() {
        return c_id_fk;
    }

    public void setC_id_fk(int c_id_fk) {
        this.c_id_fk = c_id_fk;
    }

    public int getCid() {
        return cid;
    }

    public void setCid(int cid) {
        this.cid = cid;
    }

    public Date getTime() {
        return time;
    }

    public void setTime(Date time) {
        this.time = time;
    }
    
    public static int getCid(int from, int to){
        int cid = 0;
        cid = getExistsCid(from,to);
        if(cid==0){
            addCid(from,to);
            return getExistsCid(from,to);
        }
        return cid;
    }
    public static int getAllMessageCount(){
        Connection con = ConnectionAgent.getConnection();
        int amount=0;
        String sql = "SELECT COUNT(cr_id) FROM conversation_reply";
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
    public static int getExistsCid(int from,int to){
        Connection con = ConnectionAgent.getConnection();
        int cid = 0;
        String sql = "SELECT c_id FROM conversation WHERE (user_one= ? AND user_two= ? ) OR (user_one= ? AND user_two= ?)";
        PreparedStatement pstm;
        try {
            pstm = con.prepareStatement(sql);
            pstm.setInt(1, from);
            pstm.setInt(2, to);
            pstm.setInt(3, to);
            pstm.setInt(4, from);
            ResultSet rs = pstm.executeQuery();
            while(rs.next()){
                cid = rs.getInt(1);
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
        return cid;
    }
    public static void addCid(int from, int to){
        Connection con = ConnectionAgent.getConnection();
        String sql = "INSERT INTO  conversation (user_one,user_two)VALUES (?,?)";
        PreparedStatement pstm;
        try {
            pstm = con.prepareStatement(sql);
            pstm.setInt(1, from);
            pstm.setInt(2, to);
            pstm.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(Message.class.getName()).log(Level.SEVERE, null, ex);
        }finally{
            try {
                con.close();
            } catch (SQLException ex) {
                Logger.getLogger(Message.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }
    public static boolean addReply(int userID,int cid,String message,Date time){
        boolean success=false;
        java.sql.Timestamp sTime = new java.sql.Timestamp(time.getTime());
        String sql = "INSERT INTO conversation_reply (user_id_fk,reply,time,c_id_fk) VALUES (?,?,?,?);";
         Connection con = ConnectionAgent.getConnection();
         PreparedStatement pstm;
        try {
            pstm = con.prepareStatement(sql);
            pstm.setInt(1, userID);
            pstm.setString(2, message);
            pstm.setTimestamp(3, sTime);
            pstm.setInt(4, cid);
            pstm.executeUpdate();
            success=true;
        } catch (SQLException ex) {
            Logger.getLogger(Message.class.getName()).log(Level.SEVERE, null, ex);
        }finally{
            try {
                con.close();
            } catch (SQLException ex) {
                Logger.getLogger(Message.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return success;
    }
    public static List getLastMessage(int cid){
        Connection con = ConnectionAgent.getConnection();
        SimpleDateFormat sf = new SimpleDateFormat("d/M/yy HH:mm:ss");
        List result = new ArrayList();
        PreparedStatement pstm;
        String sql = "SELECT * FROM  conversation_reply WHERE c_id_fk ="+cid+" ORDER BY TIME DESC LIMIT 1;";
        try {
            pstm = con.prepareStatement(sql);
            ResultSet rs = pstm.executeQuery();
            while(rs.next()){
                Date date = rs.getTimestamp("time");
                result.add(rs.getString("reply"));
                result.add(sf.format(date));
            }
        } catch (SQLException ex) {
            Logger.getLogger(Message.class.getName()).log(Level.SEVERE, null, ex);
        }
        return result;
    }
    public static List getAllCID(int doctorID){
        Connection con = ConnectionAgent.getConnection();
        List cid = new ArrayList();
        PreparedStatement pstm;
        String sql = "SELECT * FROM  conversation WHERE user_one = "+doctorID+" OR user_two ="+doctorID;
        try {
            pstm = con.prepareStatement(sql);
            ResultSet rs = pstm.executeQuery();
            while(rs.next()){
            cid.add(rs.getString("c_id"));
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
        return cid;
    }
    public static int getPatientID(int cid,int user){
        Connection con = ConnectionAgent.getConnection();
        PreparedStatement pstm;
        int result=0;
        String sql = "SELECT * FROM  conversation WHERE c_id = "+cid;
        try {
            pstm = con.prepareStatement(sql);
            ResultSet rs = pstm.executeQuery();
            while(rs.next()){
                if(rs.getInt("user_one")!=user){
                    result = rs.getInt("user_one");
                }
                if(rs.getInt("user_two")!=user){
                    result = rs.getInt("user_two");
                }
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
        return result;
    }
    public static List<Message> getAllMessage(int cid){
        Connection con = ConnectionAgent.getConnection();
        List message = new ArrayList();
        ResultSet rs;
        PreparedStatement pstm;
        Message ms;
        String sql = "SELECT cr_id,reply,user_id_fk,c_id_fk,time FROM conversation_reply WHERE c_id_fk = ?";
        try {
            pstm = con.prepareStatement(sql);
            pstm.setInt(1, cid);
            rs = pstm.executeQuery();
            while(rs.next()){
                ms = new Message();
                ms.setMid(rs.getInt(1));
                ms.setMessage(rs.getString(2));
                ms.setUser_id_fk(rs.getInt(3));
                ms.setC_id_fk(rs.getInt(4));
                ms.setTime(rs.getTimestamp(5));
                message.add(ms);
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
        return message;
    }
    public static void main(String[] args) {
        Date date = new Date();
        System.out.println(Message.getAllMessageCount());
        
    }
}
