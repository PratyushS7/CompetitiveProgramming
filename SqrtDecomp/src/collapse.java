import java.io.*;
import java.util.*;

class collapse implements Runnable 
{
	private boolean console=false;

	public void solve() 
	{
		int i;
		int n=in.ni(); ArrayList<Integer> t=new ArrayList();
		t.add(in.ni());
		for(i=1;i<n;i++)
		{
			int v=in.ni();
			if(v!=t.get(i-1))
				t.add(v);
		}
		n=t.size(); int a[]=new int[n];
		for(i=0;i<n;i++)
			a[i]=t.get(i);
		int ans[]=new int[n]; int count=0;
		for(i=1;i*i<n;i++)
		{
			count=0; HashSet<Integer> h=new HashSet();
			for(int j=0;j<n;j++)
			{
				if(h.size()==i)
				{
					h=new HashSet(); count++;
				}
				if(!h.contains(a[j]))
					h.add(a[j]);
			}
			ans[i-1]=count;
		}
		int val=i-1; HashSet<Integer> h[]=new HashSet[count]; 
		int b[]=new int[count]; int k=0; int size=0;
		for(i=0;i<n;i++)
		{
			if(h[k].size()==val)
			{
				b[k]=size; k++; size=0;
			}
			size++;
			if(!h[k].contains(a[i]))
				h[k].add(a[i]);
		}
		
		
					
		
		
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
	public static void main(String[] args) throws Exception {	 new collapse().run();	 }

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
