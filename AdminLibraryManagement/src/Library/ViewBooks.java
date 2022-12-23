package Library;

import java.awt.event.*;
import java.awt.*;
import javax.swing.*;
import java.sql.*;

public class ViewBooks extends JFrame
{
    
    String x[]={"S.No.","Book Id","Book Name","Author","Publisher","Quantity","Issued","Date"};
    JButton b1;
    String y[][]=new String[20][8];
    int i=0,j=0;
    JTable t;
    Font f1;
    
    ViewBooks()
    {
       super("Book Informations");
       setLocation(1,1);
       setSize(1000,400);
       
       f1=new Font("Arial",Font.PLAIN,14);
       
       try
       {
          ConnectionClass obj=new ConnectionClass();
          String q="select * from bookdetails";
          ResultSet rest=obj.sta.executeQuery(q);
          while(rest.next())
          {
              y[i][j++]=rest.getString("id");
              y[i][j++]=rest.getString("bookid");
              y[i][j++]=rest.getString("bookname");
              y[i][j++]=rest.getString("author");
              y[i][j++]=rest.getString("publisher");
              y[i][j++]=rest.getString("quantity");
              y[i][j++]=rest.getString("issuebook");
              y[i][j++]=rest.getString("date");             
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
        new ViewBooks().setVisible(true);
    }
}
