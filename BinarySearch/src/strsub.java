/* package codechef; // don't place package name! */

import java.util.*;
import java.lang.*;
import java.io.*;



/* Name of the class has to be "Main" only if the class is public. */
public class strsub
{
         static class Input {
        private StringTokenizer tokenizer = null;
        private BufferedReader reader;
 
        public Input(InputStream inputStream) {
            reader = new BufferedReader(new InputStreamReader(inputStream));
        }
 
        public String nextLine() {
            try {
                return reader.readLine();
            } catch (IOException e) {
                throw new RuntimeException();
            }
        }
 
        public String next() {
            while (tokenizer == null || !tokenizer.hasMoreTokens()) {
                tokenizer = new StringTokenizer(nextLine());
            }
            return tokenizer.nextToken();
        }
 
        public int nextInt() {
            return Integer.parseInt(next());
        }
 
        public long nextLong() {
            return Long.parseLong(next());
        }
 
        public int[] nextIntArray(int n, int add) {
            int[] result = new int[n];
            for (int i = 0; i < n; i++) {
                result[i] = nextInt() + add;
            }
            return result;
        }
 
        public long[] nextLongArray(int n, long add) {
            long[] result = new long[n];
            for (int i = 0; i < n; i++) {
                result[i] = nextLong() + add;
            }
            return result;
        }
 
        public int[] nextIntArray(int n) {
            return nextIntArray(n, 0);
        }
 
    }
    
	public static void main (String[] args) throws java.lang.Exception
	{
		Input s=new Input(System.in);
		int t=s.nextInt();
		while(t-->0)
		{
		    int n=s.nextInt();
		    int k=s.nextInt();
		    int q=s.nextInt();
		    
		    String st=s.next();
		    int far[]=new int[n];
		    int count[]=new int[2];
		    int j=0;
		    for(j=0;j<n;j++)
		    {
		        count[st.charAt(j)-'0']++;
		        //System.out.println(j+" "+count[0]+" "+count[1]);
		        if(count[0]>k || count[1]>k)
		        break;
		        
		       
		    }
		    far[0]=j-1;
		    count[st.charAt(0)-'0']--;
		    for(int i=1;i<n;)
		    {
		          if(j>=n-1)
		          { 
		             if(count[0]>k || count[1]>k)    
		            far[i]=j-1;
		            else
		            far[i]=j;
		            count[st.charAt(i)-'0']--;
		            i++;
		          }
		          else if(count[0]>k || count[1]>k)
		          {
		              count[st.charAt(i)-'0']--;
		              far[i]=j-1;
		              i++;
		          }
		          else
		          {
		              j++;
		              count[st.charAt(j)-'0']++;
		          }
		    }
		    
		    
		    long ans[]=new long[n];
		    for(int i=n-1;i>=0;i--)
		    {
		        long temp=(far[i]-i+1);
		       if(i==n-1)
		       ans[i]=temp;
		       else
		       ans[i]=ans[i+1]+temp;
		    }
		  
		    
		    while(q-->0)
		    {
		        int l=s.nextInt()-1;
		        int r=s.nextInt()-1;
		        int sta=l,en=r,mid=0;
		        int ind=r+1;
		        
		        
		        while(en>=sta)
		        {
		            mid=(sta+en)/2;
		            if(far[mid]<=r)
		            sta=mid+1;
		            else
		            {
		              en=mid-1;
		              ind=Math.min(ind,mid);
		            }
		            
		            
		        }
		        long sum=0;
		        if(ind<=n-1)
		        sum=ans[l]-ans[ind];
		        else
		        sum=ans[l];
		        long tel=(r-ind+1);
		        sum+=(tel*(tel+1))/2;
		        
		        System.out.println(sum);
		    }
		    
		}
	}
}
