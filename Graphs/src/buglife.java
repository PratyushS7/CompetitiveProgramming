import java.util.Arrays;
import java.util.*;
class buglife
{
	static int n;
	public static void main (String[] args)
	 {
		Scanner sc=new Scanner(System.in);
		int t,i;
		t=sc.nextInt();
		int p=t;
		while(t>0)
		{
			t--;
			n=sc.nextInt();
			int v=sc.nextInt();
			ArrayList<Integer> adj[]=new ArrayList[n+1];
			for(i=1;i<=n;i++)
				adj[i]=new ArrayList();
			for(i=0;i<v;i++)
			{
				int u=sc.nextInt();
				int ve=sc.nextInt();
				adj[u].add(ve);
				adj[ve].add(u);
			}
			int c[]=new int[n+1];
			Arrays.fill(c, -1);
			int vis[]=new int[n+1];
			c[1]=0;
			boolean ans=true;
			for(i=1;i<=n;i++)
			{
				ans=dfs(vis,adj,c,i);
				if(!ans)
					break;
			}
			System.out.printf ("Scenario #%d:\n", p-t);
			if(!ans)
				System.out.println("Suspicious bugs found!");
			else
				System.out.println("No suspicious bugs found!");
		}
	 }
	static boolean dfs(int vis[],ArrayList<Integer> adj[],int c[],int v)
	{	
		for(int i:adj[v])
		{
			if(c[i]!=-1)
			{
				if(c[i]==c[v])
					return false;
				continue;
			}
			c[i]=1-c[v];
			if(!dfs(vis,adj,c,i))
				return false;
		}
		return true;
	}
} 