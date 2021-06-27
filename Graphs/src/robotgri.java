import java.io.*;
import java.util.*;

class Pair
{
	int x,y;
	Pair(int x,int y)
	{
		this.x=x;
		this.y=y;
	}
}
class robotgri implements Runnable 
{
	private boolean console=false;
	 
	char a[][];
	int n;
	int X[]= {-1,0,0,1};
	int Y[]= {0,-1,1,0};
	public void solve() 
	{
		int i;
		n=in.ni();
		long mod=(1<<31)-1;
		a=new char[n][n];
		for(i=0;i<n;i++)
			a[i]=in.ns().toCharArray();
		long dp[][]=new long[n][n];
		for(i=0;i<n;i++)
		{
			if(a[i][0]=='#')
			{
				while(i<n)
				{
					dp[i][0]=0;
					i++;
				}
				break;
			}
			dp[i][0]=1;
		}
		for(i=0;i<n;i++)
		{
			if(a[0][i]=='#')
			{
				while(i<n)
				{
					dp[0][i]=0;
					i++;
				}
				break;
			}
			dp[0][i]=1;
		}
		for(i=1;i<n;i++)
		{
			for(int j=1;j<n;j++)
			{
				if(a[i][j]=='#')
				{
					dp[i][j]=0;
					continue;
				}
				dp[i][j]=(dp[i-1][j]+dp[i][j-1])%mod;
			}
		}
		if(dp[n-1][n-1]!=0)
		{
			out.println(dp[n-1][n-1]);
			return;
		}
		Queue<Pair> q=new LinkedList();
		q.add(new Pair(0,0));
		boolean ans[][]=new boolean[n][n];
		ans[0][0]=true;
		while(!q.isEmpty()) 
		{
			Pair pos=q.poll();
			for(i=0;i<4;i++)
			{
				int x=pos.x;
				int y=pos.y;
				x+=X[i];
				y+=Y[i];
				if(check(x,y))
				{
					if(ans[x][y]==false)
					{
						ans[x][y]=true;	
						q.add(new Pair(x,y));
					}
				}
			}
		}
		if(ans[n-1][n-1])
			out.println("THE GAME IS A LIE");
		else
			out.println("INCONCEIVABLE");
	}
	public boolean check(int x,int y)
	{
		if(x>=0&&y>=0&&x<n&&y<n&&a[x][y]!='#')
			return true;
		return false;
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
	public static void main(String[] args) throws Exception {	 new robotgri().run();	 }

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
