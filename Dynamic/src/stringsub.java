import java.util.*;
public class stringsub 
{
	public static void main(String [] args)
	{
		Scanner sc=new Scanner(System.in);
		int i;
		char a[]=sc.next().toCharArray(); char b[]=sc.next().toCharArray();
		int m=a.length; int n=b.length; int dp[][]=new int[m+1][n+1];
		for(i=0;i<=m;i++)
			dp[i][0]=1;
		for(i=1;i<=m;i++)
		{
			for(int j=1;j<=n;j++)
			{
				if(a[i-1]==b[j-1])
					dp[i][j]=dp[i-1][j-1]+dp[i-1][j];
				else 
					dp[i][j]=dp[i-1][j];
			}
		}
		System.out.println(dp[m][n]);
	}
}

