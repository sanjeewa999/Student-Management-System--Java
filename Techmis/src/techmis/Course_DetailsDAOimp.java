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
public class Course_DetailsDAOimp {
     public List<studentCourseDetails> list() {
        List<studentCourseDetails> list = new ArrayList<studentCourseDetails>();
        try {
            Connection con = LecturerDB.getConnection();
            String sql = "SELECT * FROM course ";
            PreparedStatement ps = con.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            
            
            
            while(rs.next()){
                studentCourseDetails cd = new studentCourseDetails();
                cd.setCourse_id(rs.getString("course_id"));
                cd.setCourse_dep_id(rs.getString("course_dep_id"));
                cd.setCourse_name(rs.getString("course_name"));
                cd.setCourse_lec_id(rs.getString("course_lec_id"));
                cd.setCredit(rs.getString("credit"));
                
                list.add(cd);
            }
            
        } catch (Exception e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(null, "Error");
        }
        return list;
    }

}
