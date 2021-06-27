import java.util.Scanner;
class CKISSHUG
{
	public static void main(String[] args)
	{
		Scanner sc=new Scanner(System.in);
		int t,i,j,k;
		long n;
		t=sc.nextInt();
		while(t>0)
		{
			long p=0,o=0,c=0;
			t--;
			n=sc.nextLong();
			long x=n;
			while(n>0)
			{
				
				 if(n%2!=0)
				{
					o=x-(n+1)/2-c;
					p+=fast_exp(2,o);
				}
				else
				{
					o=x-n/2-c;
					p+=fast_exp(2,o);
				}
				n--;
				c++;
			}
			System.out.println(p+1);
		}
	}
	public static long fast_exp(long base, long exp) 
	{
		long MOD=1000000007;
		long res=1;
		while(exp>0) {
	       if(exp%2==1) res=(res*base)%MOD;
	       base=(base*base)%MOD;
	       exp/=2;
	    }
	    return res%MOD;
	}
}