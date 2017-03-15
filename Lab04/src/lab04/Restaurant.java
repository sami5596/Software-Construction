package lab04;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.*;

//restaurant class
public class Restaurant {   
    List reservation;
    int OpenTime;
    int CloseTime;
    Connection con;
    Statement stmt;
    ResultSet rs;
    
    //constructor class
    Restaurant(){
        reservation = new LinkedList();
        OpenTime = 1100;
        CloseTime = 2200;
        try{
            con = DriverManager.getConnection("jdbc:derby://localhost:1527/RRS", "root", "root");
        }
        catch(SQLException err){
            System.out.println(err.getMessage());
        }
    }
    
    //booking class
    void Booking(){
        String N;
        String T;
        String tmp1;
        String tmp2;
        int tmp3;
        int G;
        int choice = 0;
        Scanner In = new Scanner(System.in);
        while (choice != -1){
            System.out.println("Note: Every Table is booked for an hour & can only be booked at whole hour times.");
            System.out.println("1. Make Reservation.");
            System.out.println("2. Remove Reservation.");
            System.out.println("3. Register user.");
            System.out.println("4. -1 to Exit");
            choice = In.nextInt();
            
            //taking booking details
            if (choice == 1){
                String user;
                String pass;
                System.out.println("1. Enter username:");
                user = In.nextLine();
                user = In.nextLine();
                System.out.println("2. Enter password:");
                pass = In.nextLine();
                                
                try{
                    stmt = con.createStatement();
                    String SQL = "SELECT username, password FROM Employee WHERE username = '" +user+ "' and password = '"+pass+"'";
                    rs = stmt.executeQuery(SQL);                     
                    if(rs.next() == false){ 
                        System.out.println("You are Verified!");
                        System.out.println("Enter Your Name:");
                        N = In.nextLine();
                        N = In.nextLine();
                        System.out.println("Enter reservation time and date in format (24h format): DD/MM/YYYY HH:MM:");
                        T = In.nextLine();
                        System.out.println("Enter number of guests:");
                        G = In.nextInt();
                
                        String[] tokens1 = T.split(" ");
                        tmp1 = tokens1[1];
                        String[] tokens2 = tmp1.split(":");
                        tmp2 = tokens2[0] + tokens2[1];
                        tmp3 = Integer.parseInt(tmp2);
                
                        //check opening and closing time
                        if(tmp3 >= OpenTime && tmp3 <= (CloseTime - 100) && G <= 6){
                            //checks availability
                            if(CheckAvailability(T, G) == true){
                                Reservation R = new Reservation(N, G, T);
                                reservation.add(R);
                                System.out.println("Reservation made successfully");
                            }
                            else{
                            System.out.println("Sorry, we don't have open reservations at the given time");
                            }
                        }
                        else{
                            System.out.println("Sorry we're closed at the mentioned time");
                        }
                    }
                }              
                catch(SQLException err){
                    System.out.println("Sorry, you are not Registered");
                    System.out.println(err.getMessage());
                }
            }
            else if(choice == 2){
                //entering details
                System.out.println("Enter Your Name:");
                N = In.nextLine();
                N = In.nextLine();
                System.out.println("Enter reservation time and date in format (24h format): DD/MM/YYYY HH:MM:");
                T = In.nextLine();
                System.out.println("Enter number of guests:");
                G = In.nextInt();
                
                //checking and removing reservations
                if(RemoveReservation(N, T, G)==true){
                    System.out.println("Reservation removed.");
                }
                else{
                    System.out.println("Reservation does not exists.");
                }
            }
            else if(choice == 3){
                String fname;
                String lname;
                String username;
                String password;
                int mobile;
                System.out.println("1. Enter First Name.");
                fname = In.nextLine();
                fname = In.nextLine();
                System.out.println("2. Enter Last Name.");
                lname = In.nextLine();
                System.out.println("3. Enter Username.");
                username = In.nextLine();
                System.out.println("4. Enter Password.");
                password = In.nextLine();
                System.out.println("5. Enter Mobile Number.");
                mobile = In.nextInt();
                try{
                    stmt = con.createStatement();
                    String SQL = "INSERT INTO Customer (fname, lname, username, password, mobile) VALUES ('"+fname+"', '"+lname+"', '"+username+"', '"+password+"', "+mobile+")";
                    stmt.executeUpdate(SQL);
                    System.out.println("User Successfully Registered!");
                }
                catch(SQLException err){
                    System.out.println(err.getMessage());
                }
            }
            else if(choice == -1){
                System.exit(0);
            }
        }
        
    }
    
    
    //checking function
    boolean CheckAvailability(String t, int g){
        int scounter = 0;
        int mcounter = 0;
        int lcounter = 0;
        int elcounter = 0;
        
        String tmp1;
        String tmp2;
        int tmp3;
        String tmp4;
        String tmp5;
        int tmp6;
        //taking time as integer
        String[] tokens1 = t.split(" ");
        tmp1 = tokens1[1];
        String[] tokens2 = tmp1.split(":");
        tmp2 = tokens2[0] + tokens2[1];
        tmp3 = Integer.parseInt(tmp2);
        
        Iterator iterator = reservation.iterator();
        while(iterator.hasNext()) {     
            Reservation tmp = (Reservation) iterator.next();
            
            //taking time as integer
            String[] tokens3 = (tmp.getTime()).split(" ");
            tmp4 = tokens3[1];
            String[] tokens4 = tmp1.split(":");
            tmp5 = tokens4[0] + tokens4[1];
            tmp6 = Integer.parseInt(tmp2);
            
            //check if table for two is booked at the given time
            if(g <= 2 && g > 0 ){
                if((tmp.getTime()).equals(t) && tmp.getGuests() <= g && ((tmp3 >= tmp6 + 100 || tmp3 <= tmp6 - 100) && scounter < 4)){
                    scounter++;
                }
            }
            //check if table for four is booked at the given time
            else if(g <= 4){
                if((tmp.getTime()).equals(t) && tmp.getGuests() <= g && ((tmp3 >= tmp6 + 100 || tmp3 <= tmp6 - 100) && mcounter < 8)){
                    mcounter++;
                }
            }
            //check if table for six is booked at the given time
            else if(g <= 6){
                if((tmp.getTime()).equals(t) && tmp.getGuests() <= g && ((tmp3 >= tmp6 + 100 || tmp3 <= tmp6 - 100) && lcounter < 3)){
                    lcounter++;
                }
            }
            //check if table for twelve is booked at the given time
            else if(g <= 12){
                if((tmp.getTime()).equals(t) && tmp.getGuests() <= g && ((tmp3 >= tmp6 + 100 || tmp3 <= tmp6 - 100) && elcounter < 1)){
                    elcounter++;
                }
            }
        }
        //return statements if table is available or not
        if(g <= 2 && g > 0){
            if(scounter >= 4){
                return false;
            }
            else{
                return true;
            }
        }
        else if(g <= 4){
            if(mcounter >= 8){
                return false;
            }
            else{
                return true;
            }
        }
        else if(g <= 6){
            if(lcounter >= 3){
                return false;
            }
            else{
                return true;
            }
        }
        else if(g <= 12){
            if(elcounter >= 1){
                return false;
            }
            else{
                return true;
            }
        }
        return true;
    }
    
    //removing reservation from linked list
    boolean RemoveReservation(String name, String time, int guests){
        Iterator iterator = reservation.iterator();
        while(iterator.hasNext()) { 
            Reservation tmp = (Reservation) iterator.next();
            if((tmp.getName()).equals(name) && (tmp.getTime()).equals(time) && (tmp.getGuests() == guests)){
                reservation.remove(tmp);
                return true;
            }
        }
        return false;
    }
    
    
}
