package techmis;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */


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
public class StudentNoticeimp implements StudentNoticeinterface {
     public List<studentNoticedetails> list() {
        List<studentNoticedetails> list = new ArrayList<studentNoticedetails>();
        try {
            Connection con = LecturerDB.getConnection();
            String sql = "SELECT * FROM notice ";
            PreparedStatement ps = con.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            
            
            
            while(rs.next()){
                studentNoticedetails sn = new studentNoticedetails();
                sn.setNotice_id(rs.getString ("notice_id"));
                sn.setDate(rs.getString("date"));
                sn.setTitle(rs.getString("title"));
                sn.setNotice(rs.getString("notice"));
                
               
                
                list.add(sn);
            }
            
        } catch (Exception e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(null, "Error");
        }
        return list;
    }
     
public studentNoticedetails get(String notices_id) {
       
          studentNoticedetails sn = new studentNoticedetails();
        try {
            Connection con = LecturerDB.getConnection();
            String sql = "SELECT * FROM notice WHERE notice_id=?";
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setString(1, notices_id);
            ResultSet rs = ps.executeQuery();
            if(rs.next()){
                
                sn.setNotice_id(rs.getString("notice_id"));
                sn.setDate(rs.getString("date"));
                sn.setTitle(rs.getString("title"));
                sn.setNotice(rs.getString("notice"));
                
            }
            
        } catch (Exception e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(null, "Error");
        }
        return sn;
        
    }

    @Override
    public List<studentNoticedetails> List() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
}
