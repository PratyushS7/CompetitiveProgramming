import java.util.*;
class minimal
{
	public static void main (String[] args)
	 {
		Scanner sc=new Scanner(System.in); 
		int i,j=0,k=0;
		String s="";
		String u="";
		s=sc.next();
		int count[]=new int[26];
		Stack<Character> t= new Stack<Character>();
		for(i=0;i<s.length();i++)
			count[(int)s.charAt(i)-97]++;
		for(i=0;i<s.length();i++)
		{
			t.push(s.charAt(i));
			while(true)
			{
				if(count[j]==0)
					j++;
				else
					break;
			}
			count[(int)s.charAt(i)-97]--;
			while(t.peek()<=(j+97))
			{
				
				u=u+t.pop();

				if(t.isEmpty())
					break;
			}
		}
		while(!t.isEmpty())
			u=u+t.pop();
		System.out.println(u);
	}
}