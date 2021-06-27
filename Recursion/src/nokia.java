import java.util.Scanner;
import java.math.*;
class nokia
{
	public static void main (String[] args)
	{
		Scanner sc=new Scanner(System.in); 
		int t,i,n,j;
		t=sc.nextInt();
		while(t>0)
		{
			t--;
			n=sc.nextInt();
			int m=sc.nextInt();
			int a[]=new int[n];
			for(i=0;i<n;i++)
				a[i]=i+1;
			permute(a,0,n-1,m);
		} 
	}
	public static void permute(int a[], int l, int r, int m) 
	{ 
		
		if (l == r) 
		{
			int min=Integer.MAX_VALUE;
			int x=m;
			int maxl,maxr=0;
			int n=a.length;
			int len=0;
			int d[]=new int[n];
			maxl=maxr=a[0];
			len+=a[0]+(n+1-a[0]);				
			for(int i=1;i<n;i++)
			{
				if(a[i]<maxl)
				{
					len+=maxl;
					maxl=a[i];
				}
				else if(a[i]>maxr)
				{
					len+=n+1-maxr;
					maxr=a[i];
				}
				else
				{
					len+=maxr-maxl;
				}
			}
			x=x-len;
			if(x>=0&&x<min)
				min=x;
			
			
	    }
	    else
	    { 
	    	for (int i = l; i <= r; i++) 
	    	{ 
	    		a = swap(a,l,i); 
	        	permute(a, l+1, r, m); 
	        	a = swap(a,l,i); 
	    	} 
	    	
	     } 
		
	 } 
	  public static int[] swap(int a[], int i, int j) 
	  { 
	        int temp; 
	        temp = a[i] ; 
	        a[i] = a[j]; 
	        a[j] = temp; 
	        return a; 
	  } 
}