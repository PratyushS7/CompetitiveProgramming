import java.util.*;
class anarc
{
	public static void main (String[] args)
	 {
		Scanner sc=new Scanner(System.in); 
		int i,j,k=0;
		String s="";
		s=sc.next();
		Stack<Character> p= new Stack<Character>();
		while(!s.contains("-"))
		{
			int count=0,ele=0;
			k++;
			for(i=0;i<s.length();i++)
			{
				if(p.isEmpty())
				{
					if(s.charAt(i)=='}')
					{
						count++;
						p.push('{');
					}
					else
						p.push(s.charAt(i));
				}
				else 
				{
					if(s.charAt(i)=='}')
						p.pop();
					else
						p.push(s.charAt(i));
				}
			}
			while(!p.isEmpty())
			{
				p.pop();
				ele++;
			}
			
			count+=(ele/2);
			System.out.println(k+". "+count);
			s=sc.next();			
		} 
	}
}