import java.io.*;
import java.util.*;
class uwcoi implements Runnable 
{
	private boolean console=false;

	int z; int cnt=0; int k,n;
	public void solve() 
	{
		int i;   n=in.ni(); k=in.ni(); ArrayList<long []> a=new ArrayList();   z=-1; cnt=0;
		for(i=0;i<=n;i++)
		{
			long c[]= {in.nl(),i};
			if(c[0]==0) continue;		
			else a.add(c);
		}
		while(cnt<n)
		{
			solve(a);
			ArrayList<long[]> b=new ArrayList(); z=-1;
			for(i=0;i<a.size();i++)
			{
				long c[]= {a.get(i)[0],a.get(i)[1]};
				if(c[0]==0) continue;
				else b.add(c);
			}
			a=new ArrayList();
			for(i=0;i<b.size();i++)
			{
				long c[]= {b.get(i)[0],b.get(i)[1]}; a.add(c);
			}
		}

	}
	public void solve(ArrayList<long []> a)
	{
		Collections.sort(a,(p,q)-> (int)(p[0]-q[0]));
		int l=0; int r=a.size()-1;
		while(l<r)
		{
			if(a.get(l)[0]==0)
			{
				l++; continue;
			}
			long need=Math.max(k-a.get(l)[0],0);
			a.get(r)[0]-=need;
			System.out.println(a.get(r)[1]+" "+need+" "+a.get(l)[1]+" "+a.get(l)[0]);
			a.get(l)[0]-=k-need;
			if(a.get(r)[0]==0) r--;
			cnt++; l++;
		}
		if(a.size()==1)
		{
			long ind=-1;
			if(a.get(0)[1]-1>=0) ind=a.get(0)[1]-1; 
			else if(a.get(0)[1]+1<=n) ind=a.get(0)[1]+1;
			System.out.println(a.get(0)[1]+" "+k+" "+ind+" "+0);
			cnt++;
		}
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
	public static void main(String[] args) throws Exception {	 new uwcoi().run();	 }

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

