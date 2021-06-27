import java.util.Arrays;
import java.util.*;
class cam5
{
	static int ans;
	public static void main (String[] args)
	 {
		Scanner sc=new Scanner(System.in);
		int t,i;
		t=sc.nextInt();
		while(t>0)
		{
			t--;
			int n=sc.nextInt();
			int c=sc.nextInt();
			ArrayList<Integer> adj[]=new ArrayList[n];
			for(i=0;i<n;i++)
				adj[i]=new ArrayList();
			for(i=0;i<c;i++)
			{
				int u=sc.nextInt();
				int v=sc.nextInt();
				adj[u].add(v);
				adj[v].add(u);
			}
			ans=0;
			int vis[]=new int[n];
			for(i=0;i<n;i++)
			{
				if(vis[i]==0)
				{
					ans++;
					dfs(vis,adj,i);
				}
			}
			System.out.println(ans);
		}
	 }
	static void dfs(int vis[],ArrayList<Integer> adj[],int v)
	{
		vis[v]=1;
		for(int node:adj[v])
		{
			if(vis[node]==0)
				dfs(vis,adj,node);
		}
	}
} 