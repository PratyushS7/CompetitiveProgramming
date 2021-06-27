import java.io.*;
import java.util.*;
public class global implements Runnable 
{
	private boolean console=false;

	public void solve() 
	{
		int i; int n=in.ni(); int a[]=new int[n]; HashMap<Integer,ArrayList<String>> h=new HashMap();
		for(i=0;i<n;i++) a[i]=in.ni();
		HashSet<String> done=new HashSet();
		for(i=2;i<=1000;i++) h.put(i, new ArrayList());
		ArrayList<String> t=new ArrayList(); t.add("1"); 
		h.put(1,t); out.println(1);
		String pa="1";
		for(i=1;i<n;i++)
		{
			if(a[i]==1)
			{
				ArrayList<String> p=h.get(1);
				String s=check(pa,h); p.add(s); pa=s;
				out.println(s);
			}
			else
			{
				ArrayList<String> p=h.get(a[i]-1); ArrayList<String> cur=h.get(a[i]);
				for(int j=p.size()-1;j>=0;j--)
				{
					String b[]=p.get(j).split("\\."); 
					String k=b[b.length-1];
					int x=Integer.parseInt(k)+1;
					String c=p.get(j).substring(0,p.get(j).lastIndexOf(k))+x;
					String l=String.valueOf(c);
					if(!done.contains(l))
					{
						done.add(l); cur.add(l);
						break;
					}
				}
				pa=cur.get(cur.size()-1);
				out.println(pa);
			}
		}
	}
	public String check(String pa, HashMap<Integer,ArrayList<String>> h)
	{
		for(int i=1;i<=1000;i++)
		{
			String hi=h.get(i).get(h.get(i).size()-1)+".1";
			if(hi.compareTo(pa)>0) return hi; 
		}
		return "";
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
	public static void main(String[] args) throws Exception {	 new global().run();	 }

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
