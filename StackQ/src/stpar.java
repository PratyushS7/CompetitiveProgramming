import java.util.*;
class stpar
{
	public static void main (String[] args) 
	 {
		try {
		Scanner sc=new Scanner(System.in); 
		int t,i,n,j;
		n=sc.nextInt();
		while(n>0)
		{
			int x=n;
			int flag=0;
			int a[]=new int[n];
			for(i=0;i<n;i++)
				a[i]=sc.nextInt();
			n=sc.nextInt();
			Stack<Integer> b=new Stack<Integer>();
			Stack<Integer> h=new Stack<Integer>();
			h.push(0);
			for(i=0;i<x-1;i++)
			{
				if(a[i]>a[i+1])
				{
					if(b.isEmpty())
						b.push(a[i]);
					else if(a[i]<b.peek())
						b.push(a[i]);
					else
					{
						if(!b.isEmpty())
						{
							while(a[i]>b.peek())
							{
								if(h.peek()+1==b.peek())
									h.push(b.pop());
								else
								{
									flag=1;
									break;
								}
								if(b.isEmpty())
									break;
							}
							if(flag==1)
								break;
							b.push(a[i]);
						}
						
					}
				}
				else 
				{
					if(a[i]==h.peek()+1)
					{
						h.push(a[i]);
						continue;
					}	
					else if(h.peek()!=0)
					{
						if(!b.isEmpty())
						{
							while(b.peek()==h.peek()+1)
							{
								h.push(b.pop());
								if(b.isEmpty())
									break;
							}	
							b.push(a[i]);
						}
						else 
						{
							flag=1;
							break;
						}
					}
					else 
					{
						flag=1;
						break;
					}
				}
			}
		
			if(flag==1)
				System.out.println("no");
			else
				System.out.println("yes");
			
		}}
		catch(Exception e)
		{
			return;
		}
		
	 }
}