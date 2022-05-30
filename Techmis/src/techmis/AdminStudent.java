/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package techmis;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Vector;
import javax.swing.JOptionPane;

/**
 *
 * @author ASUS
 */
public class AdminStudent extends User implements AdminStudentInterface{
    
    private String ID;
    private String depId;
    private String menterId;
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

    public String getMenterId() {
        return menterId;
    }

    public void setMenterId(String menterId) {
        this.menterId = menterId;
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
        String sql = "insert into student(stu_id, stu_d_id, mentor_id, stu_name, stu_address, stu_email, stu_b_day, stu_p_no, gender) values (?,?,?,?,?,?,?,?,?)";
        try {
            PreparedStatement pst = conn.prepareStatement(sql);
            pst.setString(1, ID);
            pst.setString(2, depId);
            pst.setString(3, menterId);
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
        String sql = "update student set stu_id=?, stu_d_id=?, mentor_id=?, stu_name=?, stu_address=?, stu_email=?, stu_b_day=?, stu_p_no=?, gender=? where stu_id=?";
        try {
            PreparedStatement pst = conn.prepareStatement(sql);
            pst.setString(1, ID);
            pst.setString(2, depId);
            pst.setString(3, menterId);
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
        String sql = "delete from student where stu_id=?";
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
       String sql = "select * from student"; 
        try {
            PreparedStatement pst = conn.prepareStatement(sql);
            ResultSet rs = pst.executeQuery();
            
            while(rs.next()){
                String stu_ID = rs.getString("stu_id");
                String dep_id = rs.getString("stu_d_id");
                String mentor_id = rs.getString("menter_id");
                String st_name = rs.getString("stu_name");
                String st_address = rs.getString("stu_address");
                String st_email = rs.getString("stu_email");
                String st_dob = rs.getString("stu_b_day");
                String st_contact = rs.getString("stu_p_no");
                String st_gender = rs.getString("gender");
                
                Vector row = new Vector();
                
                row.add(stu_ID);
                row.add(dep_id);
                row.add(mentor_id);
                row.add(st_name);
                row.add(st_address);
                row.add(st_email);
                row.add(st_dob);
                row.add(st_gender);
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
        String sql = "select * from student where stu_id = " + ID;
        try {
            PreparedStatement pst = conn.prepareStatement(sql);
            ResultSet rs = pst.executeQuery();
            
            if(rs.next()){
                rowCounter++;
                String ID = rs.getString("ID");
                String depId = rs.getString("depId");
                String menterId = rs.getString("menterId");
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
    } 
    
}
