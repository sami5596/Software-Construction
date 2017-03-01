package lab03;

import java.text.SimpleDateFormat;
import java.util.Date;

public class STable extends Table {
    private static int counter = 0;
    private int tableID;
    STable(){
        this.capacity = 2;
        this.tableID = counter++;

    }
    public int getCapacity(){
        return this.capacity;
    }
}
