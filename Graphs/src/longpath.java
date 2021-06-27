import java.util.Arrays;
import java.util.*;
class longpath
{
	static int used[]=new int[10000];
	static Stack<Integer> s=new Stack();
	static int ans=-1;
	public static void main (String[] args)
	 {
		Scanner sc=new Scanner(System.in);
		int i;
		int n=sc.nextInt();
		int m[][]=new int[n][n];
		Arrays.fill(used,0);
		for(i=0;i<n;i++)
		{
			for(int j=0;j<n;j++)
				m[i][j]=sc.nextInt();
		}
		System.out.println(lop(m));
		
	 }
	public static int lop(int matrix[][])
	{
		int i,j;
		int a=matrix.length;
		int b=matrix[0].length;
		int dp[][]=new int[a][b];
		for(i=0;i<a;i++)
			for(j=0;j<b;j++)
				 lip(matrix,a,b,i,j,dp,0);
		int max=0;
		for(i=0;i<a;i++)
			for(j=0;j<b;j++)
				 if(dp[i][j]>max)
					 max=dp[i][j];
		return max;
	}
	static int lip(int m[][],int a,int b,int i,int j,int dp[][],int p)
	{
		 if (i < 0 || i >= a || j < 0 || j >= b || m[i][j] <= p)
		 {
	            return 0;
	      }
		 if (dp[i][j] > 0) {
	            return dp[i][j];
	        }
		 int cur = m[i][j];
         int tempMax = 0;
         tempMax = Math.max(lip(m,a,b,i - 1, j, dp, cur), tempMax);
         tempMax = Math.max(lip(m,a,b,i + 1, j,  dp, cur), tempMax);
         tempMax = Math.max(lip(m,a,b,i, j - 1,  dp, cur), tempMax);
         tempMax = Math.max(lip(m,a,b,i, j + 1,  dp, cur), tempMax);
         dp[i][j] = ++tempMax;
         return tempMax;
		
	}
} 