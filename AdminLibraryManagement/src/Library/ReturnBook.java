package Library;

import java.awt.event.*;
import java.awt.*;
import javax.swing.*;
import java.sql.*;

public class ReturnBook extends JFrame implements ActionListener
{
    JLabel l1,l2,l3;
    JButton b1,b2;
    JPanel p1,p2;
    Font f,f1;
    JTextField tf1,tf2;  
    
    ReturnBook()
    {
       super("Return Books");
       setLocation(0,0);
       setSize(650,400);
       
       f=new Font("Arial",Font.BOLD,25);
       f1=new Font("Arial",Font.BOLD,20);
       
       l1=new JLabel("Return Book");
       l2=new JLabel("Book Id");
       l3=new JLabel("Admin Id");
       
       l1.setHorizontalAlignment(JLabel.CENTER);
       l1.setForeground(Color.WHITE);
       
       tf1=new JTextField();
       tf2=new JTextField();
       
       b1=new JButton("Return Book");
       b2=new JButton("Cancel");
       
       b1.setFont(f1);
       b2.setFont(f1);
       
       b1.addActionListener(this);
       b2.addActionListener(this);
       
       l1.setFont(f);
       l2.setFont(f1);
       l3.setFont(f1);
       
       tf1.setFont(f1);
       tf2.setFont(f1);
       
       p1=new JPanel();
       p1.setLayout(new GridLayout(1,1,10,10));
       p1.add(l1);
       p1.setBackground(Color.BLUE);
       
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
        String bookno=tf1.getText();
        int adminid=Integer.parseInt(tf2.getText());
        
        if(e.getSource()==b1){
            try
            {
                ConnectionClass obj=new ConnectionClass();
                String q="delete from issuebook where bookno='"+bookno+"' and adminid='"+adminid+"'";
                int res=obj.sta.executeUpdate(q);
                if(res==0)
                {
                    JOptionPane.showMessageDialog(null, "Book was not issued.");
                   this.setVisible(false);
                }
                else
                {
                String q1="update bookdetails set issuebook=issuebook-1 where bookid='"+bookno+"'";
                String q2="update bookdetails set quantity=quantity+1 where bookid='"+bookno+"'";
                int aa=obj.sta.executeUpdate(q1);
                int aaa=obj.sta.executeUpdate(q2);
                
                if(aa==1)
                    {
                        if(aaa==1)
                        {
                            JOptionPane.showMessageDialog(null, "Book Returned Successfully!!!");
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
            
            }
            catch(Exception ex)
            {
                ex.printStackTrace();
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
        new ReturnBook().setVisible(true);
    }
}
