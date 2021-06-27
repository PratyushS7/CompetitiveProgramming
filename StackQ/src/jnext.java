import java.util.*;
public class jnext
{
	public static void main(String[] args)
	{
		Scanner sc=new Scanner(System.in);
		int t,i,n,v=0;
		t=sc.nextInt();
		while(t>0)
		{
			t--;	
			n=sc.nextInt();
			int a[]=new int[n];
			for(i=0;i<n;i++)
				a[i]=sc.nextInt();
			int b[]=new int[n];
			int k=0,j=0;
			b[k++]=a[n-1];
			for(i=n-2;i>=0;i--)
			{
				if(a[i]<b[k-1])
				{
					j=i;
					break;
				}
				else 
					b[k++]=a[i];
			}
			
			if(i==-1)
			{
				System.out.println(-1);
				continue;
			}
			int l=b[k-1]-a[j];
			int st=a[j];
			Arrays.sort(b);
			while(l>0)
			{
				l--;
				v=Arrays.binarySearch(b,++st);
				
				if(v>0)
					break;
			}
			int temp=0;
			temp=a[j];
			a[j]=b[v];
			b[v]=temp;
			Arrays.sort(b);
			for(i=0;i<=j;i++)
				System.out.print(a[i]);
			for(i=0;i<n;i++)
			{
				if(b[i]==0)
					continue;
				System.out.print(b[i]);
			}
			
		}
	}

}
