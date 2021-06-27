import java.util.Arrays;
import java.util.*;
class paradox
{
	static int n;
	static String ans;
	static int va[];
	public static void main (String[] args)
	 {
		Scanner sc=new Scanner(System.in);
		int n,i;
		n=sc.nextInt();
		while(n!=0)
		{
			ArrayList<Integer> adj[]=new ArrayList[n+1];
			int ver[][]=new int[n+1][n+1];
			for(i=1;i<=n;i++)
				adj[i]=new ArrayList();
			va=new int[n+1];
			Arrays.fill(va,-1);
			for(i=1;i<=n;i++)
			{
				int u=sc.nextInt();
				boolean s= Boolean.parseBoolean(sc.next());
				adj[i].add(u);
				int d=-1;
				if(s)
					d=1;
				else 
					d=0;
				ver[i][u]=d;
			}
			ans="NOT PARADOX";
			int vis[]=new int[n+1];
			for(i=1;i<=n;i++)
			{
				if(vis[i]==0)
				{
					va[i]=1;
					dfs(vis,adj,i,ver);
				}
			}
			System.out.println(ans);
			n=sc.nextInt();
		}
	 }
	static void dfs(int vis[],ArrayList<Integer> adj[],int v,int ver[][])
	{	
		vis[v]=1;
		for(int i:adj[v])
		{
			if(vis[i]==1)
			{
				if(va[i]==1)
				{
					if(va[i]!=ver[v][i])
						ans="PARADOX";
				}
				else
				{
					if(va[i]==ver[v][i])
						ans="PARADOX";
				}
			}
			else
			{
				if(va[v]==1)
					va[i]=ver[v][i];
				else
					va[i]=1-ver[v][i];
				dfs(vis,adj,i,ver);
			}
		}
		va[v]=-1;
	}
}  