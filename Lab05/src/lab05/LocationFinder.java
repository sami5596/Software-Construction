package lab05;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;

public class LocationFinder {
    Configuration cfg;
    ServiceRegistry serviceRegistry;
    SessionFactory factory;
    
    LocationFinder(){
        cfg = new Configuration();
	cfg.configure("/main/resources/hibernate.cfg.xml");//populates the data of the configuration file  
        serviceRegistry = new StandardServiceRegistryBuilder().applySettings(cfg.getProperties()). build();
        factory = cfg.buildSessionFactory(serviceRegistry);
    }
    
    public void initiate(){ 
		Session session=factory.openSession();  			
                        BufferedReader br = null;
                        try{     //Reading the csv file
                            br = new BufferedReader(new FileReader("GeoLiteCity-Location.csv"));         
                            String line = "";
                            //Read to skip the header
                            br.readLine();
                            //Reading from the second line            
                            while ((line = br.readLine()) != null){
                                String[] cityDetails = line.split(",");                
                                if(cityDetails.length > 0 ){
                                    //Save the city details in city object
                                    Transaction t=session.beginTransaction(); 
                                    City c = new City(Integer.parseInt(cityDetails[0]),
                                    cityDetails[1],cityDetails[2],cityDetails[3], cityDetails[4],
                                    Double.parseDouble(cityDetails[5]),
                                    Double.parseDouble(cityDetails[6]),Integer.parseInt(cityDetails[7]),
                                    Integer.parseInt(cityDetails[8]));
                                    session.persist(c);//persisting the object  
                                    t.commit();//transaction is commited 
                                    //cityList.add(c);
                                }
                            }
            
            //Lets print the Employee List
            //for(City c : cityList)
            //{
            //    System.out.println(c.getLocId()+"   "+c.getCountry()+"   "
            //    		+c.getRegion()+"   "+c.getCity()+"   "+c.getPostalCode()+"   "
            //                    +c.getLatitude()+"   "+c.getLongitude()+"   "/*+c.getMetroCode()+"   "+c.getAreaCode()*/);
            //}
                        }
                        catch(Exception ee){
                            ee.printStackTrace();
                        }
                        finally{
                            try{
                                br.close();
                            }
                            catch(IOException ie){
                                System.out.println("Error occured while closing the BufferedReader");
                                ie.printStackTrace();
                            }
                        }     
                        //Transaction t=session.beginTransaction();  
			//Employee e1=new Employee();  
			//e1.setId(115);  
			//e1.setFirstName("Fahad");  
			//e1.setLastName("Satti");  			 
		session.close();  
	}    
}



