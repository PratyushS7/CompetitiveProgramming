import java.io.*;
import java.util.*;

class jabo implements Runnable 
{
	private boolean console=false;

	int par[]; int r,c; int size[]; int vol[]; 
	int max=2500*500;
	HashMap<Character,Integer> h=new HashMap();
	public void solve() 
	{
		int i;
		int n=in.ni(); r=in.ni(); c=in.ni(); par=new int[max]; size=new int[max]; vol=new int[max];
		for(i=0;i<r;i++)
		{
			for(int j=0;j<=c;j++) 
			{
				par[j+i*c]=j+i*c; size[j+i*c]=1;
			}
		}	
		for(i=0;i<n;i++)
		{
			char a[]=in.ns().toCharArray();
			int x1,y1,x2,y2;
			if(a[0]=='W')
			{
				x1=52*h.get(a[1])+h.get(a[2]); y1=52*h.get(a[3])+h.get(a[4])-1;
				x2=52*h.get(a[5])+h.get(a[6]); y2=52*h.get(a[7])+h.get(a[8])-1;
				int ax=x1; int ay=y1/5; int bx=x2; int by=y2/5;
				union_sets(c*ay+ax,c*by+bx);
			}
			else if(a[0]=='V')
			{
				x1=52*h.get(a[1])+h.get(a[2]); y1=52*h.get(a[3])+h.get(a[4])-1;
				int ax=x1; int ay=y1/5;
				int set= find_set(c*ay+ax);
				vol[set]=1;
			}
			else if(a[0]=='L')
			{
				x1=52*h.get(a[1])+h.get(a[2]); y1=52*h.get(a[3])+h.get(a[4])-1;
				x2=52*h.get(a[5])+h.get(a[6]); y2=52*h.get(a[7])+h.get(a[8])-1;
				int ax=x1; int ay=y1/5; int bx=x2; int by=y2/5;
				int a1=find_set(c*ay+ax); int b1=find_set(c*by+bx);
				if(vol[a1]!=vol[b1])
					out.println("ON");
				else
					out.println("OFF");
			}
			else
			{
				x1=52*h.get(a[1])+h.get(a[2]); y1=52*h.get(a[3])+h.get(a[4])-1;
				int ax=x1; int ay=y1/5;
				int set= find_set(c*ay+ax);
				vol[set]=0;
			}	
		}
	}
	public void form()
	{
		int k=0; int i;
		for(i=0;i<26;i++)
			h.put((char)(i+'A'),k++);
		for(i=0;i<26;i++)
			h.put((char)(i+'a'),k++);
	}
	public void union_sets(int a,int b)
	{
		a=find_set(a); b=find_set(b);
		if(a==b)
			return;
		if(size[a]<size[b])
		{
			int temp=b; a=b; b=temp;
		}
		par[b]=a;
		size[a]+=size[b];
	}
	public int find_set(int v)
	{
		if(v==par[v])
			return v;
		return par[v]=find_set(par[v]);
	}
	@Override
	public void run() {
		try {  init();  } 
		catch (FileNotFoundException e) {  e.printStackTrace();   }

		int t= 1;
		form();
		while (t-->0) {
			solve();
			out.flush(); }
	}
	private FastInput in;    private PrintWriter out;
	public static void main(String[] args) throws Exception {	 new jabo().run();	 }

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
