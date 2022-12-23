package Library;

import java.awt.event.*;
import java.awt.*;
import javax.swing.*;
import java.sql.*;

public class LibrarianSection extends JFrame implements ActionListener
    {
    JLabel l1;
    JButton b1;
    JPanel p1,p2;
    Font f,f1;
    
    LibrarianSection()
    {
       super("Librarian Section Page");
       setLocation(0,0);
       setSize(1500,800);
       
       f=new Font("Arial",Font.BOLD,25);
       f1=new Font("Arial",Font.BOLD,20);
       
       ImageIcon img=new ImageIcon(ClassLoader.getSystemResource("Library/icon/delete.png"));
       Image i=img.getImage().getScaledInstance(1500,800,Image.SCALE_DEFAULT);
       ImageIcon img2=new ImageIcon(i);
       l1=new JLabel(img2);
       
       JMenuBar m1=new JMenuBar();
       JMenu me1=new JMenu("Add");
       JMenuItem men1=new JMenuItem("Add Books");
       
       JMenu me2=new JMenu("View");
       JMenuItem men2=new JMenuItem("View Books");
       
       JMenu me3=new JMenu("Issue");
       JMenuItem men4=new JMenuItem("Issue Book");
       
       JMenu me4=new JMenu("Return");
       JMenuItem men5=new JMenuItem("Return Book");
       
       JMenu me5=new JMenu("Exit");
       JMenuItem men6=new JMenuItem("Logout");
       
       me1.add(men1);
       me2.add(men2);
       me3.add(men4);
       me4.add(men5);
       me5.add(men6);
       
       
       m1.add(me1);
       m1.add(me2);
       m1.add(me3);
       m1.add(me4);
       m1.add(me5);
       
       me1.setFont(f);
       me2.setFont(f);
       me3.setFont(f);
       me4.setFont(f);
       me5.setFont(f);
       
       men1.setFont(f1);
       men2.setFont(f1);
       men4.setFont(f1);
       men5.setFont(f1);
       men6.setFont(f1);
       
       men1.addActionListener(this);
       men2.addActionListener(this);
       men4.addActionListener(this);
       men5.addActionListener(this);
       men6.addActionListener(this);
       
       
       setJMenuBar(m1);
       add(l1);
       
    }
    
    public void actionPerformed(ActionEvent e)
    {
        String cmd=e.getActionCommand();
        if(cmd.equals("Add Books"))
        {
            new AddBooks().setVisible(true);
        }
        else if(cmd.equals("View Books"))
         {
            new ViewBooks().setVisible(true); 
         }
        else if(cmd.equals("Issue Book"))
        {
            new IssueBook().setVisible(true);
        }
        else if(cmd.equals("Return Book"))
        {
            new ReturnBook().setVisible(true);
        }
        else if(cmd.equals("Logout"))
        {
            System.exit(0);
        }
      }
    public static void main(String args[])
    {
        new LibrarianSection().setVisible(true);
    }
}
