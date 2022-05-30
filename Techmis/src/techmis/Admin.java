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
public class Admin extends User implements AdminInterface{
    private String ID;
    private String name;
    private String address;
    private String email;
    private String dob;
    private Integer mobile;
    private String gender;
    private String role;
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

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

     

    

    @Override
    public void insert() {
        super.connection();
        String sql = "insert into admin(admin_id, admin_name, admin_address, admin_email, admin_dob, admin_p_no, gender, admin_role) values (?,?,?,?,?,?,?,?)";
        try {
            PreparedStatement pst = conn.prepareStatement(sql);
            pst.setString(1, ID);
            pst.setString(2, name);
            pst.setString(3, address);
            pst.setString(4, email);
            pst.setString(5, dob);
            pst.setInt(6, mobile);
            pst.setString(7, gender);
            pst.setString(8, role);
            
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
        String sql = "update admin set admin_id=?, admin_name=?, admin_address=?, admin_email=?, admin_dob=?, admin_p_no=?, gender=?, admin_role=? where admin_id=?";
        try {
            PreparedStatement pst = conn.prepareStatement(sql);
            pst.setString(1, ID);
            pst.setString(2, name);
            pst.setString(3, address);
            pst.setString(4, email);
            pst.setString(5, dob);
            pst.setInt(6, mobile);
            pst.setString(7, gender);
            pst.setString(8, role);
            pst.setString(9, ID);
            
            pst.executeUpdate();
            pst.close();
            message("Successfully Updated");
        } catch (Exception e) {
            message(e.getMessage());
        }
    }
    
    @Override
    public void delete(String ID) {
        super.connection();
        String sql = "delete from admin where admin_id=?";
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
       String sql = "select * from admin";
        try {
            PreparedStatement pst = conn.prepareStatement(sql);
            ResultSet rs = pst.executeQuery();
            
            while(rs.next()){
                String Admin_ID = rs.getString("admin_id");
                String Admin_name = rs.getString("admin_name");
                String Admin_address = rs.getString("admin_address");
                String Admin_email = rs.getString("admin_email");
                String Admin_dob = rs.getString("admin_dob");
                String Admin_p_no = rs.getString("admin_p_no");
                String Admin_gender = rs.getString("gender");
                String Admin_role = rs.getString("admin_role");
                
                Vector row = new Vector();
                
                row.add(Admin_ID);
                row.add(Admin_name);
                row.add(Admin_address);
                row.add(Admin_email);
                row.add(Admin_dob);
                row.add(Admin_p_no);
                row.add(Admin_gender);
                row.add(Admin_role);
                this.getData().add(row);
            }
        } catch (Exception e) {
            message(e.getMessage());   
        }
    }
    
     @Override
    public void notices() {
        super.connection();
        byte rowCounter = 0;
        String sql = "select * from admin where admin_id =" + ID;
         try {
            PreparedStatement pst = conn.prepareStatement(sql);
            ResultSet rs = pst.executeQuery();
            
            if(rs.next()){
                rowCounter++;
                String ID = rs.getString("ID");
                String name = rs.getString("name");
                String address = rs.getString("address");
                String email = rs.getString("email"); 
                String dob = rs.getString("dob");
                Integer mobile = rs.getInt("mobile");
                String gender = rs.getString("gender");
                String role = rs.getString("role");
            }
         } catch (Exception e) {
             message(e.getMessage());
         }
    }
    
    private void message(String message){ //start
        JOptionPane.showMessageDialog(null, message);
    } //end
    
}
