import java.io.*;
import java.util.*;

class giveaway implements Runnable 
{
	private boolean console=false;

	public void solve() 
	{
		int i;
		int n=in.ni();  
		int len=(int) Math.sqrt(n)+1; int a[][]=new int[n][2];
		for(i=0;i<n;i++)
		{
			a[i][0]=in.ni(); a[i][1]=i;
		}
		int q=in.ni();
		
		for(i=0;i<len;i++)
		{
			if(len*i>=n)
				break;
			Arrays.sort(a,len*i,Math.min(n, len*(i+1)),Comparator.comparing((int d[])-> d[0]));
		}
		for(i=0;i<q;i++)
		{
			int t=in.ni();
			if(t==0)
			{
				int l=in.ni()-1; int r=in.ni()-1; int c=in.ni();
				int cl=l/len; int cr=r/len; int ans=0;
				if(cl==cr)
				{
					for(int j=cl*len;j<Math.min(n,(cl+1)*len);j++)
					{
						if(a[j][0]>=c&&a[j][1]>=l&&a[j][1]<=r)
							ans++;
					}
				}
				else
				{
					for(int j=cl*len;j<Math.min(n,(cl+1)*len);j++)
					{
						if(a[j][0]>=c&&a[j][1]>=l&&a[j][1]<=r)
							ans++;
					}
					for(int j=cr*len;j<Math.min(n,(cr+1)*len);j++)
					{
						if(a[j][0]>=c&&a[j][1]>=l&&a[j][1]<=r)
							ans++;
					}
					for(int j=cl+1;j<=cr-1;j++)					
						ans+=bins(a,j*len,Math.min((j+1)*len, n),c);
				}
				out.println(ans);
			}
			else
			{
				int pos=in.ni()-1; int v=in.ni();
				int w=pos/len;
				for(int j=w*len;j<Math.min(n,(w+1)*len);j++)
				{
					if(a[j][1]==pos)
					{
						a[j][0]=v; break;
					}
				}
				Arrays.sort(a,len*w,Math.min(n, len*(w+1)),Comparator.comparing((int d[])-> d[0]));
			}
		}
	}
	public int bins(int a[][],int l,int r,int c)
	{
		int f=r;
		while(l<r)
		{
			int mid=l +(r-l)/2;
			if(a[mid][0]<c)
				l=mid+1;
			else
				r=mid;
		}
		return f-l;
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
	public static void main(String[] args) throws Exception {	 new giveaway().run();	 }

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
