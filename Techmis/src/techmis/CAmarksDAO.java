package techmis;



/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */


import java.util.List;

/**
 *
 * @author CHATHURANGA
 */
public interface CAmarksDAO {
    public void save(CAmarks camarks);
    public void update(CAmarks camarks);
    public void delete(CAmarks camarks);
    public CAmarks get(String stu_id);
    public List<CAmarks> list();
}
