/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lab03;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Sami
 */
public class AvailabilityTest {
    
    public AvailabilityTest() {
            Restaurant R = new Restaurant();
            boolean result;
            result = R.CheckAvailability("02/02/2016" , 2);
            if (result == false){
                System.out.println("Passed");
            }
    
    }
    
}
