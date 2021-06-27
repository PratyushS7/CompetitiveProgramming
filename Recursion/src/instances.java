import java.util.Scanner;
import java.util.Stack;
class instances
{
	public static void main (String[] args)
	 {
		Scanner sc=new Scanner(System.in); 
		int t,i,n,j;
		n=sc.nextInt();
		int a[]=new int[n];
		for(i=0;i<n;i++)
			a[i]=sc.nextInt();
		int k=sc.nextInt();
		int c=count(a,n-1,k);
		System.out.println(c);
	}
	public static int count(int a[],int n,int k)
	{
		if(n==-1)
			return 0;
		else 
		{
			if(a[n]==k)
				return 1+count(a,n-1,k);
			else 
				return count(a,n-1,k);
		}
	}
}