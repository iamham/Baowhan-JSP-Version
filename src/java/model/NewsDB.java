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
    public static boolean editNews(int id,String name,String detail,int author){
            Connection con = ConnectionAgent.getConnection();
            boolean result = false;
            String sql = "UPDATE  content SET  name =?,detail=?,authorID=? WHERE  contentID = ?";
            PreparedStatement pst;
         try {
            pst = con.prepareStatement(sql);
            pst.setString(1, name);
            pst.setString(2, detail);
            pst.setInt(3, author);
            pst.setInt(4,id);
            pst.executeUpdate();
            result = true;
        } catch (SQLException ex) {
            Logger.getLogger(NutritionDB.class.getName()).log(Level.SEVERE, null, ex);
        }finally{
                try {
                    con.close();
                } catch (SQLException ex) {
                    Logger.getLogger(NutritionDB.class.getName()).log(Level.SEVERE, null, ex);
                }
        }
         return result;
    }
    public static boolean deleteNews (int id){
        boolean success = false;
        Connection con = ConnectionAgent.getConnection();
        String sql = "DELETE FROM content WHERE contentID = ?";
            PreparedStatement pst;
        try {
            pst = con.prepareStatement(sql);
            pst.setInt(1, id);
            pst.executeUpdate();
            success = true;
        } catch (SQLException ex) {
            Logger.getLogger(NewsDB.class.getName()).log(Level.SEVERE, null, ex);
        }finally{
            try {
                con.close();
            } catch (SQLException ex) {
                Logger.getLogger(NewsDB.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
            return success;
    }
    public static NewsDB showOneNews(int id){
        String sql = "SELECT * FROM content WHERE contentID = "+id;
        Connection con = ConnectionAgent.getConnection();
        List news = new ArrayList();
        NewsDB db = new NewsDB();
        PreparedStatement ps;
        try {
            ps = con.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            while(rs.next()){
                db.setAuthorid(rs.getInt("authorID"));
                db.setDetail(rs.getString("detail"));
                db.setName(rs.getString("name"));
                db.setId(rs.getInt("contentID"));
            }
        } catch (SQLException ex) {
            Logger.getLogger(NewsDB.class.getName()).log(Level.SEVERE, null, ex);
        }finally{
            try {
                con.close();
            } catch (SQLException ex) {
                Logger.getLogger(NewsDB.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return db;
    }
    public static boolean addNews(String name,String detail,int author){
        boolean success= false;
        String sql = "INSERT INTO  content (name,detail,authorID) VALUES (?,?,?);";
        Connection con = ConnectionAgent.getConnection();
        PreparedStatement ps;
        try {
            ps = con.prepareStatement(sql);
            ps.setString(1, name);
            ps.setString(2,detail);
            ps.setInt(3, author);
            ps.executeUpdate();
            success = true;
        } catch (SQLException ex) {
            Logger.getLogger(NewsDB.class.getName()).log(Level.SEVERE, null, ex);
        }finally{
            try {
                con.close();
            } catch (SQLException ex) {
                Logger.getLogger(NewsDB.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return success;
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
                  System.out.println(n);
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
            n.setId(rs.getInt("contentID"));
            n.setName(rs.getString("name"));
            n.setDetail(rs.getString("detail"));
            n.setAuthorid(rs.getInt("authorid"));
        } catch (SQLException ex) {
            Logger.getLogger(NewsDB.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public String toString() {
        return "NewsDB{" + "id=" + id + ", name=" + name + ", detail=" + detail + ", authorid=" + authorid + ", type=" + type + '}';
    }
    
    public static void main(String[] args) {
        System.out.println(NewsDB.showNews());
    }

    }
