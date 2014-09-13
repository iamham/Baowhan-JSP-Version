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
public class Content {
    private int contentID;
    private String name;
    private String detail;
    private int authorID;
    private int type;

    public Content() {
    }

    public Content(int contentID, String name, String detail, int authorID, int type) {
        this.contentID = contentID;
        this.name = name;
        this.detail = detail;
        this.authorID = authorID;
        this.type = type;
    }

    public int getContentID() {
        return contentID;
    }

    public void setContentID(int contentID) {
        this.contentID = contentID;
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

    public int getAuthorID() {
        return authorID;
    }

    public void setAuthorID(int authorID) {
        this.authorID = authorID;
    }

    public int getType() {
        return type;
    }

    public void setType(int type) {
        this.type = type;
    }

    public static List<Content> showContent() {
        String sqlCmd = "SELECT * FROM content ORDER BY ContentID desc";
        Connection con = ConnectionAgent.getConnection();
        Content ct = null;
        List<Content> ctl = new ArrayList<Content>();
        try {
            PreparedStatement ps = con.prepareStatement(sqlCmd);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                ct = new Content();
                rToO(ct, rs);
                ctl.add(ct);
            }
        } catch (SQLException ex) {
            Logger.getLogger(Content.class.getName()).log(Level.SEVERE, null, ex);
        }
        return ctl;
    }
    
    private static void rToO(Content ct, ResultSet rs) {
        try {
            ct.setContentID(rs.getInt("contentID"));
            ct.setName(rs.getString("name"));
            ct.setDetail(rs.getString("detail"));
            ct.setAuthorID(rs.getInt("authorID"));
            ct.setType(rs.getInt("type"));
            
        } catch (SQLException ex) {
            Logger.getLogger(Content.class.getName()).log(Level.SEVERE, null, ex);
        }

    }
    
    @Override
    public String toString() {
        return "Content{" + "contentID=" + contentID + ", name=" + name + 
                ", detail=" + detail + ", authorID=" + authorID + ", type=" + type + '}';
    }
    
    
}
