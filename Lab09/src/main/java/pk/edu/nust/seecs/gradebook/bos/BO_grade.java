/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package main.java.pk.edu.nust.seecs.gradebook.bos;

import main.java.pk.edu.nust.seecs.gradebook.dao.GradeDao;
import main.java.pk.edu.nust.seecs.gradebook.entity.Grade;

/**
 *
 * @author Sami
 */
public class BO_grade {
     private GradeDao gradedao;



    

    public GradeDao getGradedao() {
        return gradedao;
    }

    public void setGradedao(GradeDao gradedao) {
        this.gradedao = gradedao;
    }


    
    
    
    public void addGrade(Grade grade){
        gradedao.addGrade(grade);
    }
    
    public void updateGrade(Grade grade){
        gradedao.updateGrade(grade);
    }
    
    
    public void deleteGrade(int gradeid){
        gradedao.deleteGrade(gradeid);
    }
}
