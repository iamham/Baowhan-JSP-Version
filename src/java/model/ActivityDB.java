/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package model;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author LudjaPae
 */
public class ActivityDB {
    private int activityID;
    private String name;
    private double cal;

    public ActivityDB() {
    }

    public ActivityDB(int activityID, String name, double cal) {
        this.activityID = activityID;
        this.name = name;
        this.cal = cal;
    }

    public int getActivityID() {
        return activityID;
    }

    public void setActivityID(int activityID) {
        this.activityID = activityID;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getCal() {
        return cal;
    }

    public void setCal(double cal) {
        this.cal = cal;
    }
    
    private static void rToO(ActivityDB adb, ResultSet rs) {
        try {
            adb.setActivityID(rs.getInt("activityID"));
            adb.setName(rs.getString("name"));
            adb.setCal(rs.getDouble("cal"));
        } catch (SQLException ex) {
            Logger.getLogger(ActivityDB.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    @Override
    public String toString() {
        return "ActivityDB{" + "activityID=" + activityID + ", name=" + name + ", cal=" + cal + '}';
    }
    
    
}
