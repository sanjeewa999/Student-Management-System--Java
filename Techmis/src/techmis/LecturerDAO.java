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
public interface LecturerDAO {
    public void save(Lecturer lecturer);
    public void update(Lecturer lecturer);
    public void delete(Lecturer lecturer);
    public Lecturer get(String lect_id);
    public List<Lecturer> list();
}
