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
    private double eAG;
    public Ranking() {
    }

    public double geteAG() {
        return eAG;
    }

    public void seteAG(double eAG) {
        this.eAG = eAG;
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
                r.seteAG(rs.getDouble(2));
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
    
    
}
