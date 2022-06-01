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
public class StudentFinalMarksimp {
     public StudentFinalMark get(String stu_id) {
       
          StudentFinalMark sf = new StudentFinalMark();
        try {
            Connection con = LecturerDB.getConnection();
            String sql = "SELECT * FROM final_exam_marks WHERE stu_id=?";
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setString(1, stu_id);
            ResultSet rs = ps.executeQuery();
            if(rs.next()){
                
                sf.setCourse_id(rs.getString("course_id"));
                sf.setStu_id(rs.getString("stu_id"));
                sf.setPractical(rs.getFloat("practical"));
                sf.setTheory(rs.getFloat("theory"));
               
            }
            
        } catch (Exception e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(null, "Error");
        }
        return sf;
        
    }

    public List<StudentFinalMark> list() {
        List<StudentFinalMark> list = new ArrayList<StudentFinalMark>();
        try {
            Connection con = LecturerDB.getConnection();
            String sql = "SELECT * FROM final_exam_marks ";
            PreparedStatement ps = con.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            
            
            
            while(rs.next()){
                StudentFinalMark sf = new StudentFinalMark();
                
                sf.setCourse_id(rs.getString("course_id"));
                sf.setStu_id(rs.getString("stu_id"));
                sf.setPractical(rs.getFloat("practical"));
                sf.setTheory(rs.getFloat("theory"));
               
                
                list.add(sf);
            }
            
        } catch (Exception e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(null, "Error");
        }
        return list;
    }
}
