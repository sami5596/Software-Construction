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
public class BookingTest {
    
    public BookingTest() {
    }
    @Test
    public void testgetname(){
        Booking b = new Booking("sami",2,1900,222);
        assertEquals(2, b.getGuests());
    }
    
    
    @Test
    public void testgettime(){
        Booking b1 = new Booking("sami",2,1900,222);
        assertEquals(1900, b1.getBtime());
    }
    
    
    @Test
    public void testgetdate(){
        Booking b2 = new Booking("sami",2,1900,222);
        assertEquals(222, b2.getBdate());
    }
    
}
