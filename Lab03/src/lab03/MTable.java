package lab03;

import java.text.SimpleDateFormat;
import java.util.Date;

public class MTable extends Table{
    private static int counter = 0;
    private int tableID;
    MTable(){
        this.capacity = 4;
        this.tableID = counter++;

    }
    public int getCapacity(){
        return this.capacity;
    }
    
}
