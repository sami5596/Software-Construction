package lab03;

import java.text.SimpleDateFormat;
import java.util.*;

public class Restaurant {
    private final ELTable eltable;
    private final LTable[] ltable;
    private final MTable[] mtable;
    private final STable[] stable;
    
    private final int openTime;
    private final int closeTime;   
    
    HashMap <Table, Booking> ST;
    HashMap <Table, Booking> MT;
    HashMap <Table, Booking> LT;
    HashMap <Table, Booking> ELT;
    
    Restaurant(){
        openTime = 1100;
        closeTime = 2200;
        
        this.ltable = new LTable[3];
        this.mtable = new MTable[8];
        this.stable = new STable[4];
        for (int i = 0; i < 3; i++){
            ltable[i] = new LTable();
        }
        for (int i = 0; i < 8; i++){
            mtable[i] = new MTable();
        }
        for (int i = 0; i < 4; i++){
            stable[i] = new STable();
        }
        eltable = ELTable.getInstance();
        
        
        
        this.ST = new HashMap<>();
        this.MT = new HashMap<>();
        this.LT = new HashMap<>();
        this.ELT = new HashMap<>();
        
    }
    
    public void Order(){
        int scounter = 0, mcounter = 0, lcounter = 0, elcounter = 0;
        int opt = 0;
        int noGuests = 0;
        String time;
        String date;
        int Time;
        int Date;
        String cname = "";
        Scanner userIn = new Scanner(System.in);
            while(opt != 6){
                System.out.println("1. Make Reservation");
                opt = userIn.nextInt();
                if(opt == 1){
                    System.out.println("Enter your name to store reservation");
                    cname = userIn.next();
                    
                    System.out.println("Enter Number of Guests");
                    noGuests = userIn.nextInt();
                    
                    System.out.println("Enter date in format: dd/MM/yy");
                    date = userIn.next();
                    String[] tokens1 = date.split("/");
                    date = tokens1[0] + tokens1[1] + tokens1[2];
                    Date = Integer.parseInt(date);
                    
                    System.out.println("Enter time in format: HH:mm");
                    time = userIn.next();
                    String[] tokens2 = time.split(":");
                    time = tokens2[0] + tokens2[1];                     
                    Time = Integer.parseInt(time);
                    
                    if(noGuests <= 2 && noGuests > 0 && Time >= openTime && Time <= (closeTime - 100)){
                        
                        if(scounter != 4){
                            Booking B = new Booking(cname, noGuests, Time, Date);
                            ST.put(stable[scounter], B);
                            scounter++;
                        }
                        else{
                            System.out.println("Sorry, No more tables at this time");
                        }
                    }
                    else if(noGuests <= 4 && Time >= openTime && Time <= (closeTime - 100)){
                        if(mcounter != 8){
                        Booking B = new Booking(cname, noGuests, Time, Date);
                        MT.put(mtable[mcounter], B);
                        mcounter++;
                        }
                        else{
                            System.out.println("Sorry, No more tables at this time");
                        }
                    }
                    else if(noGuests <= 6 && Time >= openTime && Time <= (closeTime - 100)){
                        if (lcounter != 3){
                        Booking B = new Booking(cname, noGuests, Time, Date);
                        LT.put(ltable[lcounter], B);
                        lcounter++;
                        }
                        else{
                            System.out.println("Sorry, No more tables at this time");
                        }
                    }
                    else if(noGuests <= 12){
                        if(elcounter != 1){
                        Booking B = new Booking(cname, noGuests, Time, Date);
                        ELT.put(eltable, B);
                        elcounter++;
                        }
                        else{
                            System.out.println("Sorry, No more tables at this time");
                        }    
                    }
                    else{
                        System.out.println("We are sorry we don't have table with that capacity OR we are not open at the specified time");
                    }
                    
                    
                    Set set = ST.entrySet();  
                    Iterator i = set.iterator();  
                    while(i.hasNext()) {
                        Map.Entry me = (Map.Entry)i.next();
                        Booking test = (Booking) me.getValue();
                        System.out.println(test.getId() + " " + test.getCname() + " " + test.getBtime() + " " + test.getBdate());
                    }
                }
                else if(opt == 6){
                    System.exit(0);
                }
            }
    }    
    
    
}
