
import java.util.*;
 class RPN
{
	public static void main(String[] args)
	{
		Scanner sc=new Scanner(System.in);
		int t,i;
		t=sc.nextInt();
		String a="";
		while(t>0)
		{
			a="";
			t--;	
			String s=sc.next();
			Stack<Character> p=new Stack<Character>();
			HashMap<Character,Integer> h= new HashMap<Character,Integer>();
			h.put('+',1);
			h.put('-',2);
			h.put('*',3);
			h.put('/',4);
			h.put('^',5);
			h.put('(',0);
			p.push('(');
			char x;
			int j=0;
			for(i=0;i<s.length();i++)
			{
				if(Character.isLetter(s.charAt(i)))
				{
					a+=s.charAt(i);
					continue;
				}
				else if(s.charAt(i)=='+')
					j=1;
				else if(s.charAt(i)=='-')
					j=2;
				else if(s.charAt(i)=='*')
					j=3;
				else if(s.charAt(i)=='/')
					j=4;
				else if(s.charAt(i)=='^')
					j=5;
				else if(s.charAt(i)=='(')
					j=9;
				else 
					j=8;
				a=assign(p,j,h,s.charAt(i),a);
			}
			System.out.println(a);
		}
		
	}
	public static String assign(Stack<Character> p,int j,HashMap<Character,Integer> h,char c,String a)
	{
		int i;
		
		if(c==')')
		{
			while(p.peek()!='(')
			{
				a+=p.pop();
			}
			p.pop();
		}
		else if(j>=h.get(p.peek()))
			p.push(c);
		else 
		{
			while(j<h.get(p.peek()))
			{
				a+=p.pop();
			}
		}
		
		return a;
	}

}
