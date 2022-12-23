package Library;

import java.awt.event.*;
import java.awt.*;
import javax.swing.*;
import java.sql.*;

public class Admin extends JFrame implements ActionListener
{
    JLabel l1,l2,l3;
    JButton b1,b2;
    JPanel p1,p2;
    Font f,f1;
    JTextField tf1;
    JPasswordField tf2;
    
    Admin()
    {
       super("Admin Login Page");
       setLocation(450,400);
       setSize(500,200);
       
       f=new Font("Arial",Font.BOLD,25);
       f1=new Font("Arial",Font.BOLD,20);
       
       l1=new JLabel("Admin Login");
       l2=new JLabel("Name");
       l3=new JLabel("Password");
       
       b1=new JButton("Login");
       b2=new JButton("Cancel");
       
       b1.addActionListener(this);
       b2.addActionListener(this);
       
       tf1=new JTextField();
       tf2=new JPasswordField();
       
       l1.setFont(f);
       l2.setFont(f1);
       l3.setFont(f1);
       b1.setFont(f1);
       b2.setFont(f1);
       tf1.setFont(f1);
       tf2.setFont(f1);
       
       l1.setHorizontalAlignment(JLabel.CENTER);
       l1.setForeground(Color.WHITE);
       
       p1=new JPanel();
       p1.setLayout(new GridLayout(1,1,10,10));
       p1.add(l1);
       p1.setBackground(Color.CYAN);
       
       p2=new JPanel();
       p2.setLayout(new GridLayout(3,2,10,10));
       
       p2.add(l2);
       p2.add(tf1);
       p2.add(l3);
       p2.add(tf2);
       p2.add(b1);
       p2.add(b2);
       
       setLayout(new BorderLayout(10,10));
       add(p1,"North");
       add(p2,"Center");
       
       
    }
    
    public void actionPerformed(ActionEvent e)
    {
        String name=tf1.getText();
        String password=tf2.getText();
        
        if(e.getSource()==b1)
        {
            try
            {
                ConnectionClass obj=new ConnectionClass();
                String s="select * from admin where username='"+name+"' and password='"+password+"'";
                ResultSet rest=obj.sta.executeQuery(s);
                if(rest.next())
                {
                    new  AdminSection().setVisible(true);
                    this.setVisible(false);
                }
                else
                {
                    JOptionPane.showMessageDialog(null, "Either Name or Password is Incorrect");
                    this.setVisible(false);
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
        new Admin().setVisible(true);
    }
}
