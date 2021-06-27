import java.util.Scanner;
import java.util.Stack;
class count_7
{
	public static void main (String[] args)
	 {
		Scanner sc=new Scanner(System.in); 
		int t,i,n,j;
		n=sc.nextInt();
		int c=count(n);
		System.out.println(c);
	}
	public static int count(int n)
	{
		if(n==0)
			return 0;
		else 
		{
			if(n%10==7)
			{
				return 1+count(n/10);
			}
			else
			{
				return count(n/10);
			}
		}
	}
}