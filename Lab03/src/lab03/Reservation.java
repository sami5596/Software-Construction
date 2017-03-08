
package lab03;


public class Reservation {
    String name;
    int guests;
    String time;
    
    Reservation(String N, int G, String t){
        name = N;
        guests = G;
        time = t;
    }
    
    public String getName(){
        return name;
    }
    
    public int getGuests(){
        return guests;
    }
    
    public String getTime(){
        return time;
    }
    
    public void print(){
        System.out.println(this.name);
        System.out.println(this.guests);
        System.out.println(this.time);
    }
    
}
