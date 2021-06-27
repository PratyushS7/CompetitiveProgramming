import java.io.*;
import java.util.*;

class fillmtr implements Runnable 
{
	private boolean console=false;

	int par[],size[]; 
	boolean pos=true;
	public void solve() 
	{
		int i; int n=in.ni(); int q=in.ni(); par=new int[n]; size=new int[n];  pos=true;
		ArrayList<int []> oq=new ArrayList();
		for(i=0;i<n;i++)
			par[i]=i;
		for(i=0;i<q;i++)
		{
			int u=in.ni()-1; int v=in.ni()-1; int val=in.ni();
			if(u==v&&val==1)
				pos=false;
			else if(val==1)
			{
				int arr[]= {u,v}; oq.add(arr);
			}
			else
				union(u,v);
		}
		HashMap<Integer,Integer> c=new HashMap();
		for(i=0;i<oq.size();i++)
		{
			int u=oq.get(i)[0];  int v=oq.get(i)[1];
			u=find_set(u); v=find_set(v);
			if(u==v)
				pos=false;
			if(c.get(u)==null&&c.get(v)==null)
			{
				c.put(u,0); c.put(v,1);
			}
			else if(c.get(u)==null)
				c.put(u, 1-c.get(v));
			else if(c.get(v)==null)
				c.put(v, 1-c.get(u));
			else if(c.get(u)==c.get(v))
				pos=false;
		}
		if(!pos)
			out.println("no"); 
		else
			out.println("yes");
	}
	public int find_set(int a)
	{
		if(par[a]==a)
			return a;
		else
			return par	[a]=find_set(par[a]);
	}
	public void union(int a,int b)
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
	@Override
	public void run() {
		try {  init();  } 
		catch (FileNotFoundException e) {  e.printStackTrace();   }

		int t= in.ni();

		while (t-->0) {
			solve();
			out.flush(); }
	}
	private FastInput in;    private PrintWriter out;
	public static void main(String[] args) throws Exception {	 new fillmtr().run();	 }

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
