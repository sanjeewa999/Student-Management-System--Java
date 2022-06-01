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
public class StudentAttendanceimp {
      public StudentAttendanceDetails get(String stu_id) {
       
          StudentAttendanceDetails sa = new StudentAttendanceDetails();
        try {
            Connection con = LecturerDB.getConnection();
            String sql = "SELECT * FROM attendance WHERE stu_id=?";
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setString(1, stu_id);
            ResultSet rs = ps.executeQuery();
            if(rs.next()){
                
                sa.setStu_id(rs.getString("stu_id"));
                sa.setCourse_id(rs.getString("course_id"));
                sa.setDay(rs.getString("day"));
                sa.setType(rs.getString("type"));
                sa.setStatus(rs.getString("status"));
                
            }
            
        } catch (Exception e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(null, "Error");
        }
        return sa;
        
    }

    public List<StudentAttendanceDetails> list() {
        List<StudentAttendanceDetails> list = new ArrayList<StudentAttendanceDetails>();
        try {
            Connection con = LecturerDB.getConnection();
            String sql = "SELECT * FROM attendance ";
            PreparedStatement ps = con.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            
            
            
            while(rs.next()){
                StudentAttendanceDetails sa = new StudentAttendanceDetails();
                
                sa.setStu_id(rs.getString("stu_id"));
                sa.setCourse_id(rs.getString("course_id"));
                sa.setDay(rs.getString("day"));
                sa.setType(rs.getString("type"));
                sa.setStatus(rs.getString("status"));
                
                list.add(sa);
            }
            
        } catch (Exception e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(null, "Error");
        }
        return list;
    }
}
