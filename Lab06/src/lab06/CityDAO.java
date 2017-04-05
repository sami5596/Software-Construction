package lab06;

import java.util.ArrayList;
import org.hibernate.Session;
import org.hibernate.Transaction;

public class CityDAO {
    public Session currSession = null;
    public CityDAO(){
        HibernateUtil.createSessionFactory();
	currSession = HibernateUtil.getSessionFactory().openSession();  
    }
    
    public void finalize(){
	currSession.close();
    }
    
    public void save(ArrayList<City> cityList){
	Transaction t = currSession.beginTransaction();  
      	for(int i = 0; i < cityList.size(); i++){
            currSession.merge((City)cityList.get(i));
            System.out.println(i);
 	           
        }
        t.commit();  
    }
    
}
