import java.sql.*;

import javax.sound.midi.SysexMessage;

class mainndata
{
    Connection sql;
    static Statement query;
    int onezero;
    static ResultSet result;
    static final String url = "jdbc:mysql://127.0.0.1:3306/trainticketdatabase";
    static final String nanthan = "root";
    static final String sollamudiyathu = "Lumia535*";

}

public class database extends mainndata {
    static String conerr = "0";
    static String userid;
    static String password;
    static String dobd;
    static String userdata;
    int rowsize=0;


    

    database() {
        try {
            sql = DriverManager.getConnection(url, nanthan, sollamudiyathu);
            query = sql.createStatement();

        } catch (Exception e) {
            conerr = "y";
            System.out.println(e);
        }
    }

    public String checkcredentials(String user, String pass) throws SQLException {
        userdata = user;
        System.out.println(userdata);
        if (conerr.equals("0")) {

            String check = "SELECT * FROM userdata WHERE LOGINID='" + user + "'and PASSWORD='" + pass + "'";
            result = query.executeQuery(check);
            if (result.next()) {
                return "1";
            }
            return "0";
        } else {
            return conerr;
        }

    }

    public int checkforduplicate(String user) throws SQLException {

        String check = "SELECT * FROM userdata WHERE LOGINID='" + user + "'";
        result = query.executeQuery(check);
        if (result.next()) {
            return 1;
        }
        return 0;
    }

    public String credentials(String user, String pass, String dob) throws SQLException {

        if (conerr.equals("0")) {

            userid = user;
            password = pass;
            String[] name = userid.split("@");
            dobd = dob;
            int checkonezero = checkforduplicate(user);

            if (checkonezero == 0) {

                String insert = "INSERT INTO `trainticketdatabase`.`userdata` (`LOGINID`, `PASSWORD`, `NAME`, `DOB`) VALUES ('"
                        + userid + "', '" + password + "','" + name[0] + "','" + dobd + "')";
                onezero = query.executeUpdate(insert);

                if (onezero == 0) {
                    System.out.println("000000000000000000000");
                    return "00";
                } else {
                    System.out.println("11111111111111111111");
                    return "1";
                }

            } else {
                return "0";
            }
        } else {
            return conerr;
        }

    }

    public String getdata(String needed) throws SQLException {


       
        String check = "SELECT * FROM userdata WHERE LOGINID='" + userdata + "'";
        result = query.executeQuery(check);
        if (result.next()) {
            if (needed.equals("dob")) {
                return result.getString(5);
            } else {
                return result.getString(4);
            }

        } else {
            return "-----";
        }

    }

    public  String[][] traindatabase(String start, String end) throws SQLException
    {
        String[][] arr = new String[100][4];
        String[][] arrr = new String[100][4];
        try {
            sql = DriverManager.getConnection(url, nanthan, sollamudiyathu);
            query = sql.createStatement();
            conerr="1";

        } catch (Exception e) {
            conerr = "y";
            System.out.println(e);
        }
       
        if(conerr.equals("1"))
        {
          
            System.out.println("conn error False");
            String source = start;
            String destination = end;
            String get = "select * from trainplaceandtime where (place ='" + source
                    + "'  and no in (select no from trainplaceandtime where place = '" + destination + "')) or (place ='"
                    + destination + "'  and no in (select no from trainplaceandtime where place = '" + source + "'))";
            result = query.executeQuery(get);

            int j=0;
            int i=0;
            int iii=0;
            int jjj=0;
        while(result.next())
            {
            arr[i][j]=result.getString(2);
            System.out.print(arr[i][j]+" ");
            j++;
            arr[i][j]=result.getString(3);
            System.out.print(arr[i][j]+" ");
            j++;
            arr[i][j]=result.getString(4);
            System.out.print(arr[i][j]+" ");
            j++;
            arr[i][j]=result.getString(5);
            System.out.println(arr[i][j]);
            j=0;
            i++;
           
            }
            int check=0;
            for (int fi=0;fi<i;fi++)
            {
                 String cc=arr[fi][1];
                 cc=cc.toLowerCase();
                 source=source.toLowerCase();
                 check=0;
                for(int fj=0;fj<4;fj++)
                {
                   
                    if(fi%2==0)
                    {
                        if( cc.equals(source))
                        {
                            System.out.print(arr[fi][fj]);
                            System.out.println("+++++++++");
                            arrr[iii][jjj]=arr[fi][fj];
                            check=1;
                            jjj++;
                            
                            
                        }
                        
                    }
                    if(fi%2!=0)
                    {
                        if( cc.equals(destination))
                        {
                            System.out.print(arr[fi][fj]);
                            System.out.println("---------");
                            arrr[iii][jjj]=arr[fi][fj];
                            check=1;
                            jjj++;
                           
                        }
                        
                    }
                   
                }
                if(check==1)
                {
                    iii++;
                    jjj=0;
                }
                
            }

            System.out.println(iii);
            rowsize=iii;
            System.out.println(rowsize);
            return arrr; 
        }
        else
        {
            System.out.println("conn error true");
           return arrr;
        }
        

    }

    public  String[][] getdetailswithtrainno(String no) throws SQLException
    {
        String[][] traindetails=new String[100][4];int pp=0;
        int pj=0;
        
        
            String gettd="SELECT * FROM trainticketdatabase.traincoachandseat  WHERE NO='"+no+"';";
            result=query.executeQuery(gettd);
            
            while(result.next())
            {
                System.out.print(result.getString(3)+"  ");
                traindetails[pp][pj]=result.getString(3);
                pj++;
                System.out.print(result.getString(4)+" ");
                traindetails[pp][pj]=result.getString(4);
                pj++;
                System.out.println(result.getString(5)+" ");
                traindetails[pp][pj]=result.getString(5);
                pj=0;
                pp++;
            }
            System.out.println("*****************************");
        
       

        for(int i=0;i<7;i++)
        {
            for(int j=0;j<3;j++)
            {
                System.out.print(traindetails[i][j]+" ");
            }
            System.out.println();
        }
        return traindetails;

    
    }

    public int updatedetails(String number,String coach,String updatevalue) throws SQLException
    {
        String upv ="UPDATE `trainticketdatabase`.`traincoachandseat` SET `SEAT` = '"+updatevalue+"' WHERE (NO='"+number+"')and (coach='"+coach+"');";
        return query.executeUpdate(upv);
        
    }

    public int historydata(String uname,String number,String coach,StringBuilder temp,int count,String p) throws SQLException
    {
        String ui=uname;
        String booked="booked";
        String doo =" INSERT INTO `trainticketdatabase`.`userhistory` (USERID,trainno, coach,list, seat, price,bookingstatus) VALUES ('"+ui+"',  '"+number+"', '"+coach+"','"+temp+"', '"+count+"', '"+p+"','"+booked+"');";
        return query.executeUpdate(doo);

    }

    public String seatc(String number,String coach) throws SQLException
    {
        String upv ="SELECT seat FROM trainticketdatabase.traincoachandseat where no='"+number+"' and coach='"+coach+"';";
        ResultSet r= query.executeQuery(upv);

        r.next();
        String ss=r.getString(1);
        return ss;
    
        
    }


    int jh=0;
    public String[][] gethistoryy(String ui) throws SQLException
    {
        String[][] his=new String[100][6];
        int i=0;
        int j=0;
        result=null;
        String get="SELECT * FROM trainticketdatabase.userhistory where userid='"+ui+"';";
        result=query.executeQuery(get);
        while(result.next())
        {
            i=0;
            his[j][i]=result.getString(3);
            i++;
            his[j][i]=result.getString(4);
            i++;
            his[j][i]=result.getString(5);
            i++;
            his[j][i]=result.getString(6);
            i++;
            his[j][i]=result.getString(7);
            i++;
            his[j][i]=result.getString(8);
            j++;
        }

        jh=j;
        return his;
    }
    
    public void close() throws SQLException
    {
        userdata="";
        userid="";
        conerr="1";
        userid="";
        password="";
        dobd="";
        sql.close();
    }
    /**/

	public int updateuserhistory(String unameh, String no, String ch, String string, String ss) throws SQLException 
    {
        String up="UPDATE `trainticketdatabase`.`userhistory` SET bookingstatus = 'cancelled' WHERE (USERID = '"+unameh+"') and (trainno='"+no+"' )and (coach='"+ch+"') and (list='"+string+"') and (seat='"+ss+"');";
        return query.executeUpdate(up);
    }
    public static void main (String[] args)throws SQLException 
    {
        database d=new database();
        //d.traindatabase("salem","erode");
        System.out.println(d.updateuserhistory("admin","2620","gn","Shilo S,Prawin S","2"));
        
    }

}


