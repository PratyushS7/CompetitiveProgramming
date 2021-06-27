
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.util.*;

class snakeeat implements Runnable 
{  
	private boolean testCases = true;
	private boolean console = false;
	private long MOD = 1000_000_007L;
	private int MAX = 1000_001;

	public void solve() 
	{
		int i;
		int n=in.ni();
		int q=in.ni();
		long l[]=new long[n];
		for(i=0;i<n;i++)
			l[i]=in.nl();
		Arrays.sort(l);
		long ps[]=new long[n];
		ps[0]=l[0];
		for(i=1;i<n;i++)
			ps[i]=ps[i-1]+l[i];
		
		for(i=0;i<q;i++) 
		{
			int q1=in.ni();
			int lo=-1;
			int hi=n-1;
			while(lo<hi)
			{
				int m=lo+(hi-lo+1)/2;
				if(l[m]>=q1)
					hi=m-1;
				else 
					lo=m;
			}
			if(hi==-1)
			{
				out.println(n);
				continue;
			}
			hi=lo+1;
			lo=1;
			int ul=hi-1;
			
			while(lo<hi)
			{
				int m=lo+(hi-lo)/2;
				long v=ps[ul]-ps[m-1];
				long need=(long)q1*(ul+1-m)-v;
				if(need>m)
					lo=m+1;
				else 
					hi=m;
			}
			out.println(n-hi);
		}
	}

	@Override
	public void run() {
		try {
			init();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		int t = testCases ? in.ni() : 1;
		while (t-- > 0) {
			solve();
			out.flush();
		}
	}

	private FastInput in;
	private PrintWriter out;

	public static void main(String[] args) throws Exception {
		new snakeeat().run();
	}

	private void init() throws FileNotFoundException {
		InputStream inputStream = System.in;
		OutputStream outputStream = System.out;
		try {
			if (!console && System.getProperty("user.name").equals("sachan")) {
				outputStream = new FileOutputStream("/home/sachan/Desktop/output.txt");
				inputStream = new FileInputStream("/home/sachan/Desktop/input.txt");
			}
		} catch (Exception ignored) {
		}
		out = new PrintWriter(outputStream);
		in = new FastInput(inputStream);
	}

	private void maualAssert(int a, int b, int c) {
		if (a < b || a > c)
			throw new RuntimeException();
	}

	private void maualAssert(long a, long b, long c) {
		if (a < b || a > c)
			throw new RuntimeException();
	}

	private void sort(int[] arr) {
		List<Integer> list = new ArrayList<>();
		for (int object : arr) list.add(object);
		Collections.sort(list);
		for (int i = 0; i < list.size(); ++i) arr[i] = list.get(i);
	}

	private void sort(long[] arr) {
		List<Long> list = new ArrayList<>();
		for (long object : arr) list.add(object);
		Collections.sort(list);
		for (int i = 0; i < list.size(); ++i) arr[i] = list.get(i);
	}

	public long ModPow(long x, long y, long MOD) {
		long res = 1L;
		x = x % MOD;
		while (y >= 1) {
			if ((y & 1) > 0) res = (res * x) % MOD;
			x = (x * x) % MOD;
			y >>= 1;
		}
		return res;
	}

	public int gcd(int a, int b) {
		if (a == 0) return b;
		return gcd(b % a, a);
	}

	public long gcd(long a, long b) {
		if (a == 0) return b;
		return gcd(b % a, a);
	}

	static class FastInput {
		InputStream obj;

		public FastInput(InputStream obj) {
			this.obj = obj;
		}

		byte inbuffer[] = new byte[1024];
		int lenbuffer = 0, ptrbuffer = 0;

		int readByte() {
			if (lenbuffer == -1) throw new InputMismatchException();
			if (ptrbuffer >= lenbuffer) {
				ptrbuffer = 0;
				try {
					lenbuffer = obj.read(inbuffer);
				} catch (IOException e) {
					throw new InputMismatchException();
				}
			}
			if (lenbuffer <= 0) return -1;
			return inbuffer[ptrbuffer++];
		}

		String ns() {
			int b = skip();
			StringBuilder sb = new StringBuilder();
			while (!(isSpaceChar(b))) // when nextLine, (isSpaceChar(b) && b!=' ')
			{
				sb.appendCodePoint(b);
				b = readByte();
			}
			return sb.toString();
		}

		int ni() {
			int num = 0, b;
			boolean minus = false;
			while ((b = readByte()) != -1 && !((b >= '0' && b <= '9') || b == '-')) ;
			if (b == '-') {
				minus = true;
				b = readByte();
			}
			while (true) {
				if (b >= '0' && b <= '9') {
					num = num * 10 + (b - '0');
				} else {
					return minus ? -num : num;
				}
				b = readByte();
			}
		}

		long nl() {
			long num = 0;
			int b;
			boolean minus = false;
			while ((b = readByte()) != -1 && !((b >= '0' && b <= '9') || b == '-')) ;
			if (b == '-') {
				minus = true;
				b = readByte();
			}
			while (true) {
				if (b >= '0' && b <= '9') {
					num = num * 10L + (b - '0');
				} else {
					return minus ? -num : num;
				}
				b = readByte();
			}
		}

		boolean isSpaceChar(int c) {
			return (!(c >= 33 && c <= 126));
		}

		int skip() {
			int b;
			while ((b = readByte()) != -1 && isSpaceChar(b)) ;
			return b;
		}

		float nf() {
			return Float.parseFloat(ns());
		}

		double nd() {
			return Double.parseDouble(ns());
		}

		char nc() {
			return (char) skip();
		}
	}
}