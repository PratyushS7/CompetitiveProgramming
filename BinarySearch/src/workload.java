import java.util.Arrays;
import java.util.Scanner;
class workload
{
	public static void main (String[] args)
	 {
		Scanner sc=new Scanner(System.in); 
		int t,i;
		int a[]= { 10, 20, 30, 40, 50, 60, 70, 80, 90 };
		System.out.println(getMostWork(a,5));
		
	}
	static int getMostWork(int folders[],int workers)
	{
		int n = folders.length;
		int i;
		int lo=0;
		int hi=0;
		for(i=0;i<n;i++)
		{
			if(folders[i]>lo)
				lo=folders[i];
			hi+=folders[i];
		}
		  while (lo <hi) 
		  {
			  int x = lo + (hi - lo) / 2;
			  int required = 1, current_load = 0;
			  for ( i = 0; i <n; ++i) 
			  {
				  if (current_load + folders[i] <= x) 
		      {
		       
					  current_load += folders[i];
		      }
			 else 
		      { 
				 ++required;
				 current_load = folders[i];
		     	}
		    }

		    if (required <= workers)
		      hi = x;
		    else
		      lo = x + 1;
		  }
		  return lo;
	}
}
