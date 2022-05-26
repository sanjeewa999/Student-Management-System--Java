package techmis;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */



import java.sql.Connection;
import java.sql.PreparedStatement;
import java.util.List;
import javax.swing.JOptionPane;
import java.sql.ResultSet;
import java.util.ArrayList;


/**
 *
 * @author CHATHURANGA
 */
public class CAmarksDAOimp implements CAmarksDAO{

    @Override
    public void save(CAmarks camarks ) {
          try {
            Connection con =  LecturerDB.getConnection();
            String sql = "INSERT INTO ca_marks(course_id,stu_id,q1,q2,q3,q4,ass1,ass2,ass3,mid) VALUES (?,?,?,?,?,?,?,?,?,?)";
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setString(1, camarks.getCourse_id());
            ps.setString(2, camarks.getStu_id());
            ps.setFloat(3, camarks.getQ1());
            ps.setFloat(4, camarks.getQ2());
            ps.setFloat(5, camarks.getQ3());
            ps.setFloat(6, camarks.getQ4());
            ps.setFloat(7, camarks.getAss1());
            ps.setFloat(8, camarks.getAss2()); 
            ps.setFloat(9, camarks.getAss3());
            ps.setFloat(10, camarks.getMid());
            ps.executeUpdate();
            JOptionPane.showMessageDialog(null, "Saved!");
        } catch (Exception e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(null, "Error");
        }
    }

    @Override
    public void update(CAmarks camarks) {
        
         try {
          
            Connection con = LecturerDB.getConnection();
            String sql = "UPDATE ca_marks SET course_id=?,stu_id=?,q1=?,q2=?,q3=?,q4=?,ass1=?,ass2=?,ass3=?,mid=? WHERE stu_id=? and course_id=?";
            
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setString(1, camarks.getCourse_id());
            ps.setString(2, camarks.getStu_id());
            ps.setFloat(3, camarks.getQ1());
            ps.setFloat(4, camarks.getQ2());
            ps.setFloat(5, camarks.getQ3());
            ps.setFloat(6, camarks.getQ4());
            ps.setFloat(7, camarks.getAss1());
            ps.setFloat(8, camarks.getAss2());
            ps.setFloat(9, camarks.getAss3());
            ps.setFloat(10, camarks.getMid());
            //ps.setString(10, camarks.getCourse_id());
            ps.setString(11, camarks.getStu_id());
            ps.executeUpdate();
  
        
            JOptionPane.showMessageDialog(null, "Updated!");
        } catch (Exception e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(null, e);
        }
        
    }

    @Override
    public void delete(CAmarks camarks) {
        
        try {
          
            Connection con = LecturerDB.getConnection();
            String sql = "delete from ca_marks  WHERE stu_id=?";
            PreparedStatement ps = con.prepareStatement(sql);  
            ps.setString(1, camarks.getStu_id());
            ps.executeUpdate();
            JOptionPane.showMessageDialog(null, "Deleteddd!");
        } catch (Exception e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(null, "Error");
        }
        
    }

    @Override
    public CAmarks get(String stu_id) {
       
          CAmarks ca = new CAmarks();
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

    @Override
    public List<CAmarks> list() {
        List<CAmarks> list = new ArrayList<CAmarks>();
        try {
            Connection con = LecturerDB.getConnection();
            String sql = "SELECT * FROM ca_marks ";
            PreparedStatement ps = con.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            
            
            
            while(rs.next()){
                CAmarks ca = new CAmarks();
                
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
