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
public class LecturerDAOimp implements LecturerDAO{

    @Override
    public void save(Lecturer lecturer ) {
          try {
            Connection con =  LecturerDB.getConnection();
            String sql = "INSERT INTO lecturer(lec_id,lec_dept_id,lec_name,lec_address,lec_email,lec_dob,lec_p_no,gender,lec_position) VALUES (?,?,?,?,?,?,?,?,?)";
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setString(1, lecturer.getLec_id());
            ps.setString(2, lecturer.getLec_dept_id());
            ps.setString(3, lecturer.getLec_name());
            ps.setString(4, lecturer.getLec_address());
            ps.setString(5, lecturer.getLec_email());
            ps.setString(6, lecturer.getLec_dob());
            ps.setInt(7, lecturer.getLec_p_no());
            ps.setString(8, lecturer.getGender()); 
            ps.setString(9, lecturer.getLec_position());
            ps.executeUpdate();
            JOptionPane.showMessageDialog(null, "Saved!");
        } catch (Exception e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(null, "Error");
        }
    }

    @Override
    public void update(Lecturer lecturer) {
        
         try {
          
            Connection con = LecturerDB.getConnection();
            String sql = "UPDATE lecturer SET lec_id=?,lec_dept_id=?,lec_name=?,lec_address=?,lec_email=?,lec_dob=?,lec_p_no=?,gender=?,lec_position=? WHERE lec_id=?";
            
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setString(1, lecturer.getLec_id());
            ps.setString(2, lecturer.getLec_dept_id());
            ps.setString(3, lecturer.getLec_name());
            ps.setString(4, lecturer.getLec_address());
            ps.setString(5, lecturer.getLec_email());
            ps.setString(6, lecturer.getLec_dob());
            ps.setInt(7, lecturer.getLec_p_no());
            ps.setString(8, lecturer.getGender());
            ps.setString(9, lecturer.getLec_position());
            ps.setString(10, lecturer.getLec_id());
            ps.executeUpdate();
  
        
            JOptionPane.showMessageDialog(null, "Updated!");
        } catch (Exception e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(null, "Error");
        }
        
    }

    @Override
    public void delete(Lecturer lecturer) {
        
        try {
          
            Connection con = LecturerDB.getConnection();
            String sql = "delete from lecturer  WHERE lec_id=?";
            PreparedStatement ps = con.prepareStatement(sql);  
            ps.setString(1, lecturer.getLec_id());
            ps.executeUpdate();
            JOptionPane.showMessageDialog(null, "Deleteddd!");
        } catch (Exception e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(null, "Error");
        }
        
    }

    @Override
    public Lecturer get(String lect_id) {
       
          Lecturer lec = new Lecturer();
        try {
            Connection con = LecturerDB.getConnection();
            String sql = "SELECT * FROM lecturer WHERE lec_id=?";
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setString(1, lect_id);
            ResultSet rs = ps.executeQuery();
            if(rs.next()){
                
                lec.setLec_id(rs.getString("lec_id"));
                lec.setLec_dept_id(rs.getString("lec_dept_id"));
                lec.setLec_name(rs.getString("lec_name"));
                lec.setLec_address(rs.getString("lec_address"));
                lec.setLec_email(rs.getString("lec_email"));
                lec.setLec_dob(rs.getString("lec_dob"));
                lec.setLec_p_no(rs.getInt("lec_p_no"));
                lec.setGender(rs.getString("gender"));
                lec.setLec_position(rs.getString("lec_position"));
            }
            
        } catch (Exception e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(null, "Error");
        }
        return lec;
        
    }

    @Override
    public List<Lecturer> list() {
        List<Lecturer> list = new ArrayList<Lecturer>();
        try {
            Connection con = LecturerDB.getConnection();
            String sql = "SELECT * FROM lecturer ";
            PreparedStatement ps = con.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            
            
            
            while(rs.next()){
                Lecturer lec = new Lecturer();
                lec.setLec_id(rs.getString("lec_id"));
                lec.setLec_dept_id(rs.getString("lec_dept_id"));
                lec.setLec_name(rs.getString("lec_name"));
                lec.setLec_address(rs.getString("lec_address"));
                lec.setLec_email(rs.getString("lec_email"));
                lec.setLec_dob(rs.getString("lec_dob"));
                lec.setLec_p_no(rs.getInt("lec_p_no"));
                lec.setGender(rs.getString("gender"));
                lec.setLec_position(rs.getString("lec_position"));
 
                list.add(lec);
            }
            
        } catch (Exception e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(null, "Error");
        }
        return list;
    }

    
}

