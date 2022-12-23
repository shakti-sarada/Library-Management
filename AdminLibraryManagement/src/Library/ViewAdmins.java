package Library;

import java.awt.event.*;
import java.awt.*;
import javax.swing.*;
import java.sql.*;

public class ViewAdmins extends JFrame 
{
    String x[]={"Id","Name","Password","Email","Contact","Address","City"};
    JButton b1;
    String y[][]=new String[20][7];
    int i=0,j=0;
    JTable t;
    Font f1;
    
    ViewAdmins()
    {
       super("Admin Informations");
       setLocation(1,1);
       setSize(1000,400); 
       
       f1=new Font("Arial",Font.PLAIN,14);
       
       try
       {
          ConnectionClass obj=new ConnectionClass();
          String q="select * from admdetails";
          ResultSet rest=obj.sta.executeQuery(q);
          while(rest.next())
          {
              y[i][j++]=rest.getString("Lid");
              y[i][j++]=rest.getString("Name");
              y[i][j++]=rest.getString("Password");
              y[i][j++]=rest.getString("Email");
              y[i][j++]=rest.getString("Contact");
              y[i][j++]=rest.getString("Address");
              y[i][j++]=rest.getString("City");
              i++;
              j=0;
              
          }
          t=new JTable(y,x);
          t.setFont(f1);
       }
       catch(Exception ee)
       {
           ee.printStackTrace();
       }
       JScrollPane sp=new JScrollPane(t);
       add(sp);
    }
    
    public static void main(String args[])
    {
        new ViewAdmins().setVisible(true);
    }
}
