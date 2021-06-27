import java.io.*;
import java.util.*;

class pair
{
	int w,s,k;
	pair(int w,int s)
	{
		this.w=w;
		this.s=s;
	}
}
class koze implements Runnable 
{
	private boolean console=false;
	
	char a[][];
	int wa,sa;
	int vis[][];
	int n,m;
	public void solve() 
	{
		int i;
		n=in.ni();
		m=in.ni();
		a=new char [n][m];
		for(i=0;i<n;i++)
			a[i]=in.ns().toCharArray();
		vis =new int[n][m];
		for(i=0;i<n;i++)
		{
			for(int j=0;j<m;j++)
			{
				pair v=new pair(0,0);
				if(a[i][j]!='#')
					v=dfs(i,j,v);
				if(v.k==1)
				{
					wa+=v.w;
					sa+=v.s;
				}
				else
				{
					if(v.w>=v.s)
						wa+=v.w;
					else
						sa+=v.s;
				}
			}
		}
		out.println(sa+" "+wa);
	}	
	public pair dfs(int i,int j,pair v)
	{
		if(i<0||j<0||i>=n||j>=m)
		{
			v.k=1;
			return v;
		}
		if(vis[i][j]==1)
			return v;
		vis[i][j]=1;
		if(a[i][j]=='k')
			v.s++;
		else if(a[i][j]=='v')
			v.w++;
		else if(a[i][j]=='#')
			return v;
		dfs(i+1,j,v);
		dfs(i-1,j,v);
		dfs(i,j+1,v);
		dfs(i,j-1,v);
		return v;
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
	public static void main(String[] args) throws Exception {	 new koze().run();	 }

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
