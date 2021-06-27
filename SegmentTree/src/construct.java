public class construct 
{
	static int t[]=new int[4*40];
	public static void main(String[] args)
	{
		int a[]= {3,5,1,-5,1,9,-5};
		int i;
		System.out.println(size(10));
		build(a,1,0,6);
		System.out.println(sum(1,0 ,a.length-1 ,2,3));		
	}
	static int size(int n)
	{
		int size = 1;
		for (; size < n; size <<= 1);
		return size ;
	}
	static void build(int a[], int v, int lo, int hi) 
	{
		if (lo == hi) t[v] = a[lo];
		else
		{
			int mid = (lo + hi) / 2; 
			build(a, v*2, lo, mid); build(a, v*2+1, mid+1, hi);
			t[v] = t[v*2] + t[v*2+1];
		}
	}
	static int sum(int v, int lo, int hi, int l, int r) 
	{
		if (l > r) return 0;
		if (l == lo && r == hi)    return t[v];

		int mid = (lo + hi) / 2;
		return sum(v*2, lo, mid, l, Math.min(r, mid))
				+ sum(v*2+1, mid+1, hi, Math.max(l, mid+1), r);
	}
	static void update(int v, int lo, int hi, int pos, int new_val)
	{
		if (lo == hi) 
		{
			t[v] = new_val; return;
		}
		int mid = (lo + hi) / 2;
		if (pos <= mid) update(v*2, lo, mid, pos, new_val);
		else update(v*2+1, mid+1, hi, pos, new_val);
		t[v] = t[v*2] + t[v*2+1];

	}
}
