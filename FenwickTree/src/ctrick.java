import java.util.*;
import java.io.*;
public class ctrick implements Runnable 
{
	private boolean console=false;

	int n; int bit[]; int max;
	public void solve() 
	{
		int i; n=in.ni(); max=n+5; bit=new int[max]; int ans[]=new int[n]; int pos=2; int last=0;
		for(i=1;i<=n;i++) update(1,i);
		for(i=1;i<=n;i++)
		{
			int cur = pos+sum(last);
			int free = n-i+1;
			int ind = cur%free;
			if(ind==0) ind=free;
			int lo=1; int hi=n;
			while(lo<hi)
			{
				int mid=(lo+hi)/2;
				int sum=sum(mid);
				if(sum<ind) lo=mid+1;
				else hi=mid;
			}
			update(-1,lo); ans[lo-1]=i; last=lo;
			pos++;
		}
		for(int v:ans) out.print(v+ " ");
		out.println();
	}
	public int sum(int ind)
	{
		int sum=0;
		for(;ind>0;ind-=ind&(-ind)) sum+=bit[ind];
		return sum;
	}
	public void update(int k, int ind)
	{
		for(;ind<max;ind+=ind&(-ind)) bit[ind]+=k;
	}
	@Override
	public void run() {
		try {  init();  } 
		catch (FileNotFoundException e) {  e.printStackTrace();   }

		int t= in.ni();

		while(t-->0)
		{
			solve(); out.flush();
		}	
	}
	private FastInput in;    private PrintWriter out;
	public static void main(String[] args) throws Exception {	 new ctrick().run();	 }

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