import java.util.Scanner;
class palpart
{
	public static void main (String[] args)
	{
		Scanner sc=new Scanner(System.in); 
		int t=sc.nextInt();
		while(t-->0)
		{
			char a[]=sc.next().toCharArray(); int i,n=a.length;
			boolean pos[][]=new boolean[n][n]; int dp[]=new int[n];
			for(i=0;i<n;i++) pos[i][i]=true;
			for(i=0;i<n;i++)
			{
				int min=i;
				for(int j=0;j<=i;j++)
				{
					if(a[i]==a[j]&&j+1>i-1&&pos[j+1][i-1])
					{
						pos[j+1][i-1]=true; 
						min= j==0?0:Math.min(min, dp[j-1]+1);
					}
				}
			}
		}
	}
}