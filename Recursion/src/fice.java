import java.util.*;
class fice
{
	public static void main (String[] args)
	 {
		Scanner sc=new Scanner(System.in); 
		int t,i,n,j;
		t=sc.nextInt();
		while(t>0)
		{
			t--;
			n= sc.nextInt();
			int m=sc.nextInt();
			 int a=1,b=1,c=0;
			 for(i=3;i<=n;i++)
			 {
				 c=a+b;
				 a=b;
				 b=c;
			 }
			 if(n==1)
				 System.out.println(2);
			 else if(n==2)
				 System.out.println(2);
			 else
			 {
				 c*=2;
				 System.out.println(c%m);
			 }
			
		
			
		}
	}
}

