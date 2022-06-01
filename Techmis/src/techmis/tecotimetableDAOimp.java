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
 * @author MSI
 */
public class tecotimetableDAOimp {
    
    
     public List<tecoTimetableview> list() {
        List<tecoTimetableview> list = new ArrayList<tecoTimetableview>();
        try {
            Connection con = LecturerDB.getConnection();
            String sql = "SELECT * FROM time_table ";
            PreparedStatement ps = con.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            
            
            
            while(rs.next()){
                tecoTimetableview tt = new tecoTimetableview();
                
                 tt.setTimetableid(rs.getInt("time_table_id"));
                tt.setTimetabledepid(rs.getString("dep_id"));
               
                tt.setTimetablelevel(rs.getString("level"));
                tt.setTimetablesemester(rs.getString("semester"));
                tt.setTimetabledate(rs.getString("date"));
                tt.setTimetablecoursename(rs.getString("course_name"));
                tt.setTimetablestart(rs.getString("start_time"));
                tt.setTimetableend(rs.getString("end_time"));
                tt.setTimetableloc(rs.getString("location"));
                tt.setTimetableloc(rs.getString("type"));
 
                list.add(tt);
            }
            
        } catch (Exception e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(null, "Error");
        }
        return list;
    }
    
    
    
    
    
}
