/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package techmis;

import java.sql.Connection;
import java.sql.DriverManager;
import javax.swing.JOptionPane;
/**
 *
 * @author ASUS
 */
public class DBConnection { //start class
    
    Connection conn;
    
    //Setter and Getter

    public Connection getConn() {
        return conn;
    }

    public void setConn(Connection conn) {
        this.conn = conn;
    }
    
    //Variables
    private static final String _CONURL_= "jdbc:mysql://localhost/mis";
    private static final String _DRIVER_ = "com.mysql.jdbc.Driver";
    
    //Create connection
    public void connection(){//Starty
        //sync connection
        synchronized (_CONURL_){//start
            try{
                Class.forName(_DRIVER_); //driver
                setConn(DriverManager.getConnection(_CONURL_,"root",""));
                //JOptionPane.showMessageDialog(null, "Connected");
                //System.out.println("Connected");
            }catch(Exception e){
             JOptionPane.showMessageDialog(null, e);
            }
        }//end
    }
    
    public static void main(String[] args) {
        //DBConnection db=new DBConnection();
        //db.connection();
    }
} //end class
