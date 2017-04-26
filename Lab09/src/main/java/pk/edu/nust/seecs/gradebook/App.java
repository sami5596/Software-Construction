package main.java.pk.edu.nust.seecs.gradebook;
/*
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
*/
import main.java.pk.edu.nust.seecs.gradebook.bos.BO_clo;
import main.java.pk.edu.nust.seecs.gradebook.bos.BO_content;
import main.java.pk.edu.nust.seecs.gradebook.bos.BO_course;
import main.java.pk.edu.nust.seecs.gradebook.bos.BO_grade;
import main.java.pk.edu.nust.seecs.gradebook.bos.BO_student;
import main.java.pk.edu.nust.seecs.gradebook.bos.BO_teacher;

import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;


public class App {

    public static void main(String[] args) {
        
        ConfigurableApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
	BO_clo Bclo = (BO_clo) context.getBean("boclo");
        BO_content Bcontent = (BO_content) context.getBean("bocontent");
        BO_course Bcourse = (BO_course) context.getBean("bocourse");
        BO_grade Bgrade = (BO_grade) context.getBean("bograde");
        BO_student Bstudent = (BO_student) context.getBean("bostudent");
        BO_teacher Bteacher = (BO_teacher) context.getBean("boteacher");
//CloDao clodao = new CloDao();

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
       // clodao.deleteClo(2);

        // Get all clos
        /*
        for (Clo iter : clodao.getAllClos()) {
            System.out.println(iter);
        }
*/
        // Get clo by id
       // System.out.println(clodao.getCloById(1));        
    }
}