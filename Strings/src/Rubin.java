import java.util.*;
public class Rubin  
{ 
	public static void main(String [] args)
	{
		Scanner sc=new Scanner(System.in);
		String s=sc.next();
		String pat=sc.next();
		int p=31;
		long m= 1000000009;
		long h[]=new long[s.length()+1];
		int n=s.length();
		
		int i;
		long pow[]=new long[n];
		pow[0]=1;
		for(i=1;i<n;i++)
			pow[i]=(pow[i-1]*p)%m;
		for(i=0;i<n;i++)
			h[i+1]=(h[i]+ (s.charAt(i)-'a'+1)*pow[i])%m;
		int count=0;
		long ph=0;
		for(i=0;i<pat.length();i++)
			ph= (ph+(pat.charAt(i)-'a'+1)*pow[i])%m;
		int m1=pat.length();
		int j;
		for(i=0;i<=n-m1;i++)
		{
			long cur = (h[i+m1]+m-h[i])%m;
			long st= (ph*pow[i])%m;
			if(st==cur)
			{
				
					count++;
			}
		}
		System.out.println(count);
	}
} 