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
public class MedicineDB {
    private int medID;
    private String name;
    private String detail;

    public MedicineDB() {
    }

    public MedicineDB(int medID, String name, String detail) {
        this.medID = medID;
        this.name = name;
        this.detail = detail;
    }

    public int getMedID() {
        return medID;
    }

    public void setMedID(int medID) {
        this.medID = medID;
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
    
    public static List<MedicineDB> showMedicine() {
        String sqlCmd = "SELECT * FROM MedicineDB";
        Connection con = ConnectionAgent.getConnection();
        MedicineDB m = null;
        List<MedicineDB> mdb = new ArrayList<MedicineDB>();
        try {
            PreparedStatement ps = con.prepareStatement(sqlCmd);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                m = new MedicineDB();
                rToO(m, rs);
                mdb.add(m);
            }
        } catch (SQLException ex) {
            Logger.getLogger(MedicineDB.class.getName()).log(Level.SEVERE, null, ex);
        }
        return mdb;
    }
    
    private static void rToO(MedicineDB m, ResultSet rs) {
        try {
            m.setMedID(rs.getInt("medID"));
            m.setName(rs.getString("name"));
            m.setDetail(rs.getString("detail"));
            
        } catch (SQLException ex) {
            Logger.getLogger(MedicineDB.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    @Override
    public String toString() {
        return "MedicineDB{" + "medID=" + medID + ", name=" + name + ", detail=" + detail + '}';
    }
    
    
}
