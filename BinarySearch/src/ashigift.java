import java.io.*;
import java.util.*;
class ashigift implements Runnable 
{
    private boolean console=false;
    static int need;
    public void solve() 
    {
    	int i;
    	int n=in.ni();
    	int k=in.ni();
    	int a[]=new int[n];
    	char s[]=in.ns().toCharArray();
    	for(i=0;i<n;i++)
    		a[i]=Character.getNumericValue(s[i]);
    	int l=2;
    	int h=n;
    	if(n==1)
    	{
    		out.println(1);
    		return;
    	}
    	while(l<h)
    	{
    		int m=l+(h-l)/2;
    		int p = check(m,a,k);
    		if(p<0)
    			l=m+1;
    		else 
    			h=m;
    	}
    	if(l==2)
    	{
    		if(check1(a,k))
    		{
    			out.println(1);
    			return;
    		}
    	}
    	out.println(l);
    }
    int check(int m,int a[],int k)
    {
    	int i=0;
    	int cl=1;
    	int cc=a[0];
    	int n=a.length;
    	for(i=1;i<n;i++)
    	{
    		if(a[i]==cc)
    			cl++;
    		if(a[i]!=cc||i==n-1)
    		{
    			if(cl<=m)
    			{
    				cl=1;
    				cc=a[i];
    				continue;
    			}
    			need=0;
    			require(cl,m);
    			k-=need;
    			if(k<0)
    				return -1; 
    			cl=1;
    			cc=a[i];
    		}
    	}
    	return k;
    }
    void require(int cl,int m)
    {
    	if(m>=cl)
    		return ;
    	else 
    		need++;
    	require(cl/2,m);
    	require((cl-1)/2,m);
    	
    }
    boolean check1(int a[],int k)
    {
    	int i;
    	int n=a.length;
    	if(n<=3)
    	{
    		if(k>=1)
    			return true;
    	}
    	if(a[0]==a[1])
    		k--;
    	if(k==-1)
    		return false;
    	for(i=2;i<n;i++)
    	{
    		if(a[i]==a[i-1])
    		{
    			a[i]=1-a[i];
    			k--;
    		}
    		if(k==-1)
    			return false;
    	}
    	return true;
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
    public static void main(String[] args) throws Exception {	 new ashigift().run();	 }
    
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
