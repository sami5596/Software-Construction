package main.java.pk.edu.nust.seecs.gradebook;
import java.sql.SQLException;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

import main.java.pk.edu.nust.seecs.gradebook.dao.CloDao;
import main.java.pk.edu.nust.seecs.gradebook.dao.ContentDao;
import main.java.pk.edu.nust.seecs.gradebook.dao.CourseDao;
import main.java.pk.edu.nust.seecs.gradebook.dao.GradeDao;
import main.java.pk.edu.nust.seecs.gradebook.dao.StudentDao;
import main.java.pk.edu.nust.seecs.gradebook.dao.TeacherDao;
import main.java.pk.edu.nust.seecs.gradebook.entity.Clo;
import main.java.pk.edu.nust.seecs.gradebook.entity.Content;
import main.java.pk.edu.nust.seecs.gradebook.entity.Course;
import main.java.pk.edu.nust.seecs.gradebook.entity.Grade;
import main.java.pk.edu.nust.seecs.gradebook.entity.Student;
import main.java.pk.edu.nust.seecs.gradebook.entity.Teacher;

/**
 * My main App. 
 * <p>
 This executes everything.
 */

public class App {

    public static void main(String[] args) {
        Scanner In = new Scanner(System.in);
        String line = "";
        int num;
        CloDao clodao = new CloDao();
        Clo clo = new Clo();
        GradeDao gradedao = new GradeDao();
        Grade grade = new Grade();
        CourseDao coursedao = new CourseDao();
        Course course = new Course();
        TeacherDao teacherdao = new TeacherDao();
        Teacher teacher = new Teacher();
        StudentDao studentdao = new StudentDao();
        Student student = new Student();
        ContentDao contentdao = new ContentDao();
        Content content = new Content();
        
        System.out.println("Enter Student Name:");
        line = In.nextLine();
        student.setName(line);
        System.out.println("Enter Teacher Name:");
        line = In.nextLine();
        teacher.setName(line);
        System.out.println("Enter Grade name then score");
        line = In.nextLine();
        grade.setName(line);
        num = In.nextInt();
        grade.setScore(num);
        System.out.println("Enter Course Title and Credit Hours");
        line = In.next();
        course.setClasstitle(line);
        num = In.nextInt();
        course.setCreditHours(num);
        System.out.println("Enter Content Title then description");
        line = In.next();
        content.setTitle(line);
        line = In.next();
        content.setDescription(line);
        Date date = new Date();        
        content.setStarttime(date);
        System.out.println("Enter CLO name then description then PLO then btlevel");
        line = In.next();
        clo.setName(line);
        line = In.next();
        clo.setDescription(line);
        line = In.next();
        clo.setPlo(line);
        line = In.next();
        clo.setBtLevel(line);
        
        
        teacherdao.addTeacher(teacher);
        teacherdao.updateTeacher(teacher);
        clodao.addClo(clo);
        clodao.updateClo(clo);
        studentdao.addStudent(student);
        studentdao.updateStudent(student);
        course.setTeacher(teacher);
        coursedao.addCourse(course);
        coursedao.updateCourse(course);
        content.setCourse(course);
        contentdao.addContent(content);
        contentdao.updateContent(content);
        grade.setContentItem(content);
        gradedao.addGrade(grade);
        gradedao.updateGrade(grade);
        // Add new clo
        /*
        Clo clo = new Clo();
        clo.setName("CLO 1");
        clo.setDescription("Design efficient solutions for algorithmic problems");
        clo.setPlo("2");
        clodao.addClo(clo);
        clodao.updateClo(clo);
*/
        // Delete an existing clo
        //clodao.deleteClo(4);

        // Get all clos
        for (Clo iter : clodao.getAllClos()) {
            System.out.println(iter);
        }        
    }

}