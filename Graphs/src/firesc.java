import java.util.Arrays;
import java.util.*;
class firesc
{
	static int size;
	public static void main (String[] args)
	 {
		Scanner sc=new Scanner(System.in);
		int t,i;
		t=sc.nextInt();
		long mod=1000000007;
		while(t>0)
		{
			t--;
			int n=sc.nextInt();
			int m=sc.nextInt();
			ArrayList<Integer> adj[]=new ArrayList[n+1];
			for(i=1;i<=n;i++)
				adj[i]=new ArrayList();
			for(i=0;i<m;i++)
			{
				int u=sc.nextInt();
				int v=sc.nextInt();
				adj[u].add(v);
				adj[v].add(u);
			}
			long maxr=0,ans=1;
			int vis[]=new int[n+1];
			for(i=1;i<=n;i++)
			{
				size=0;
				if(vis[i]==0)
				{
					dfs(i,adj,vis);
					maxr++;
					ans=(ans*size)%mod;
				}
			}
			System.out.println(maxr+" "+ans);
		}
	 }
	static void dfs(int v,ArrayList<Integer> adj[],int vis[])
	{
		size++;
		vis[v]=1;
		for(int node:adj[v])
		{
			if(vis[node]==0)
				dfs(node,adj,vis);
		}
	}
} 