
package lab07;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

public class AuthenticateDAO {
    public Session currSession = null;

    public AuthenticateDAO() {
        HibernateUtil.createSessionFactory();
	currSession = HibernateUtil.getSessionFactory().openSession(); 
    }
    public void finalize(){
	currSession.close();
    }
    
    public void read(){      
        System.out.println("sup");
        BufferedReader br = null;
        try{
            //Reading the csv file
            br = new BufferedReader(new FileReader("test_two-anon.csv"));          
            String line = "";
            //Read to skip the header
            br.readLine();
            br.readLine();
            System.out.println("sup");
             
            //Reading from the third line
            System.out.println("sup");
            while ((line = br.readLine()) != null){
                Transaction t = currSession.beginTransaction(); 
                String[] userDetails = line.split(",");   
                for(int i = 0; i < userDetails.length; i++){
                    userDetails[i] = userDetails[i].replace("\"","");
                }
                for (int i = 0; i < userDetails.length; i++) {
                    if (i > 0) {
                        System.out.print(", ");
                    }
                    System.out.print(userDetails[i]);
                }
               // if(userDetails.length > 0 && userDetails[0].equals("test") && userDetails[3].equals("0") && userDetails[3].equals("0") && userDetails[6].equals("0") && userDetails[9].equals("0") && userDetails[12].equals("0") && userDetails[15].equals("0") && userDetails[18].equals("0") && userDetails[21].equals("0") && userDetails[24].equals("0")){
                    System.out.println("sup");
                    Query q =   currSession.createQuery("update Authenticate set userid=:a,  scheme=:b,  timeTaken=:c,  state=:d,  t1=:e,  s1=:f,  t2=:g,  s2=:h,  t3=:i,  s3=:j,  t4=:k,  s4=:l,  t5=:m,  s5=:n,  t6=:o,  s6=:p,  t7=:q,  s7=:r");
                    q.setParameter("a",userDetails[0]);
                    q.setParameter("b",userDetails[2]);
                    if(userDetails[6].length() > 0){
                    q.setParameter("c",Double.parseDouble(userDetails[3]));
                    }
                    else{
                    q.setParameter("c",0.0);
                    }
                    q.setParameter("d",userDetails[4]);
                    if(userDetails[6].length() > 0){
                    q.setParameter("e",Double.parseDouble(userDetails[6]));
                    }
                    else{
                    q.setParameter("e",0.0);
                    }
                    q.setParameter("f",userDetails[7]);
                    if(userDetails[9].length() > 0){
                    q.setParameter("g",Double.parseDouble(userDetails[9]));
                    }
                    else{
                    q.setParameter("g",0.0);
                    }
                    q.setParameter("h",userDetails[10]);
                    if(userDetails[12].length() > 0){
                    q.setParameter("i",Double.parseDouble(userDetails[12]));
                    }
                    else{
                    q.setParameter("i",0.0);
                    }
                    q.setParameter("j",userDetails[13]);
                    if(userDetails[15].length() > 0){
                    q.setParameter("k",Double.parseDouble(userDetails[15]));
                    }
                    else{
                    q.setParameter("k",0.0);
                    }
                    q.setParameter("l",userDetails[16]);
                    if(userDetails[18].length() > 0){
                    q.setParameter("m",Double.parseDouble(userDetails[18]));
                    }
                    else{
                    q.setParameter("m",0.0);
                    }
                    q.setParameter("n",userDetails[19]);
                    if(userDetails[21].length() > 0){
                    q.setParameter("o",Double.parseDouble(userDetails[21]));
                    }
                    else{
                    q.setParameter("o",0.0);
                    }
                    q.setParameter("p",userDetails[22]);
                    if(userDetails[24].length() > 0){
                    q.setParameter("q",Double.parseDouble(userDetails[24]));
                    }
                    else{
                    q.setParameter("q",0.0);
                    }
                    q.setParameter("r",userDetails[25]);
                    
                    int k = q.executeUpdate();
                    System.out.println(k);
                     t.commit();
                //}
            }
           
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
        
    }
}
