import java.io.*;
import java.util.*;

class galactik implements Runnable 
{
	private boolean console=false;

	int c[]; int par[]; int size[];
	public void solve() 
	{
		int i;
		int n=in.ni(); int m=in.ni(); c=new int[n]; par=new int[n]; size=new int[n];
		for(i=0;i<n;i++)
			par[i]=i;
		for(i=0;i<m;i++)
		{
			int u=in.ni()-1; int v=in.ni()-1;
			union_sets(u,v);
		}
		for(i=0;i<n;i++)
		{
			int v=in.ni(); 
			if(v<0)
				v=Integer.MAX_VALUE;
			c[i]=v;
		}
		long ans=0;
		HashMap<Integer,Integer> h=new HashMap();
		for(i=0;i<n;i++)
		{
			int v=find_set(i);
			if(h.get(v)==null||h.get(v)>c[v])
				h.put(v,c[v]);
		}
		ArrayList<Integer> val=new ArrayList(h.values());
		if(val.size()==1)
		{
			out.println(0);
			return;
		}
		if(val.contains(Integer.MAX_VALUE))
		{
			out.println(-1);
			return;
		}
		Collections.sort(val);
		for(i=1;i<val.size();i++)		
			ans+=val.get(0)+val.get(i);
		out.println(ans);
	}
	public void union_sets(int a,int b)
	{
		a=find_set(a); b=find_set(b);
		if(a!=b)
		{
			if(size[a]<size[b])
			{
				int temp=a;
				a=b;  b=temp;
			}
			par[b]=a;
			size[a]+=size[b];
		}
	}
	public int find_set(int v)
	{
		if(v==par[v])
			return v;
		return par[v]=find_set(par[v]);
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
	public static void main(String[] args) throws Exception {	 new galactik().run();	 }

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
