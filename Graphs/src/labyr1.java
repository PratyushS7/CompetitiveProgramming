import java.util.*;
class labyr1
{	
	static int ans=0;
	static int r;
	static int c;
	static int besti;
	static int bestj;
	public static void main(String [] args)
	{
		Scanner sc=new Scanner(System.in);
		int t,i;
		t=sc.nextInt();		
		while(t>0)
		{
			t--;
			c=sc.nextInt();
			r=sc.nextInt();
			ans=0;
			char a[][]=new char[r][c];
			for(i=0;i<r;i++)
			{
				char s[]=sc.next().toCharArray();
				for(int j=0;j<c;j++)
					a[i][j]=s[j];
			}
			int vis[][]=new int[r][c];
			for(i=0;i<r;i++)
			{
				for(int j=0;j<c;j++)
				{
					if(vis[i][j]==0)
						dfs(i,j,0,a,vis,-1,-1);
				}
			}
			ans=0;
			vis =new int[r][c];
			dfs(besti,bestj,0,a,vis,-1,-1);
			ans=Math.max(ans, 1);
			System.out.println("Maximum rope length is "+(ans-1)+".");
		}
	}
	static void dfs(int i,int j,int len,char a[][],int vis[][],int pi,int pj)
	{
		if(i<0||j<0||j>=c||i>=r)
		{
			if(len>ans)
			{
				besti=pi;
				bestj=pj;
				ans=len;
			}
			return;
		}
		if(vis[i][j]==1)
			return;
		if(a[i][j]=='#')
		{
			if(len>ans)
			{
				ans=len;
				besti=pi;
				bestj=pj;
			}
			return;
		}
		vis[i][j]=1;
		dfs(i+1,j,len+1,a,vis,i,j);
		dfs(i,j+1,len+1,a,vis,i,j);
		dfs(i,j-1,len+1,a,vis,i,j);
		dfs(i-1,j,len+1,a,vis,i,j);
	}
} 
