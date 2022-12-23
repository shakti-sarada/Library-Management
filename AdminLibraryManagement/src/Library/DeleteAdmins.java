package Library;

import java.awt.event.*;
import java.awt.*;
import javax.swing.*;
import java.sql.*;

public class DeleteAdmins extends JFrame implements ActionListener
{
    String x[]={"Id","Name","Password","Email","Contact","Address","City"};
    JButton b1;
    String y[][]=new String[20][7];
    int i=0,j=0;
    JTable t;
    Font f1;
    JTextField tf1;
    JPanel p1;
    JLabel l1;
    
    DeleteAdmins()
    {
       super("Delete Admin Details");
       setLocation(1,1);
       setSize(1000,400); 
       
       f1=new Font("Arial",Font.PLAIN,20);
       
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
       
       l1=new JLabel("Delete Admin");
       tf1=new JTextField();
       b1=new JButton("Delete");
       b1.addActionListener(this);
       
       l1.setFont(f1);
       tf1.setFont(f1);
       b1.setFont(f1);
       
       p1=new JPanel();
       p1.setLayout(new GridLayout(1,3,10,10));
       p1.add(l1);
       p1.add(tf1);
       p1.add(b1);
       
       setLayout(new BorderLayout(10,10));
       add(sp,"Center");
       add(p1,"South");
      
       
    }
    
    public void actionPerformed(ActionEvent e)
    {
        if(e.getSource()==b1)
        {
            int id=Integer.parseInt(tf1.getText());
            try
            {
                ConnectionClass obj=new ConnectionClass();
                String q="delete from admdetails where Lid='"+id+"'";
                int res=obj.sta.executeUpdate(q);
                if(res==1)
                {
                    JOptionPane.showMessageDialog(null, "Data Successfully Deleted!!!");
                    this.setVisible(false);
                    new DeleteAdmins().setVisible(true);
                }
                else
                {
                    JOptionPane.showMessageDialog(null, "Error Occured!!!");
                    this.setVisible(false);
                    new DeleteAdmins().setVisible(true);
                }
            }
            catch(Exception ee)
            {
                ee.printStackTrace();
            }
        }
        
    }
    
    public static void main(String args[])
    {
        new DeleteAdmins().setVisible(true);
    }
}
