import java.util.Scanner;
import java.util.Stack;
class replace
{
	public static void main (String[] args)
	 {
		Scanner sc=new Scanner(System.in); 
		int i,j;
		String s;
		s=sc.next();
		char[] cs=s.toCharArray();
		char r=sc.next().charAt(0);
		char rep=sc.next().charAt(0);
		int len=s.length();
		count(cs,len,r,rep);
	}
	public static void count(char cs[],int len, char r,char rep)
	{
		if(len==0)
		{
			System.out.println(cs);
		}
		else 
		{
			if(cs[len-1]==r)
			{
				cs[len-1]=rep;
				count(cs,len-1,r,rep);
			}
			else {
				count(cs,len-1,r,rep);
			}
		}
	}
}