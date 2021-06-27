import java.io.*;
import java.util.*;
class najpf implements Runnable 
{
	private boolean console=false;

	public void solve() 
	{
		int i=0; char a[]=in.ns().toCharArray(); char b[]=in.ns().toCharArray();
		i=0;
		int n=a.length,m=b.length; ArrayList<Integer> ans=new ArrayList();
		int j=0; int prf[]=pref(b);
		while(i<n)
		{
			if(a[i]==b[j])
			{
				i++; j++;
			}
			if(j==m)
			{
				ans.add(i-j+1); j=prf[j-1];
			}
			else if(i<n&&a[i]!=b[j])
			{
				if(j!=0) 	j=prf[j-1];
				else i++;
			}
		}		
		if(ans.size()==0)
		{
			out.println("Not Found");	return;
		}
		out.println(ans.size());
		//for(int va:ans)
			//out.print(va+" ");
		out.println();
	}
	public int[] pref(char a[])
	{
		int i,n=a.length; int p[]=new int[n];
		for(i=1;i<n;i++)
		{
			int j=p[i-1];
			while(j>0&&a[i]!=a[j]) j=p[j-1];
			if(a[i]==a[j]) j++;
			p[i]=j;
		}
		return p;
	}
	@Override
	public void run() {
		try {  init();  } 
		catch (FileNotFoundException e) {  e.printStackTrace();   }

		int t= 1;

		while (t-->0) {
			double st=System.nanoTime();
			solve();
			out.println((System.nanoTime()-st)/1000000000);
			out.flush(); }
	}
	private FastInput in;    private PrintWriter out;
	public static void main(String[] args) throws Exception {	 new najpf().run();	 }

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
