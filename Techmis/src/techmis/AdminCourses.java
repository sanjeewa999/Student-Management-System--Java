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
public class AdminCourses extends DBConnection implements AdminCoursesInterface{
    
    private String ID;
    private String depId;
    private String name;
    private String lecId;
    private Integer credit;
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

    public String getLecId() {
        return lecId;
    }

    public void setLecId(String lecId) {
        this.lecId = lecId;
    }

    
    
    public Integer getCredit() {
        return credit;
    }

    public void setCredit(Integer credit) {
        this.credit = credit;
    }

    @Override
    public void insert() {
        super.connection();
        String sql = "insert into course(course_id, course_dep_id, course_name, course_lec_id, credit) values (?,?,?,?,?)";
        try {
            PreparedStatement pst = conn.prepareStatement(sql);
            pst.setString(1, ID);
            pst.setString(2, depId);
            pst.setString(3, name);
            pst.setString(4, lecId);
            pst.setInt(5, credit);
            pst.executeUpdate();
            pst.close();
            message("Successfully added");
            
        } catch (Exception e) {
            message(e.getMessage());
        }
    }

    @Override
    public void update() {
       super.connection();
       String sql ="update course set course_dep_id=?, course_name=?, course_lec_id=?, credit=? where course_id=?";
        try {
            PreparedStatement pst = conn.prepareStatement(sql);
            pst.setString(1, depId);
            pst.setString(2, name);
            pst.setString(3, lecId);
            pst.setInt(4, credit);
            pst.setString(5, ID);
            pst.executeUpdate();
            pst.close();
            message("Successfully updated");
        } catch (Exception e) {
            message(e.getMessage());
        }
    }

    @Override
    public void delete(String id) {
        
        super.connection();
        String sql = "delete from course where course_id=?";
        try {
            PreparedStatement pst = conn.prepareStatement(sql);
            
            pst.setString(1, id);
            pst.executeUpdate();
            pst.close();
            message("Successfully deleted");
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
        String sql = "select * from course";
        try {
           PreparedStatement pst = conn.prepareStatement(sql);
           ResultSet rs = pst.executeQuery();
           
           while(rs.next()){
                String Course_ID = rs.getString("course_id");
                String Course_dep_id = rs.getString("course_dep_id");
                String course_name= rs.getString("course_name");
                String course_lec_id= rs.getString("course_lec_id");
                Integer credit=rs.getInt("credit");
                
                
                Vector row = new Vector();
                
                row.add(Course_ID);
                row.add(Course_dep_id);
                row.add(course_name);
                row.add(course_lec_id);
                row.add(credit);
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
        String sql = "select * from course where course_id = " + ID;
        try {
            PreparedStatement pst = conn.prepareStatement(sql);
            ResultSet rs = pst.executeQuery();
            
            if(rs.next()){
                rowCounter++;
                String ID = rs.getString("ID");
                String depId = rs.getString("depId");
                String name = rs.getString("name");
                String lecId = rs.getString("lecId");
                Integer credit = rs.getInt("credit");
                
                setID(ID);
                this.setID(ID);
                this.setDepId(depId);
                this.setName(name);
                this.setLecId(lecId);
                this.setCredit(credit);
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

    void delete(int id) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
    
    
    
}
