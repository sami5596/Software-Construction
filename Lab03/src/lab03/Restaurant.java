package lab03;


import java.util.*;

//restaurant class
public class Restaurant {   
    List reservation;
    int OpenTime;
    int CloseTime;
    
    //constructor class
    Restaurant(){
        reservation = new LinkedList();
        OpenTime = 1100;
        CloseTime = 2200;
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
            choice = In.nextInt();
            
            //taking booking details
            if (choice == 1){
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
            else if(choice == -1){
                System.exit(0);
            }
        }
        
    }
    
    
    //checking function
    boolean CheckAvailability(String t, int g){
        String time;
        int guests;
        int index;
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
        int index;
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
