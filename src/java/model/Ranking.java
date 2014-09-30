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
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author LudjaPae
 */
public class Ranking {
    private int id;
    private int userId;
    private int value;
    private int point;
    public Ranking() {
    }

    public int getPoint() {
        return point;
    }

    public void setPoint(int point) {
        this.point = point;
    }

    public Ranking(int id, int userId, int value) {
        this.id = id;
        this.userId = userId;
        this.value = value;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
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

    public void setValue(int value) {
        this.value = value;
    }
    
    
    public static void addPoint(int userid,int point){
        String sql = "INSERT INTO point (userID,point) VALUES (?,?)";
        Connection con = ConnectionAgent.getConnection();
        PreparedStatement ps;
        try {
            ps = con.prepareStatement(sql);
            ps.setInt(1, userid);
            ps.setInt(2, point);
            ps.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(Ranking.class.getName()).log(Level.SEVERE, null, ex);
        }finally{
            try {
                con.close();
            } catch (SQLException ex) {
                Logger.getLogger(Ranking.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }
    public static List<Ranking> getAllPoint(Date from,Date to){
        String sql = "SELECT userID,SUM(point) AS point FROM point WHERE timestamp >= ? AND timestamp <= ? GROUP BY userID ORDER BY point DESC";
        java.sql.Timestamp fTime = new java.sql.Timestamp(from.getTime());
        java.sql.Timestamp tTime = new java.sql.Timestamp(to.getTime());
        Connection con = ConnectionAgent.getConnection();
        PreparedStatement ps;
        List point = null;
        Ranking rk;
        try {
            point = new ArrayList();
            ps = con.prepareStatement(sql);
            ps.setTimestamp(1, fTime);
            ps.setTimestamp(2, tTime);
            ResultSet rs = ps.executeQuery();
            int i = 1;
            while(rs.next()){
                rk = new Ranking();
                rk.setId(i);
                rk.setPoint(rs.getInt("point"));
                rk.setUserId(rs.getInt("userID"));
                point.add(rk);
                i++;
            }
        } catch (SQLException ex) {
            Logger.getLogger(Ranking.class.getName()).log(Level.SEVERE, null, ex);
        }
        return point;
    }
    public static Ranking updateRanking(String up) {
        String sql = "update Ranking set  value = ? and id = ?";
        PreparedStatement ps;
        Ranking r = null;
        try {
            ps = ConnectionAgent.getConnection().prepareStatement(sql);
            ps.setString(1, up);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                r = new Ranking();
                r.setValue(rs.getInt(1));
                r.setId(rs.getInt(2));
            }
        } catch (SQLException ex) {
            Logger.getLogger(Ranking.class.getName()).log(Level.SEVERE, null, ex);
        }
        return r;
    }
    public static int position(int userID){
        int position = 0;
        
        List<Ranking> ranking = showRanking();
        for(int i=0;i<ranking.size();i++){
            if(ranking.get(i).userId==userID){
                position = ranking.get(i).id;
            }
        }
        return position;
    }
    public static List<Ranking> showRanking() {
        String sqlCmd = "SELECT userID,eAG FROM User WHERE eAG > 70 order by eAG";
        Connection con = ConnectionAgent.getConnection();
        Ranking r = null;
        List<Ranking> rl = new ArrayList<Ranking>();
        try {
            PreparedStatement ps = con.prepareStatement(sqlCmd);
            ResultSet rs = ps.executeQuery();
            int x = 1;
            while (rs.next()) {
                r = new Ranking();
                r.setId(x);
                r.setUserId(rs.getInt(1));
                r.setPoint(rs.getInt(2));
                rl.add(r);
                x++;
            }
        } catch (SQLException ex) {
            Logger.getLogger(Ranking.class.getName()).log(Level.SEVERE, null, ex);
        }finally{
            try {
                con.close();
            } catch (SQLException ex) {
                Logger.getLogger(Ranking.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return rl;
    }
    

    @Override
    public String toString() {
        return "Ranking{" + "id=" + id + ", userId=" + userId + ", value=" + value + '}';
    }
    public static void main(String[] args) {
            
    }
    
}
