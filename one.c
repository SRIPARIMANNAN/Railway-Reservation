import java.io.*;
import java.String;
public static int last2(String str) 
{
  int count =0;
  if(str.length()<3)
    return 0;
  int ii=0;
  String s=str.substring(str.length()-3,str.length());
  String tt=str.substring(0,str.length()-2);
  
  for(int i=0;i<tt.length()-3;i++)
  {
    if(tt.substring(i,i+2).equals(s))
    {
      count++;
    }
  }
  
  return count;
}

public class Main
{
	public static void main(String[] args) {
		System.out.println(last2("xxaxxaxxaxx").toString());
		
	}
}
