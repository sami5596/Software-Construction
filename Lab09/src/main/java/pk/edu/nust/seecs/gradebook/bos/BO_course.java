
package main.java.pk.edu.nust.seecs.gradebook.bos;

import main.java.pk.edu.nust.seecs.gradebook.dao.CourseDao;
import main.java.pk.edu.nust.seecs.gradebook.entity.Course;

public class BO_course {
    
    private CourseDao coursedao;
    public CourseDao getCoursedao() {
        return coursedao;
    }

    public void setCoursedao(CourseDao coursedao) {
        this.coursedao = coursedao;
    }
    public void addCourse(Course course){
        coursedao.addCourse(course);
    }
    
    public void updateCourse(Course course){
        coursedao.updateCourse(course);
    }
    
    public void deleteCourse(int courseid){
        coursedao.deleteCourse(courseid);
    }
}
