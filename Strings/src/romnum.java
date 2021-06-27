import java.util.*;
class romnum
{
	static long count;
	public static void main (String[] args)
	 {
		Scanner sc=new Scanner(System.in); 
		int t,i;
		t=sc.nextInt();
		while(t>0)
		{
			t--;
			int number=0;
			String s=sc.next();
			Map<Character, Integer> map = new HashMap<Character, Integer>();
			map.put('M',1000);
			map.put('D',500);
			map.put('C',100);
			map.put('L',50);
			map.put('X',10);
			map.put('V',5);
			map.put('I',1);
			map.put('E', 0);
			for(i=0;i<=s.length()-1;i++)
			{
				char c=s.charAt(i);
				char d;
				if(i+1==s.length())
				{
					d='E';
				}
				else
					d=s.charAt(i+1);
				if(map.get(c)<map.get(d))
				{
					number+=(map.get(d)-map.get(c));
					i++;
				}
				else
					number+=map.get(c);
			}
			System.out.println(number);
		} 
	}
}