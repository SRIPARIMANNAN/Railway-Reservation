import java.awt.*;

import javax.swing.*;
import javax.swing.JScrollPane;

public class frame3
{
   
    JFrame fff;
    frame3()
    {


        fff = new JFrame();
        JLabel ne= new JLabel("hell0");
        ne.setLocation(200,100);
        ne.setVerticalAlignment(0);
        fff.add(ne);
        
        fff.setSize(500,300);
        fff.setVisible(true);
       
    }
    
    public static void main(String[] a)
    {
        
        new frame3();
    }
}