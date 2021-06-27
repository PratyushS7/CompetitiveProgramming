import java.util.Arrays;
import java.util.*;
class gcpc11j
{
	static int maxc; static int maxi;
	public static void main (String[] args)
	{
		Scanner sc=new Scanner(System.in);
		int i; int n=sc.nextInt();
		ArrayList<Integer> adj[]=new ArrayList[n+1];
		for(i=1;i<=n;i++)
			adj[i]=new ArrayList();
		for(i=0;i<n-1;i++)
		{
			int u=sc.nextInt(); int v=sc.nextInt();
			adj[u].add(v); adj[v].add(u);
		}
		maxc=maxi=0;
		int vis[]=new int[n+1];
		int cur=-1;
		dfs(1,adj,vis,cur); int s=0;
		Arrays.fill(vis,0); cur=-1; maxc=0;
		dfs(maxi,adj,vis,cur);
		int ans=maxc;
		System.out.println((ans+1)/2);
	}
	static void dfs(int v,ArrayList<Integer> adj[],int vis[],int cur)
	{
		cur++;
		if(cur>maxc)
		{
			maxc=cur; 		maxi=v;
		}
		vis[v]=1;
		for(int node:adj[v])
		{
			if(vis[node]==0)
				dfs(node,adj,vis,cur);
		}
	}
} 