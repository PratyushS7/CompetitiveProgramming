import java.io.*;
import java.util.*;

public class reform implements Runnable 
{
	private boolean console=false;

	int adj[][]; ArrayList<Integer> ans[]; int n;
	int inc[],ou[]; int poss[];
	public void solve() 
	{
		int i; n=in.ni(); int m=in.ni(); ans=new ArrayList[n]; poss=new int[n];
		for(i=0;i<n;i++)
			ans[i]=new ArrayList();
		int b[]=new int[n];
		inc=new int[n]; ou=new int[n]; adj=new int[n][n];
		for(i=0;i<m;i++)
		{
			int u=in.ni()-1; int v=in.ni()-1;
			adj[u][v]=1; adj[v][u]=1; b[u]++; b[v]++;
		}
		int v=0;
		for(i=0;i<n;i++)
		{
			if(b[i]%2==0)
			{
				v++;
				poss[i]=1;
			}
		}
		out.println(v);
		for(i=0;i<n;i++)
		{
			if(poss[i]==1)
				dfs(i,true,-1);
			else
				dfs(i,false,-1);
		}
		for(i=0;i<n;i++)
		{
			for(int node:ans[i])
				out.println((i+1)+" "+(node+1));
		}
	}
	public void dfs(int v,boolean pos,int p)
	{	
		for(int node=0;node<n;node++)
		{
			if(adj[v][node]==1)
			{
				adj[v][node]=0; adj[node][v]=0;
				if(pos)
				{
					if(inc[v]>=ou[v])
						set(v,node);
					else
						set(node,v);
				}
				else
				{
					if(inc[node]>=ou[node])
						set(node,v);
					else
						set(v,node);
				}
				if(poss[node]==1)
					dfs(node,true,v);
				else
					dfs(node,false,v);
			}
		}
	}
	public void set(int v,int node)
	{
		ans[v].add(node);
		ou[v]++; inc[node]++;
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
	public static void main(String[] args) throws Exception {	 new reform().run();	 }

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
