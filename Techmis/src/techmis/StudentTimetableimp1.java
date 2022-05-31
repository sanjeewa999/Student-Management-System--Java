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
public class StudentTimetableimp1 implements Student_timetable {
     public List<StudentTimetables> list() {
        List<StudentTimetables> list = new ArrayList<StudentTimetables>();
        try {
            Connection con = LecturerDB.getConnection();
            String sql = "SELECT * FROM time_table ";
            PreparedStatement ps = con.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            
            
            
            while(rs.next()){
                StudentTimetables st = new StudentTimetables();
                st.setTime_table_id(rs.getInt("time_table_id"));
                st.setDep_id(rs.getString("dep_id"));
                st.setLevel(rs.getInt("level"));
                st.setSemester(rs.getString("semester"));
                st.setDate(rs.getString("date"));
                st.setCourse_name(rs.getString("course_name"));
                st.setStart_time(rs.getString("start time"));
                st.setEnd_time(rs.getString("end time"));
                st.setLocation(rs.getString("location"));
                st.setType(rs.getString("type"));
                
                list.add(st);
            }
            
        } catch (Exception e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(null, "Error");
        }
        return list;
    }

    @Override
    public List<StudentTimetables> List() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
}
