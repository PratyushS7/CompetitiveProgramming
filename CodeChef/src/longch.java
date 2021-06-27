import java.io.*;
import java.util.*;
class longch implements Runnable 
{
	private boolean console=false;

	public void solve() 
	{ 
		int i; int n=in.ni(); int x=in.ni(); int y=in.ni(); int a[]=new int[n]; int pref[]=new int[n+1];
		ArrayList<Integer> inc=new ArrayList(); ArrayList<Integer> exc=new ArrayList(); int cv=0;
		for(i=0;i<n;i++)
		{
			a[i]=in.ni(); pref[i+1]=pref[i]+a[i];
			if(pref[i+1]>y) exc.add(a[i]);
			else
			{
				inc.add(a[i]); cv=pref[i+1];
			}
		}
		for(i=0;i<=n;i++)
		{
			if(pref[i]>=x&&pref[i]<=y)
			{
				out.println(0); return;
			}
		}
		inc.add(0);
		for(i=1;i<=n;i++)
		{
			for(int j=1;j<i;j++)
			{
				int rem=a[j-1]; int pv=pref[i-1]-rem+a[i-1];
				if(pv>=x&&pv<=y)
				{
					out.println(1); return;
				}
			}
		}
		TreeSet<Integer> sp=new TreeSet();
		for(i=0;i<exc.size();i++)
		{
			for(int j=i+1;j<exc.size();j++) 
			{
				int sum=exc.get(i)+exc.get(j);
				sp.add(sum);
				if(sum>=x&&sum<=y)
				{
					out.println(2); return;
				}
			}
		}
		for(i=0;i<inc.size();i++)
		{
			for(int j=i;j<inc.size();j++)
			{
				if(i==j&&inc.get(i)!=0) continue;
				int cs=inc.get(i)+inc.get(j);
				int val=cv-cs; int need=x-val-1;
				if(sp.higher(need)!=null)
				{
					int f=sp.higher(need);
					if(f+val<=y)
					{
						out.println(2); return;
					}
				}
				
			}
		}
		out.println(-1); 
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
	public static void main(String[] args) throws Exception {	 new longch().run();	 }

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

