import java.util.Scanner;
import java.util.Stack;
public class altern
{
	public static void main (String[] args)
	 {
		Scanner sc=new Scanner(System.in); 
		int i,j=0,k=0;
		String s=sc.next();
		Stack<Character> p= new Stack<Character>();
		p.push(s.charAt(0));
		for(i=1;i<s.length();i++)
		{
			if(!p.isEmpty())
			{
				if(s.charAt(i)==p.peek())
				{
					p.pop();
				}
				else
					p.push(s.charAt(i));
			}
			else
				p.push(s.charAt(i));
		}
		if(p.isEmpty())
			System.out.println("Yes");
		else
			System.out.println("No");
	}
}