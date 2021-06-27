import java.io.*;
import java.util.*;
public class d2695 implements Runnable 
{
	private boolean console=false;

	public void solve() 
	{
		int i; int n[]=new int[3]; long a[][]=new long[3][];
		for(i=0;i<3;i++) n[i]=in.ni();
		for(i=0;i<3;i++)
		{
			int cs=n[i];
			a[i]=new long[cs];
			for(int j=0;j<cs;j++) a[i][j]=in.ni();
			Arrays.sort(a[i]);
		}
		int ptr[][]=new int[3][2];
		for(i=0;i<3;i++)
		{
			ptr[i][0]=n[i]-1; ptr[i][1]=i;
		}
		while(ptr[0][0]>0||ptr[1][0]>0||ptr[2][0]>0)
		{
			Arrays.sort(ptr,(p,q)->q[0]-p[0]);
			int aind=ptr[0][1]; int bind=ptr[1][1]; int cind=ptr[2][1];
			int ac=ptr[0][0]; 
			if(a[bind][0]<a[cind][0])
			{
				a[bind][0]-=a[aind][ac]; 
			}
			else
			{
				a[cind][0]-=a[aind][ac]; 
			}
			ptr[0][0]--;
		}
		long min=Long.MAX_VALUE; long c[]= {a[0][0],a[1][0],a[2][0]}; long sum=0;
		if(c[0]<0&&c[1]<0&&c[2]<0||c[0]>0&&c[1]>0&&c[2]>0)
		{
			Arrays.sort(c); 
			for(i=0;i<3;i++)	
				min=Math.min(min, 2*Math.abs(c[i]));
		}
		if(min==Long.MAX_VALUE) min=0;
		for(i=0;i<3;i++) sum+=Math.abs(c[i]);
		out.println(sum-min);
		
	}
	@Override
	public void run() {
		try {  init();  }  
		catch (FileNotFoundException e) {  e.printStackTrace();  }

		int t= 1;

		while (t-->0) {
			solve();
			out.flush(); }
	}
	private FastInput in;    private PrintWriter out;
	public static void main(String[] args) throws Exception {	 new d2695().run();	 }

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



