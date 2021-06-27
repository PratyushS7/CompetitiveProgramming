import java.util.Arrays;
import java.util.*;
class ppapth
{
	static Queue<Integer> q;
	public static void main (String[] args)
	{
		Scanner sc=new Scanner(System.in);
		int t,i;
		t=sc.nextInt();
		while(t>0)
		{
			t--;
			int a=sc.nextInt();
			int b=sc.nextInt();
			int dis[]=new int[10000];
			Arrays.fill(dis, Integer.MAX_VALUE);
			dis[a]=0;
			q= new LinkedList();
			q.offer(a);
			while(!q.isEmpty())
			{
				int v=q.poll();
				bfs(v,dis,dis[v]);
			}
			if(dis[b]==Integer.MAX_VALUE)
				System.out.println("Impossible");
			else
				System.out.println(dis[b]);
		}
	}
	static void bfs(int v,int dis[],int le)
	{
		int a[]=new int[4];
		for(int i=3;i>=0;i--)
		{
			a[i]=v%10;
			v/=10;
		}
		for(int j=0;j<4;j++)
		{	
			int s=a[j];
			for(int i=0;i<10;i++)
			{
				a[j]=i;
				int n=0;
				for(int k=0;k<4;k++)
					n=n*10+a[k];
				if(dis[n]>le+1&&isprime(n))
				{
					dis[n]=le+1;
					q.add(n);
				}
			}
			a[j]=s;
		}
	}
	static boolean isprime(int n)
	{
		if(n<1000)
			return false;
		for(int i=2;i*i<=n;i++)
		{
			if(n%i==0)
				return false;
		}
		return true;
	}
} 