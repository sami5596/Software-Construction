/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lab06;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;


public class Lab06 {
    public static void main(String[] args) {
        ArrayList<City> newCities = new ArrayList<City>();        
        BufferedReader br = null;
        try{
            //Reading the csv file
            br = new BufferedReader(new FileReader("GeoLiteCity-Location.csv"));          
            String line = "";
            //Read to skip the header
            br.readLine();
            //Reading from the second line
            while ((line = br.readLine()) != null){
                String[] cityDetails = line.split(",");                
                if(cityDetails.length > 0 ){
                    City c1 = new City(cityDetails[1],cityDetails[2],cityDetails[3],cityDetails[4],
                            cityDetails[5],cityDetails[6]);
                    newCities.add(c1);
                }
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
        CityDAO cDAO = new CityDAO();
        try{
            cDAO.save(newCities);
        }
        finally{
            cDAO.finalize();
        }
    }
    
}
