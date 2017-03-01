package lab03;

import java.text.SimpleDateFormat;
import java.util.Date;


public class ELTable extends Table {
    private static ELTable eltable = new ELTable();
       
    private ELTable(){
        this.capacity = 12;
    }
    
    public static ELTable getInstance(){
      return eltable;
    }
    
    public int getCapacity(){
        return this.capacity;
    }
  
}
