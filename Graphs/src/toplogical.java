import java.util.Arrays;
import java.util.*;
class toplogical
{
	static int used[]=new int[6];
	public static void main (String[] args)
	 {
		Scanner sc=new Scanner(System.in);
		int i;
		int g[][]=new int[6][6];
		Arrays.fill(used,0);
		for(i=0;i<6;i++)
		{
			int u=sc.nextInt();
			int v=sc.nextInt();
			g[u][v]=1;
		}
		
		for(i=0;i<6;i++)
		{
			if(used[i]==0)
				dfs(i,g);
		}
	 }
	static void dfs(int u,int g[][])
	{
		used[u]=1;
		for(int i=0;i<6;i++)
		{
			if(g[u][i]==1)
			{
				if(used[i]==0)	
					dfs(i,g);
				else 
				{
					if(g[i][u]==1)
					{
						System.out.println(-1);
						System.exit(-1);
					}
				}
			}
			
		}
		System.out.print(u+" ");
	}
} 