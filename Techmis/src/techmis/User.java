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
public class User extends DBConnection implements UserInteface{
    
    private String ID;
    private String pwd;
    private String role;
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

    public String getPassword() {
        return pwd;
    }

    public void setPassword(String password) {
        this.pwd = password;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
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
        String sql = "insert into user(user_id, user_pwd, user_role, user_name, user_address, user_email, user_dob, user_contact, user_gender) values (?,?,?,?,?,?,?,?,?)";
        try {
            PreparedStatement pst = conn.prepareStatement(sql);
            pst.setString(1, ID);
            pst.setString(2, pwd);
            pst.setString(3, role);
            pst.setString(4, name);
            pst.setString(5, address);
            pst.setString(6, email);
            pst.setString(7, dob);
            pst.setInt(8, mobile);
            pst.setString(9, gender);
            
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
        String sql = "update user set user_id=?, user_pwd=?, user_role=?, user_name=?, user_address=?, user_email=?, user_dob=?, user_contact=?, user_gender=? where user_id=?";
        try {
            PreparedStatement pst = conn.prepareStatement(sql);
            pst.setString(1, ID);
            pst.setString(2, pwd);
            pst.setString(3, role);
            pst.setString(4, name);
            pst.setString(5, address);
            pst.setString(6, email);
            pst.setString(7, dob);
            pst.setInt(8, mobile);
            pst.setString(9, gender);
            pst.setString(10, ID);
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
        String sql = "delete from user where user_id=?";
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
       String sql = "select * from user";
        try {
            PreparedStatement pst = conn.prepareStatement(sql);
            ResultSet rs = pst.executeQuery();
            
            while(rs.next()){
                String User_ID = rs.getString("user_id");
                String User_pwd = rs.getString("user_pwd");
                String User_role = rs.getString("user_role");
                String User_name = rs.getString("user_name");
                String User_address = rs.getString("user_address");
                String User_email = rs.getString("user_email");
                String User_dob = rs.getString("user_dob");
                String User_contact = rs.getString("user_contact");
                String User_gender = rs.getString("user_gender");
                
                Vector row = new Vector();
                
                row.add(User_ID);
                row.add(User_pwd);
                row.add(User_role);
                row.add(User_name);
                row.add(User_address);
                row.add(User_email);
                row.add(User_dob);
                row.add(User_contact);
                row.add(User_gender);
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
        String sql = "select * from user where user_id = " + ID;
        try {
            PreparedStatement pst = conn.prepareStatement(sql);
            ResultSet rs = pst.executeQuery();
            
            if(rs.next()){
                rowCounter++;
                String ID = rs.getString("ID");
                String pwd = rs.getString("pwd");
                String role = rs.getString("role");
                String name = rs.getString("name");
                String address = rs.getString("address");
                String email = rs.getString("email");
                String dob = rs.getString("dob");
                Integer mobile = rs.getInt("mobile");
                String gender = rs.getString("gender");
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
