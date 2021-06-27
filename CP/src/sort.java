import java.util.*;
public class sort 
{
	public static void main(String[] args)
	{
		Integer a[]= {-2,6,7,-4,3,-5,-1,2};
		Arrays.sort(a, new Comparator<Integer>()
				{
					@Override
					public int compare(Integer b,Integer c)
					{
						if(b<0&&c<0)
							return b-c;
						else
							return 0;
					}
				});
		for(int val:a)
			System.out.print(val+" ");
	}
}
