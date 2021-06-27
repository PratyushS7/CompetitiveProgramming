import java.io.*;
import java.util.*;
class gmplants implements Runnable 
{
	private boolean console=false;

	public void solve()
	{
		int i;int nx=in.ni(); int ny=in.ni(); int nz=in.ni(); int q=in.ni(); 
		int a[]=new int[nx]; int b[]=new int[ny]; int c[]=new int[nz];
		SegmentTree t1=new SegmentTree(a); SegmentTree t2=new SegmentTree(b); SegmentTree t3=new SegmentTree(c);
		for(i=0;i<q;i++)
		{
			int type=in.ni();
			if(type==0)
			{
				int l=in.ni(); int r=in.ni();
				t1.update(l, r);
			}
			else if(type==1)
			{
				int l=in.ni(); int r=in.ni();
				t2.update(l, r);
			}
			else if(type==2)
			{
				int l=in.ni(); int r=in.ni();
				t3.update(l, r);
			}
			else
			{
				int x1=in.ni(); int y1=in.ni(); int z1=in.ni();	 int x2=in.ni(); int y2=in.ni(); int z2=in.ni();
				out.println(t1.getValue(x1, x2)+t2.getValue(y1, y2)+t3.getValue(z1, z2));
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
	public static void main(String[] args) throws Exception {	 new gmplants().run();	 }

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
		int sum; boolean lazy; int len=1;
		void assignLeaf() 
		{
			sum=0; 
		}
		void add()
		{
			sum=len-sum;
		}
		void setlazy()
		{
			lazy=!lazy;
		}
		void merge(Node left, Node right) 
		{
			sum=left.sum+right.sum;;
		}
		boolean getlazy()
		{
			return lazy;
		}
		long getValue() 
		{
			return sum;
		}
	}
	class SegmentTree 
	{
		int N; Node nodes[];
		SegmentTree(int arr[]) 
		{
			this.N=arr.length;
			nodes = new Node[getSegmentTreeSize(N)];
			for(int i=0;i<nodes.length;i++) nodes[i]=new Node();
			buildTree(arr, 1, 0, N-1);
		}
		void buildTree(int arr[], int stIndex, int lo, int hi) 
		{
			if (lo == hi) 
			{
				nodes[stIndex].assignLeaf(); return;
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
			boolean val=nodes[stIndex].getlazy();
			if(!val) return;
			nodes[left].add(); nodes[right].add();
			nodes[left].setlazy(); nodes[right].setlazy();
			nodes[stIndex].lazy=false;
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
			if (lo > mid) return getValue(2*stIndex+1, mid+1, right, lo, hi);	
			if (hi <= mid) return getValue(2*stIndex, left, mid, lo, hi);

			Node leftResult = getValue(2*stIndex, left, mid, lo, mid);
			Node rightResult = getValue(2*stIndex+1, mid+1, right, mid+1, hi);
			Node result=new Node();
			result.merge(leftResult, rightResult);
			return result;
		}
		void update(int st,int end) 
		{
			update(1, 0, N-1, st,end);
		}
		void update(int stIndex, int lo, int hi, int st,int end) 
		{
			if(st>end) return;
			if (lo == st&& hi==end) 
			{
				nodes[stIndex].add();
				nodes[stIndex].setlazy();
			}
			else
			{
				push(stIndex);
				int left = 2 * stIndex, right = left + 1, mid = (lo + hi) / 2;
				update(left, lo, mid, st, Math.min(end,mid));
				update(right, mid+1, hi, Math.max(mid+1, st), end);
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