import java.util.Arrays;
import java.util.*;
class kfstb
{
	static long m=1000000007;
	static int des;
	public static void main (String[] args)
	 {
		Scanner sc=new Scanner(System.in);
		int t,i;
		t=sc.nextInt();
		int p=t;
		while(t>0)
		{
			t--;
			int c=sc.nextInt();
			int b=sc.nextInt();
			int s=sc.nextInt();
			des=sc.nextInt();
			ArrayList<Integer> adj[]=new ArrayList[c+1];
			for(i=1;i<=c;i++)
				adj[i]=new ArrayList();
			for(i=0;i<b;i++)
			{
				int u=sc.nextInt();
				int ve=sc.nextInt();
				adj[u].add(ve);
			}
			
			int vis[]=new int[c+1];
			long ans[]=new long[c+1];
			dfs(vis,adj,ans,s);
			System.out.println(ans[s]);
		}
	 }
	static long dfs(int vis[],ArrayList<Integer> adj[],long ans[],int v)
	{	
		vis[v]=1;
		for(int i:adj[v])
		{
			if(vis[i]==1)
			{
				ans[v]=(ans[i]+ans[v])%m;;
			}
			else if(i==des)
				ans[v]=(ans[v]+1)%m;
			else
			{
				dfs(vis,adj,ans,i);
				ans[v]=(ans[i]+ans[v])%m;
			}
		}
		return 1;
	}
} 