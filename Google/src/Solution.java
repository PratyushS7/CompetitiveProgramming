import java.util.*;
import java.io.*;
public class Solution implements Runnable 
{
	private boolean console=false;

	int a[][]; int X[]= {0,0,1,-1}; int Y[]= {1,-1,1,-1}; int s,ans;
	public void solve() 
	{
		int i; s=in.ni(); int ra=in.ni()-1,pa=in.ni()-1,rb=in.ni()-1,pb=in.ni()-1, c=in.ni(); a=new int[s][]; ans=0;
		for(i=0;i<s;i++) a[i]=new int[2*i+1];
		a[ra][pa]=1;  a[rb][pb]=1;
		for(i=0;i<c;i++) a[in.ni()-1][in.ni()-1] =1;
		out.println(dfs(ra,pa,rb,pb,true,0,true,true,a));
	}
	
	public int dfs(int ra,int pa,int rb,int pb, boolean turn, int ans, boolean paf,boolean pbf, int a[][]) 
	{
		int cur;
		if(turn)
		{
			int afail=0; cur=Integer.MIN_VALUE;
			for(int i=0;i<4;i++)
			{
				int cx=X[i]+ra; int cy=Y[i]+pa;
				if(valid(cx,cy,ra,pa)&&a[cx][cy]==0) 
				{
					a[cx][cy]=1;
					cur= Math.max(cur,dfs(cx,cy,rb,pb,!turn,ans+1,paf,pbf,a));
					a[cx][cy]=0;
				}
				else afail++;
			}
			if(afail==4)
			{	
				if(!pbf) return ans;
				else 
				{
				 	cur=Integer.MAX_VALUE; cur= Math.min(cur,dfs(ra,pa,rb,pb,!turn,ans,false,pbf,a));
				}
					
			}	
		}
		else
		{
			int bfail=0; cur=Integer.MAX_VALUE;
			for(int i=0;i<4;i++)
			{
				int cx=X[i]+rb; int cy=Y[i]+pb;
				if(valid(cx,cy,rb,pb)&&a[cx][cy]==0)
				{
					a[cx][cy]=1;
					cur= Math.min(cur,dfs(ra,pa,cx,cy,!turn,ans-1,paf,pbf,a));
					a[cx][cy]=0;
				}
				else bfail++;
			}
			if(bfail==4)
			{
				if(!paf) return ans;
				else 
				{
				 	cur=Integer.MIN_VALUE; cur= Math.max(cur,dfs(ra,pa,rb,pb,!turn,ans,paf,false,a));
				}
			}
		}
		return cur;
	}
	public boolean valid(int x,int y,int xo,int yo)
	{
		if(x<0||y<0||x>=s||y>=(2*x+1)) return false;
		int xc=-xo+x; int yc=-yo+y;
		if(xc!=yc) return true;
		else
		{
			int os=xo+yo;
			if(xo%2==0)
			{
				if(os%2==0) return (xc==1&&yc==1);
				else return (xc==-1&&yc==-1);
			}
			else
			{
				if(os%2==0) return (xc==-1&&yc==-1);
				else return (xc==1&&yc==1);
			}
		}
	}
	@Override
	public void run() {
		try {  init();  } 
		catch (FileNotFoundException e) {  e.printStackTrace();   }

		int t= in.ni();

		for(int i=1;i<=t;i++)
		{
			out.print("Case #"+i+": "); solve();
			out.flush();
		}	
	}
	private FastInput in;    private PrintWriter out;
	public static void main(String[] args) throws Exception {	 new Solution().run();	 }

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
