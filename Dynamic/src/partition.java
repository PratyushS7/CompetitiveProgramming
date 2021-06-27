import java.util.*;
class partition
{
	static int num; static int n; static char a[]; static long max; static long dp[][][];
	public static void main (String[] args)
	{
		Scanner sc=new Scanner(System.in); 
		int t=sc.nextInt();
		while(t-->0)
		{
			int i; int k=sc.nextInt()-1; num=sc.nextInt(); a=sc.next().toCharArray(); n=a.length;max=-1; long dp[][][]=new long[n+1][n+1][k+1];
			for(i=0;i<=n;i++)
			{
				for(int j=0;j<=n;j++) Arrays.fill(dp[i][j],Integer.MIN_VALUE);
			}
			for (i = 0; i < n; i++)
			{
				for(int j = i; j < n; j++) dp[i][j][0]=calc(i,j);
			}
			for(int p=1;p<=k;p++)
			{
				for(i=0;i<n;i++)
				{
					for(int j=i+1;j<n;j++)
					{
						if(dp[n-1][j][p-1]!=-1&&dp[0][i][0]!=-1)
						{
							dp[0][j][p]=Math.max(dp[0][j][p], dp[i+1][j][p-1]+dp[0][i][0]);
							max=Math.max(max, dp[0][n-1][k]);
						}
					}
				}	
			}
			//max = solve(k,0,n-1);
			System.out.println(max);
			//System.out.println(dp[0][n-1][k]);
		}
	}
	public static long solve(int k,int st,int end)
	{
		if(k<0||st>end) return -1;
		if(dp[st][end][k]!=Integer.MIN_VALUE) return dp[st][end][k];
		for(int i=st;i<n;i++)
		{
			if(dp[st][i][0]!=-1)
			{
				long c=solve(k-1,i+1,end);
				if(c!=-1)
					dp[st][end][k]=Math.max(dp[st][end][k], c+dp[st][i][0]);	
			}
		}
		if(dp[st][end][k]==Integer.MIN_VALUE) dp[st][end][k]=-1;
		return dp[st][end][k];
	}
	public static int calc(int b,int c)
	{
		long v=0;
		for(int i=b;i<=c;i++)
		{
			v=(long)v*10+ a[i]-'0';
			if(v>num)
			{
				v=-1; break;
			}
		}
		return (int)v;
	}
}