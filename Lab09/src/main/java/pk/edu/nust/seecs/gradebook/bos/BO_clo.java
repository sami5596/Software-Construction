
package main.java.pk.edu.nust.seecs.gradebook.bos;

import main.java.pk.edu.nust.seecs.gradebook.dao.CloDao;
import main.java.pk.edu.nust.seecs.gradebook.entity.Clo;

public class BO_clo {
    private CloDao clodao;
    
    public void addClo(Clo clo){
        clodao.addClo(clo);
    }
    
    public void updateClo(Clo clo){
        clodao.updateClo(clo);
    }
    
    public void deleteClo(int cloid){
        clodao.deleteClo(cloid);
    }

    public CloDao getClodao() {
        return clodao;
    }

    public void setClodao(CloDao clodao) {
        this.clodao = clodao;
    }
}
