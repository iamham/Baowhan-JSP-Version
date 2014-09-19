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
public class Hospital {
    private int id;
    private String name;
    private String address;
    private String telephone;

    public Hospital(int id, String name, String address, String telephone) {
        this.id = id;
        this.name = name;
        this.address = address;
        this.telephone = telephone;
    }

    public Hospital() {
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

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getTelephone() {
        return telephone;
    }

    public void setTelephone(String telephone) {
        this.telephone = telephone;
    }
    
    public static List<Hospital> showHospital() {
        String sqlCmd = "SELECT * FROM hospital ";
        Connection con = ConnectionAgent.getConnection();
        Hospital h = null;
        List<Hospital> hos  = new ArrayList<Hospital>();
        try {
            PreparedStatement ps = con.prepareStatement(sqlCmd);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                h = new Hospital();
                rToO(h, rs);
                hos.add(h);
            }
        } catch (SQLException ex) {
            Logger.getLogger(Hospital.class.getName()).log(Level.SEVERE, null, ex);
        }finally{
            try {
                con.close();
            } catch (SQLException ex) {
                Logger.getLogger(Hospital.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return hos;
    }
    public static String findById(int id){
        String name="";
        Connection con = ConnectionAgent.getConnection();
        String sqlCmd = "SELECT * FROM hospital WHERE id = ?";
        try {
            PreparedStatement ps = con.prepareStatement(sqlCmd);
            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();
            while(rs.next()){
                name = rs.getString("name");
                System.out.println(name);
            }
        } catch (SQLException ex) {
            Logger.getLogger(Hospital.class.getName()).log(Level.SEVERE, null, ex);
        }finally{
            try {
                con.close();
            } catch (SQLException ex) {
                Logger.getLogger(Hospital.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        
        return name;
    }

    private static void rToO(Hospital h, ResultSet rs) {
        try {
            h.setId(rs.getInt("id"));
            h.setName(rs.getString("name"));
            h.setAddress(rs.getString("address"));
            h.setTelephone(rs.getString("telephone"));
        } catch (SQLException ex) {
            Logger.getLogger(Hospital.class.getName()).log(Level.SEVERE, null, ex);
        }

    }
    
    @Override
    public String toString() {
        return "Hospital{" + "id=" + id + ", name=" + name + ", address=" + address + 
                ", telephone=" + telephone + '}';
    }
    
    
}
