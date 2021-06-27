import java.util.*;
class orderset
{
	public static void main(String[] args)
	{
		Scanner sc=new Scanner(System.in); int max=5;
		int i; int t=sc.nextInt();
		while(t-->0)
		{
			int n=sc.nextInt(); int p=(int) Math.min(sc.nextLong(),max)-1; int e[]=new int[n]; int ans=0;
			//p=Math.max(p, 0);
			/*
			if(p==0)
			{
				System.out.println(0); continue;
			}
			 */
			int a[]=new int[n]; int dp[][]=new int[n+1][max+1];
			for(i=0;i<=n;i++) Arrays.fill(dp[i], Integer.MIN_VALUE/3);
			for(i=0;i<n;i++) e[i]=sc.nextInt();
			for(i=0;i<n;i++) a[i]=sc.nextInt();
			if(p<0)
			{
				System.out.println(0); continue;
			}
			dp[0][p]=0;
			for(i=1;i<=n;i++)
			{
				for(int j=max;j>=0;j--)
				{
					if(dp[i-1][j]==Integer.MIN_VALUE/3) continue;
					if(j>0)
					{
						dp[i][j-1]=Math.max(dp[i][j-1], a[i-1]+dp[i-1][j]);
						ans=Math.max(ans, dp[i][j-1]);
					}
					if(j==0)
					{
						ans=Math.max(ans, dp[i-1][0]+a[i-1]);
					}
					if(j+e[i-1]-1>=0)
					{
						dp[i][Math.min(j+e[i-1]-1, max)] = Math.max(dp[i][Math.min(j+e[i-1]-1, max)], dp[i-1][j]);
					}
				}
			}
			for(i=max;i>=0;i--) ans=Math.max(dp[n][i], ans);
			System.out.println(ans);
		}
	}
}