
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.util.*;

class stacks implements Runnable 
{  
	private boolean testCases = true;
	private boolean console = false;
	private long MOD = 1000_000_007L;
	private int MAX = 1000_001;

	public void solve() 
	{
		int i;
		int n=in.ni();
		int a[]=new int[n];
		for(i=0;i<n;i++)
			a[i]=in.ni();
		int b[]=new int[100001];
		Arrays.fill(b, 1000000001);
		int k=0;
		for(i=0;i<n;i++)
		{
			int l=0;
			int r=100000;
			while(l<r)
			{
				int m=l+(r-l)/2;
				if(b[m]==1000000001)
					r=m;
				else if(b[m]>a[i])
					r=m;
				else
					l=m+1;
			}
			if(b[l]==1000000001)
			{
				b[l]=a[i];
				k++;
			}
			else
				b[l]=a[i];
		}
		out.print(k+" ");
		for(i=0;i<100000;i++)
		{
			if(b[i]==1000000001)
				break;
			out.print(b[i]+" ");
		}
		out.println();
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
		new stacks().run();
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