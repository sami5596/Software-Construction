
package main.java.pk.edu.nust.seecs.gradebook.bos;

import main.java.pk.edu.nust.seecs.gradebook.dao.ContentDao;
import main.java.pk.edu.nust.seecs.gradebook.entity.Content;

public class BO_content {
    
    private ContentDao contentdao;
    
    public ContentDao getContentdao() {
        return contentdao;
    }

    public void setContentdao(ContentDao contentdao) {
        this.contentdao = contentdao;
    }
    public void addContent(Content content){
        contentdao.addContent(content);
    }
    public void updateContent(Content content){
        contentdao.updateContent(content);
    }
    public void deleteContent(int contentid){
        contentdao.deleteContent(contentid);
    }
}
