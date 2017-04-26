package main.java.pk.edu.nust.seecs.gradebook.bos;

import main.java.pk.edu.nust.seecs.gradebook.dao.TeacherDao;
import main.java.pk.edu.nust.seecs.gradebook.entity.Teacher;

public class BO_teacher {
    
    private TeacherDao teacherdao;
    
    
    public TeacherDao getTeacherdao() {
        return teacherdao;
    }

    public void setTeacherdao(TeacherDao teacherdao) {
        this.teacherdao = teacherdao;
    } 
    
     public void addTeacher(Teacher teacher){
        teacherdao.addTeacher(teacher);
    }
    
    
    public void updateTeacher(Teacher teacher){
        teacherdao.updateTeacher(teacher);
    }
    
    
    public void deleteTeacher(int teacherid){
        teacherdao.deleteTeacher(teacherid);
    }
}
