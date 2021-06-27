import java.util.*;
public class LIS 
{
	public static void main(String []args)
	{
		String s="ecfbefdcfca"; String t="badfcbebbf";
		 char a[]=s.toCharArray(); char b[]=t.toCharArray(); int n=a.length,m=b.length;
	        int dp[][]=new int[n+1][m+1];
	        for(int i=0;i<n;i++)
	        {
	            for(int j=0;j<m;j++)
	            {
	                if(a[i]==b[j]) dp[i+1][j+1]=dp[i][j]+1;
	                else
	                {
	                    dp[i+1][j+1]=Math.max(dp[i][j+1],dp[i+1][j]);
	                }
	            }
	        }
	       
		System.out.println(dp[n][m]);
		System.out.println(dp[n][m]-n+Math.abs(m-n));
	}
	public static void simple(int a[],int dp[])
	{
		int i,n=a.length; 
		for(i=1;i<n;i++)
		{
			for(int j=0;j<i;j++)
			{
				if(a[j]<a[i]) dp[i]=Math.max(dp[j]+1,dp[i]);
			}
		}
	}
}
