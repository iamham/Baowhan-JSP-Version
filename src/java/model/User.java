/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package model;

import connectionDB.ConnectionAgent;
import java.io.UnsupportedEncodingException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;
/**
 *
 * @author LudjaPae
 */
public class User {
    
    static Timestamp time = new Timestamp(System.currentTimeMillis());
    private int userID;
    private String username;
    private String password;
    private String email;
    private String firstname;
    private String lastname;
    private String profilePIC;
    private String telephone;
    private String address;
    private String province;
    private String amphur;

    private int relatedUserID;
    private int hospitalID;
    private String currentmed;
    private String pastmed;
    private int type;
    private String fbID;

    public User() {
    }

    public User(int userID, String username, String password, String email, 
            String firstname, String lastname, String profilePIC, String telephone, 
            String address, String province, String amphur,  
            int relatedUserID, int hospitalID, String currentmed, String pastmed, int type) {
        this.userID = userID;
        this.username = username;
        this.password = password;
        this.email = email;
        this.firstname = firstname;
        this.lastname = lastname;
        this.profilePIC = profilePIC;
        this.telephone = telephone;
        this.address = address;
        this.province = province;
        this.amphur = amphur;
        this.relatedUserID = relatedUserID;
        this.hospitalID = hospitalID;
        this.currentmed = currentmed;
        this.pastmed = pastmed;
        this.type = type;
        
        
    }

    public User(String username, String password, String email, String firstname, String lastname, String profilePIC, String telephone, String address, String province, String amphur) {
        this.username = username;
        this.password = password;
        this.email = email;
        this.firstname = firstname;
        this.lastname = lastname;
        this.profilePIC = profilePIC;
        this.telephone = telephone;
        this.address = address;
        this.province = province;
        this.amphur = amphur;
    }

    public int getUserID() {
        return userID;
    }

    public void setUserID(int userID) {
        this.userID = userID;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getFirstname() {
        return firstname;
    }

    public String getFbID() {
        return fbID;
    }

    public void setFbID(String fbID) {
        this.fbID = fbID;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public String getProfilePIC() {
        return profilePIC;
    }

    public void setProfilePIC(String profilePIC) {
        this.profilePIC = profilePIC;
    }

    public String getTelephone() {
        return telephone;
    }

    public void setTelephone(String telephone) {
        this.telephone = telephone;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getProvince() {
        return province;
    }

    public void setProvince(String province) {
        this.province = province;
    }

    public String getAmphur() {
        return amphur;
    }

    public void setAmphur(String amphur) {
        this.amphur = amphur;
    }

    public int getRelatedUserID() {
        return relatedUserID;
    }

    public void setRelatedUserID(int relatedUserID) {
        this.relatedUserID = relatedUserID;
    }

    public int getHospitalID() {
        return hospitalID;
    }

    public void setHospitalID(int hospitalID) {
        this.hospitalID = hospitalID;
    }

    public String getCurrentmed() {
        return currentmed;
    }

    public void setCurrentmed(String currentmed) {
        this.currentmed = currentmed;
    }

    public String getPastmed() {
        return pastmed;
    }

    public void setPastmed(String pastmed) {
        this.pastmed = pastmed;
    }

    public int getType() {
        return type;
    }

    public void setType(int type) {
        this.type = type;
    }
    
    public static String passGenerator(){
        String gen="";
        SecureRandom random = new SecureRandom(); 
        gen = new BigInteger(130, random).toString(32);
        return gen;
    }
    
    public static String passRecovery(String email){
        User u = getUserByEmail(email);
        String nPass = passGenerator();
        u.setPassword(toMD5(nPass));
        return nPass;
    }
    public static List<User> getDoctor(){
        Connection con = ConnectionAgent.getConnection();
        String sql = "SELECT * FROM User WHERE type = 2";
        Statement st;
        ResultSet rst;
        List<User> user = new ArrayList();
        User usr;
        try {
            st = con.createStatement();
            rst = st.executeQuery(sql);
            while(rst.next()){
                usr = new User();
                usr.setFirstname(rst.getString("firstname"));
                usr.setLastname(rst.getString("lastname"));
                usr.setUserID(rst.getInt("userID"));
                user.add(usr);
            }
        } catch (SQLException ex) {
            Logger.getLogger(User.class.getName()).log(Level.SEVERE, null, ex);
        }finally{
            try {
                con.close();
            } catch (SQLException ex) {
                Logger.getLogger(User.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return user;
    }
    public static boolean userIsAvaiable(String username){
         Connection con = ConnectionAgent.getConnection();
         boolean result=false;
         String sql = "SELECT * FROM User WHERE username = \'"+username+"\'";
         Statement st;
         try {
             st = con.createStatement();
             ResultSet rst = st.executeQuery(sql);
             if(rst.next()==false)result=true;
             //if(rst.getString(3).equalsIgnoreCase(username))result=false;
         } catch (SQLException ex) {
             Logger.getLogger(User.class.getName()).log(Level.SEVERE, null, ex);
             result=false;
         }finally{
             try {
                 con.close();
             } catch (SQLException ex) {
                 Logger.getLogger(User.class.getName()).log(Level.SEVERE, null, ex);
             }
         }
         return result;
     }
    
    public static String toUTF8(String text) {
        String result = null;
        try {
            result = new String(text.getBytes("ISO8859-1"),"UTF-8");
        } catch (UnsupportedEncodingException ex) {
            result = null;
        }
        return result;
    }
    
    public static String toMD5(String input) {
         
        String md5 = null;
         
        if(null == input) return null;
         
        try {
             
        //Create MessageDigest object for MD5
        MessageDigest digest = MessageDigest.getInstance("MD5");
         
        //Update input string in message digest
        digest.update(input.getBytes(), 0, input.length());
 
        //Converts message digest value in base 16 (hex) 
        md5 = new BigInteger(1, digest.digest()).toString(16);
 
        } catch (NoSuchAlgorithmException e) {
 
            e.printStackTrace();
        }
        return md5;
    }
    
    public static boolean pRegister(
            String username,
            String password,
            String email,
            String firstname,
            String lastname,
            String telephone,
            String province,
            int hospital,
            int doctor,
            int type
            ){
        password = toMD5(password);
        Connection con = ConnectionAgent.getConnection();
         boolean result = false;
         PreparedStatement ps;
         String sql = "INSERT INTO User(username,password,email,firstname,lastname,telephone,province,hospitalID,relatedUserID,type) VALUES (?,?,?,?,?,?,?,?,?,?)";
         try { 
             System.out.println(sql);
             ps = con.prepareStatement(sql);
             ps.setString(1, username);
             ps.setString(2, password);
             ps.setString(3, email);
             ps.setString(4, firstname);
             ps.setString(5, lastname);
             ps.setString(6, telephone);
             ps.setString(7, province);
             ps.setInt(8, hospital);
             ps.setInt(9, doctor);
             ps.setInt(10, type);
             ps.executeUpdate();
             result=true;
         } catch (SQLException ex) {
             Logger.getLogger(User.class.getName()).log(Level.SEVERE, null, ex);
             result=false;
         }finally{
             try {
                 con.close();
             } catch (SQLException ex) {
                 Logger.getLogger(User.class.getName()).log(Level.SEVERE, null, ex);
             }
         }
         return result; 
     }

    public static boolean updateUser(User u){
        Connection con = ConnectionAgent.getConnection();
         boolean result = false;
         String sql = "UPDATE User = \'"+u.getUsername()+"\', \'password\' = \'"+u.getPassword()+"\', \'email\' = \'"+u.getEmail()+"\',\'firstname\' = \'"+u.getFirstname()+"\', \'lastname\' = \'"+u.getLastname()+"\', \'profilePIC\' = \'"+u.getProfilePIC()+"\', \'telephone\' = \'"+u.getTelephone()+"\', \'address\' = \'"+u.getAddress()+"\', \'province\' = \'"+u.getProvince()+"\',  \'relatedUserID\' = "+u.getRelatedUserID()+", \'hospitalID\' = "+u.getHospitalID()+", \'currentmed\' = \'"+u.getCurrentmed()+"\', \'pastmed\' = \'"+u.getPastmed()+"\', \'fbid\' = \'"+u.getFbID()+"\' WHERE userID = "+u.getUserID()+";\n";
         try { 
             Statement st = con.createStatement();
             st.executeUpdate(sql);
             result=true;
         } catch (SQLException ex) {
             Logger.getLogger(User.class.getName()).log(Level.SEVERE, null, ex);
             result=false;
         }finally{
             try {
                 con.close();
             } catch (SQLException ex) {
                 Logger.getLogger(User.class.getName()).log(Level.SEVERE, null, ex);
             }
         }
         return result; 
     }
    public static boolean updateEAG(int userID){
        Connection con = ConnectionAgent.getConnection();
        double result = DiabetesLog.getEAG(userID);
        boolean success=false;
        String sql = "UPDATE User SET eAG = "+result+" WHERE userID="+userID+"";
        System.out.println(sql);
        PreparedStatement ps;
        try {
            ps = con.prepareStatement(sql);
            ps.executeUpdate();
            success=true;
        } catch (SQLException ex) {
            Logger.getLogger(User.class.getName()).log(Level.SEVERE, null, ex);
        }finally{
            try {
                con.close();
            } catch (SQLException ex) {
                Logger.getLogger(User.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return success;
    }
    
    public static User getUser(String user) {
        Connection con = ConnectionAgent.getConnection();
        String sql = "select username ,password ,email ,firstname ,lastname ,profilePIC ,telephone ,address ,province,userID,hospitalID,relatedUserID,type from User where username= ?";
        PreparedStatement ps;
        User u = null;
        try {
            ps = con.prepareStatement(sql);
            ps.setString(1, user);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                u = new User();
                u.setUsername(rs.getString(1));
                u.setPassword(rs.getString(2));
                u.setEmail(rs.getString(3));
                u.setFirstname(rs.getString(4));
                u.setLastname(rs.getString(5));
                u.setProfilePIC(rs.getString(6));
                u.setTelephone(rs.getString(7));
                u.setAddress(rs.getString(8));
                u.setProvince(rs.getString(9));
                u.setUserID(rs.getInt(10));
                u.setHospitalID(rs.getInt(11));
                u.setRelatedUserID(rs.getInt(12));
                u.setType(rs.getInt(13));
            }
        } catch (SQLException ex) {
            Logger.getLogger(User.class.getName()).log(Level.SEVERE, null, ex);
        }finally{
            try {
                con.close();
            } catch (SQLException ex) {
                Logger.getLogger(User.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return u;
    }
    
    public static User getUserByEmail(String email) {
        Connection con = ConnectionAgent.getConnection();
        String sql = "select username ,password ,email ,firstname ,lastname ,profilePIC ,telephone ,address ,province from User where email= ?";
        PreparedStatement ps;
        User u = null;
        try {
            ps = con.prepareStatement(sql);
            ps.setString(1, email);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                u = new User();
                u.setUsername(rs.getString(1));
                u.setPassword(rs.getString(2));
                u.setEmail(rs.getString(3));
                u.setFirstname(rs.getString(4));
                u.setLastname(rs.getString(5));
                u.setProfilePIC(rs.getString(6));
                u.setTelephone(rs.getString(7));
                u.setAddress(rs.getString(8));
                u.setProvince(rs.getString(9));
               
            }
        } catch (SQLException ex) {
            Logger.getLogger(User.class.getName()).log(Level.SEVERE, null, ex);
        }finally{
            try {
                con.close();
            } catch (SQLException ex) {
                Logger.getLogger(User.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return u;
    }
    public static double getUserEAG(int userID){
        Connection con = ConnectionAgent.getConnection();
        double eAG=0;
        try {
            String sql = "select eAG from User where userid= ?";
            PreparedStatement ps;
            ps = con.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            while(rs.next()){
                eAG = rs.getDouble("eAG");
            }
        } catch (SQLException ex) {
            Logger.getLogger(User.class.getName()).log(Level.SEVERE, null, ex);
        }finally{
            try {
                con.close();
            } catch (SQLException ex) {
                Logger.getLogger(User.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return eAG;
    }
    public static String getUserName(int userID){
        Connection con = ConnectionAgent.getConnection();
        String name = null;
        try {
            String sql = "select firstname,lastname from User where userid= ?";
            PreparedStatement ps;
            ps = con.prepareStatement(sql);
            ps.setInt(1, userID);
            ResultSet rs = ps.executeQuery();
            while(rs.next()){
                name = rs.getString(1)+" "+rs.getString(2);
            }
        } catch (SQLException ex) {
            Logger.getLogger(User.class.getName()).log(Level.SEVERE, null, ex);
        }finally{
            try {
                con.close();
            } catch (SQLException ex) {
                Logger.getLogger(User.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return name;
    }
    
    public static User getUserRecord(String ur) {
        Connection con = ConnectionAgent.getConnection();
        String sql = "select userid,username,firstname,lastname,profilePIC,telephone from User where userid= ?";
        PreparedStatement ps;
        User u = null;
        try {
            ps = con.prepareStatement(sql);
            ps.setString(1, ur);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                u = new User();
                u.setUserID(rs.getInt(1));
                u.setUsername(rs.getString(2));
                u.setFirstname(rs.getString(3));
                u.setLastname(rs.getString(4));
                u.setProfilePIC(rs.getString(5));
                u.setTelephone(rs.getString(6));
            }
        } catch (SQLException ex) {
            Logger.getLogger(User.class.getName()).log(Level.SEVERE, null, ex);
        } finally{
            try {
                con.close();
            } catch (SQLException ex) {
                Logger.getLogger(User.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return u;
    }
    
    public static List<User> showPatientList() {
        Connection con = ConnectionAgent.getConnection();
        String sqlCmd = "SELECT * FROM User";
        User u = null;
        List<User> ul = new ArrayList<User>();
        try {
            PreparedStatement ps = con.prepareStatement(sqlCmd);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                u = new User();
                rToO(u, rs);
                ul.add(u);
            }
        } catch (SQLException ex) {
            Logger.getLogger(User.class.getName()).log(Level.SEVERE, null, ex);
        }finally{
            try {
                con.close();
            } catch (SQLException ex) {
                Logger.getLogger(User.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return ul;
    }
    
    public static List<User> showAccPatientList(int doctorID) {
        Connection con = ConnectionAgent.getConnection();
        String sqlCmd = "SELECT * FROM User WHERE relatedUserID = ? AND reqStatus = 2";
        User u = null;
        List<User> ul = new ArrayList<User>();
        try {
            PreparedStatement ps = con.prepareStatement(sqlCmd);
            ps.setInt(1, doctorID);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                u = new User();
                rToO(u, rs);
                ul.add(u);
            }
        } catch (SQLException ex) {
            Logger.getLogger(User.class.getName()).log(Level.SEVERE, null, ex);
        }finally{
            try {
                con.close();
            } catch (SQLException ex) {
                Logger.getLogger(User.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return ul;
    }
    public static List<User> showAccRequest(int doctorID) {
        Connection con = ConnectionAgent.getConnection();
        String sqlCmd = "SELECT * FROM User WHERE relatedUserID = ? AND reqStatus = 1";
        User u = null;
        List<User> ul = new ArrayList<User>();
        try {
            PreparedStatement ps = con.prepareStatement(sqlCmd);
            ps.setInt(1, doctorID);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                u = new User();
                rToO(u, rs);
                ul.add(u);
            }
        } catch (SQLException ex) {
            Logger.getLogger(User.class.getName()).log(Level.SEVERE, null, ex);
        }finally{
            try {
                con.close();
            } catch (SQLException ex) {
                Logger.getLogger(User.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return ul;
    }
    
     private static void rToO(User u, ResultSet rs) {
        try {
            u.setUsername(rs.getString("username"));
            u.setPassword(rs.getString("password"));
            u.setEmail(rs.getString("email"));
            u.setFirstname(rs.getString("firstname"));
            u.setLastname(rs.getString("lastname"));
            u.setProfilePIC(rs.getString("profilePIC"));
            u.setTelephone(rs.getString("telephone"));
            u.setAddress(rs.getString("address"));
            u.setProvince(rs.getString("province"));         
            u.setHospitalID(rs.getInt("hospitalID"));
            u.setRelatedUserID(rs.getInt("relatedUserID"));
            u.setType(rs.getInt("type"));
            u.setCurrentmed(rs.getString("currentmed"));
            u.setPastmed(rs.getString("pastmed"));
            u.setUserID(rs.getInt("userid"));
        } catch (SQLException ex) {
            Logger.getLogger(User.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    @Override
    public String toString() {
        return "User{" + "userID=" + userID + ", username=" + username + ", password=" 
                + password + ", email=" + email + ", firstname=" + firstname + ", lastname=" 
                + lastname + ", profilePIC=" + profilePIC + ", telephone=" + telephone + 
                ", address=" + address + ", province=" + province + ", amphur=" + amphur + 
                ", relatedUserID=" + relatedUserID + ", hospitalID=" + 
                hospitalID + ", currentmed=" + currentmed + ", pastmed=" + pastmed + ", type=" + type + '}';
    }
    public static void main(String[] args) {
        System.out.println(User.showAccPatientList(2));
        System.out.println(User.showAccRequest(2));
    }
}
