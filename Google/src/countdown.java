import java.util.Arrays;
import java.util.*;
 class countdown
{
	public static void main (String[] args)
	 {
		Scanner sc=new Scanner(System.in);
		int i;
		int t=sc.nextInt();
		int p=t;
		while(t>0)
		{
			t--;
			int n=sc.nextInt();
			
			int a[]=new int[n];
			for(i=0;i<n;i++)
				a[i]=sc.nextInt();
			int ans[]=new int[10000000+1];
			for(i=0;i<n;i++)
			{
				ans[a[i]]++;
				int sum=a[i];
				for(int j=i+1;j<n;j++)
				{
					sum+=a[j];
					ans[sum]++;
				}
			}
			int an=0;
			for(i=0;i<ans.length;i++)
			{
				if(ans[i]==0)
					continue;
				double y =Math.sqrt(i);
				if(Math.ceil(y)==Math.floor(y))
					an+=ans[i];
			}
			System.out.println("Case #"+(p-t)+": "+an);
		}
		
	 }
} 