package main.java.pk.edu.nust.seecs.gradebook.bos;

import main.java.pk.edu.nust.seecs.gradebook.dao.StudentDao;
import main.java.pk.edu.nust.seecs.gradebook.entity.Student;


public class BO_student {
    
    private StudentDao studentdao;
    
    public StudentDao getStudentdao() {
        return studentdao;
    }

    public void setStudentdao(StudentDao studentdao) {
        this.studentdao = studentdao;
    }
    
    public void addStudent(Student student){
        studentdao.addStudent(student);
    }
   
    public void updateStudent(Student student){
        studentdao.updateStudent(student);
    }
    
    public void deleteStudent(int studentid){
        studentdao.deleteStudent(studentid);
    }
}
