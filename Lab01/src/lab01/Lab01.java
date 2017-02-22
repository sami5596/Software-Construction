/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lab01;
import java.util.Scanner;
/**
 *
 * @author mbelal.bese14seecs
 */
class Channel{
        private String value;
        private Channel nextChannel;
        private String description;
        
        public Channel()
        {
            value = null;
            nextChannel = null;
            description = null;
        }				//end constructor
  
        public Channel(String value, Channel newChannel, String d)
        {
            this.value = value;
            this.nextChannel = newChannel;
            this.description = d;
        }	
        
        public void SetNChannel(Channel C){
            nextChannel = C;
        }
        
        public Channel GetNChannel(){
            return nextChannel;
        }
        
        public void SetData(String Val, String d){
            value = Val;
            description = d;
        }
        
        public String GetValue(){
            return value;
        }
        
        public String GetDescription(){
            return description;
        }
    }

    
class TVManager{
        protected Channel start;
        protected Channel end ;
        public int size ;
        
        public TVManager(){
            start = null;
            end = null;
            size = 0;
        }
        
        void addChannel(String value, String d){
            Channel Cptr = new Channel(value ,null, d);              
            if(start == null) 
            {
                start = Cptr;
                end = start;
            }
            else 
            {
                end.SetNChannel(Cptr);
                end = Cptr;
            }
            size++;  
        }
        
        void replaceChannel(String Nvalue, String Ovalue, String d){               
            
            Channel ptr = start;
            for (int i = 1; i < size; i++) 
            {
                if (ptr.GetValue().equals(Ovalue)) 
                {
                    ptr.SetData(Nvalue, d);
                    break;
                }
                ptr = ptr.GetNChannel();
            }
        }
        
        void deleteChannel(String Path){
            Channel ptr = start;
            if (ptr.GetValue().equals(Path)){
                ptr = ptr.GetNChannel(); 
                size--;
                return;
            }
            for (int i = 1; i < size - 1; i++) 
            {
                if ((ptr.GetNChannel()).GetValue().equals(Path)) 
                {
                    ptr.SetNChannel((ptr.GetNChannel()).GetNChannel());
                    break;
                }
                ptr = ptr.GetNChannel();
            }
            size--;        
        }
        
        void printChannel(){
            System.out.print("\nPrinting Description for each channel\n\n");
            if (size == 0) 
            {
                System.out.print("Linked List Empty\n");
                return;
            }    
            if (start.GetNChannel() == null) 
            {
                System.out.println(start.GetDescription());
                System.out.println("\n");
                return;
            }
            Channel ptr = start;
            while (ptr.GetNChannel() != null)
            {
                System.out.println(ptr.GetValue() + "\n");
                System.out.print(ptr.GetDescription()+ "\n\n\n");
                ptr = ptr.GetNChannel();
            }
            System.out.println(ptr.GetValue() + "\n");
            System.out.print(ptr.GetDescription()+ "\n\n\n");
        }
        
    }

public class Lab01 {    
    
    public static void main(String[] args) {
        int opt = 0;
        Scanner sc = new Scanner(System.in);
        String val;
        String d;
        String oval;
        TVManager tv = new TVManager();
        while(opt != 5){     
            System.out.println("1. Add Channel\n");
            System.out.println("2. Replace Channel\n");
            System.out.println("3. Delete Channel\n");
            System.out.println("4. Print Channels Description\n");
            System.out.println("5. Exit");       
            System.out.println("Enter Option: ");
            opt = sc.nextInt();
            if(opt == 1){
                System.out.println("Enter New Path: ");
                val = sc.next();
                System.out.println("Enter New Description: ");
                d = sc.next();
                tv.addChannel(val, d);
            }
            else if(opt == 2){
                System.out.println("Enter New Path: ");
                val = sc.next();
                System.out.println("Enter New Description: ");
                d = sc.next();
                System.out.println("Enter Old Path: ");
                oval = sc.next();
                tv.replaceChannel(val, oval, d);
            }
            else if(opt == 3){
                System.out.println("Enter Path to delete: ");
                val = sc.next();
                tv.deleteChannel(val);
            }
            else if(opt == 4){
                tv.printChannel();
            }
            else{
                System.out.println("Invalid Entry! Try Again! \n");
            }
        }
    }    
}
