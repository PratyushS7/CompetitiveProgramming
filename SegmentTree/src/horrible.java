import java.io.*;
import java.util.*;
class horrible implements Runnable 
{
	private boolean console=false;

	public void solve()
	{
		int i; int n=in.ni(); int c=in.ni(); long a[]=new long[n];
		SegmentTree t=new SegmentTree(a);
		for(i=0;i<c;i++)
		{
			int type=in.ni();
			if(type==1)
			{
				int l=in.ni()-1; int r=in.ni()-1;
				out.println(t.getValue(l, r)); out.flush();
			}
			else
			{
				int l=in.ni()-1; int r=in.ni()-1; long v=in.nl();
				t.update(l,r,v);
			}
		}
	}
	@Override
	public void run() {
		try {  init();  }  
		catch (FileNotFoundException e) {  e.printStackTrace();   }

		int t=in.ni();
		while(t-->0)
		{
			solve(); out.flush();
		}
	}
	private FastInput in;    private PrintWriter out;
	public static void main(String[] args) throws Exception {	 new horrible().run();	 }

	private void init() throws FileNotFoundException {
		InputStream inputStream = System.in; 	 OutputStream outputStream = System.out;
		try {  if (!console && System.getProperty("user.name").equals("sachan")) {
			outputStream = new FileOutputStream("/home/sachan/Desktop/output.txt");
			inputStream = new FileInputStream("/home/sachan/Desktop/input.txt");   	}
		}	catch (Exception ignored) {	}
		out = new PrintWriter(outputStream); 	 in = new FastInput(inputStream);
	}
	static class FastInput { InputStream obj;
	public FastInput(InputStream obj) {	this.obj = obj;	}
	byte inbuffer[] = new byte[1024];  int lenbuffer = 0, ptrbuffer = 0;
	int readByte() { if (lenbuffer == -1) throw new InputMismatchException();
	if (ptrbuffer >= lenbuffer) { ptrbuffer = 0;
	try { lenbuffer = obj.read(inbuffer);  }
	catch (IOException e) { throw new InputMismatchException(); } }    
	if (lenbuffer <= 0) return -1;return inbuffer[ptrbuffer++]; }

	String ns() { int b = skip();StringBuilder sb = new StringBuilder();
	while (!(isSpaceChar(b)))	  { sb.appendCodePoint(b);b = readByte(); }return sb.toString();}

	int ni() { int num = 0, b;boolean minus = false;
	while ((b = readByte()) != -1 && !((b >= '0' && b <= '9') || b == '-')) ;
	if (b == '-') { minus = true;b = readByte(); }
	while (true) { if (b >= '0' && b <= '9') { num = num * 10 + (b - '0'); } else {
		return minus ? -num : num; }b = readByte(); }}

	long nl() { long num = 0;int b;boolean minus = false;
	while ((b = readByte()) != -1 && !((b >= '0' && b <= '9') || b == '-')) ;
	if (b == '-') { minus = true;b = readByte(); }
	while (true) { if (b >= '0' && b <= '9') { num = num * 10L + (b - '0'); } else {
		return minus ? -num : num; }b = readByte(); } }

	boolean isSpaceChar(int c) { return (!(c >= 33 && c <= 126)); }
	int skip() { int b;while ((b = readByte()) != -1 && isSpaceChar(b)) ;return b; }
	float nf() {return Float.parseFloat(ns());}
	double nd() {return Double.parseDouble(ns());}
	char nc() {return (char) skip();}
	}
	class Node
	{
		long sum; long lazy; int len=1;
		void assignLeaf(long value) 
		{
			sum=value; 
		}
		void add(long val)
		{
			sum+=val;
		}
		void addlazy(long val)
		{
			lazy+=val;
		}
		void reset()
		{
			lazy=0;
		}
		void merge(Node left, Node right) 
		{
			sum=left.sum+right.sum;;
		}
		long getlazy()
		{
			return lazy/len;
		}
		long getValue() 
		{
			return sum;
		}
	}
	class SegmentTree 
	{
		int N; Node nodes[];
		SegmentTree(long arr[]) 
		{
			this.N=arr.length;
			nodes = new Node[getSegmentTreeSize(N)];
			for(int i=0;i<nodes.length;i++) nodes[i]=new Node();
			buildTree(arr, 1, 0, N-1);
		}
		void buildTree(long arr[], int stIndex, int lo, int hi) 
		{
			if (lo == hi) 
			{
				nodes[stIndex].assignLeaf(arr[lo]); return;
			}
			nodes[stIndex].len=hi-lo+1;
			int left = 2 * stIndex, right = left + 1, mid = (lo + hi) / 2;
			buildTree(arr, left, lo, mid);
			buildTree(arr, right, mid + 1, hi);
			nodes[stIndex].merge(nodes[left], nodes[right]);
		}
		void push(int stIndex)
		{
			int left = 2 * stIndex, right = left + 1;
			long val=nodes[stIndex].getlazy();
			nodes[left].add(val*(nodes[left].len)); nodes[right].add(val*nodes[right].len);
			nodes[left].addlazy(val*nodes[left].len); nodes[right].addlazy(val*nodes[right].len);
			nodes[stIndex].reset();
		}
		long getValue(int lo, int hi)
		{
			Node result = getValue(1, 0, N-1, lo, hi);
			return result.getValue();
		}
		Node getValue(int stIndex, int left, int right, int lo, int hi) 
		{
			if (left == lo && right == hi) 	return nodes[stIndex];
			push(stIndex);
			int mid = (left + right) / 2;
			if ( lo > mid) return getValue(2*stIndex+1, mid+1, right, lo, hi);	
			if (hi <= mid) return getValue(2*stIndex, left, mid, lo, hi);

			Node leftResult = getValue(2*stIndex, left, mid, lo, mid);
			Node rightResult = getValue(2*stIndex+1, mid+1, right, mid+1, hi);
			Node result=new Node();
			result.merge(leftResult, rightResult);
			return result;
		}
		void update(int st,int end,long val) 
		{
			update(1, 0, N-1, st,end,val);
		}
		void update(int stIndex, int lo, int hi, int st,int end,long val) 
		{
			if(st>end) return;
			if (lo == st&& hi==end) 
			{
				nodes[stIndex].add(val*(hi-lo+1));
				nodes[stIndex].addlazy(val*(hi-lo+1));
			}
			else
			{
				push(stIndex);
				int left = 2 * stIndex, right = left + 1, mid = (lo + hi) / 2;
				update(left, lo, mid, st, Math.min(end,mid),val);
				update(right, mid+1, hi, Math.max(mid+1, st), end,val);
				nodes[stIndex].merge(nodes[left], nodes[right]);
			}
		}
		int getSegmentTreeSize(int N) 
		{
			int size = 1;
			for (; size < N; size <<= 1);
			return size<<1;
		}
	}
}

/*
1
6 10
1 1 6
0 1  6 5
1 2 4
13


 */
