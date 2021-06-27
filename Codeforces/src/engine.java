import java.util.*;
class engine
{
	public static void main(String [] args)
	{
		int arr[][]=new int[100000][1];

		TreeSet<int[]> q1 = new TreeSet<>((o1, o2) -> o1[1] == o2[1] ? o1[2] - o2[2] : o1[1] - o2[1]);

		Arrays.sort(arr,(d,q)-> d[0] == q[0] ? d[1] - q[1] : d[0] - q[0]);

		Arrays.sort(arr,Comparator.comparing((int a[])->a[0]));
		
		// For Long  Arrays.sort(arr,(p,r)-> p.q<r.q?-1: p.q>r.q?1:0); 

		PriorityQueue<Integer> p=new PriorityQueue<>((x,y)->Integer.compare(y,x));
	}
	long gcd(long a, long b)
	{
	    if (b == 0)   return a;
	    return gcd(b, a % b);
	}
	public int[] kmp(char a[])
	{
		int i; int n=a.length; int p[]=new int[n];
		for(i=1;i<n;i++)
		{
			int j=p[i-1];
			while(j>0&&a[i]!=a[j]) j=p[j-1];
			if(a[i]==a[j]) j++;
			p[i]=j;
		}
		return p;
	}
	public long power(long a,long b,long mod)
	{
		long x = 1, y = a; 
		while (b > 0)
		{
			if (b%2!=0) 
				x = (x*y)%mod;
			y = (y*y)%mod; 
			b /= 2; 
		} 
		return x%mod; 
	}
	long modinverse(long n, long mod)
	{ 
		return power(n, mod-2, mod); 
	}
	long f[]=new long[1000000]; 
	long nCr(int n, int r, long mod)
	{ 
		return (f[n]*((modinverse(f[r], mod) * modinverse(f[n-r], mod)) % mod)) % mod; 
	}  
} 

