package Library;

import java.awt.event.*;
import java.awt.*;
import javax.swing.*;
import java.sql.*;

public class AddAdmins extends JFrame implements ActionListener
{
    JLabel l1,l2,l3,l4,l5,l6,l7;
    JButton b1,b2;
    JPanel p1,p2;
    Font f,f1;
    JTextField tf1,tf2,tf3,tf4,tf5;
    JPasswordField pf1;
    
    AddAdmins()
    {
       super("Add Admins");
       setLocation(450,400);
       setSize(650,400);
       
       f=new Font("Arial",Font.BOLD,25);
       f1=new Font("Arial",Font.BOLD,20);
       
       l1=new JLabel("Admin Details");
       l2=new JLabel("Name");
       l3=new JLabel("Password");
       l4=new JLabel("Email");
       l5=new JLabel("Contact No.");
       l6=new JLabel("Address");
       l7=new JLabel("City");
       
       tf1=new JTextField();
       tf2=new JTextField();
       tf3=new JTextField();
       tf4=new JTextField();
       tf5=new JTextField();
       
       pf1=new JPasswordField();
       
       l1.setForeground(Color.WHITE);
       l1.setHorizontalAlignment(JLabel.CENTER);
       
       l1.setFont(f);
       l2.setFont(f1);
       l3.setFont(f1);
       l4.setFont(f1);
       l5.setFont(f1);
       l6.setFont(f1);
       l7.setFont(f1);
       
       tf1.setFont(f1);
       tf2.setFont(f1);
       tf3.setFont(f1);
       tf4.setFont(f1);
       tf5.setFont(f1);
       
       pf1.setFont(f1);
       
       b1=new JButton("Add Admin");
       b2=new JButton("Cancel");
       
       b1.setFont(f1);
       b2.setFont(f1);
       
       b1.addActionListener(this);
       b2.addActionListener(this);
       
       p1=new JPanel();
       p1.setLayout(new GridLayout(1,1,10,10));
       p1.add(l1);
       p1.setBackground(Color.BLUE);
       
       p2=new JPanel();
       p2.setLayout(new GridLayout(7,2,10,10));
       
       p2.add(l2);
       p2.add(tf1);
       p2.add(l3);
       p2.add(pf1);
       p2.add(l4);
       p2.add(tf2);
       p2.add(l5);
       p2.add(tf3);
       p2.add(l6);
       p2.add(tf4);
       p2.add(l7);
       p2.add(tf5);
       p2.add(b1);
       p2.add(b2);
       
       setLayout(new BorderLayout(10,10));
       add(p1,"North");
       add(p2,"Center");
    }
    
   public void actionPerformed(ActionEvent e)
    {
        String name=tf1.getText();
        String password=pf1.getText();
        String email=tf2.getText();
        String contact=tf3.getText();
        String address=tf4.getText();
        String city=tf5.getText();
        
        if(e.getSource()==b1)
        {
           try
           {
               ConnectionClass obj=new ConnectionClass();
               String q="insert into admdetails(name,password,email,contact,address,city) values('"+name+"','"+password+"','"+email+"','"+contact+"','"+address+"','"+city+"')";
               int aa=obj.sta.executeUpdate(q);
               
               if(aa==1)
               {
                   JOptionPane.showMessageDialog(null, "Data Added Successfully!!!");
                   this.setVisible(false);
                          
               }
               else
               {
                   JOptionPane.showMessageDialog(null, "Error Occured!!!");
                   this.setVisible(true);  
               }
               
           }
           catch(Exception ee)
           {
               ee.printStackTrace();
           }
        }
        
        if(e.getSource()==b2)
        {
            this.setVisible(false);  
        }
    }
   
    public static void main(String args[])
    {
        new AddAdmins().setVisible(true);
    }
}
