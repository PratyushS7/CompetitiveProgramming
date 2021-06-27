import java.util.Arrays;
class orderset
{

	static int MAX_VAL = 16;
	static void update(int i, int add,Integer[] BIT)
	{
		while (i > 0 && i < BIT.length)
		{
			BIT[i] += add;
			i = i + (i & (-i));
		}
	}
	static int sum(int i, Integer[] BIT)
	{
		int ans = 0;
		while (i > 0)
		{
			ans += BIT[i];
			i = i - (i & (-i));
		}
		return ans;
	}
	static int findKthSmallest(int k,Integer[] BIT)
	{
		int l = 0;
		int h = BIT.length;

		while (l < h)
		{
			int mid = (l + h) / 2;
			if (k <= sum(mid, BIT))
				h = mid;
			else
				l = mid + 1;
		}
		return l;
	}
	static void insertElement(int x, Integer[] BIT)
	{
		update(x, 1, BIT);
	}
	static void deleteElement(int x, Integer[] BIT)
	{
		update(x, -1, BIT);
	}
	static int findRank(int x, Integer[] BIT)
	{
		return sum(x, BIT);
	}
	public static void main(String[] args)
	{
		Integer[] BIT = new Integer[MAX_VAL];
		Arrays.fill(BIT, 0);

		insertElement(5, BIT);
		insertElement(8, BIT);
		insertElement(10, BIT);
		insertElement(4, BIT);
		insertElement(6, BIT);

		System.out.println("2nd Smallest element is " +
				findKthSmallest(2, BIT));

		deleteElement(4, BIT);

		System.out.println("Rank of 50 is " +
				findRank(6, BIT));
	}
}
