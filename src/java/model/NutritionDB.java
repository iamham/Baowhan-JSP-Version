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
public class NutritionDB {
    private int nutriID;
    private String name;
    private double carb;
    private double cal;
    private double quantitySugar;

    public NutritionDB() {
    }

    public NutritionDB(int nutriID, String name, double carb, double cal, double quantitySugar) {
        this.nutriID = nutriID;
        this.name = name;
        this.carb = carb;
        this.cal = cal;
        this.quantitySugar = quantitySugar;
    }

    public int getNutriID() {
        return nutriID;
    }

    public void setNutriID(int nutriID) {
        this.nutriID = nutriID;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getCarb() {
        return carb;
    }

    public void setCarb(double carb) {
        this.carb = carb;
    }

    public double getCal() {
        return cal;
    }

    public void setCal(double cal) {
        this.cal = cal;
    }

    public double getQuantitySugar() {
        return quantitySugar;
    }

    public void setQuantitySugar(double quantitySugar) {
        this.quantitySugar = quantitySugar;
    }
    public static boolean addNutrient(String name,Double carb,Double cal){
       
            Connection con = ConnectionAgent.getConnection();
            boolean result = false;
            String sql = "INSERT INTO  NutritionDB (name ,carb ,cal) VALUES (?,?,?)";
            PreparedStatement pst;
         try {
            pst = con.prepareStatement(sql);
            pst.setString(1, utility.toUTF8(name));
            pst.setDouble(2, carb);
            pst.setDouble(3, cal);
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
    public static boolean editNutrient(int id,String name,Double carb,Double cal){
       
            Connection con = ConnectionAgent.getConnection();
            boolean result = false;
            String sql = "UPDATE  NutritionDB SET  name =?,carb=?,cal=? WHERE  nutriID = ?";
            PreparedStatement pst;
         try {
            pst = con.prepareStatement(sql);
            pst.setString(1, utility.toUTF8(name));
            pst.setDouble(2, carb);
            pst.setDouble(3, cal);
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
    public static boolean delNutrient(int id){
       
            Connection con = ConnectionAgent.getConnection();
            boolean result = false;
            String sql = "DELETE FROM NutritionDB WHERE nutriID = ?";
            PreparedStatement pst;
         try {
            pst = con.prepareStatement(sql);
            pst.setInt(1, id);
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
    public static NutritionDB showOneNutrition(int id) {
        String sqlCmd = "SELECT * FROM NutritionDB WHERE nutriID = ?";
        Connection con = ConnectionAgent.getConnection();
        NutritionDB n = null;
        try {
            PreparedStatement ps = con.prepareStatement(sqlCmd);
            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                n = new NutritionDB();
                rToO(n, rs);
            }
        } catch (SQLException ex) {
            Logger.getLogger(NutritionDB.class.getName()).log(Level.SEVERE, null, ex);
        }finally{
            try {
                con.close();
            } catch (SQLException ex) {
                Logger.getLogger(NutritionDB.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return n;
    }
    public static List<NutritionDB> showNutrition() {
        String sqlCmd = "SELECT * FROM NutritionDB";
        Connection con = ConnectionAgent.getConnection();
        NutritionDB n = null;
        List<NutritionDB> nl = new ArrayList<NutritionDB>();
        try {
            PreparedStatement ps = con.prepareStatement(sqlCmd);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                n = new NutritionDB();
                rToO(n, rs);
                nl.add(n);
            }
        } catch (SQLException ex) {
            Logger.getLogger(NutritionDB.class.getName()).log(Level.SEVERE, null, ex);
        }finally{
            try {
                con.close();
            } catch (SQLException ex) {
                Logger.getLogger(NutritionDB.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return nl;
    }
   
    private static void rToO(NutritionDB n, ResultSet rs) {
        try {
            n.setNutriID(rs.getInt("nutriID"));
            n.setName(rs.getString("name"));
            n.setCarb(rs.getDouble("carb"));
            n.setCal(rs.getDouble("cal"));
        } catch (SQLException ex) {
            Logger.getLogger(NutritionDB.class.getName()).log(Level.SEVERE, null, ex);
        }

    }
    
    @Override
    public String toString() {
        return "NutritionDB{" + "nutriID=" + nutriID + ", name=" + name + 
                ", carb=" + carb + ", cal=" + cal + ", quantitySugar=" + quantitySugar + '}';
    }
    
    public static void main(String[] args) {
        NutritionDB.addNutrient("สวัสดี",23.3,23.3);
    }
}
