import java.io.*;
import java.util.*;
class solve
{
	public static void main (String[] args) throws Exception
	{
		Scanner sc=new Scanner(System.in);
		int t=1;
		while(t-->0)
		{
			int n=2; int k=1; int a[]= {2,1,2,2,1,2};
			System.out.println(solve(n,a));
			//System.out.println(naive(n,k,a));
		}
	}
	static long solve(int n, int s[])
    {
        int i; HashMap<Integer,Integer> all =new HashMap(); TreeSet<Integer> s1 =new TreeSet(); 
        TreeSet<Integer> s2 =new TreeSet(); TreeSet<Integer> s3 =new TreeSet();
        int ans=0; HashSet<Integer> done=new HashSet();  HashSet<Integer> nums=new HashSet();
        for(i=0;i<n*3;i++)
        {
        	nums.add(s[i]);
        	if(all.containsKey(s[i])) all.remove(s[i]);
        	else all.put(s[i], 1);
        }
        if(all.size()>0) return -1;
        fill(s1,s,0,n-1); fill(s2,s,n,2*n-1); fill(s3,s,2*n,3*n-1);
        
        for(int v:s1)
        {
        	if(done.contains(v)) continue;
        	int next=s1.higher(v);
        	if(s3.contains(v)&&s3.contains(next))
        	{
        		ans++; s2.remove(next); done.add(next); done.add(v);
        	}
        }
        ans+=s2.size()/2;
        return ans;
    }
	static void fill(TreeSet<Integer> h, int s[], int st,int en)
	{
		for(int i=st;i<=en;i++) 
		{
			if(h.contains(s[i])) h.remove(s[i]);
        	else h.add(s[i]);
		}
	}
	static long naive(int N, int K, int[] A)
	{
		int i; long result =0;
        for(i=0;i<N;i++)
        {
            for(int j=i+1;j<N;j++)
            {
            	if((j-i)%K==0)
            	{
            		result+=A[i]*A[j];
            	}
            }
        }
        return result;
	}
}

