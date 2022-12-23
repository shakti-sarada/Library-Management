package Library;

import java.awt.event.*;
import java.awt.*;
import javax.swing.*;
import java.sql.*;

public class IssueBook extends JFrame implements ActionListener
{
    JLabel l1,l2,l3,l4,l5,l6,l7,l8;
    JButton b1,b2;
    JPanel p1,p2;
    Font f,f1;
    Choice ch;
    JTextField tf1,tf2,tf3,tf4,tf5,tf6;
    
    IssueBook()
    {
       super("Issue Books");
       setLocation(0,0);
       setSize(650,400);
       
       f=new Font("Arial",Font.BOLD,25);
       f1=new Font("Arial",Font.BOLD,20);
       
       l1=new JLabel("Issue Book");
       l2=new JLabel("S.No.");
       l3=new JLabel("Book Id");
       l4=new JLabel("Book Name");
       l5=new JLabel("Admin Id");
       l6=new JLabel("Admin Name");
       l7=new JLabel("Admin Contact");
       l8=new JLabel("Book Quantity");
       
       l1.setHorizontalAlignment(JLabel.CENTER);
       l1.setForeground(Color.WHITE);
       
       tf1=new JTextField();
       tf2=new JTextField();
       tf3=new JTextField();
       tf4=new JTextField();
       tf5=new JTextField();
       tf6=new JTextField();
       
       b1=new JButton("Issue Book");
       b2=new JButton("Cancel");
       
       b1.setFont(f1);
       b2.setFont(f1);
       
       b1.addActionListener(this);
       b2.addActionListener(this);
       
       l1.setFont(f);
       l2.setFont(f1);
       l3.setFont(f1);
       l4.setFont(f1);
       l5.setFont(f1);
       l6.setFont(f1);
       l7.setFont(f1);
       l8.setFont(f1);
       
       tf1.setFont(f1);
       tf2.setFont(f1);
       tf3.setFont(f1);
       tf4.setFont(f1);
       tf5.setFont(f1);
       tf6.setFont(f1);
       tf6.setEditable(false);
       tf6.setForeground(Color.red);
       
       ch=new Choice();
       
       try
       {
           ConnectionClass obj=new ConnectionClass();
           String q="select id from bookdetails";
           ResultSet rest=obj.sta.executeQuery(q);
           while(rest.next())
           {
               ch.add(rest.getString("id"));
           }
       }
       catch(Exception e)
       {
           e.printStackTrace();
       }
        ch.setFont(f1);
        
        p1=new JPanel();
        p1.setLayout(new GridLayout(1,1,10,10));
        p1.add(l1);
        p1.setBackground(Color.CYAN);
        
        p2=new JPanel();
       p2.setLayout(new GridLayout(8,2,10,10));
       p2.add(l2);
       p2.add(ch);
       p2.add(l3);
       p2.add(tf1);
       p2.add(l4);
       p2.add(tf2);
       p2.add(l5);
       p2.add(tf3);
       p2.add(l6);
       p2.add(tf4);
       p2.add(l7);
       p2.add(tf5);
       p2.add(l8);
       p2.add(tf6);
       p2.add(b1);
       p2.add(b2);
        
       setLayout(new BorderLayout(10,10));
       add(p1,"North");
       add(p2,"Center");
        
        ch.addMouseListener(new MouseAdapter()
        {
            @Override
            public void mouseClicked(MouseEvent arg0)
            {
                try
                {
                    ConnectionClass obj2=new ConnectionClass();
                    int id=Integer.parseInt(ch.getSelectedItem());
                    String q1="select * from bookdetails where id='"+id+"'";
                    ResultSet rest1=obj2.sta.executeQuery(q1);
                    while(rest1.next())
                    {
                        tf1.setText(rest1.getString("bookid"));
                        tf2.setText(rest1.getString("bookname"));
                        tf6.setText(rest1.getString("quantity"));
                    }
                }
                catch(Exception exp)
                {
                    exp.printStackTrace();
                }
               
            }
        });        
    }
    
    public void actionPerformed(ActionEvent e)
    {
        if(e.getSource()==b1){   
        
        int qnt=0;
        int bookid=Integer.parseInt(ch.getSelectedItem());
        String bookno=tf1.getText();
        String bookname=tf2.getText();
        int adminid=Integer.parseInt(tf3.getText());
        String adminname=tf4.getText();
        String admincontact=tf5.getText();
        String date=new java.util.Date().toString();
        
        try
        {
            ConnectionClass obj3=new ConnectionClass();
            String q0="select quantity from bookdetails where id='"+bookid+"'";
            ResultSet rest0=obj3.sta.executeQuery(q0);
            while(rest0.next())
            {
                qnt=Integer.parseInt(rest0.getString("quantity"));
            }
            if(qnt<=0)
            {
                JOptionPane.showMessageDialog(null, "No Books Available!!!");
                this.setVisible(false);
            }
            else
            {
                String q2="insert into issuebook values('"+bookid+"','"+bookno+"','"+bookname+"','"+adminid+"','"+adminname+"','"+admincontact+"','"+date+"')";
                String q3="update bookdetails set issuebook=issuebook+1 where id='"+bookid+"'";
                String q4="update bookdetails set quantity=quantity-1 where id='"+bookid+"'";
                int aa=obj3.sta.executeUpdate(q2);
                int aaa=obj3.sta.executeUpdate(q3);
                int aaaa=obj3.sta.executeUpdate(q4);
                if(aa==1)
                {
                    if(aaa==1)
                    {
                        if(aaaa==1)
                        {
                            JOptionPane.showMessageDialog(null, "Book Issued Successfully!!!");
                            this.setVisible(false);
                        }
                        else
                        {
                            JOptionPane.showMessageDialog(null, "Error Occured");
                            
                        }
                    }
                    else
                        {
                            JOptionPane.showMessageDialog(null, "Error Occured");
                            
                        }
                }
                else
                        {
                            JOptionPane.showMessageDialog(null, "Error Occured");
                            
                        }
            }
         }
        catch(Exception ee)
        {
            ee.printStackTrace();
        }
      } 
        
        if(e.getSource()==b2)
        {
           JOptionPane.showMessageDialog(null, "Are you sure !"); 
           this.setVisible(false);
        }   
 }
    
    public static void main(String args[])
    {
        new IssueBook().setVisible(true);
    }
}
