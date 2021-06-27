import java.util.Scanner;
import java.util.Stack;
public class mxors
{
	public static void main(String[] args)
	{
		Scanner sc=new Scanner(System.in);
		int t,i,j;
			int n=sc.nextInt();
			int max=0,smax=0,mxor=0;
			int a[]=new int[n];
			for(i=0;i<n;i++)
				a[i]=sc.nextInt();
			Stack<Integer> p=new Stack<Integer>();
			  p.push(a[0]);
			for(i=1;i<n;i++)
			{
				 if(a[i]<p.peek())
				{
					if((a[i]^p.peek())>mxor)
						mxor=a[i]^p.peek();
					p.push(a[i]);
				}
				else
				{
					while(p.peek()<a[i])
					{
						int y=p.pop();
						if((y^a[i])>mxor)
							mxor=y^a[i];
						if(p.isEmpty())
							break;
					}
					if(!p.isEmpty())
					{
						if((a[i]^p.peek())>mxor)
							mxor=a[i]^p.peek();
					}
					p.push(a[i]);
				}
			}
			smax=p.pop();
			if(!p.isEmpty())	
			{
			if((smax^p.peek())>mxor)
				mxor=smax^p.peek();
			}
			System.out.println(mxor);
		}
	}

