package lab03;

import java.text.SimpleDateFormat;
import java.util.Date;

public class LTable extends Table{
    private int tableID;
    private static int counter = 0;
    LTable(){
        this.capacity = 6;
        this.tableID = counter++;
    }
    public int getCapacity(){
        return this.capacity;
    }
   
}
