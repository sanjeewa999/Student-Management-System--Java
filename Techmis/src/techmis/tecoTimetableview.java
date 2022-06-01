/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package techmis;

/**
 *
 * @author MSI
 */
public class tecoTimetableview {
    
    private int t_id;
    private String t_dep_id;
    private String t_level;
    private String t_semester;
    private String t_date;
    private String t_coursename;
    private String t_start;
    private String t_end;
    private String t_loc;
    private String t_type;

    public int getTimetableid() {
        return t_id;
    }

    public void setTimetableid(int t_id) {
        this.t_id = t_id;
    }

    public String getTimetabledepid() {
        return t_dep_id;
    }

    public void setTimetabledepid(String t_dep_id) {
        this.t_dep_id = t_dep_id;
    }

    public String getTimetablelevel() {
        return t_level;
    }

    public void setTimetablelevel(String t_level) {
        this.t_level = t_level;
    }

    public String getTimetablesemester() {
        return t_semester;
    }

    public void setTimetablesemester(String t_semester ) {
        this.t_semester = t_semester;
    }

    public String getTimetabledate() {
        return t_date;
    }

    
    public void setTimetabledate(String t_date ) {
        this.t_date = t_date;
    }
    
    public String getTimetablecoursename() {
        return t_coursename;
    }

    
    public void setTimetablecoursename(String t_coursename ) {
        this.t_coursename = t_coursename;
    }
    
    public String getTimetablestart() {
        return t_start;
    }

    
    public void setTimetablestart(String t_start ) {
        this.t_start = t_start;
    }
    
    public String getTimetableend() {
        return t_end;
    }

    
    public void setTimetableend(String t_end) {
        this.t_end = t_end;
    }
    
    public String getTimetableloc() {
        return t_loc;
    }

    
    public void setTimetableloc(String t_loc) {
        this.t_loc = t_loc;
    }
    
    public String getTimetabletype() {
        return t_type;
    }

    
    public void setTimetabletype(String t_type) {
        this.t_type = t_type;
    }
    
    
    
}
