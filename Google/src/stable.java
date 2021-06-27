import java.util.Arrays;
import java.util.*;
class stable
{
	public static void main (String[] args)
	{
		Scanner sc=new Scanner(System.in);
		int i;
		int t=sc.nextInt();
		int pr=t;
		while(t>0)
		{
			t--;
			int r=sc.nextInt();
			int c=sc.nextInt();
			char a[][]=new char[r][c];
			for(i=0;i<r;i++)
				a[i]=sc.next().toCharArray();
			char p[][]=new char[r][c];
			int l[]=new int[26];

			int j,k,m;

			int all[]=new int[26];

			int v=1;
			int f=0;
			for(i=0;i<c;i++)
			{
				
				if(l[a[r-1][i]-'A']==0)
				{
					l[a[r-1][i]-'A']=v;
					v++;
				}
				for(j=r-2;j>=0;j--)
				{
					if(a[j][i]!=a[j+1][i]&&l[a[j][i]-'A']==0)
					{
						l[a[j][i]-'A']=v;
						v++;
					}
					else if(a[j][i]!=a[j+1][i])
					{
						if(l[a[j][i]-'A']<l[a[j+1][i]-'A'])
						{
							int st=l[a[j][i]-'A'];
							l[a[j][i]-'A']=l[a[j+1][i]-'A'];
							l[a[j+1][i]-'A']=st;
						}
					}
				}
			}
			String an="";
			for(i=1;i<=26;i++)
			{
				for(j=0;j<26;j++)
				{
					if(l[j]==i)
						an+=(char)(j+'A');
				}
			}
			
			System.out.println("Case #"+(pr-t)+": "+an);
		}

	}
} 