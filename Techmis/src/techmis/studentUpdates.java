/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package techmis;

/**
 *
 * @author User
 */
public class studentUpdates extends studentUpdateDAOimp{
    private String stu_id;
    private String stu_name;
    private String stu_address;
    private String stu_email;
    private String stu_b_day;
    private int stu_p_no;

    public String getStu_id() {
        return stu_id;
    }

    public void setStu_id(String stu_id) {
        this.stu_id = stu_id;
    }

    public String getStu_name() {
        return stu_name;
    }

    public void setStu_name(String stu_name) {
        this.stu_name = stu_name;
    }

    public String getStu_address() {
        return stu_address;
    }

    public void setStu_address(String stu_address) {
        this.stu_address = stu_address;
    }

    public String getStu_email() {
        return stu_email;
    }

    public void setStu_email(String stu_email) {
        this.stu_email = stu_email;
    }

    public String getStu_b_day() {
        return stu_b_day;
    }

    public void setStu_b_day(String stu_b_day) {
        this.stu_b_day = stu_b_day;
    }

    public int getStu_p_no() {
        return stu_p_no;
    }

    public void setStu_p_no(int stu_p_no) {
        this.stu_p_no = stu_p_no;
    }
    

    
   
}
