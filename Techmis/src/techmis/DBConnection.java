/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package techmis;

import java.sql.*;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author ASUS
 */
public class DBConnection {
    
    public static void main(String[] args){
        
        try {
            
            String url = "jdbc:mysql://localhost:3306/mis";
            String user = "root";
            String pw = "";
            
            Connection myConnection = DriverManager.getConnection(url, user, pw);
            
            if(myConnection != null)
                System.out.println("Connected");
            
            //Statement stmt = myConnection.createStatement();
            
            
            Class.forName("com.mysql.cj.jdbc.Driver");
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(DBConnection.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(DBConnection.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }
}
