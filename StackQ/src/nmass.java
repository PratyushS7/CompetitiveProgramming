import java.util.*;
class nmass
{
	public static void main(String[] args)
	{
		Scanner sc=new Scanner(System.in);
		int t,i;
		t=sc.nextInt();
		while(t>0)
		{
			t--;
			int sum=0,temp=0,tempsum=0;
			HashMap<Character,Integer> a=new HashMap<Character,Integer>();
			a.put('H',1);
			a.put('C',12);
			a.put('O',16);
			Stack<Character> p=new Stack<Character>();
			String s=sc.next();
			for(i=0;i<s.length();i++)
			{
				if(s.charAt(i)=='('||s.charAt(i)==')')
				{
					while(s.charAt(i)!=')') 
					{
						p.push(s.charAt(i));
						i++;
					}
					char c=' ';
					int j;
					while(c!='(')
					{
						c=p.pop();
						j=Character.getNumericValue(c);
						if(j<0)
							temp=a.get(c)+temp;
						else
							temp+=a.get(p.pop())*j;			
					}
					p.pop();
				}
				else if(Character.getNumericValue(s.charAt(i))>0)
				{
					tempsum+=Character.getNumericValue(s.charAt(i))*temp;
					temp=0;
					if(p.isEmpty())
					{
						sum=tempsum;
						tempsum=0;
					}
				   
				}
				
			}
		}	
	}
}
