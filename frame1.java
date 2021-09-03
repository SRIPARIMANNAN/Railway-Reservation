import java.awt.*;
import java.awt.event.*;
import java.io.*;
import java.sql.SQLException;
import javax.swing.*;


class framme1 extends frame2 
{
    private Dimension screensize;
    private JLabel sname;
    protected JFrame f;
    protected JTabbedPane tp;
    private JLabel closex;
    private JButton close;

    private JLabel useridlabel;
    private JLabel passlabel;
    private JTextField userid;
    private JPasswordField pass;
    private JButton button1;
    private JLabel forgetpass;

    private JLabel emaillabel;
    private JLabel dateofbirthlabel;
    private JLabel npasslabel;
    private JLabel cpasslabel;
    private JTextField email;
    private JPasswordField npass;
    private JPasswordField cpass;
    private JTextField dateofbirth;
    private JTextField mailsentpass;
    private JButton button2;
    private JButton button22;

    private JLabel forgetemaillabel;
    private JTextField forgetemailid;
    private JButton button3;
    private JDialog dialog;
    private JLabel out;
    private JOptionPane op;
    
    private JPanel panel1;
    private JPanel panel2;
    private JPanel panel3;
   
   
    private int mouseX;
    private int mouseY;
    private int height;
    private int width;


    String newemail="";
    String dob;
    String npassvalue;
    String cpassvalue;
    String emailvalue;
    int dupkey;
    String dup;
    
    framme1()
	{
        //intialization of all comoponents
        f =new JFrame();
        screensize = Toolkit.getDefaultToolkit().getScreenSize();
        height=screensize.height;
        width= screensize.width;
        sname = new JLabel("SSS-ticketing");
        closex = new JLabel("            >>");
        close =new JButton("X");
        

        useridlabel = new JLabel("User Id :");
        passlabel = new JLabel("Password :");
        forgetpass = new JLabel("Forget Password");
        emaillabel = new JLabel("Email :");
        npasslabel = new JLabel("New Password :");
        cpasslabel = new JLabel("Confirm :");
        dateofbirthlabel = new JLabel("D.O.B");

        userid = new JTextField("User ID");
        pass = new JPasswordField("********"); 
        button1 = new JButton("Log in");
        
        email = new JTextField("Email id");
        npass = new JPasswordField("********");
        cpass = new JPasswordField("********");
        dateofbirth = new JTextField("00/00/0000");
        mailsentpass= new JTextField();
        button2 = new JButton("continue");
        button22 = new JButton("Sign up");
        

        
        forgetemaillabel= new JLabel("Email id :");
        forgetemailid= new JTextField("Email");
        button3= new JButton("Get");
        
        dialog = new JDialog(f,"INFORMATION");
        op = new JOptionPane();
        out=new JLabel();

        panel1 = new JPanel(null);
        panel2 = new JPanel(null);
        panel3= new JPanel(null);
        tp = new JTabbedPane();        
    }

  
    private void listeners()
    {
        close.addActionListener(this);
        
        tp.addMouseMotionListener(this);
        tp.addMouseListener(this);

        button1.addActionListener(this);
        button2.addActionListener(this);
        button22.addActionListener(this);
        button3.addActionListener(this);

        userid.addMouseListener(this);
        pass.addMouseListener(this);
        
        email.addMouseListener(this);
        npass.addMouseListener(this);
        cpass.addMouseListener(this);
        dateofbirth.addMouseListener(this);

        forgetpass.addMouseListener(this);
        
    }
    private void dialogbox(JLabel s)
    {
        
        int x=f.getX();
        int y=f.getY();
        dialog.add(s);
        dialog.setVisible(true);
        dialog.setBounds(x+120,y+100,280,100);
    }

    private void opbox(String s)
    {
        
        int x=f.getX();
        int y=f.getY();
        JOptionPane.showMessageDialog(f,s,"Alert",JOptionPane.WARNING_MESSAGE);
        op.setVisible(true);
        op.setBounds(x+120,y+100,280,100);


    }

    private void loginpanel()
    {
        //setting color
        panel1.setBackground(Color.darkGray);
        passlabel.setForeground(Color.black);
        useridlabel.setForeground(Color.black);
        pass.setForeground(Color.gray);
        userid.setForeground(Color.gray);
        button1.setBackground(Color.cyan);
        forgetpass.setForeground(Color.red);
        forgetpass.setBackground(Color.gray);

        

        //where to place
        useridlabel.setBounds(9,50,79,30);
        passlabel.setBounds(9,100,79,30);
        userid.setBounds(80,50,190,30);
        pass.setBounds(80,100,190,30);
        button1.setBounds(110,150,95,30);
        forgetpass.setBounds(9,230,100,15);

        //adding compoinents to login panel
        panel1.add(pass);
        panel1.add(userid);
        panel1.add(passlabel);
        panel1.add(useridlabel);
        panel1.add(button1);
        panel1.add(forgetpass);


    }

    private void signuppannel()
    {
        //adding components to signup panel
        panel2.add(email);
        panel2.add(npass);
        panel2.add(cpass);
        panel2.add(dateofbirth);
        panel2.add(emaillabel);
        panel2.add(npasslabel);
        panel2.add(cpasslabel);
        panel2.add(dateofbirthlabel);
        panel2.add(mailsentpass);
        panel2.add(button2);
        panel2.add(button22);

        //set font color
        panel2.setBackground(Color.darkGray);
        emaillabel.setForeground(Color.black);
        npasslabel.setForeground(Color.black);
        cpasslabel.setForeground(Color.black);
        dateofbirthlabel.setForeground(Color.black);
        button2.setBackground(Color.cyan);
        button2.setBackground(Color.red);
        email.setForeground(Color.gray);
        npass.setForeground(Color.gray);
        cpass.setForeground(Color.gray);
        dateofbirth.setForeground(Color.gray);
        

        //where to place them
        email.setBounds(130,30,190,30);
        npass.setBounds(130,130,190,30);
        cpass.setBounds(130,180,190,30);
        dateofbirth.setBounds(130,80,190,30);
        button2.setBounds(180,230,95,30);
        button22.setBounds(180,230,95,30);
        emaillabel.setBounds(9,30,110,30);
        npasslabel.setBounds(9,130,110,30);
        cpasslabel.setBounds(9,180,79,30);
        dateofbirthlabel.setBounds(9,80,80,30);
        mailsentpass.setBounds(130,130,190,30);
        mailsentpass.setVisible(false);
    }

    private void forgetdetailspanel()
    {
        //setting color
        panel3.setBackground(Color.darkGray);
        forgetemaillabel.setForeground(Color.black);
        forgetemailid.setForeground(Color.black);
        button3.setBackground(Color.cyan);
       //where to place 
        forgetemaillabel.setBounds(10,30,70,20);
        forgetemailid.setBounds(70,25,180,30);
        button3.setBounds(90,90,90,20);

        //adding component
        panel3.setLayout( null );
        panel3.add(forgetemaillabel);
        panel3.add(forgetemailid);
        panel3.add(button3);

       
    }

    private void tabbedpane()
    {
        //adding both panels as tab
        tp.add("Log In", panel1);
        tp.add("Sign Up", panel2);

        //set background color for tab
        tp.setBackgroundAt(0, Color.black);
        tp.setBackgroundAt(1, Color.black);
        tp.setForegroundAt(0, Color.blue);
        tp.setForegroundAt(1, Color.blue);
        //where to locate
        tp.setBounds(0,0,f.getWidth(),f.getHeight());

    }
        
    public void loginframe()
    {
        f.getContentPane().setBackground(Color.black);

        sname.setBounds(230,0,80,20);
        sname.setForeground(Color.orange);

        closex.setBounds(420,1,60,20);
        closex.setForeground(Color.red);

        close.setBorderPainted(false);
        close.setLayout(null);
        close.setBackground(Color.black);
        close.setFont(new Font("serif",0,5));
        close.setBounds(470, 1, 100, 20);
            
        // adding components to loginframe
        f.add(sname);
        f.add(closex);
        f.add(close);
        f.add(tp);
       
        //setting size to frame
        f.setBounds((width/2)-250,height/2-150,500,300);
        
        f.setUndecorated(true);
        f.setLayout(null);
        f.setVisible(true);

        //creatiing main components
        listeners();
        loginpanel();
        signuppannel();
        forgetdetailspanel();
        tabbedpane();
        
    }

    @Override
    public void actionPerformed(ActionEvent e) 
    {
    
  
        

        if(e.getSource()==button1)
        {
        
            String eemail=userid.getText();
            String passvalue=String.valueOf(pass.getPassword());
            try
            {
                String result = new database().checkcredentials(eemail, passvalue);
                if(result.equals("1"))
                {
                   userid.setText("User ID");
                   pass.setText("********");
                   f.dispose();
                   new frame2().mainframe();
                }
                else if(result.equals("0"))
                {
                    result="             userid or password missmatch";
                    out.setText(result);
                    dialogbox(out);
                }
                else if(result.equals("y"))
                {
                    result="    fucking DATABASE CONNECTION LOST, call admin";
                    out.setText(result);
                    dialogbox(out);
                }
                
            }
            catch(SQLException oe)
            {
                System.out.println(oe);
            }
            
           
         
        }
        
        

        if(e.getSource()==button2)
        {
            newemail=email.getText();
            dob = dateofbirth.getText();
           String dcheck[]=dob.split("/");
            npassvalue=String.valueOf(npass.getPassword());
            cpassvalue=String.valueOf(cpass.getPassword());
            emailvalue=email.getText();
            
           

            if(emailvalue.contains("@gmail.com"))
            {
                if(dcheck[0].length()==2 && dcheck[1].length()==2 && dcheck[2].length()==4 )
                {

                    if(npassvalue.equals(cpassvalue) && npassvalue.length()>=8 )
                    {
                        try
                        {
                            dupkey=(int)(Math.random()*(400-200+1)+200);
                            dup=String.valueOf(dupkey);
                            mail.send("projectmaildummy@gmail.com","dummymail1",newemail,"hello",dup);
                           

                            dateofbirth.setVisible(false);
                            npass.setVisible(false);
                            cpass.setVisible(false);
                            button2.setVisible(false);
                            npasslabel.setVisible(false);
                            cpasslabel.setVisible(false);
                            dateofbirthlabel.setVisible(false);
                            button22.setVisible(true);
                            mailsentpass.setVisible(true);

                        }
                        catch(Exception oe)
                        {
                            System.out.println(oe);
                        }
                        
                    
                    
                    }
                    else
                    {
                        out.setText("password mismatch or lessthan 8 letters");
                        dialogbox(out);
                    }

                }
                else
                {
                    opbox("check your dob or format(00/00/0000)");
                }
                
              
            }
            else
            {
                opbox("check your mail id");
            }
            

            
           
        } 
//***************************************************************** */

if(e.getSource()==button22)
{
    String mailsentpasstext = mailsentpass.getText();

    if(dup.equals(mailsentpasstext))
    {
        try
        {
            
            String result = new database().credentials(newemail, cpassvalue,dob);
            if(result.equals("1"))
            {
                result="    user added SUCCESSFULLY go and login";
                email.setText("Email id");
                cpass.setText("********");
                npass.setText("********");
            }
            else if(result.equals("0"))
            {
                result="          user already EXISTED";
                email.setText("Email id");
                cpass.setText("********");
                npass.setText("********");
            }
            else if(result.equals("y"))
            {
                result="    fucking DATABASE CONNECTION LOST, call admin";
                email.setText("Email id");
                cpass.setText("********");
                npass.setText("********");
            }
            else
            {
                result="                    query error";
                email.setText("Email id");
                cpass.setText("********");
                npass.setText("********");
            }
            
            out.setText(result);
            dialogbox(out);

            dateofbirth.setVisible(true);
            npass.setVisible(true);
            cpass.setVisible(true);
            button2.setVisible(true);
            npasslabel.setVisible(true);
            cpasslabel.setVisible(true);
            dateofbirthlabel.setVisible(true);
            button22.setVisible(false);
            mailsentpass.setVisible(false);

        }
        catch(Exception oe)
        {
            System.out.println(oe);
        }
    }
    else
    {
        opbox("mismatch");
    }
    

    
   
} 

        if(e.getSource()==button3)
        {
            out.setText("upcoming");
            dialogbox(out);
            tp.remove(panel3);
            tp.add("Log In", panel1);
            tp.add("Sign Up", panel2);
        } 
        if(e.getSource()==close)
        {
            f.dispose();
            System.exit(0);
        } 
    }

    @Override   
    public void mousePressed(MouseEvent e)
    {
        mouseX=e.getX();
        mouseY=e.getY();
        System.out.println(mouseX+ " " + mouseY+"---");
    }
    @Override
    public void mouseDragged(MouseEvent e)
    {
        f.setLocation(f.getX() + e.getX() - mouseX, f.getY()+e.getY()- mouseY);
    }

    @Override
    public void mouseMoved(MouseEvent e) 
    {
        // TODO Auto-generated method stub

    }

    @Override
    public void mouseClicked(MouseEvent e)
    {
        if(e.getSource()==forgetpass)
        {
            tp.remove(panel2);
            tp.remove(panel1); 
            tp.add("Forget Password",panel3);                 
            System.out.println("forget pass");
        }

        if(e.getSource()==cpass)
        {
            String emailvalue=email.getText();
            if(emailvalue.length()<1)
            {
                email.setText("Email id");
            }

            String npassvalue=npass.getText();
            if(npassvalue.length()<1)
            {
                npass.setText("********");
            }

            String cpassvalue=cpass.getText();
            if(cpassvalue.equals("********"))
            {
                cpass.setText("");
            }
            String datevalue=dateofbirth.getText();
            if(datevalue.equals(""))
            {
                dateofbirth.setText("00/00/0000");
            }
        }
       
        if(e.getSource()==npass)
        {
            String emailvalue=email.getText();
            
            if(emailvalue.length()<1)
            {
                email.setText("Email id");
            }

            String npassvalue=npass.getText();
            if(npassvalue.equals( "********"))
            {
                npass.setText("");
            }

            String cpassvalue=cpass.getText();
            if(cpassvalue.length()<1)
            {
                cpass.setText("********");
            }
            String datevalue=dateofbirth.getText();
            if(datevalue.equals(""))
            {
                dateofbirth.setText("00/00/0000");
            }
        }

        if(e.getSource()==email)
        {
            String emailvalue=email.getText();
            if(emailvalue.equals("Email id"))
            {
                email.setText("");
            }

            String npassvalue=npass.getText();
            if(npassvalue.length()<1)
            {
                npass.setText("********");
            }

            String cpassvalue=cpass.getText();
            if(cpassvalue.length()<1)
            {
                cpass.setText("********");
            }

            String datevalue=dateofbirth.getText();
            if(datevalue.equals(""))
            {
                dateofbirth.setText("00/00/0000");
            }
        }

        if(e.getSource()==dateofbirth)
        {
            String datevalue=dateofbirth.getText();
            if(datevalue.equals("00/00/0000"))
            {
                dateofbirth.setText("");
            }

            String emailvalue=email.getText();
            if(emailvalue.equals(""))
            {
                email.setText("Email id");
            }

            String npassvalue=npass.getText();
            if(npassvalue.length()<1)
            {
                npass.setText("********");
            }

            String cpassvalue=cpass.getText();
            if(cpassvalue.length()<1)
            {
                cpass.setText("********");
            }
        }

        
        if(e.getSource()==pass)
        {
            String passvalue=pass.getText();
            if(passvalue.equals( "********"))
            {
                pass.setText("");
            }

            String useridvalue=userid.getText();
            if(useridvalue.length()<1)
            {
                userid.setText("User ID");
            }

        }
       
        if(e.getSource()==userid)
        {
            String useridvalue=userid.getText();
            if(useridvalue.equals( "User ID"))
            {
                userid.setText("");
            }

            String passvalue= pass.getText();
            if(passvalue.length()<1)
            {
                pass.setText("********");
            }   
        }
       

    }

    @Override
    public void mouseReleased(MouseEvent e) 
    {
        // ena sola ethu solla

    }

    @Override
    public void mouseEntered(MouseEvent e) 
    {
        if(e.getSource()==forgetpass)
        {
            forgetpass.setForeground(Color.blue);
            
        }
   }

    @Override
    public void mouseExited(MouseEvent e) 
    {
       if(e.getSource()==forgetpass)
        {
            forgetpass.setForeground(Color.red);
        }

    }

}

class frame1
{
    public static void main(String[] srgs)    
    {
        framme1 framme1object=new framme1();
        framme1object.loginframe();
    }
}