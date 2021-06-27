import java.io.*;
import java.util.*;

class setele implements Runnable 
{
	private boolean console=false;

	int par[]; int size[];
	public void solve() 
	{
		int i; int n=in.ni(); int e[][]=new int[n-1][3]; long t= (long) n*(n-1)/2; long s=0; long cost=0;
		par=new int[n]; size=new int[n];
		for(i=0;i<n;i++)
		{
			par[i]=i; size[i]=1;
		}
		for(i=0;i<n-1;i++)
		{
			e[i][0]=in.ni()-1; e[i][1]=in.ni()-1; e[i][2]=in.ni(); cost+=e[i][2];
		}
		Arrays.sort(e, (p,q)-> p[2]-q[2]);
		for(i=0;i<e.length;i++)
		{
			int fs=find_set(e[i][0]), ss= find_set(e[i][1]);
			//t+=(long)size[fs]*size[ss];
			s+=(long)size[fs] * size[ss]*e[i][2]; 
			union_sets(fs,ss);
		}
		double ans=cost-s*1.0/t;
		out.println(ans);
	}
	
	public void union_sets(int a,int b)
	{
		a=find_set(a); b=find_set(b);
		if(a==b)
			return;
		if(size[a]<size[b])
		{
			int temp=a; a=b; b=temp;
		}
		par[b]=a; size[a]+=size[b];
	}
	public int find_set(int a)
	{
		if(par[a]==a)
			return a;
		return par[a]=find_set(par[a]);
	}
	@Override
	public void run() {
		try {  init();  } 
		catch (FileNotFoundException e) {  e.printStackTrace();   }

		int t= 1;

		while (t-->0) {
			solve();
			out.flush(); }
	}
	private FastInput in;    private PrintWriter out;
	public static void main(String[] args) throws Exception {	 new setele().run();	 }

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
}
