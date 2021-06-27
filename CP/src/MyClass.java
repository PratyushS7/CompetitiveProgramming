import java.util.*;
public class MyClass 
{
	public static void main(String [] args)
	{
		Scanner sc=new Scanner(System.in);
		List<Integer> h=new ArrayList(); List<Integer> v=new ArrayList();
		h.add(1); v.add(2); //v.add(3);
		System.out.println(solve(3,3,h,v));
		
	}
	public static int solve(int n,int m,List<Integer> H,List<Integer> V)
	{
		int lh=1,lv=1;
		Collections.sort(H); Collections.sort(V);
		for(int i=0;i<H.size();i++)
		{
			int c=H.get(i); int ch=2; i++;
			while(i<H.size()&&H.get(i)-1==H.get(i-1))
			{
				ch++; i++;
			}
			lh=Math.max(lh, ch);
			i--;
		}
		for(int i=0;i<V.size();i++)
		{
			int c=V.get(i); int ch=2; i++;
			while(i<V.size()&&V.get(i)-1==V.get(i-1))
			{
				ch++; i++;
			}
			lv=Math.max(lv, ch);
			i--;
		}
		return lh*lv;
	}
}
