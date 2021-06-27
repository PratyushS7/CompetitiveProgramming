import java.util.*;
public class decom 
{
	public static void  main(String []args)
	{
		Scanner sc=new Scanner(System.in);
		int i; int n=sc.nextInt(); 
		int a[]=new int[n];
		
		for(i=0;i<n;i++)
			a[i]=sc.nextInt();
		
		int len=(int)Math.sqrt(n)+1;
		int b[]=new int[len];
		
		for(i=0;i<n;i++)
			b[i/len]+=a[i];
		
		int q=sc.nextInt();
		for(i=0;i<q;i++)
		{
			int l=sc.nextInt()-1; int r=sc.nextInt()-1;
			int cl= l/len; int cr= r/len;
			int sum=0;
			if(cl==cr)
			{
				for(i=l;i<=r;i++)
					sum+=a[i];
			}
			else
			{
				for(int j=l,end=(cl+1)*len;j<end;j++)
					sum+=a[j];
				for(int j=cl+1;j<=cr-1;j++)
					sum+=b[j];
				for(int j=cr*len;j<=r;j++)
					sum+=a[j];
			}
			System.out.println(sum);
		}
	}
}
