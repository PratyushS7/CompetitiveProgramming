import java.io.*;
import java.util.*;
public class eduprac implements Runnable 
{
	private boolean console=false;

	int n,m; HashMap<String,Integer> ind; ArrayList<Integer> adj[]; int ans[]; int vis[];
	int un=1;
	public void solve() 
	{
		int i; n=in.ni(); m=in.ni(); ind=new HashMap(); ans=new int[m]; vis=new int[n]; adj=new ArrayList[n];
		for(i=0;i<n;i++) adj[i]=new ArrayList();
		for(i=0;i<m;i++) 
		{
			int u=in.ni()-1;  int v=in.ni()-1;
			String s=u+" "+v; ind.put(s,i);
			adj[u].add(v);
		}
		for(i=0;i<n;i++)
		{
			if(vis[i]==0) dfs(i);
		}
		out.println(un);
		for(int v:ans) out.print(v+" ");		
	}
	public void dfs(int v)
	{
		vis[v]=2;
		for(int node:adj[v])
		{
			String s=v+" "+node; int cind=ind.get(s);
			if(vis[node]==2)
			{
				ans[cind]=2; un=2;
			}
			else if(vis[node]==1) ans[cind]=1;
			else if(vis[node]==0)
			{
				ans[cind]=1; dfs(node);
			}
		}
		vis[v]=1;
	}
	@Override
	public void run() {
		try {  init();  } 
		catch (FileNotFoundException e) {  e.printStackTrace();   }

		int t= 1;

		while(t-->0)
		{
			solve();
			out.flush(); }
	}
	private FastInput in;    private PrintWriter out;
	public static void main(String[] args) throws Exception {	 new eduprac().run();	 }

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