import java.io.*;
import java.util.*;

class mtrwy implements Runnable 
{
	private boolean console=false;

	int par[]; int size[]; int max,n,m;
	public void solve() 
	{
		int i;n=in.ni();m=in.ni();int q=in.ni(); long ans=0; par=new int[n*m]; size=new int[n*m]; max=1; 
		ArrayList<int []> qu=new ArrayList();HashSet<Integer> hor=new HashSet();  HashSet<Integer> ver=new HashSet();
		for(i=0;i<n*m;i++)
		{
			par[i]=i; size[i]=1;
		}
		for(i=0;i<q;i++)
		{
			int v=in.ni(); 
			if(v==1)
			{
				int c[]={1,in.ni()-1,in.ni()-1}; int cur=c[1]*m+c[2];
				if(hor.contains(cur)) continue;
				hor.add(c[1]*m+c[2]); qu.add(c);
			}
			else if(v==2)
			{
				int c[]= {2,in.ni()-1,in.ni()-1}; int cur=c[1]*m+c[2];
				if(ver.contains(cur)) continue;
				ver.add(c[1]*m+c[2]); qu.add(c);
			}
			else if(v==3)
			{
				int c[]= {3,in.ni()-1,in.ni()-1,in.ni()-1,in.ni()-1}; qu.add(c);
			}
			else 
			{
				int c[]= {4}; qu.add(c);
			}
		}
		for(i=0;i<n;i++)
		{
			for(int j=0;j<m;j++)
			{ 
				int s=i*m+j;
				if(!hor.contains(s)&&j+1<m) union(s,s+1);
				if(!ver.contains(s)&&i+1<n) union(s,s+m);
			}
		}
		for(i=qu.size()-1;i>=0;i--)
		{
			if(qu.get(i)[0]==1)
			{
				int x=qu.get(i)[1],y=qu.get(i)[2]; union(x*m+y,x*m+y+1);
			}
			else if(qu.get(i)[0]==2)
			{
				int x=qu.get(i)[1],y=qu.get(i)[2]; union(x*m+y,(x+1)*m+y);
			}
			else if(qu.get(i)[0]==3)
			{
				int s1=qu.get(i)[1]*m+qu.get(i)[2], s2=qu.get(i)[3]*m+qu.get(i)[4];
				if(find(s1)==find(s2)) ans++;
			}
			else ans+=max;
		}
		out.println(ans);
	}
	public void union(int a,int b)
	{
		a=find(a); b=find(b);
		if(a==b) return;
		if(size[b]>size[a])
		{
			int t=a; a=b; b=t;
		}
		par[b]=a; size[a]+=size[b]; 
		if(size[a]>max) max=size[a];
	}
	public int find(int a)
	{
		return (par[a]==a)?a:(par[a]=find(par[a]));
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
	public static void main(String[] args) throws Exception {	 new mtrwy().run();	 }

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
