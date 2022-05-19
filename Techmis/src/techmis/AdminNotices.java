/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package techmis;

import java.sql.Connection;
import javax.swing.JOptionPane;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Vector;

/**
 *
 * @author ASUS
 */
public class AdminNotices extends DBConnection implements AdminNoticesInterface{
    
    private Integer ID;
    private String date;
    private String title;
    private String notice;
    

    public Integer getID() {    
        return ID;
    }

    public void setID(Integer ID) {
        this.ID = ID;
    }

    public Connection getConn() {
        return conn;
    }

    //getter and setter
    public void setConn(Connection conn) {
        this.conn = conn;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getNotice() {
        return notice;
    }

    public void setNotice(String notice) {
        this.notice = notice;
    }

    
    //Insert function from adminnoticeinterface
    @Override
    public void insert() { //start
      //call connection
        super.connection();
        String sql = "insert into notice(ID, date, title, notice) values (?,?,?,?)";
        try {
            PreparedStatement pst = conn.prepareStatement(sql);
            pst.setInt(1, ID);
            pst.setString(2, date);
            pst.setString(3, title);
            pst.setString(4, notice);
            pst.executeUpdate();
            pst.close();
            message("Successfully added");
        } catch (Exception e) {
            message(e.getMessage());
        }
    }//end

    @Override
    public void update() {
        //call connection
        super.connection();
        String sql = "update notice set (date=?, title=?, notice=? " + "where notice_id=?";
        try {
            PreparedStatement pst = conn.prepareStatement(sql);
            pst.setString(1, date);
            pst.setString(2, title);
            pst.setString(3, notice);
            pst.setInt(4, ID);
            pst.executeUpdate();
            pst.close();
            message("Successfully updated");
        } catch (Exception e) {
            message(e.getMessage());
        }
    }

    @Override
    public void delete() {
        //call connection
        super.connection();
        String sql = "delete from notice where notice_id = ?";
        try {
            PreparedStatement pst = conn.prepareStatement(sql);
            
            pst.setInt(1, ID);
            pst.executeUpdate();
            pst.close();
            message("Successfully deleted");
        } catch (Exception e) {
            message(e.getMessage());
        }
    }

    @Override
    public void loadlist() { //start class
        //set new vector values
        this.setData(new Vector());
        super.connection();
        byte rowCounter = 0;
        String sql = "select * from notice";
        try {
            PreparedStatement pst = conn.prepareStatement(sql);
            ResultSet rs = pst.executeQuery();
            
            while(rs.next()){ //start while
                rowCounter++;
                //byte_notice_id = rs.getByte("");
                Integer ID; = rs.getInt("ID");
                String date; = rs.getString("date");
                String title; = rs.getString("title");
                String notice; = re.getString("notice");
                
                Vector row = new Vector();
                row.add(" "+rowCounter+".");
                row.add(ID);
                row.add(date);
                row.add(title);
                row.add(notice);
                this.getData().add(row);
            }//end while
            
            rs.close();
            pst.close();
            
        } catch (Exception e) {
            message(e.getMessage());
        }
    }

    @Override
    public void notices() {
        super.connection();
        byte rowCounter = 0;
        String sql = "select * from notice where notice_id = " + ID;
        try {
            PreparedStatement pst = conn.prepareStatement(sql);
            ResultSet rs = pst.executeQuery();
            
            if(rs.next()){ //start while
                rowCounter++;
                //byte_notice_id = rs.getByte("");
                Integer ID; = rs.getInt("ID");
                String date; = rs.getString("date");
                String title; = rs.getString("title");
                String notice; = re.getString("notice");
                
              //set the values
              this.setId(ID);
              this.setDate(date);
              this.setTitle(title);
              this.setNotice(notice);
            }//end while
            
            rs.close();
            pst.close();
            
        } catch (Exception e) {
            message(e.getMessage());
        }
    }

    @Override
    public void search() {
        this.setData(new Vector());
        super.connection();
        byte rowCounter = 0;
        String sql = "select * from notice where name like '%"++"%'";
        try {
            PreparedStatement pst = conn.prepareStatement(sql);
            ResultSet rs = pst.executeQuery();
            
            while(rs.next()){ //start while
                rowCounter++;
                //byte_notice_id = rs.getByte("");
                Integer ID; = rs.getInt("ID");
                String date; = rs.getString("date");
                String title; = rs.getString("title");
                String notice; = re.getString("notice");
                
                Vector row = new Vector();
                row.add(" "+rowCounter+".");
                row.add(ID);
                row.add(date);
                row.add(title);
                row.add(notice);
                this.getData().add(row);
            }//end while
            
            rs.close();
            pst.close();
            
        } catch (Exception e) {
            message(e.getMessage());
        }
    }
    
    

    //prompt message
    private void message(String message){ //start
        JOptionPane.showMessageDialog(null, message);
    } //end
    
    
    
} //end class
