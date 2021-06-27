import java.util.*;
class trisq
{
	public static void main (String[] args)
	 {
		Scanner sc=new Scanner(System.in); 
		int t,i,n,j;
		t=sc.nextInt();
		while(t>0)
		{
			t--;
			int b=sc.nextInt();
			int ans=calculate(b-2);
			System.out.println(ans);
			
		}
	}
	public static int  calculate(int b)
	{
		if(b<=0)
			return 0;
		else
		{
			return b/2+calculate(b-2);
		}
	}
}