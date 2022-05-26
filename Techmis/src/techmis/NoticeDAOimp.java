package techmis;


import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;
import techmis.Lecturer;
import techmis.LecturerDB;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author MSI
 */
public class NoticeDAOimp {
    public List<Notice> list() {
        List<Notice> list = new ArrayList<Notice>();
        try {
            Connection con = LecturerDB.getConnection();
            String sql = "SELECT * FROM notice ";
            PreparedStatement ps = con.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            
            
            
            while(rs.next()){
                Notice notice = new Notice();
                notice.setNoticeID(rs.getInt("notice_id"));
                notice.setNoticeDate(rs.getString("date"));
                notice.setNoticeTitle(rs.getString("title"));
                notice.setNotice(rs.getString("notice"));

 
                list.add(notice);
            }
            
        } catch (Exception e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(null, "Error");
        }
        return list;
    }
}
