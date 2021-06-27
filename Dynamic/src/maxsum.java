import java.io.*;
import java.util.*;
public class maxsum implements Runnable 
{
	private boolean console=false;

	int dp[][][];
	public void solve() 
	{
		int i; int n=in.ni(); char a[]=in.ns().toCharArray(); dp=new int[301][301][301]; String ans="";
		int r=0,g=0,b=0;
		for(i=0;i<a.length;i++)
		{
			if(a[i]=='R') r++;
			else if(a[i]=='G') g++;
			else b++;
		}
		dp[r][g][b]=1; solve(r,g,b);
		if(dp[0][0][1]>0) ans+='B';
		if(dp[0][1][0]>0) ans+='G';
		if(dp[1][0][0]>0) ans+='R';
		out.println(ans);
	}
	public void solve(int a,int b,int c)
	{
		if(dp[a][b][c]==2) return;
		dp[a][b][c]=2;
		if(a>0&&b>0&&dp[a-1][b-1][c+1]!=2)
		{
			solve(a-1,b-1,c+1);
		}
		if(b>0&&c>0&&dp[a+1][b-1][c-1]!=2)
		{
			solve(a+1,b-1,c-1);
		}
		if(a>0&&c>0&&dp[a-1][b+1][c-1]!=2)
		{
			solve(a-1,b+1,c-1);
		}
		if(a>1&&dp[a-1][b][c]!=2)
		{
			solve(a-1,b,c);
		}
		if(b>1&&dp[a][b-1][c]!=2)
		{
			solve(a,b-1,c);
		}
		if(c>1&&dp[a][b][c-1]!=2)
		{
			solve(a,b,c-1);
		}
	}
	@Override
	public void run() {
		try {  init();  } 
		catch (FileNotFoundException e) {  e.printStackTrace();   }

		int t= 1;

		for(int i=1;i<=t;i++)
		{
			solve();
			out.flush(); }
	}
	private FastInput in;    private PrintWriter out;
	public static void main(String[] args) throws Exception {	 new maxsum().run();	 }

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