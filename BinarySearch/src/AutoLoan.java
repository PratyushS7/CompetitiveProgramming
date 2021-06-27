import java.util.Arrays;
import java.util.Scanner;
class AutoLoan
{
	public static void main (String[] args)
	 {
		Scanner sc=new Scanner(System.in); 
		int t,i;
		double p=15000;
		double mp=364;
		int lt=48;
		System.out.println(interestRate(p,mp,lt)*12.0);
	}
	static double interestRate(double price, double monthlyPayment, int loanTerm)
	{
		double pr=price;
		double mp=monthlyPayment;
		int lt=loanTerm;
		double l=0;
		double h=100;
		double tv= mp*lt-pr;
		double p;
		while(l<h)
		{
			 p =l+ (h-l)/2.0;
			double v= calc(pr,mp,lt,p);
			if(v==tv)
				return p;
			else if(v<tv)
				l=p;
			else
				h=p;
		}
		return l;
	}
	static double calc(double pr,double mp,int lt,double p)
	{
		int i;
		double in=0.0;
		double ip=pr;
		for(i=1;i<=lt;i++)
		{
			double inte=(pr*p/100.0);
			in+=inte ;
			pr=pr+inte-mp;
		}
		return in;
	}
}
