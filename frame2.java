import java.awt.*;
import java.awt.event.*;
import java.sql.SQLException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.swing.*;
import javax.swing.border.LineBorder;

import com.toedter.calendar.*;

import javafx.scene.control.ComboBox;

class frame2 extends database implements ActionListener, MouseMotionListener, MouseListener, blayout {
    private JFrame ff;
    private JPanel titlebar;
    private JLabel tname;
    private JLabel closel;

    private JPanel panel5;
    private JPanel bookticket;
    private JPanel history;
    private JPanel logout;
    private JLabel bookticketlabel;
    private JLabel historylabel;
    private JLabel logoutlabel;

    private JPanel panel6;
    private JPanel panel61;
    private JPanel panel62;
    private JPanel panel63;
    private JPanel bigpanel;
    private JScrollPane scrollPane;
    private JPanel contentPane;
    private JPanel[]  sp1 = new JPanel[50];
    
    private JPanel[] coachpanel= new JPanel[200];
    private JPanel preconfirmpanel;


    private JLabel originlabel;
    private JLabel rightarrow;
    private JLabel leftarrow;
    private JLabel destinationlabel;
    private JLabel departurelabel;
    private JLabel quotalabel;
    private JLabel findtrainbuttonl;
    private JLabel comingsoonlabel;
    private JTextField origin;
    private JTextField destination;
    private String[] quotaitems = { "General", "Ladies", "Senior", "Tatkal" };
    private final JComboBox<String> quota;
    private JDateChooser date;
    private JButton findtrainbutton;
   
    private JOptionPane  opp;


    private JPanel panel7;
    private JPanel panel71;
    private JPanel panel8;
    private JPanel panel81;
    private JPanel panel82;
    private JPanel panel83;
    private JLabel namelabel;
    private JLabel doblabel;
    private JLabel panel83logoutlabel;

  
    JLabel[] s;
    JLabel[] trainno;
    JLabel[] e;
    JLabel[] times;
    JLabel[] timee;

    JPanel toppanel;
    JScrollPane scroller;
    JPanel cpanel;

    JLabel[] clab= new JLabel[100];
    JLabel[] slab= new JLabel[100] ;
    JLabel[] plab= new JLabel[100] ;

    JLabel trainname= new JLabel();
    JLabel startingtrain= new JLabel();
    JLabel  endingtrain= new JLabel();
    JLabel startingtraintime= new JLabel();
    JLabel endingtraintime= new JLabel();
    JLabel boardingpointlabel= new JLabel("Boarding point");
    JTextField boardingpointfield = new JTextField();
    JLabel one= new JLabel("1");
    JLabel irctclabel= new JLabel("IRCTC user ID");
    JTextField irctcfield = new JTextField("currently NA");
    JLabel two= new JLabel("2");
    JLabel passengerinfolabel= new JLabel("Passenger Inforamtion");
    JLabel passengercount = new JLabel("NO.of Passengers :");
    JTextField passengercountfield;
    JTextField[] pna = new JTextField[6];
    JTextField[] pa = new JTextField[6];
    String[] gender={"Male","Female","Transgender"};
    JComboBox<String>[] pg = new JComboBox[6];
    JLabel addresslabel = new JLabel("Destination Address :");
    JTextField  streetfield;
    JTextField  colonyfield;
    JTextField  pinfield;
    JTextField  addressfield;
    JTextField phonenumberfield;

    String data[][]=new String[100][4];
    JPanel pctoppanel;
    JScrollPane pscroller;

    JPanel pcpanel;
    String[] trainnolist= new String[50];
    int seatcount=0;
    int count=-9;


    String trainnumber;
    String start;
    String end;
    String tn;
    String ts;
    String te;
    String tst;
    String tet;


    JButton go;
    JButton continuebutton ;
  

    private int mouseX;
    private int mouseY;
    private String sd = "";
    private String starting = "";
    private String ending = "";
    private int coachpanelcount=0;
    private int scrollingpanelcount=0;
    private String selecteddate="";
    int ccii;


    JPanel lastp;
    JScrollPane lasts;
    JPanel lastsp;


    String pricefcp;
    String coachfcp;
    String seatstr;

    JPanel thankyoupanel;
    JPanel book;

    //historypanel

    JLabel[] coachh = new JLabel[100];
    JLabel[] seath = new JLabel[100];
    JLabel[] priceh = new JLabel[100];
    JLabel[] trainnno= new JLabel[100];
    JPanel[] cancelh = new JPanel[100];
    private String unameh;
    JLabel[] can=new JLabel[100];
    String[] uplist=new String[100];

    String totalstr;
    String[][] pasli=new String[100][100];

    JLabel backgroundimage;

    frame2() {

        tname = new JLabel("SSS");
        ff = new JFrame();
        titlebar = new JPanel(null);
        closel = new JLabel(" X");

        comingsoonlabel = new JLabel("coming soon         (soon may take some decades)");

        originlabel = new JLabel("Origin");
        destinationlabel = new JLabel("Destination");
        departurelabel = new JLabel("Departure");
        quotalabel = new JLabel("Quota");

        panel5 = new JPanel(null);
        bookticket = new JPanel();
        history = new JPanel();
        logout = new JPanel();

        panel6 = new JPanel(new CardLayout());
        panel61 = new JPanel(null);
        panel62 = new JPanel(null);
       
       
        
        

        bookticketlabel = new JLabel("Book ticket");
        historylabel = new JLabel("History");
        logoutlabel = new JLabel("My Account");
        origin = new JTextField("from ?");
        destination = new JTextField("to ?");
        rightarrow = new JLabel("---->");
        leftarrow = new JLabel("<----");
        date = new JDateChooser();
        quota = new JComboBox<>(quotaitems);
        findtrainbuttonl = new JLabel("");
        findtrainbutton = new JButton("Find");
        trainno = new JLabel[200];
        s = new JLabel[200];
        e = new JLabel[200];
        times = new JLabel[200];
        timee = new JLabel[200];

        
        
        go = new JButton("Go");
       
        

       

        panel7 = new JPanel(new CardLayout());
        panel71 = new JPanel(null);

        panel8 = new JPanel(new CardLayout());
        panel81 = new JPanel(null);
        panel82 = new JPanel(null);
        namelabel = new JLabel("Name :");
        namelabel.setFont(new Font("Calibri", 1, 15));
        doblabel = new JLabel("D.O.B :");
        doblabel.setFont(new Font("Calibri", 1, 15));
        panel83 = new JPanel(null);
        panel83logoutlabel = new JLabel("LOG OUT");

        

        opp= new JOptionPane();
        mouseX = 0;
        mouseY = 0;
        ccii=0;
    }

    private void oppbox(String s)
    {
        
        int x=ff.getX();
        int y=ff.getY();
        JOptionPane.showMessageDialog(ff,s,"Alert",JOptionPane.WARNING_MESSAGE);
        opp.setVisible(true);
        opp.setBounds(x+120,y+100,280,100);


    }

    private void rightpanel5() {

        panel5.setBounds(0, 25, 150, 475);
        new Color(58, 14, 71);
        panel5.setBackground( Color.BLACK);

        bookticketlabel.setBounds(5, 60, 149, 30);
        historylabel.setBounds(5, 100, 149, 30);
        logoutlabel.setBounds(5, 140, 149, 30);

        historylabel.setFont(new Font("Calibri", 0, 20));
        bookticketlabel.setFont(new Font("Calibri", 0, 20));
        logoutlabel.setFont(new Font("Calibri", 0, 20));

        bookticketlabel.setForeground(Color.WHITE);
        historylabel.setForeground(Color.WHITE);
        logoutlabel.setForeground(Color.WHITE);

        bookticket.setBounds(1, 50, 148, 30);
        history.setBounds(1, 90, 148, 30);
        logout.setBounds(1, 445, 148, 30);

        bookticket.setBackground (Color.BLACK);
        history.setBackground( Color.BLACK);
        logout.setBackground( Color.BLACK);

        bookticket.addMouseListener(this);
        history.addMouseListener(this);
        logout.addMouseListener(this);

        bookticket.add(bookticketlabel);
        history.add(historylabel);
        logout.add(logoutlabel);

        panel5.add(bookticket);
        panel5.add(history);
        panel5.add(logout);
    }

    private void leftpanels() throws SQLException {
        panel6.setBounds(150, 25, 650, 475);
        panel61.setBounds(150, 25, 650, 475);
        panel61.setBackground(Color.darkGray);
        panel62.setBackground(Color.black);
        panel62.setBounds(0, 0, 650, 137);

        originlabel.setForeground(Color.WHITE);
        destinationlabel.setForeground(Color.white);
        departurelabel.setForeground(Color.WHITE);
        quotalabel.setForeground(Color.white);

        originlabel.setBounds(50, 10, 190, 30);
        destinationlabel.setBounds(260, 10, 190, 30);
        departurelabel.setBounds(50, 80, 190, 30);
        quotalabel.setBounds(260, 80, 190, 30);
        origin.setBounds(50, 35, 190, 30);
        destination.setBounds(260, 35, 190, 30);
        date.setBounds(50, 105, 190, 30);
        quota.setBounds(260, 105, 190, 30);
        rightarrow.setBounds(430, 44, 40, 30);
        leftarrow.setBounds(420, 50, 40, 30);

        findtrainbutton.setBorder(null);
        findtrainbutton.addActionListener(this);
        findtrainbutton.setBounds(490, 70, 90, 30);
        findtrainbuttonl.setBounds(20, 20, 80, 30);
        findtrainbutton.setBackground(Color.green);

        findtrainbutton.add(findtrainbuttonl);
        date.setDateFormatString("dd/MM/yyyy");

        origin.addMouseListener(this);
        destination.addMouseListener(this);

        panel62.add(origin);
        panel62.add(destination);
        panel62.add(originlabel);
        panel62.add(destinationlabel);
        panel62.add(departurelabel);
        panel62.add(quotalabel);
        panel62.add(date);
        panel62.add(quota);
        panel62.add(findtrainbutton);

        panel61.add(panel62);

        backgroundimage = new JLabel(new ImageIcon("C:/Users/Parim/Desktop/DESKTOP/VScode/Project1/Project1/OIP.png"));
        backgroundimage.setBounds(0, 118, 650, 363);
        panel61.add(backgroundimage);

        panel6.add(panel61);

        panel7.setBounds(150, 25, 650, 479);
        comingsoonlabel.setBounds(60, 150, 600, 100);
        comingsoonlabel.setForeground(Color.red);
        comingsoonlabel.setFont(new Font("Calibri", 3, 25));
        panel71.setBackground(Color.black);

        panel71.add(comingsoonlabel);

        panel7.add(panel71);

        panel8.setBounds(150, 25, 650, 479);

        panel81.setBackground(new Color(58, 14, 71));
        panel82.setBackground(new Color(58, 14, 71));
        panel83.setBackground(new Color(58, 14, 71));

        panel82.setBounds(0, 0, 650, 30);
        panel83.setBounds(0, 450, 650, 30);
        panel83logoutlabel.setBounds(0, 451, 650, 30);
        panel83.addMouseListener(this);

        JLabel myaccountnamelabel = new JLabel("MY ACCOUNT DETAILS");
        final JTextField myaccountdob = new JTextField(new database().getdata("dob"));
        unameh=new database().getdata("name");
        final JTextField myaccountname = new JTextField(unameh);

        myaccountnamelabel.setBounds(200, 8, 200, 25);
        myaccountnamelabel.setForeground(Color.green);
        myaccountnamelabel.setFont(new Font("Calibri", 1, 18));

        namelabel.setBounds(10, 80, 80, 30);
        doblabel.setBounds(10, 130, 80, 30);
        panel83logoutlabel.setBounds(260, 3, 200, 25);
        myaccountname.setBounds(80, 80, 140, 30);
        myaccountdob.setBounds(80, 130, 140, 30);
        namelabel.setForeground(Color.black);
        doblabel.setForeground(Color.black);
        panel83logoutlabel.setForeground(Color.red);
        panel83logoutlabel.setFont(new Font("Calibri", 1, 18));

        myaccountname.setEditable(false);
        myaccountdob.setEditable(false);

        panel82.add(myaccountnamelabel);
        panel83.add(panel83logoutlabel);
        panel81.add(myaccountdob);
        panel81.add(myaccountname);
        panel81.add(namelabel);
        panel81.add(doblabel);

        panel81.add(panel82);
        panel81.add(panel83);
        panel8.add(panel81);
    }


    public void coachsetting(int spn,String tn) throws SQLException
    {
        int cciii=0;
        String[][] coachdetailswithseats=getdetailswithtrainno(tn);
        
        int ci=spn;
      
        for(int cci=0;cci<4;cci++)
        {
            String cs=coachdetailswithseats[cciii][0];
            String ss=coachdetailswithseats[cciii][1];
            String ps=coachdetailswithseats[cciii][2];
            if(cs!=null)
            {
                if(cci==0)
                {
                    clab[ccii]=new JLabel();
                    slab[ccii]=new JLabel();
                    plab[ccii]=new JLabel();
                    plab[ccii].setText(ps);

                    clab[ccii].setText(cs);
                    slab[ccii].setText(ss+" seat");
                    coachpanel[ccii]=new JPanel();
                    coachpanel[ccii].addMouseListener(this);
                    coachpanel[ccii].setBounds(320,40,60,40);
                    coachpanel[ccii].add(clab[ccii]);
                    coachpanel[ccii].add( slab[ccii]);
                    sp1[ci].add(coachpanel[ccii]);
                }
                if(cci==1)
                {
                    clab[ccii]=new JLabel();
                    slab[ccii]=new JLabel();
                    plab[ccii]=new JLabel();
                    plab[ccii].setText(ps);

                    clab[ccii].setText(cs);
                    slab[ccii].setText(ss+" seat");
                    coachpanel[ccii]=new JPanel();
                    coachpanel[ccii].addMouseListener(this);
                    coachpanel[ccii].setBounds(390,40,60,40);
                    coachpanel[ccii].add(clab[ccii]);
                    coachpanel[ccii].add(slab[ccii]);
                    sp1[ci].add(coachpanel[ccii]);
                }
                if(cci==2)
                {
                    clab[ccii]=new JLabel();
                    slab[ccii]=new JLabel();
                    plab[ccii]=new JLabel();
                    plab[ccii].setText(ps);

                    clab[ccii].setText(cs);
                    slab[ccii].setText(ss+" seat");
                    coachpanel[ccii]=new JPanel();
                    coachpanel[ccii].addMouseListener(this);
                    coachpanel[ccii].setBounds(460,40,60,40);
                    coachpanel[ccii].add( clab[ccii]);
                    coachpanel[ccii].add( slab[ccii]);
                    sp1[ci].add(coachpanel[ccii]);
                }
                if(cci==3)
                {
                    clab[ccii]=new JLabel();
                    slab[ccii]=new JLabel();
                    plab[ccii]=new JLabel();
                    plab[ccii].setText(ps);

                    clab[ccii].setText(cs);
                    slab[ccii].setText(ss+" seat");
                    coachpanel[ccii]=new JPanel();
                    coachpanel[ccii].addMouseListener(this);
                    coachpanel[ccii].setBounds(530,40,60,40);
                    coachpanel[ccii].add( clab[ccii]);
                    coachpanel[ccii].add( slab[ccii]);
                    sp1[ci].add(coachpanel[ccii]);
                }
                ccii++;
                cciii++;
                
            }
        }
            
        
    
        coachpanelcount=ccii;
        
    }

    public void resultingpanel(int resultcount,String[][] data,String date) throws SQLException 
    {

        if(panel63!=null)
            {
                if(scrollPane!=null)
                {
                    scrollPane.remove(bigpanel);
                    panel63.remove(scrollPane);
                }
               
                
                panel61.remove(panel63);
                

                contentPane=null;
                bigpanel=null;
                scrollPane=null;

            }
       
        panel63 = new JPanel(null);
        bigpanel = new JPanel();
        scrollPane = new JScrollPane(bigpanel);
        contentPane = new JPanel(new BorderLayout());

       // bigpanel.removeAll();
        System.out.println("hello gorgeous");
        int multipanelheigth = 0;
        multipanelheigth = 100 * rowsize/2;
        panel63.setBounds(0, 137, 650, 340);
        panel63.setBackground(Color.black);
        panel63.setLayout(new FlowLayout());
        bigpanel.setLayout(new GridLayout(0,1));
        bigpanel.setBackground(Color.black);
        bigpanel.setPreferredSize(new Dimension(650, multipanelheigth));
        bigpanel.setAutoscrolls(true);

        scrollPane.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
        scrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED);
        scrollPane.setBounds(0, 0, 650, 340);

        contentPane.setPreferredSize(new Dimension(650, 335));
        contentPane.add(scrollPane, BorderLayout.CENTER);

        //adding scrolling panel to backpanel

        for (int i = 0; i < rowsize/2; i++) 
        {

            System.out.println("hellllloooooooooooo heyyyyyyyy");

            sp1[i] = new JPanel();
            sp1[i].setLayout(null);

            sp1[i].setBackground(Color.black);
            sp1[i].setBounds(0, 0, 650, 300);
            sp1[i].addMouseListener(this);
            sp1[i].setPreferredSize(new Dimension(650, 80));
            sp1[i].setBorder(new LineBorder(Color.white));

            bigpanel.add(sp1[i]);

        }
        scrollingpanelcount=rowsize/2;

        
        int pi=0;
        
        String[] trainnofordetails = new String[50];
        int tnfd=0;
        //adding details to scrolling panels

        
        for (int fi=0;fi<rowsize;fi++)
            {
                for(int fj=0;fj<4;fj++)
                {
                    String upcoming=data[fi][fj];
                    System.out.println(upcoming);
                    if(fj==0 && fi%2==0)
                    {
                        trainnofordetails[tnfd]=upcoming;
                        tnfd++;
                        trainno[pi] = new JLabel(upcoming);
                        trainno[pi].setForeground(Color.red);
                        trainno[pi].setBounds(10, 10, 160, 30);
                        System.out.println(pi+" " + upcoming);
                        trainnolist[pi]=upcoming;
                        sp1[pi].add(trainno[pi]);
                        coachsetting(pi, upcoming);
                    }
                    if(fj==1 && fi%2==0)
                    {
                        s[pi] = new JLabel(upcoming);
                        s[pi].setForeground(Color.red);
                        s[pi].setBounds(5, 40,80, 30);
                        sp1[pi].add(s[pi]);
                    }
                    if(fj==1 && fi%2!=0)
                    {
                        e[pi] = new JLabel(upcoming);
                        e[pi].setForeground(Color.red);
                        e[pi].setBounds(180, 40,80, 30);
                        sp1[pi].add(e[pi]);
                    }

                    if(fj==2 && fi%2==0)
                    {
                        times[pi] = new JLabel(upcoming);
                        times[pi].setForeground(Color.red);
                        times[pi].setBounds(5, 65, 40, 30);
                        sp1[pi].add(times[pi]);
                    }

                    if(fj==2 && fi%2!=0)
                    {
                        timee[pi] = new JLabel(upcoming);
                        timee[pi].setForeground(Color.red);
                        timee[pi].setBounds(180, 65, 80, 30);
                        sp1[pi].add(timee[pi]);
                    }

                }
                if(fi%2!=0)
                {
                    pi++;
                }
                
               
            }

       

        
        
        panel63.add(contentPane);
        panel61.add(panel63);
        panel63.setVisible(false);

    }
    private void preconfirm(int cpi, int spi) 
    {
        preconfirmpanel=new JPanel(null);
        toppanel = new JPanel(null);
        scroller = new JScrollPane(toppanel);
        cpanel = new JPanel(null);


        passengercountfield = new JTextField();
        phonenumberfield = new JTextField("+91 ");
        streetfield = new JTextField("Street (Optional)");
        colonyfield = new JTextField("Colony (Optional)");
        pinfield = new JTextField("Pincode");
        addressfield = new JTextField("Adress");



        panel61.remove(preconfirmpanel);
        preconfirmpanel.setLayout(null);
        preconfirmpanel.setBackground(Color.black);
        preconfirmpanel.setLayout(new FlowLayout());
        preconfirmpanel.setBounds(0, 0, 650, 800);

        toppanel.setBackground(Color.black);
        toppanel.setPreferredSize(new Dimension(650,1100));
        toppanel.setAutoscrolls(true);
      
        scroller.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
        scroller.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED);
        scroller.setBackground(Color.black);
        scroller.setBounds(0,0,650,475);
        
        cpanel.setPreferredSize(new Dimension(650,800));
        cpanel.setBackground(Color.black);
        cpanel.add(scroller);
        preconfirmpanel.add(cpanel);

        tn=trainno[spi].getText();
        ts=s[spi].getText();
        te=e[spi].getText();
        tst=times[spi].getText();
        tet=timee[spi].getText();
        System.out.println("scrolling panel count =="+" "+tn);   
        panel63.setVisible(false);
        



        trainname.setText(tn);
        trainname.setBounds(10,20,300,30);
        trainname.setForeground(Color.BLUE);

        startingtrain.setText(ts);
        startingtrain.setBounds(90,50,300,30);
        startingtrain.setForeground(Color.BLUE);

        endingtrain.setText(te);
        endingtrain.setBounds(90,130,300,30);
        endingtrain.setForeground(Color.BLUE);

        startingtraintime.setText(tst);
        startingtraintime.setBounds(10,50,300,30);
        startingtraintime.setForeground(Color.BLUE);

        endingtraintime.setText(tet);
        endingtraintime.setBounds(10,130,130,30);
        endingtraintime.setForeground(Color.BLUE);

        
        boardingpointlabel.setBounds(10,175,130,30);

        boardingpointfield.setText(ts);
        boardingpointfield.setBounds(10,200,130,30);
        boardingpointfield.setBorder(null);
        boardingpointfield.setBackground(Color.lightGray);
        boardingpointfield.setEditable(false);

         
        one.setFont(new Font("calibri",Font.BOLD,30));
        one.setBounds(10,230,30,90);
        one.setForeground(Color.BLUE);

        
        irctclabel.setBounds(40,257,180,40);
        irctclabel.setFont(new Font("calibri",Font.BOLD,20));

        
        irctcfield.setBounds(10,290,130,30);
        irctcfield.setEditable(false);

        
        two.setFont(new Font("calibri",Font.BOLD,30));
        two.setBounds(10,350,30,90);
        two.setForeground(Color.BLUE);

       
        passengerinfolabel.setFont(new Font("calibri",Font.BOLD,20));
        passengerinfolabel.setBounds(40,350,190,90);

       
        passengercount.setBounds(10,410,140,30);
        toppanel.add(passengercount);

       
        go.setBounds(200,413,30,25);
        go.setLayout(null);
        go.setBorder(null);
        go.addActionListener(this);
        toppanel.add(go);


        
        passengercountfield.setBounds(140,412,40,25);
        passengercountfield.setBorder(null);
        toppanel.add(passengercountfield);        

        JLabel maxcount = new JLabel("* Maximum 6");
        maxcount.setBounds(240,410,100,25);
        maxcount.setForeground(Color.red);
        toppanel.add(maxcount);

        

        

        JLabel three = new JLabel("3.");
        three.setBounds(10,700,30,30);
        three.setFont(new Font("calibri",1,30));
        three.setForeground(Color.blue);

        JLabel contactinfo = new JLabel("Contact Information");
        contactinfo.setBounds(50,700,220,30);
        contactinfo.setFont(new Font("calibri",1,25));

        JLabel phonenumberlabel = new JLabel("Phone Number :");
        phonenumberlabel.setBounds(10,740,120,30);

        phonenumberfield.setBounds(130, 740, 160,30);




        
        addresslabel.setBounds(10,800,150,30);

       
        addressfield.setBounds(10, 850, 254,30);
        addressfield.addMouseListener(this);

        
        streetfield.setBounds(10, 900, 254,30);
        streetfield.addMouseListener(this);


        
        colonyfield.setBounds(10, 950, 254,30);
        colonyfield.addMouseListener(this);

       
        pinfield.setBounds(10, 1000, 254,30);
        pinfield.addMouseListener(this);

        continuebutton = new JButton("continue");
        continuebutton.setBounds(520,1055,100,40);
        continuebutton.setBorder(null);
        continuebutton.addActionListener(this);
        continuebutton.setBackground(Color.blue);
        continuebutton.setForeground(Color.green);
        continuebutton.addMouseListener(this);



        pcpanel = new JPanel(new FlowLayout());
        pctoppanel = new JPanel(null);
        pscroller = new JScrollPane(pctoppanel);
        pcpanel.setBounds(0,480,650,200);
        pcpanel.setBackground(Color.black);

        toppanel.add(pcpanel);
        toppanel.add(phonenumberlabel);
        toppanel.add(phonenumberfield);
        toppanel.add(addresslabel);

        toppanel.add(continuebutton);
        toppanel.add(streetfield);
        toppanel.add(colonyfield);
        toppanel.add(pinfield);

        toppanel.add(addressfield);
        toppanel.add(contactinfo);
        toppanel.add(three);
       
        toppanel.add(trainname);
        toppanel.add(startingtrain);
        toppanel.add(endingtrain);
        toppanel.add(startingtraintime);
        toppanel.add(endingtraintime);
        toppanel.add(boardingpointlabel);
        toppanel.add(boardingpointfield);
        toppanel.add(one);
        toppanel.add(irctclabel);
        toppanel.add(irctcfield);
        toppanel.add(two);
        toppanel.add(passengerinfolabel);

        preconfirmpanel.setBackground(Color.black);
        continuebutton.setEnabled(true);
        panel62.setVisible(false);
        panel63.setVisible(false);
        
        preconfirmpanel.setVisible(true);
        panel61.add(preconfirmpanel);
        
        
    }

    void addpassenger(String c)
    {

       
        
        if(c.equals(""))
        {
            pcpanel.setVisible(false);
        }
        else
        {
            count= Integer.parseInt(c);
        }
        
        if(count>0 && count<7)
        {
            pctoppanel.setVisible(true);
            pcpanel.setVisible(true);
            pctoppanel.removeAll();
            pcpanel.removeAll();
            //pcscroller.removeAll();

            pcpanel.setLayout(new FlowLayout());
            pctoppanel.setAutoscrolls(true);
            pctoppanel.setBackground(Color.black);
            int pctpheight=count*51;
            pctoppanel.setPreferredSize(new Dimension(650, pctpheight));

            
            pscroller.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
            pscroller.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED);
            pscroller.setPreferredSize(new Dimension(650,200));

            pcpanel.add(pscroller);

        
            int y=20;
            for (int i=0;i<count;i++)
            {
            
                pna[i]=new JTextField("Name");
                pna[i].setBounds(10,y,150,30);
                pna[i].addMouseListener(this);

                pa[i]=new JTextField("Age");
                pa[i].setBounds(200,y,60,30);
                pa[i].addMouseListener(this);

                pg[i]=new JComboBox<String>(gender);
                pg[i].setBounds(300,y,90,30);
                pg[i].addMouseListener(this);


                y=y+50;
                pctoppanel.add(pna[i]);
                pctoppanel.add(pa[i]);
                pctoppanel.add(pg[i]);
            }
        }
        else
        {
            pcpanel.setVisible(false);
        }

       
        
    }

    
   
    public void confirmpanel(String[] se,String[][] plist, String adrs)
    {


        pasli=plist;
        System.out.println("poloolooool");
        preconfirmpanel.setVisible(false);
        lastsp= new JPanel(null);

        trainnumber=se[0];
        start=se[1];
        end=se[2];

        int so;
        int st;
        int eo;
        int et;

        String stt=se[3];
        String[] soo=stt.split(":");
        so=Integer.parseInt(soo[0]);
        st=Integer.parseInt(soo[1]);

        String ett=se[4];
        String[] eoo=ett.split(":");
        eo=Integer.parseInt(eoo[0]);
        et=Integer.parseInt(eoo[1]);

        String traveltimeh=String.valueOf((eo-so));
        String traveltimem=(String.valueOf(Math.abs(et-st)));

        String traveltime;
        traveltime=traveltimeh+"hr "+traveltimem+"min";


        String ssk=(data[0][3]);
        int sk=Integer.parseInt(ssk);

        String eek=(data[1][3]);
        int ek=Integer.parseInt(eek);

        int kilom=ek-sk;
        String kilometer=String.valueOf(kilom)+" "+"Km";


        System.out.println(kilometer+"kkkkkkkkkkkkkkkkkkkkkkkkkkkkk");

        JLabel tl=new JLabel(trainnumber);
        JLabel sl=new JLabel(start);
        JLabel el=new JLabel(end);
        JLabel sst=new JLabel(se[3]);
        JLabel eet=new JLabel(se[4]);
        JLabel tt=new JLabel(traveltime);
        JLabel km=new JLabel(kilometer);
        JLabel coachview = new JLabel(coachfcp);
        JLabel passengerlistl= new JLabel("Passenger list");

        

       
        tl.setBounds(20,10,50,30);
        sl.setBounds(70,10,50,30);
        sst.setBounds(120,10,50,30);


        km.setBounds(90,40,50,30);
        tt.setBounds(150,40,150,30);

        el.setBounds(70,70,50,30);
        eet.setBounds(120,70,50,30);
        coachview.setBounds(20,88,50,30);

        passengerlistl.setBounds(20,105,150,30);


        JLabel[] pll=new JLabel[6];

        int y=130;
        for(int i=0;i<count;i++)
        {
            int ii=i;
            ii++;
            String name=plist[i][0];
            String age=plist[i][1];
            String gende=plist[i][2];



            if(name==null)
            {
                break;
            }
            else
            {
                System.out.println("hello");
                String combine=ii+".  "+name+" ( "+age+","+gende+" )";
                pll[i]=new JLabel(combine);
                pll[i].setBounds(20,y,200,30);
                y+=30;
                lastsp.add(pll[i]);
                
            }

            
        }


        int pricei=Integer.parseInt(pricefcp);
        int price=kilom*pricei*count;
        int servicecharge=20;

        int total=price+servicecharge;

        String servicestr=String.valueOf("₹ "+servicecharge);
        String pricestr= String.valueOf("₹ "+price);
        totalstr= String.valueOf("₹ "+total);
        

        JLabel tip = new JLabel("Ticket price");
        tip.setFont(new Font("calibri",Font.BOLD,18));
        tip.setBounds(20,305,100,50);
        tip.setForeground(Color.white);

        JLabel pricel = new JLabel(pricestr);
        pricel.setFont(new Font("calibri",Font.LAYOUT_RIGHT_TO_LEFT,18));
        pricel.setBounds(350,305,100,50);
        pricel.setForeground(Color.white);

        JLabel scl = new JLabel("Service charge");
        scl.setFont(new Font("calibri",Font.LAYOUT_RIGHT_TO_LEFT,18));
        scl.setBounds(20,325,150,50);
        scl.setForeground(Color.white);

        JLabel sc = new JLabel(servicestr);
        sc.setFont(new Font("calibri",Font.PLAIN,18));
        sc.setBounds(350,325,100,50);
        sc.setForeground(Color.white);

        JLabel gcl = new JLabel("Gateway charge");
        gcl.setFont(new Font("calibri",Font.PLAIN,18));
        gcl.setBounds(20,345,150,50);
        gcl.setForeground(Color.white);

        JLabel gc = new JLabel("₹ 00");
        gc.setFont(new Font("calibri",Font.PLAIN,18));
        gc.setBounds(350,345,100,50);
        gc.setForeground(Color.white);

        JLabel til = new JLabel("Total insurance");
        til.setFont(new Font("calibri",Font.PLAIN,18));
        til.setBounds(20,365,150,50);
        til.setForeground(Color.white);

        JLabel ti = new JLabel("₹ 00");
        ti.setFont(new Font("calibri",Font.PLAIN,18));
        ti.setBounds(350,365,100,50);
        ti.setForeground(Color.white);

        JLabel totalll = new JLabel("Total");
        totalll.setFont(new Font("calibri",Font.BOLD,18));
        totalll.setBounds(20,395,100,50);
        totalll.setForeground(Color.white);

        
        JLabel totall = new JLabel(totalstr);
        totall.setFont(new Font("calibri",Font.BOLD,18));
        totall.setBounds(350,395,100,50);
        totall.setForeground(Color.white);


        book= new JPanel(new FlowLayout());
        JLabel bookl= new JLabel("Confirm");
        book.addMouseListener(this);
        book.add(bookl);
        book.setBounds(350,440,100,30);
        book.setBackground(Color.red);

        lastsp.add(book);
        lastsp.add(tip);
        lastsp.add(pricel);
        lastsp.add(scl);
        lastsp.add(sc);
        lastsp.add(gc);
        lastsp.add(ti);
        lastsp.add(totall);
        lastsp.add(gcl);
        lastsp.add(til);
        lastsp.add(totalll);
        lastsp.add(tl);
        lastsp.add(sl);
        lastsp.add(el);
        lastsp.add(tt);
        lastsp.add(km);
        lastsp.add(eet);
        lastsp.add(sst);
        lastsp.add(coachview);
        lastsp.add(passengerlistl);
    
        lastsp.setBounds(0,0,650,475);
        lastsp.setBackground(Color.black);
        panel61.add(lastsp);
        lastsp.setVisible(true);
        
       
    }




    public boolean checkconfirmpanel(String pin,String phonenumber, String address)
    {


            int checkpassna=0;
            int pincheck=0;
            int phonecount=0;
            int pinccount=0;
            int phonecheck=0;
            int addresscheck=0;

            
            for(char c : pin.toCharArray())
                {
                    if(c>='0' && c<='9')
                    {
                        pinccount++;
                    }
                }
            for(char c : phonenumber.toCharArray())
            {
                if(c>='0' && c<='9')
                {
                    phonecount++;
                }
            }

            System.out.println(pinccount);
            System.out.println(phonecount);
            if(phonecount==12)
            {
               
                phonecheck=1;
            }

            if(pinccount==6)
            {
               
                pincheck=1;
            }

            if(address.length()>15)
            {
                addresscheck=1;
            }

            if(count>0)
            {
                for(int i=0;i<count;i++)
                {
                    String name=pna[i].getText();
                    String age= pa[i].getText();
                    
                    
                    if((name.equals("Name"))&& (name.length()>2)&&(age.equals("Age")))
                    {
                        checkpassna=1;
                        break;
                    }
                }
            }
            else
            {
               checkpassna=1;
            }
            


            if(!(phonenumber.equals("+91 ")) && !(pin.equals("Pincode")) && !(address.equals("Adress"))&&checkpassna==0 && pincheck==1 && phonecheck==1 && addresscheck==1)
            {
                return true;
            }
            else
            {
                oppbox("fill required field's correctly");
                return false;
            }
       
    }

    public void history() throws SQLException
    {

        JPanel hp1= new JPanel(new FlowLayout());
        JPanel hps= new JPanel(null);
        JScrollPane shp= new JScrollPane(hps);
        JPanel ccpanel = new JPanel(null);

        
        System.out.println(unameh+":+++++++++++++++++++++++++++++++++++++++++++++++++++++++++++");

        String[][] answers =gethistoryy(unameh);        
        JComboBox<String>[] nameh = new JComboBox[100];
        JLabel[] namelh=new JLabel[100];
    
        
        int tt=0;
        for(int i=0;i<jh;i++)
        {
            tt=tt+50;
            int pp=50;
            for(int j=0;j<6;j++)
            {
                String temp= answers[i][j];

                if(temp!=null)
                {


                    if(j==0)
                    {
                        trainnno[i]= new JLabel(temp);
                        trainnno[i].setText(temp);
                        trainnno[i].setBounds(pp,tt,100,30);
                        pp=pp+100;

                        System.out.println(trainno[i]);
                        hps.add(trainnno[i]);
                
                    }
                    if(j==1)
                    {
                        coachh[i]= new JLabel(temp);
                        coachh[i].setBounds(pp,tt,100,30);
                        pp=pp+50;
                        hps.add(coachh[i]);
                        System.out.println(coachh[i]);
                    }

                    if(j==2) 
                    {
                        String[] ttt=temp.split(",");
                        if(ttt.length<=1)
                        {
                            uplist[i]=temp;
                            namelh[i]=new JLabel(ttt[0]);
                            namelh[i].setBounds(pp,tt,100,30);
                            pp+=120;
                            hps.add(namelh[i]);

                        }else
                        {
                            uplist[i]=temp;
                            nameh[i]= new JComboBox<String>(ttt);
                            nameh[i].setBounds(pp,tt,100,30);
                            pp=pp+120;
                            hps.add(nameh[i]);
                        }

                        
                        System.out.println(nameh[i]);
                    }

                    if(j==3)
                    {
                        seath[i]= new JLabel(temp);
                        seath[i].setBounds(pp,tt,100,30);
                        pp=pp+50;
                        hps.add(seath[i]);
                        System.out.println(seath[i]);
                    }


                    if(j==4)
                    {
                        
                        priceh[i]= new JLabel(temp);
                        priceh[i].setBounds(pp,tt,100,30);
                        pp=pp+120;
                        hps.add( priceh[i]);
                        System.out.println(priceh[i]);
                    
                    }
                    if(j==5)
                    {
                        if(temp.equals("booked"))
                        {
                            can[i]=new JLabel("cancel");
                            cancelh[i] = new JPanel(new FlowLayout());
                            cancelh[i].setBounds(pp,tt,80,30);
                            cancelh[i].setBackground(Color.red);
                            cancelh[i].add(can[i]);
                            cancelh[i].addMouseListener(this);
                            hps.add(cancelh[i]);
                        }

                        if(temp.equals("cancelled"))
                        {
                            can[i]=new JLabel("cancelled");
                            cancelh[i] = new JPanel(new FlowLayout());
                            cancelh[i].setBounds(pp,tt,80,30);
                            cancelh[i].setBackground(Color.cyan);
                            cancelh[i].add(can[i]);
                            hps.add(cancelh[i]);
                        }
                        
                        
                    }


                }

                
            }
        }

        hp1.setBounds(0,-50,670,490);
        hp1.setBackground(Color.BLACK);


        int height=jh*56;
        hps.setPreferredSize(new Dimension(650,height));       
        hps.setBackground(Color.BLACK);
        hps.setAutoscrolls(true);       

        shp.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
        shp.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED);
        shp.setBackground(Color.blue);
        shp.setBounds(0,0,650,490);


        ccpanel.setPreferredSize(new Dimension(660,800));
        ccpanel.setBackground(Color.black);
        ccpanel.add(shp);

        hp1.add(ccpanel);
        panel71.removeAll();
        panel71.setLayout(new FlowLayout());
        panel71.add(hp1);
        

    }

    public void mainframe() throws SQLException {

        Dimension screensize = Toolkit.getDefaultToolkit().getScreenSize();
        int height = screensize.height;
        int width = screensize.width;

        titlebar.setBounds(0, 0, 800, 25);
        titlebar.setBackground(Color.black);

        titlebar.addMouseMotionListener(this);
        titlebar.addMouseListener(this);

        closel.setBounds(778, 2, 40, 20);
        closel.setForeground(Color.red);
        closel.setFont(new Font("TimesNewRoman", 1, 20));
        closel.addMouseListener(this);

        tname.setBounds(35, 2, 100, 20);
        tname.setForeground(Color.orange);

        titlebar.add(closel);
        titlebar.add(tname);

        leftpanels();
        rightpanel5();
        
       

        panel7.setVisible(false);
        panel8.setVisible(false);

        ff.add(panel5);
        ff.add(panel6);
        ff.add(panel7);
        ff.add(panel8);
        ff.add(titlebar);
        ff.setUndecorated(true);
        ff.setLayout(null);
        ff.setBounds(width / 2 - 400, height / 2 - 250, 800, 500);
        ff.setVisible(true);
    }

    

  
    @Override
    public void mouseClicked(MouseEvent e) 
    {

        if(e.getSource()==continuebutton)
        {
            String phonenumber=phonenumberfield.getText();
            String pin=pinfield.getText();
            String address=addressfield.getText();

            boolean entrycheck=checkconfirmpanel(pin,phonenumber,address);

            String[] se={tn,ts,te,tst,tet};
            System.out.println(se+"****************");
            if(entrycheck)
            {
                
                String[][] pl= new String[6][3];
                for(int i=0;i<count;i++)
                {
                    for(int j=0;j<3;j++)
                    {
                        if(j==0)
                        {
                            pl[i][j]=pna[i].getText();
                        }
                        
                        if(j==1)
                        {
                            pl[i][j]= pa[i].getText();
                        }

                        if(j==2)
                        {
                            pl[i][j]=(String)pg[i].getSelectedItem();
                        }
                        
                    }
                }
                   
                    
                
                confirmpanel(se,pl,address);
            }

            
           
        }
        System.out.println(e.getSource());

        Object oo =e.getSource();
        for(int cpi=0;cpi<coachpanelcount;cpi++)
        {
            if(oo==coachpanel[cpi])
            {
                System.out.println("helo here coach panel is "+" "+cpi);
                for(int spi=0;spi<scrollingpanelcount;spi++)
                {
                    if( coachpanel[cpi].getParent()==sp1[spi])
                    {
                        coachfcp=clab[cpi].getText();
                        pricefcp=plab[cpi].getText();
                        seatstr=slab[cpi].getText();
                        String seatc=slab[cpi].getText();
                        String[] seatcc=seatc.split(" ");
                        seatcount=Integer.parseInt(seatcc[0]);
                        if(seatcount>0)
                        {
                            
                            System.out.println("scrolling panel count =="+" "+spi+"coach and seat"+slab[cpi].getText());
                            preconfirm(cpi,spi);
                        }
                        else{
                            oppbox("seats are filled");
                        }

                       
                    }
                }
            }
        }

            
        if (e.getSource() == closel) {
            ff.dispose();
        }
        if (e.getSource() == titlebar && e.getClickCount() == 2) {
            ff.setState(Frame.ICONIFIED);
        }

        if (e.getSource() == bookticket) {

            backgroundimage.setBounds(0, 120, 650, 364);
            if(preconfirmpanel!=null)
            {
                panel61.remove(toppanel);
                panel61.remove(cpanel);
                panel61.remove(scroller);
                panel61.remove(preconfirmpanel);
                preconfirmpanel=null;    
                toppanel=null;
                cpanel=null;
                scroller=null;  
                if(pctoppanel!=null)
                {
                    
                    pctoppanel=null;
                    pcpanel=null;
                    pscroller=null;
                }

               
            }
            if(lastsp!=null)
            {
                System.out.println("removed");
                panel61.remove(lastsp);
                lastsp=null;
            }
            if(thankyoupanel!=null)
            {
                panel61.remove(thankyoupanel);
                thankyoupanel=null;
            }

            if(panel63!=null)
            {
            
                if(scrollPane!=null)
                {
                    scrollPane.remove(bigpanel);
                    panel63.remove(scrollPane);
                }
               
                
                panel61.remove(panel63);
                

                contentPane=null;
                bigpanel=null;
                scrollPane=null;

            }
            
            

               
            panel62.setVisible(true);
           
            panel6.setVisible(true);
            panel7.setVisible(false);
            panel8.setVisible(false);
        }
        if (e.getSource() == history) {
            panel6.setVisible(false);
            panel7.setVisible(true);
            panel8.setVisible(false);
        }

        if (e.getSource() == logout) {
            panel6.setVisible(false);
            panel7.setVisible(false);
            panel8.setVisible(true);
        }

        if (e.getSource() == panel83) {
            try {
                new database().close();
            } catch (SQLException e1) {
                // TODO Auto-generated catch block
                e1.printStackTrace();
            }
            ff.dispose();
        }

        String originvalue = origin.getText();
        String destinationvalue = destination.getText();

        if (e.getSource() == origin && originvalue.equals("from ?")) {
            origin.setText("");
            if (destinationvalue.equals("")) {
                destination.setText("to ?");
            }
        }

        if (e.getSource() == destination && destinationvalue.equals("to ?")) {
            destination.setText("");
            if (originvalue.equals("")) {
                origin.setText("from ?");
            }
        }

        if (e.getSource() == date) {
            Date d = date.getDate();
            SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
            sd = sdf.format(d);
        }

        String sq = quota.getItemAt(quota.getSelectedIndex());

        if (e.getSource() == quota && sq.equals("General") || sq.equals("Ladies") || sq.equals("Tatkal")
                || sq.equals("Senior")) {

            if (originvalue.length() > 4 && destinationvalue.length() > 4 && sd.length() > 9 && sq.length() > 5) {
                panel6.remove(panel63);
            }
        }


        if(e.getSource()==addressfield)
        {
            if(addressfield.getText().equals("Adress"))
            {
                addressfield.setText("");
            }
            if(streetfield.getText().equals(""))
            {
                streetfield.setText("Street (Optional)");
            }
            if(colonyfield.getText().equals(""))
            {
                colonyfield.setText("Colony (Optional)");
            }
            if(pinfield.getText().equals(""))
            {
                pinfield.setText("Pincode");
            }
        }

        if(e.getSource()==streetfield)
        {
            if(streetfield.getText().equals("Street (Optional)"))
            {
                streetfield.setText("");
            }
            if(addressfield.getText().equals(""))
            {
                addressfield.setText("Adress");
            }
            if(colonyfield.getText().equals(""))
            {
                colonyfield.setText("Colony (Optional)");
            }
            if(pinfield.getText().equals(""))
            {
                pinfield.setText("Pincode");
            }
        }

        if(e.getSource()==colonyfield)
        {
            if(colonyfield.getText().equals("Colony (Optional)"))
            {
                colonyfield.setText("");
            }
            if(addressfield.getText().equals(""))
            {
                addressfield.setText("Adress");
            }
            if(streetfield.getText().equals(""))
            {
                streetfield.setText("Street (Optional)");
            }
            if(pinfield.getText().equals(""))
            {
                pinfield.setText("Pincode");
            }
        }

        if(e.getSource()==pinfield)
        {
            if(pinfield.getText().equals("Pincode"))
            {
                pinfield.setText("");
            }
            if(addressfield.getText().equals(""))
            {
                addressfield.setText("Adress");
            }
            if(colonyfield.getText().equals(""))
            {
                colonyfield.setText("Colony (Optional)");
            }
            if(streetfield.getText().equals(""))
            {
                streetfield.setText("Street (Optional)");
            }
        }

        if(e.getSource()==book)
        {
            String[] sarr=seatstr.split(" ");
            int counttii=Integer.parseInt(sarr[0]);
            
            String updateseat=String.valueOf(counttii-count);
            System.out.println(trainnumber+" "+coachfcp+" "+updateseat);

            StringBuilder temp= new StringBuilder();
            for( int i=0;i<count;i++)
            {
                temp.append(pasli[i][0]);
                if(i!=count-1)
                {
                    temp.append(",");
                }
                
            }
            
            int updatecheck= 0;
            int hd=0;
            try {
                updatecheck = new database().updatedetails(trainnumber,coachfcp,updateseat);
                hd=historydata(unameh,trainnumber,coachfcp,temp,count,totalstr);
            } catch (SQLException e1)
            {
                
                e1.printStackTrace();
            }
            
            if(updatecheck!=0 && hd!=0)
            {

               
                oppbox("your ticket has been booked sucessfully");
                lastsp.setVisible(false);
                panel61.remove(lastsp);
                lastsp=null;
                thankyoupanel = new JPanel(null);
                JLabel thankyoulabel = new JLabel("Enjoy your Journey.....");
                
                thankyoulabel.setFont(new Font("Calibri",Font.BOLD,20));

                thankyoupanel.add(thankyoulabel);
                thankyoulabel.setForeground(Color.red);
                thankyoulabel.setBounds(220,190,250,75);
                thankyoupanel.setBounds(0,0,650,475);
                thankyoupanel.setBackground(Color.black);
                panel61.add(thankyoupanel);
            }
            else
            {
                oppbox("server error try again later");
            }
        }


        for(int i=0;i<5;i++)
        {
            if(e.getSource()==cancelh[i])
            {

                
                String no=trainnno[i].getText();
                String ch=coachh[i].getText();
                String ss=seath[i].getText();
                String sc="";
				try {
					sc = seatc(no,ch);
				} catch (SQLException e2) {
					// TODO Auto-generated catch block
					e2.printStackTrace();
				}

                int sss=Integer.parseInt(ss);
                int ssc=Integer.parseInt(sc);

                sss=ssc+sss;
                String us=String.valueOf(sss);
                
                try {

                   
                    if(updatedetails(no,ch,us)!=0)
                    {
                        if( updateuserhistory(unameh,no,ch,uplist[i],ss)!=0)
                        {
                            oppbox("your ticket cancelled sucessfully");
                            can[i].setText("Cancelled");
                            cancelh[i].removeMouseListener(this);
                            cancelh[i].setBackground(Color.CYAN);
                        }
                        
                    }
                    else
                    {
                        oppbox("server error try again later");
                    }
                } catch (SQLException e1) {
                    // TODO Auto-generated catch block
                    e1.printStackTrace();
                }
            }

        }

        


    }

  

    @Override
    public void mouseDragged(MouseEvent e) {
        ff.setLocation(ff.getX() + e.getX() - mouseX, ff.getY() + e.getY() - mouseY);
    }

    @Override
    public void mouseReleased(MouseEvent e) {
        // TODO Auto-generated method stub

    }

    @Override
    public void mouseEntered(MouseEvent e) {

        if (e.getSource() == bookticket) {
            bookticket.setBackground(Color.red);
        }
        if (e.getSource() == history) {
            try {
                history();
            } catch (SQLException e1) {
                // TODO Auto-generated catch block
                e1.printStackTrace();
            }
            history.setBackground(Color.red);
        }

        if (e.getSource() == logout) {
            logout.setBackground(Color.red);
        }

        if (e.getSource() == panel83) {
            panel83.setBackground(Color.red);
            panel83logoutlabel.setForeground(Color.blue);
        }

    }

    @Override
    public void mouseExited(MouseEvent e) {
        if (e.getSource() == bookticket) {
            bookticket.setBackground(Color.BLACK);
        }

        if (e.getSource() == logout) {
            logout.setBackground(Color.BLACK);
        }
        if (e.getSource() == history) {
            history.setBackground(Color.BLACK);
        }
        if (e.getSource() == panel83) {
            panel83.setBackground(new Color(58, 14, 71));
            panel83logoutlabel.setForeground(Color.red);
        }

    }

    @Override
    public void mouseMoved(MouseEvent e) {
        // 645454
    }

    @Override
    public void mousePressed(MouseEvent e) {
        mouseX = e.getX();
        mouseY = e.getY();
        System.out.println(mouseX + "---" + mouseY);

    }

    @Override
    public void actionPerformed(ActionEvent e) 
    {
        if (e.getSource() == findtrainbutton) 
        {
            ccii=0;
            
            starting = origin.getText();
            ending = destination.getText();
             DateFormat sdd = new SimpleDateFormat("dd-MM-yyy");

            try
            {
               
            
           
            selecteddate=sdd.format(date.getDate());
            System.out.println(selecteddate);
            }
           catch(java.lang.NullPointerException ee)
            {
                
                System.out.println(ee);
                Date datet= new Date();
                selecteddate= sdd.format(datet);
                System.out.println(selecteddate);
            }

            try {
                if(starting.equals("from ?") || ending .equals("to ?"))
                {
                    oppbox("enter source and destination");
                }
                else
                {
                    data=traindatabase(starting ,ending);
                System.out.println(data+"++++++++++++++");
                }
                
               
            } catch (SQLException e1) 
            {
                e1.printStackTrace();
            }
            backgroundimage.setBounds(0, 0, 0, 0);
            if(data[0][0]==null)
            {
               oppbox("NO trains found");
            }
            else
            {
                try {
                    resultingpanel(10, data, selecteddate);
                } catch (SQLException e1) {
                    // TODO Auto-generated catch block
                    e1.printStackTrace();
                }
                panel63.setVisible(true);
            }
                       
        }

        if(e.getSource()==go)
        {
            String cc=passengercountfield.getText();
            
            int ccc= Integer.parseInt(cc);
            if (ccc <= seatcount)
            {
                addpassenger(cc);
            }
            else
            {
                oppbox("seats you asked is more than available");
            }
        }

       
       
    }

    

    public static void main(String[] a) throws SQLException
    {
        new frame2().mainframe();
    }
}