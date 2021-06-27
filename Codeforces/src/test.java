import java.io.*;
import java.util.*;
public class test implements Runnable 
{
	class pair
	{
		int x, y, xor,val;
		pair(int x,int y,int xor,int val)
		{
			this.x=x; this.y=y; this.xor=xor; this.val=val;
		}
	}
	private boolean console=false;
 
	int up=5000;
	public void solve()
	{
		int i;  int n=in.ni(); int a[]=new int[n]; int pos[][]=new int[up+1][2]; int max=0; HashSet<Integer> same[]=new HashSet[up+1];
		for(i=0;i<=up;i++)
		{
			Arrays.fill(pos[i], -1); same[i]=new HashSet();
		}
		for(i=0;i<n;i++)
		{
			a[i]=in.ni();
			if(pos[a[i]][0]==-1) pos[a[i]][0]=i;
			pos[a[i]][1]=i;
		}
		for(i=0;i<=up;i++)
		{
			if(pos[i][0]==-1) continue;
			for(int j=pos[i][0];j<=pos[i][1];j++)
			{
				same[i].add(a[j]); same[a[j]].add(i);
			}
		}
		ArrayList<pair> p=new ArrayList();  
		for(i=0;i<=up;i++)
		{
			if(pos[i][0]==-1) continue;
			HashSet<Integer> t= new HashSet(); int xor=0;
			for(int j=pos[i][0];j<=pos[i][1];j++)
			{
				if(!t.contains(a[j]))
				{
					t.add(a[j]); xor^=a[j];
				}
			}
			p.add(new pair(pos[i][0],pos[i][1],xor,i));
		}
		Collections.sort(p,(o1,o2)-> o1.xor-o2.xor);
		for(i=0;i<p.size();i++)
		{
			pair here=p.get(i); int ans=here.xor; ArrayList<HashSet<Integer>> st=new ArrayList();
			HashSet<Integer> cur=new HashSet(same[here.val]);  st.add(cur);
			for(int j=p.size()-1;j>=0;j--)
			{
				pair it=p.get(j); boolean poss=true;
				for(HashSet<Integer> temp:st)
				{
					if(temp.contains(it.val))
					{
						poss=false; break;
					}
				}
				if(poss)
				{
					st.add(same[it.val]);
					ans+=it.xor;
				}
			}
			max=Math.max(max, ans);
		}
		/*
		HashSet<Integer> tr=new HashSet();
		for(i=0;i<p.size();i++)
		{
			int cx=p.get(i).x; int cy=p.get(i).y;
			for(int j=i+1;j<p.size();j++)
			{
				if(p.get(j).x>=cx&&p.get(j).y<=cy)
				{
					tr.add(i); break;
				}
			}
		}
		ArrayList<pair> pt=new ArrayList(5000);
		for(i=0;i<p.size();i++)
		{
			if(tr.contains(i)) continue;
			pt.add(p.get(i));
		}
		*/
		
		out.println(max);
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
	public static void main(String[] args) throws Exception {	 new test().run();	 }
 
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
 