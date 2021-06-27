import java.util.*;
public class KMP 
{
	public static void main(String [] args)
	{
		Scanner sc=new Scanner(System.in);
		int i; char a[]=sc.next().toCharArray(); int n=a.length;
		int ans[]=new int[n+1];
		int pr[]=pref(a);
		for(i=0;i<n;i++)
			ans[pr[i]]++;
		for(i=n-1;i>0;i--)
			ans[pr[i-1]]+=ans[i];
		for(i=0;i<n;i++)
			ans[i]++;
		System.out.println();
	}
	static int[] pref(char a[])
	{
		int i; int n=a.length; int p[]=new int[n];
		for(i=1;i<n;i++)
		{
			int j=p[i-1];
			while(j>0&&a[i]!=a[j]) j=p[j-1];
			if(a[i]==a[j]) j++;
			p[i]=j;
		}
		return p;
	}
}
