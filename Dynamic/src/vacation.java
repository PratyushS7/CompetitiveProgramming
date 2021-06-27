import java.util.Arrays;
import java.util.Collections;
import java.util.*;
class vacation
{
	public static void main (String[] args)
	{
		Scanner sc=new Scanner(System.in); 
		int t,i;	
		int n=sc.nextInt();
		int a[][]=new int[n][3];
		for(i=0;i<n;i++)
		{
			a[i][0]=sc.nextInt();
			a[i][1]=sc.nextInt();
			a[i][2]=sc.nextInt();
		}
		long dp[][]=new long[n+1][3];
		for(i=1;i<=n;i++)
		{
			for(int j=0;j<3;j++)
			{
				for(int k=0;k<3;k++)
				{
					if(j!=k)
					{
						dp[i][j]=Math.max(dp[i][j], dp[i-1][k]+a[i-1][k]);
					}
				}
			}
		}
		System.out.println(Math.max(dp[n][0], Math.max(dp[n][1], dp[n][2])));
	}
}