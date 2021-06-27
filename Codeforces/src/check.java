import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;
 
public class check {
	
	static int N;
	static int[] list;
	static int[] right;
	
	
	public static void main(String[] args) 
	{
		int[] memo;	
		FS scan = new FS(System.in);
		N = scan.nextInt();
		list = new int[N];
		for(int i=0;i<N;i++)list[i] = scan.nextInt();
		right = new int[5001];Arrays.fill(right,-1);
		for(int i=N-1;i>=0;i--)if(right[list[i]]==-1)right[list[i]]=i;
		
		memo = new int[N];
		Arrays.fill(memo, -1);
		//System.out.println(Arrays.toString(right));
		System.out.println(solve(0,memo));
		System.out.println();
		
		
	}
	private static int solve(int idx,int memo[]) {
		//System.out.println(idx);
		if(idx>=N)return 0;
		if(memo[idx]!=-1)return memo[idx];
		
		int sol = 0;
		boolean[] seen = new boolean[5001];
		boolean[] cant = new boolean[5001];
		for(int i=0;i<idx;i++)cant[list[i]]=true;
		int xor = 0;
		for(int i=idx;i<N;i++){
			int r = right[list[i]];
			boolean valid = true;
			for(int j=i;j<=r;j++){
				if(right[list[j]]>r)r=right[list[j]];
				if(cant[list[j]])valid=false;
				if(seen[list[j]])continue;
				seen[list[j]]=true;
				xor^=list[j];
			}
			if(!valid)break;
			//System.out.println(i+" "+idx+" "+r);
			sol = Math.max(sol, xor+solve(r+1,memo));
			i = r;
		}
		sol = Math.max(sol, solve(idx+1,memo));
		
		return memo[idx] = sol;
	}
	private static class FS {
		BufferedReader br;
		StringTokenizer st;
		public FS(InputStream in) {
			br = new BufferedReader(new InputStreamReader(in));
		}
		String next(){
			while(st==null||!st.hasMoreElements()){
				try{st = new StringTokenizer(br.readLine());}
				catch(IOException e){e.printStackTrace();}
			}
			return st.nextToken();
		}
		int nextInt() {return Integer.parseInt(next());}
		long nextLong() {return Long.parseLong(next());}
		double nextDouble() { return Double.parseDouble(next());}
	}
}