package Library;

import java.sql.*;
public class ConnectionClass {
    Connection con;
    Statement sta;
    
    ConnectionClass(){
        try{
            Class.forName("com.mysql.cj.jdbc.Driver");
            con=DriverManager.getConnection("jdbc:mysql://localhost:3306/Admin","root","");
            sta=con.createStatement();
            if(con.isClosed()){
                System.out.println("Not Connected");
            }
            else
            {
                System.out.println("Connected");
            }
                
        }
        catch(Exception e){
            e.printStackTrace();
        }
    }
    public static void main(String args[]){
        new ConnectionClass();
    }
}
