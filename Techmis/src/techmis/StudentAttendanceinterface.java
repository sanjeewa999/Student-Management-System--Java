/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package techmis;

import java.util.List;

/**
 *
 * @author User
 */
public interface StudentAttendanceinterface {
     public StudentAttendanceDetails get(String stu_id);
     public List<StudentAttendanceDetails> list();
}
