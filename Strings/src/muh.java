import java.util.Scanner;
public class muh 
{
	public static void main(String [] args)
	{
		Scanner sc=new Scanner(System.in);
		int i; int n=sc.nextInt(); int m=sc.nextInt(); int et[]=new int[m]; int bt[]=new int[n]; int ans=0;
		for(i=0;i<n;i++) bt[i]=sc.nextInt();
		for(i=0;i<m;i++) et[i]=sc.nextInt();
		if(m>n)
		{
			System.out.println(0); return;
		}
		if(m==1)
		{
			System.out.println(n); return;
		}
		int e[]=new int[m-1]; int b[]=new int[n-1];
		
		for(i=1;i<n;i++) 	b[i-1]=bt[i]-bt[i-1];
		for(i=1;i<m;i++) 	e[i-1]=et[i]-et[i-1];
		m--; n--;
		int p[]=pref(e);
		i=0; int j=0; 
		while(i<n)
		{
			//if(j==0) cur=e[0]-b[i];
			if(b[i]==e[j])
			{
				i++; j++;
			}
			if(j==m) 
			{
				ans++; j=p[j-1];
			}
			//if(j==0&&i<n) cur=e[0]-b[i];
			else if(i<n&&b[i]!=e[j])
			{
				if(j==0) i++;
				else
					j=p[j-1];
			}
		}
		System.out.println(ans);
	}
	static int[] pref(int a[])
	{
		int i,n=a.length; int p[]=new int[n];
		for(i=1;i<n;i++)
		{
			int j=p[i-1];
			while(j>0&&a[i]!=a[j]) j=p[j-1];
			if(a[j]==a[i]) j++;
			p[i]=j;
		}
		return p;
	}
}
