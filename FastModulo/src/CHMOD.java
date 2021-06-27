import java.util.Scanner;
class CHMOD
{
	public static void main(String[] args)
	{
		Scanner sc=new Scanner(System.in);
		int n,i,j,k;
		long p=1;
		n=sc.nextInt();
		int a[]=new int[n+1];
		for(i=1;i<=n;i++)
			a[i]=sc.nextInt();
		long op=sc.nextInt();
		while(op>0)
		{
			p=1;
			int l=sc.nextInt();
			int r=sc.nextInt();
			int m=sc.nextInt();
			for(i=l;i<=r;i++)
				p*=a[i];
			System.out.println(p%m);
			op--;
		}
		
	}
}