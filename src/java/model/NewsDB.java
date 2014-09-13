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
 * @author GAME
 */
public class NewsDB {
    private int id;
    private String name;
    private String detail;
    private int authorid;
    private int type;

    public NewsDB() {
    }

    public NewsDB(int id, String name, String detail, int authorid, int type) {
        this.id = id;
        this.name = name;
        this.detail = detail;
        this.authorid = authorid;
        this.type = type;
    }
    
    
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDetail() {
        return detail;
    }

    public void setDetail(String detail) {
        this.detail = detail;
    }

    public int getAuthorid() {
        return authorid;
    }

    public void setAuthorid(int authorid) {
        this.authorid = authorid;
    }

    public int getType() {
        return type;
    }

    public void setType(int type) {
        this.type = type;
    }
    
    public static List<NewsDB> showNews(){
        String sqlCmd = "Select * from content";
        Connection con =ConnectionAgent.getConnection();
        NewsDB n = null;
        List<NewsDB> n1 = new ArrayList<NewsDB>();
        
        try {
            PreparedStatement ps =con.prepareStatement(sqlCmd);
              ResultSet rs = ps.executeQuery();
              while (rs.next()){
                  n = new NewsDB();
                  rToO(n, rs);
                  n1.add(n);
              }
            
        } catch (SQLException ex) {
            Logger.getLogger(NewsDB.class.getName()).log(Level.SEVERE, null, ex);
        } finally{
            try {
                con.close();
            } catch (SQLException ex) {
                Logger.getLogger(NewsDB.class.getName()).log(Level.SEVERE, null, ex);
            }
        return n1;
       }
    }
        
    private static void rToO(NewsDB n,ResultSet rs){
        try {
            n.setId(rs.getInt("id"));
            n.setName(rs.getString("name"));
            n.setDetail(rs.getString("detail"));
            n.setAuthorid(rs.getInt("authorid"));
            n.setType(rs.getInt("type"));
        } catch (SQLException ex) {
            Logger.getLogger(NewsDB.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public String toString() {
        return "NewsDB{" + "id=" + id + ", name=" + name + ", detail=" + detail + ", authorid=" + authorid + ", type=" + type + '}';
    }
    
    

    }
