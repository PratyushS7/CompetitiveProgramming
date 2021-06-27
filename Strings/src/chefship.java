import java.util.Scanner;
class chefship  
{ 
	public static void main(String [] args)
	{
		Scanner sc=new Scanner(System.in);
		int i,t;
		t=sc.nextInt();
		while(t>0)
		{
			t--;
			int p=31;
			long m= 1000000009;
			char a[]=sc.next().toCharArray();
			int n=a.length;
			long h[]=new long[n+1];
			long pow[]=new long[n];
			
			pow[0]=1;
			for(i=1;i<n;i++)
				pow[i]=(pow[i-1]*p)%m;
			
			int cc[]=new int[26];
			//for(i=0;i<n;i++)
				//cc[a[i]-'a']++;
			int f=0;
			for(i=0;i<26;i++)
				if(cc[i]==n)
				{
					f=1;
					System.out.println((n-2)/2);
				}
			if(f==1)
				continue;
			
			for(i=0;i<n;i++)
				h[i+1]=(h[i]+ (a[i]-'a'+1)*pow[i])%m;
			int count=0;
			
			for(i=1;i<n-2;i+=2)
			{
				int p1=i/2;
				long hp1 = h[p1+1];
				long hp2 = (h[i+1]+m-h[p1+1])%m;
				int r1= (n+i)/2;
				long rp1= (h[n]+m-h[r1+1])%m;
				long rp2= (h[r1+1]+m-h[i+1])%m;
				if((hp1*pow[p1+1])%m==hp2&&(rp1*pow[i+1])%m==(rp2*pow[r1+1])%m)
					count++;
			}
			System.out.println(count);
		}
	}
} 