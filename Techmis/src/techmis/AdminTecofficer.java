/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package techmis;

import com.mysql.cj.jdbc.PreparedStatementWrapper;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Vector;
import javax.swing.JOptionPane;

/**
 *
 * @author ASUS
 */
public class AdminTecofficer extends User implements AdminTecofficerInterface{
    private String ID;
    private String depId;
    private String name;
    private String address;
    private String email;
    private String dob;
    private Integer mobile;
    private String gender;
    private Vector data;

    public Vector getData() {
        return data;
    }

    public void setData(Vector data) {
        this.data = data;
    }
    
    

    public String getID() {
        return ID;
    }

    public void setID(String ID) {
        this.ID = ID;
    }

    public String getDepId() {
        return depId;
    }

    public void setDepId(String depId) {
        this.depId = depId;
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

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getDob() {
        return dob;
    }

    public void setDob(String dob) {
        this.dob = dob;
    }

    public Integer getMobile() {
        return mobile;
    }

    public void setMobile(Integer mobile) {
        this.mobile = mobile;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    

    

    @Override
    public void insert() {
        super.connection(); 
        String sql = "insert into tecnical_officer(tec_id, tec_dep_id, tec_name, tec_address, tec_email, tec_dob, tec_p_no, gender) values (?,?,?,?,?,?,?,?)";
        try {
            PreparedStatement pst = conn.prepareStatement(sql);
            pst.setString(1, ID);
            pst.setString(2, depId);
            pst.setString(3, name);
            pst.setString(4, address);
            pst.setString(5, email);
            pst.setString(6, dob);
            pst.setInt(7, mobile);
            pst.setString(8, gender);
            
            pst.executeUpdate();
            pst.close();
            message("Successfully Added");
        } catch (Exception e) {
            message(e.getMessage());
        }
       
    }
    
        
    @Override
    public void update() {
        super.connection();
        String sql = "update tecnical_officer set tec_id=?, tec_dep_id=?, tec_name=?, tec_address=?, tec_email=?, tec_dob=?, tec_p_no=?, gender=? where tec_id=?";
        try {
            PreparedStatement pst = conn.prepareStatement(sql);
            pst.setString(1, ID);
            pst.setString(2, depId);
            pst.setString(3, name);
            pst.setString(4, address);
            pst.setString(5, email);
            pst.setString(6, dob);
            pst.setInt(7, mobile);
            pst.setString(8, gender);
            pst.setString(9, ID);
            
            pst.executeUpdate();
            pst.close();
            message("Successfully Updated");
        } catch (Exception e) {
            message(e.getMessage());
        }
    }

    @Override
    public void delete() {
        super.connection();
        String sql = "delete from tecnical_officer where tec_id=?";
        try {
            PreparedStatement pst = conn.prepareStatement(sql);
            pst.setString(1, ID);
            pst.executeUpdate();
            pst.close();
            message("Successfully Deleted");
        } catch (Exception e) {
            message(e.getMessage());
        }
    }

    @Override
    public void loadlist() {
       this.setData(new Vector());
       this.setData(new Vector());
       super.connection();
       byte rowCounter = 0;
       String sql = "select * from tecnical_officer";
        try {
            PreparedStatement pst = conn.prepareStatement(sql);
            ResultSet rs = pst.executeQuery();
            
            while(rs.next()){
                String Tec_ID = rs.getString("tec_id");
                String Tec_depId = rs.getString("tec_dep_id");
                String Tec_name = rs.getString("tec_name");
                String Tec_address = rs.getString("tec_address");
                String Tec_email = rs.getString("tec_email");
                String Tec_dob= rs.getString("tec_dob");
                String Tec_mobile = rs.getString("tec_p_no");
                String Tec_gender= rs.getString("gender");
                
                Vector row = new Vector();
                
                row.add(Tec_ID);
                row.add(Tec_depId);
                row.add(Tec_name);
                row.add(Tec_address);
                row.add(Tec_email);
                row.add(Tec_dob);
                row.add(Tec_mobile);
                row.add(Tec_gender);
                getData().add(row);
            }
        } catch (Exception e) {
            message(e.getMessage());
        }
    }

    
    @Override
    public void notices() {
        super.connection();
        byte rowCounter = 0;
        String sql = "select * from tecnical_officer where tec_id = " + ID;
        try {
            PreparedStatement pst = conn.prepareStatement(sql);
            ResultSet rs = pst.executeQuery();
            
            if(rs.next()){
                rowCounter++;
                String Tec_ID = rs.getString("tec_id");
                String Tec_depId = rs.getString("tec_dep_id");
                String Tec_name = rs.getString("tec_name");
                String Tec_address = rs.getString("tec_address");
                String Tec_email = rs.getString("tec_email");
                String Tec_dob= rs.getString("tec_dob");
                String Tec_mobile = rs.getString("tec_p_no");
                String Tec_gender= rs.getString("gender");
            }
            
            rs.close();
            pst.close();
        } catch (Exception e) {
            message(e.getMessage());
        }
    }

    private void message(String message){ //start
        JOptionPane.showMessageDialog(null, message);
    } //end
    
    
}
