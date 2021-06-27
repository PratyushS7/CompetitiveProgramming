import java.io.*;
import java.util.*;


class queen implements Runnable 
{
	private boolean console=false;
	
	char a[][];
	int vis;
	int n,m;
	Queue<Pair> q;
	int X[]= {-1,-1,-1,0,0,1,1,1};
	int Y[]= {-1,0,1,-1,1,-1,0,1};
	public void solve() 
	{
		int i;
		n=in.ni();
		m=in.ni();
		a=new char[n][m];
		for(i=0;i<n;i++)
			a[i]=in.ns().toCharArray();
		int ans[][]=new int[n][m];
		q=new LinkedList();
		for(i=0;i<n;i++)
			Arrays.fill(ans[i], Integer.MAX_VALUE);
		vis=0;
		Pair des=new Pair(0,0);
		for(i=0;i<n;i++)
		{
			for(int j=0;j<m;j++)
			{
				if(a[i][j]=='S')
				{
					q.add(new Pair(i,j));
					ans[i][j]=0;
				}
				if(a[i][j]=='F')
					des=new Pair(i,j);
			}
		}
		while(!q.isEmpty())
		{
			Pair d=q.poll();
			for(i=0; i<8; i++)
			{
			    Pair copy = d;
			    int x=copy.x;
			    int y=copy.y;
			    x += X[i];
			    y += Y[i];
			    while(check(x,y))
			    {
			    	if(ans[x][y] == Integer.MAX_VALUE) 
			    	{
			    		ans[x][y] = ans[d.x][d.y] + 1;
			    		q.add(new Pair(x,y));
			    	}
			    	else if(ans[x][y] != ans[d.x][d.y]+1)
			    		break; 
			    	x += X[i];
			    	y += Y[i];
			   	}	
			}
		}
		if(ans[des.x][des.y]==Integer.MAX_VALUE)
			out.println(-1);
		else
			out.println(ans[des.x][des.y]);
		
	}
	boolean check(int x,int y)
	{
		vis++;
		if(x >=0 && x <n &&y >=0 && y <m  && a[x][y] != 'X')
			return true;
		return false;
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
	public static void main(String[] args) throws Exception {	 new queen().run();	 }

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
