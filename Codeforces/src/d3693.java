import java.io.*;
import java.util.*;
public class d3693 implements Runnable 
{
	private boolean console=false;

	public void solve() 
	{
		int i; int n=in.ni(); Integer a[][]=new Integer [n][4]; Integer b[][]=new Integer [n][4];  int ans[]=new int[n]; Arrays.fill(ans,-1);
		for(i=0;i<n;i++) 
		{
			a[i][0]=in.ni(); a[i][1]=in.ni(); a[i][2]=i+1; a[i][3]=i+1;
			b[i][0]=a[i][0]; b[i][1]=a[i][1]; b[i][2]=i+1; b[i][3]=i+1;
		}
		Arrays.sort(a,(p,q)->q[0]-p[0]);
		int min=a[n-1][1]; int ind=a[n-1][3];
		for(i=n-2;i>=0;i--)
		{
			if(a[i][1]>min)
			{
				a[i][1]=min; a[i][2]=ind;
			}
			if(a[i][1]<min)
			{
				min=a[i][1]; ind=i+1;
			}
		}
		for(i=0;i<n-1;i++)
		{
			if(a[i+1][2]!=a[i+1][3]) ans[a[i][3]-1]=a[i+1][2];
		}
		Arrays.sort(b,(p,q)->q[1]-p[1]);
		min=b[n-1][0];  ind=b[n-1][3];
		for(i=n-2;i>=0;i--)
		{
			if(b[i][0]>min)
			{
				b[i][0]=min; b[i][2]=ind;
			}
			if(b[i][0]<min)
			{
				min=b[i][0]; ind=i+1;
			}
		}
		for(i=0;i<n-1;i++)
		{
			if(b[i+1][2]!=b[i+1][3])
				ans[b[i][3]-1]=b[i+1][2];
		}
		for(int v:ans) out.print(v+" ");
		out.println();
	}
	@Override
	public void run() {
		try {  init();  } 
		catch (FileNotFoundException e) {  e.printStackTrace();   }

		int t= in.ni();

		while(t-->0)
		{
			solve();
			out.flush(); }
	}
	private FastInput in;    private PrintWriter out;
	public static void main(String[] args) throws Exception {	 new d3693().run();	 }

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