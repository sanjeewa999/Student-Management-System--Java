/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package techmis;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;

/**
 *
 * @author User
 */
public class StudentCAviweimp {
     public studentCAviews get(String stu_id) {
       
          studentCAviews ca = new studentCAviews();
        try {
            Connection con = LecturerDB.getConnection();
            String sql = "SELECT * FROM ca_marks WHERE stu_id=?";
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setString(1, stu_id);
            ResultSet rs = ps.executeQuery();
            if(rs.next()){
                
                ca.setCourse_id(rs.getString("course_id"));
                ca.setStu_id(rs.getString("stu_id"));
                ca.setQ1(rs.getFloat("q1"));
                ca.setQ2(rs.getFloat("q2"));
                ca.setQ3(rs.getFloat("q3"));
                ca.setQ4(rs.getFloat("q4"));
                ca.setAss1(rs.getFloat("ass1"));
                ca.setAss2(rs.getFloat("ass2"));
                ca.setAss3(rs.getFloat("ass3"));
                ca.setMid(rs.getFloat("mid"));
            }
            
        } catch (Exception e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(null, "Error");
        }
        return ca;
        
    }

    public List<studentCAviews> list() {
        List<studentCAviews> list = new ArrayList<studentCAviews>();
        try {
            Connection con = LecturerDB.getConnection();
            String sql = "SELECT * FROM ca_marks ";
            PreparedStatement ps = con.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            
            
            
            while(rs.next()){
                studentCAviews ca = new studentCAviews();
                
                ca.setCourse_id(rs.getString("course_id"));
                ca.setStu_id(rs.getString("stu_id"));
                ca.setQ1(rs.getFloat("q1"));
                ca.setQ2(rs.getFloat("q2"));
                ca.setQ3(rs.getFloat("q3"));
                ca.setQ4(rs.getFloat("q4"));
                ca.setAss1(rs.getFloat("ass1"));
                ca.setAss2(rs.getFloat("ass2"));
                ca.setAss3(rs.getFloat("ass3"));
                ca.setMid(rs.getFloat("mid"));
 
                list.add(ca);
            }
            
        } catch (Exception e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(null, "Error");
        }
        return list;
    }
}
