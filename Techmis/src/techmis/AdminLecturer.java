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
public class AdminLecturer extends User implements AdminLecturerInterface{
    
    private String ID;
    private String depId;
    private String name;
    private String address;
    private String email;
    private String dob;
    private Integer mobile;
    private String gender;
    private String position;
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

    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position;
    }

    @Override
    public void insert() {
        super.connection();
        String sql = "insert into lecturer(lec_id, lec_dept_id, lec_name, lec_address, lec_email, lec_dob, lec_p_no, gender, lec_possion) values (?,?,?,?,?,?,?,?,?)";
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
            pst.setString(9, position);
            
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
        String sql = "update lecturer set lec_id=?, lec_dept_id=?, lec_name=?, lec_address=?, lec_email=?, lec_dob=?, lec_p_no=?, gender=?, lec_possion=? where lec_id=?";
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
            pst.setString(9, position);
            pst.setString(10, ID);
            pst.executeUpdate();
            pst.close();
            message("Successfully Updated");
        } catch (Exception e) {
        }
    }
    
    @Override
    public void delete(String ID) {
        super.connection();
        String sql = "delete from lecturer where lec_id=?";
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
       String sql = "select * from lecturer";
        try {
            PreparedStatement pst = conn.prepareStatement(sql);
            ResultSet rs = pst.executeQuery();
            
             while(rs.next()){
                String Lecturer_ID = rs.getString("lec_id");
                String Lecturer_dep = rs.getString("lec_dept_id");
                String Lecturer_name = rs.getString("lec_name");
                String Lecturer_address = rs.getString("lec_address");
                String Lecturer_email = rs.getString("lec_email");
                String Lecturer_dob = rs.getString("lec_dob");
                String Lecturer_p_no = rs.getString("lec_p_no");
                String Lecturer_gender = rs.getString("gender");
                String Lecturer_position = rs.getString("lec_position");
                
                Vector row = new Vector();
                
                row.add(Lecturer_ID);
                row.add(Lecturer_dep);
                row.add(Lecturer_name);
                row.add(Lecturer_address);
                row.add(Lecturer_email);
                row.add(Lecturer_dob);
                row.add(Lecturer_p_no);
                row.add(Lecturer_gender);
                row.add(Lecturer_position);
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
        String sql = "select * from lecturer where lec_id = " + ID;
        try {
            PreparedStatement pst = conn.prepareStatement(sql);
            ResultSet rs = pst.executeQuery();
            
            if(rs.next()){
                rowCounter++;
                String ID = rs.getString("ID");
                String depId = rs.getString("depId");
                String name = rs.getString("name");
                String address = rs.getString("address");
                String email = rs.getString("email");
                String dob = rs.getString("dob");
                Integer mobile = rs.getInt("mobile");
                String gender = rs.getString("gender");
                String position = rs.getString("position");
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
