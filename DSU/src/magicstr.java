import java.io.*;
import java.util.*;
class magicstr implements Runnable 
{
	private boolean console=false;
 
	int par[],size[]; long mod=(int) 1e9+7;
	public void solve()
	{
		 int i; int n=in.ni(); int m=in.ni();  par=new int[n]; size=new int[n]; HashSet<Integer> a=new HashSet(); 
		 HashSet<String> done=new HashSet();
		 for(i=0;i<n;i++)
		 {
			 par[i]=i; size[i]=1;
		 }
		 for(i=0;i<m;i++)
		 {
			 int l=in.ni()-1; int r=in.ni()-1; String cur=""+l+r; int len=(r-l+1)/2;
			 if(done.contains(cur)) continue;
			 else done.add(cur);
			 int cnt=0;
			 while(cnt<len)
			 {
				 union(l+cnt,r-cnt); cnt++;
			 }
		 }
		 for(i=0;i<n;i++) a.add(find(i));
		 int b=a.size(); 
		 out.println(power(26,b,mod));
	}
	public long power(long a,long b,long mod)
	{
		long x = 1, y = a; 
		while (b > 0)
		{
			if (b%2!=0) 
				x = (x*y)%mod;
			y = (y*y)%mod; 
			b /= 2; 
		} 
		return x%mod; 
	}
	public int find(int a)
	{
		return (par[a]==a)? a: (par[a]=find(par[a])); 
	}
	public void union(int a,int b)
	{
		a=find(a); b=find(b);
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
	public static void main(String[] args) throws Exception {	 new magicstr().run();	 }
 
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