import java.util.Arrays;
import java.util.*;
class pair
{
	int x,y,h;
	pair(int x,int y,int h)
	{
		this.x=x; this.y=y; this.h=h;
	}
}
class cmp implements Comparator<pair>
{
	public int compare(pair a,pair b)
	{
		return a.y-b.y;
	}
}
class convert
{
	public static void main (String[] args)
	{
		Scanner sc=new Scanner(System.in);
		int i;
		int t=sc.nextInt();
		while(t>0)
		{
			t--; int n=sc.nextInt(); int a[][]=new int[n][3];;
			for(i=0;i<n;i++)
			{
				String in=sc.next();
				String s[]=in.split(","); 
				String sf=s[0].substring(1);
				String sl=s[2].substring(0,s[2].length()-1);
				a[i][0]=Integer.parseInt(sf); a[i][1]=Integer.parseInt(s[1]); a[i][2]=Integer.parseInt(sl);
			}
			Arrays.sort(a, (p,q)->p[0]-q[0]);  
			PriorityQueue<pair> q=new PriorityQueue(new cmp()); int k=0;
			TreeSet<Integer> h=new TreeSet(Collections.reverseOrder());
			for(i=0;i<=20;i++)
			{
				if(k<n&&i==a[k][0])
				{
					if(q.isEmpty())
					{	
						System.out.print("("+a[k][0]+","+a[k][2]+") "); h.add(a[k][2]);
						q.add(new pair(a[k][0],a[k][1],a[k][2])); k++;
					}
					while(k<n&&i==a[k][0])
					{
						if(a[k][0]<q.peek().y&&a[k][2]>q.peek().h)
						{
							System.out.print("("+a[k][0]+","+a[k][2]+") "); 
						}
						q.add(new pair(a[k][0],a[k][1],a[k][2])); k++;
						h.add(a[k][2]);
					}
				}
				while(!q.isEmpty()&&q.peek().y==i)
				{
					pair p=q.poll();
					if(p.h==h.first())
					{
						h.pollFirst();
						if(!h.isEmpty())
							System.out.print("("+p.y+","+h.first()+") ");
						else
						{
							
						}
					}
				}
			}
		}
	}
} 