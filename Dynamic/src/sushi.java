import java.util.Arrays;
import java.util.Collections;
import java.util.*;
class sushi
{
	public static void main (String[] args)
	{
		Scanner sc=new Scanner(System.in); 
		int i;
		int n=sc.nextInt();
		double dp[][][]=new double[n+5][n+5][n+5];
		int one=0,two=0,three=0;
		for(i=0;i<n;i++)
		{
			int v=sc.nextInt();
			if(v==1)
				one++;
			else if(v==2)
				two++;
			else
				three++;
		}
		for(int k=n;k>=0;k--)
		{
			for(int j=n;j>=0;j--)
			{
				for(i=n;i>=0;i--)
				{
					if(i+j+k==0)
						continue;
					if(i+j+k>n)
						continue;
					dp[i][j][k]=(double)n/(i+j+k);
					if(i>0)
						dp[i][j][k]+=(dp[i-1][j][k]*i)/(i+j+k);
					if(j>0)
						dp[i][j][k]+= (dp[i+1][j-1][k]*j)/(i+j+k);
					if(k>0)
						dp[i][j][k]+= (dp[i][j+1][k-1]*k)/(i+j+k);
				}
			}
		}
		System.out.println(dp[one][two][three]);
		
		
	}
}