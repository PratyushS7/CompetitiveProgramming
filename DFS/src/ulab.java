import java.io.*;
import java.util.*;
public class ulab implements Runnable 
{
	private boolean console=false;

	int vis[];
	ArrayList<Integer> adj[]; ArrayList<Integer> ans;
	int allow; int k;
	public void solve() 
	{
		int i;
		int n=in.ni(); int m=in.ni(); k=in.ni();
		adj=new ArrayList [n+1];
		for(i=1;i<=n;i++)
			adj[i]=new ArrayList();
		allow = (int)Math.ceil(((double)2*n/k)); 
		for(i=0;i<m;i++)
		{
			int u=in.ni(); int v=in.ni();
			adj[u].add(v); adj[v].add(u);
		}
		vis=new int[n+1];
		ans=new ArrayList();
		dfs(1);
		ArrayList<Integer> val[]=new ArrayList[k];
		for(i=0;i<k;i++)
			val[i]=new ArrayList();
		int pt=0;
		for(i=0;i<ans.size();i++)
		{
			if(pt<k-1)
			{
				if(val[pt].size()<allow)
					val[pt].add(ans.get(i));
				else
				{
					pt++;
					val[pt].add(ans.get(i));
				}
			}
			else
				val[pt].add(ans.get(i));
		}
		for(;pt<k;pt++)
		{
			if(val[pt].size()==0)
				val[pt].add(1);
		}
		for(i=0;i<k;i++)
		{
			out.print(val[i].size()+" ");
			for(int j=0;j<val[i].size();j++)
				out.print(val[i].get(j)+" ");
			out.println();
		}
	}
	public void dfs(int v)
	{
		vis[v]=1;
		ans.add(v);
		for(int node:adj[v])
		{
			if(vis[node]==0)
			{
				dfs(node);
				ans.add(v);
			}
		}
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
	public static void main(String[] args) throws Exception {	 new ulab().run();	 }

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
