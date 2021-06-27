import java.io.*;
import java.util.*;
public class quantity implements Runnable 
{
	private boolean console=false;
 
	int par[],size[]; long mod=(int) 1e9+7;
	public void solve()
	{
		 int i; int n=in.ni(); int m=in.ni(); int k=in.ni(); par=new int[n]; size=new int[n];
		 for(i=0;i<n;i++)
		 {
			 par[i]=i; size[i]=1;
		 }
		 f[0]=1;
		 for(i=1;i<f.length;i++) f[i]=f[i-1]*i%mod;
		 for(i=0;i<n-k+1;i++)
		 {
			int cend=i+k-1; int sub=0;
			for(int j=i;j<=i+k/2;j++)
			{
				int c=j; int end=cend-sub++;
				if(c<n&&end<n)
					union(c,end);
			}
		 }
		 HashSet<Integer> a=new HashSet();
		 for(i=0;i<n;i++)
			 a.add(find(i));
		 int b=a.size(); 
		 out.println(power(m,b,mod));
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
	long modinverse(long n, long mod)
	{ 
		return power(n, mod-2, mod); 
	}
	long f[]=new long[1000000]; 
	long nCr(int n, int r, long mod)
	{ 
		return (f[n]*((modinverse(f[r], mod) * modinverse(f[n-r], mod)) % mod)) % mod; 
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
 
		int t= 1;
 
		while (t-->0) {
			solve();
			out.flush(); }
	}
	private FastInput in;    private PrintWriter out;
	public static void main(String[] args) throws Exception {	 new quantity().run();	 }
 
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