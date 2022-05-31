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
public class StudentMedicalimp {
     public StudentMedicaldetails get(String stu_id) {
       
          StudentMedicaldetails sm = new StudentMedicaldetails();
        try {
            Connection con = LecturerDB.getConnection();
            String sql = "SELECT * FROM medical WHERE stu_id=?";
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setString(1, stu_id);
            ResultSet rs = ps.executeQuery();
            if(rs.next()){
                
                sm.setStu_id(rs.getString("stu_id"));
                sm.setCourse_id(rs.getString("course_id"));
                sm.setStart_date(rs.getString("start_date"));
                sm.setEnd_date(rs.getString("end_date"));
                sm.setMedical_type(rs.getString("medical_type"));
                
            }
            
        } catch (Exception e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(null, "Error");
        }
        return sm;
     }
     
    public List<StudentMedicaldetails> list() {
        List<StudentMedicaldetails> list = new ArrayList<StudentMedicaldetails>();
        try {
            Connection con = LecturerDB.getConnection();
            String sql = "SELECT * FROM medical ";
            PreparedStatement ps = con.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            
            
            
            while(rs.next()){
                StudentMedicaldetails sm = new StudentMedicaldetails();
                sm.setStu_id(rs.getString("stu_id"));
                sm.setCourse_id(rs.getString("course_id"));
                sm.setStart_date(rs.getString("start_date"));
                sm.setEnd_date(rs.getString("end_date"));
                sm.setMedical_type(rs.getString("medical_type"));
                
               
                
                list.add(sm);
            }
            
        } catch (Exception e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(null, "Error");
        }
        return list;
    }
}
