/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package techmis;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.util.List;
import javax.swing.JOptionPane;

/**
 *
 * @author User
 */
public class studentUpdateDAOimp {
     public void update(studentUpdates studentUpdates) {
        
         try {
          
            Connection con = LecturerDB.getConnection();
            String sql = "UPDATE student SET stu_id=?,stu_name=?,stu_address=?,stu_email=?,stu_b_day=?,stu_p_no=? WHERE stu_id=?";
            
            PreparedStatement su = con.prepareStatement(sql);
            su.setString(1, studentUpdates.getStu_id());
            su.setString(2, studentUpdates.getStu_name());
            su.setString(3, studentUpdates.getStu_address());
            su.setString(4, studentUpdates.getStu_email());
            su.setString(5, studentUpdates.getStu_b_day());
            su.setInt(6, studentUpdates.getStu_p_no());
            su.setString(7, studentUpdates.getStu_id());
           
            
            su.executeUpdate();
  
        
            JOptionPane.showMessageDialog(null, "Updated!");
        } catch (Exception e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(null, "Error");
        }
}
}

   