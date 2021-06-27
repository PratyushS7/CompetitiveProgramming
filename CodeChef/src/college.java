import java.util.*;
class college 
{
	static Scanner sc=new Scanner(System.in);
	public static void main(String[] args)
	{
		int t=1;
		while(t-->0) solve();
	}
	public static void solve()
	{
		int i; int n=sc.nextInt(); int a[]=new int[n]; int ans=0; int minb=Integer.MAX_VALUE/3,maxb=0;
		for(i=0;i<n;i++) a[i]=sc.nextInt();
		for(i=0;i<n;i++)
		{
			if(a[i]<minb)
			{
				minb=a[i];
			}
			ans=Math.max(a[i]-minb, ans);
		}
		System.out.println(ans);
	}
}
