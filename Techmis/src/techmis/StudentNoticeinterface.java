package techmis;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */


import java.util.List;

/**
 *
 * @author User
 */
public interface StudentNoticeinterface {
    public studentNoticedetails get(String notices_id);
    public List<studentNoticedetails> List();
}
