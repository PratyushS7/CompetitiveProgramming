import java.util.Scanner;
class csub
{
	public static void main(String[] args)
	{
		Scanner sc=new Scanner(System.in);
		int t,n,i,j;
		t=sc.nextInt();
		while(t>0)
		{
			int count=0;
			t--;
			n=sc.nextInt();
			String s=sc.next();
			for(i=0;i<n;i++) 
			{
				for(j=i;j<n;j++)
				{
					if(s.charAt(i)=='0')
						break;
					else
					{
						if(s.charAt(j)=='1')
							count++;
					}
				}
			}
			System.out.println(count);
			
			
		
		
	}}
}