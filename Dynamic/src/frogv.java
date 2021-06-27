	import java.util.Arrays;
	import java.util.Collections;
	import java.util.*;
	class frogv
	{
		public static void main (String[] args)
		 {
			Scanner sc=new Scanner(System.in); 
			int t,i;	
				int n=sc.nextInt();
				int k=sc.nextInt();
				int p=sc.nextInt();
				int a[][]=new int[n][2];
				int g[]=new int[n+1];
				for(i=0;i<n;i++)
				{
					a[i][0]=sc.nextInt();
					a[i][1]=i;
				}
				int co[][]=new int[p][2];
				for(i=0;i<p;i++)
				{
					co[i][0]=sc.nextInt();
					co[i][1]=sc.nextInt();
				}
				   Arrays.sort(a, new Comparator<int[]>() { 
				            
				          @Override
				          public int compare(final int[] entry1,  
				                             final int[] entry2) { 
				        	  if (entry1[0] > entry2[0]) 
				                return 1; 
				            else
				                return -1; 
				          } 
				        }); 
				g[0]=0;
				int j=0;
				for(i=1;i<n;i++)
				{
					if(a[i][0]-a[i-1][0]<=k)
						g[a[i][1]]=j;
					else
					{
						j++;
						g[a[i][1]]=j;
					}
				}
				for(i=0;i<p;i++)
				{
					if(g[co[i][0]-1]==g[co[i][1]-1])
						System.out.println("Yes");
					else
						System.out.println("No");
				}
				
		}
	}