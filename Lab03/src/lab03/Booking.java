package lab03;

        
public class Booking {
    private int noGuests;
    private int Btime;
    private int Bdate;
    private String cname;
    private int Bid;
    private static int counter = 0;
    
    Booking(String name, int guests, int time, int date){
        this.cname = name;
        this.noGuests = guests;
        this.Btime = time;
        this.Bdate = date;
        this.Bid = counter++;
    }
    
    public int getId(){
        return Bid;
    }
    
    public int getBtime(){
        return Btime;
    }
    
    public int getBdate(){
        return Bdate;
    }
    
    public String getCname(){
        return cname;
    }
    
    public int getGuests(){
        return noGuests;
    }
}
