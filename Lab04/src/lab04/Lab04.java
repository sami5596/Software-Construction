package lab04;

import java.sql.Statement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.ResultSet;

public class Lab04 {
    public static void main(String[] args){
        try{
            String host = "jdbc:derby://localhost:1527/RRS";
            String username = "root";
            String password = "root";
            Connection con = DriverManager.getConnection(host, username, password);
            Statement stmt = con.createStatement();
            String SQL = "SELECT * FROM Employee";
            ResultSet rs = stmt.executeQuery(SQL);
            while(rs.next()){
                int id_col = rs.getInt("id");
                String first_name = rs.getString("fname");
                System.out.println(id_col + " " + first_name);
            }
        
        }
        catch(SQLException err){
            System.out.println(err.getMessage());
        }
    Restaurant R = new Restaurant();
    R.Booking();
   }
}
    

