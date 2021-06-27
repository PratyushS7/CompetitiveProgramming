import java.util.Arrays;
import java.util.Scanner;
class Mortgage
{
	public static void main (String[] args)
	 {
		Scanner sc=new Scanner(System.in); 
		int t,i;
		int l=1000;
			

		i=50;
		t=	1;
		System.out.println(monthlyPayment(l,i,t));
	}
	static int monthlyPayment(int loan, int interest, int term)
	{
		int l=0;
		int h=loan;
		double mi=interest/120.0;
		int t=term*12;
		while(l<h)
		{
			int m=l+(h-l)/2;
			long pay=calc(loan,mi,t, m);
			if(pay>0)
				l=m+1;
			else
				h=m;
		}
		return l;
	}
	static long calc(int l,double mi,int t,int m)
	{
		int i;
		long loan=l;
		for(i=1;i<=t;i++)
		{
			loan-=m;
			double in= mi*loan/100;
			loan+=(int)Math.ceil(in);
			if(loan<0)
				return loan;
		}
		return loan;
	}
}
