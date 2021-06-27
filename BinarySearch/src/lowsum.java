import java.io.DataInputStream;
import java.io.InputStream;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Arrays;


public class lowsum{

	
	public static void main(String[] args) throws Exception {
		Parserdoubt77771112225 in  = new Parserdoubt77771112225(System.in);
		PrintWriter out = new PrintWriter(System.out);
		double st=System.nanoTime();
		int T = 5;
		for (int t = 0; t < T; t++) {
			int k = 20000;
			int Q = 500;
			
			Long a[] = new Long[k];
			Long b[] = new Long[k];
			for (int i = 0; i < k; i++) {
				a[i] =(long) i+1;
			}
			for (int i = 0; i < k; i++) {
				b[i] = (long)100+i ;
			}
			Arrays.sort(a);
			Arrays.sort(b);
			
			for (int q = 0; q < Q; q++) {
				long qi = 10000;
				
				long ans = -1;
				long left = 0;
				long right = 2 * 1000000000000000000L;
				
				while(left <= right){
					long mid = (left + right) / 2;
					
					long count = 0;
					
					for (int i = 0; i < a.length; i++) {
						
						long value = mid - a[i];
						
						//
						long res = -1;
						int l = 0;
						int r = b.length - 1;
						while(l <= r){
							int m = (l + r) / 2;
							if(b[m] <= value){
								res = m;
								l = m + 1;
							}
							else {
								r = m - 1;
							}
						}
						if(res == -1){
							break;
						}
						else {
							count += res + 1;
						}
						if(count >= 10100){
							break;
						}
//						System.out.println(count);
					}
//					System.out.println(mid + " " + count);
					if(count >= qi){
						ans = mid;
						right = mid - 1;
					}
					else {
						left = mid + 1;
					}
				}
//				System.out.println(ans);
				out.println(ans);
			}
		out.println((System.nanoTime()-st)/1000000000);
		}
		
		out.close();
	}
	
	
}


class Parserdoubt77771112225
{
   final private int BUFFER_SIZE = 1 << 17;
 
   private DataInputStream din;
   private byte[] buffer;
   private int bufferPointer, bytesRead;
 
   public Parserdoubt77771112225(InputStream in)
   {
      din = new DataInputStream(in);
      buffer = new byte[BUFFER_SIZE];
      bufferPointer = bytesRead = 0;
   }
   public String nextString() throws Exception
   {
	   StringBuffer sb=new StringBuffer("");
	   byte c = read();
	   while (c <= ' ') c = read();
	   do
	   {
		   sb.append((char)c);
		   c=read();
	   }while(c>' ');
	   return sb.toString();
   }
   public char nextChar() throws Exception
   {
	   byte c=read();
	   while(c<=' ') c= read();
	   return (char)c;
   }
   public int nextInt() throws Exception
   {
      int ret = 0;
      byte c = read();
      while (c <= ' ') c = read();
      boolean neg = c == '-';
      if (neg) c = read();
      do
      {
    	  ret = ret * 10 + c - '0';
         c = read();
      } while (c > ' ');
      if (neg) return -ret;
      return ret;
   }
   public long nextLong() throws Exception
   {
      long ret = 0;
      byte c = read();
      while (c <= ' ') c = read();
      boolean neg = c == '-';
      if (neg) c = read();
      do
      {
    	  ret = ret * 10 + c - '0';
         c = read();
      } while (c > ' ');
      if (neg) return -ret;
      return ret;
   }
   private void fillBuffer() throws Exception
   {
      bytesRead = din.read(buffer, bufferPointer = 0, BUFFER_SIZE);
      if (bytesRead == -1) buffer[0] = -1;
   }
 
   private byte read() throws Exception
   {
      if (bufferPointer == bytesRead) fillBuffer();
      return buffer[bufferPointer++];
   }
} 