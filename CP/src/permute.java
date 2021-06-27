import java.util.*;
public class permute 
{
	static int val[][]; static int ptr=0; static int len=6;
	public static void main(String [] args)
	{
		int i; int fact[]=new int[11]; fact[0]=1;
		for(i=1;i<11;i++) fact[i]=fact[i-1]*i;
		int count=0;
		int a[]=new int [len]; val=new int[fact[len]][len];
		for(i=0;i<len;i++) a[i]=i+1;
		per(a.length,a);
		Arrays.sort(val, Arrays::compare); 
		int f[]=new int[len*fact[len]]; int k=0;
		for(i=0;i<fact[len];i++)
		{
			for(int j=0;j<len;j++)
				f[k++]=val[i][j];
		}
		int sum=len*(len+1)/2;
		for(i=0;i<len*fact[len];i++)
		{
			int cur=0;
			for(int j=i;j<Math.min(f.length, i+len);j++)
			{
				cur+=f[j];
			}
			if(cur==sum)
			{
				count++;
				for(int j=i;j<Math.min(f.length, i+len);j++)
				{
					System.out.print(f[j]+" ");
				}
				System.out.println();
			}
		}
		System.out.println(count);
	}
	public static  void per(int n, int[] elements) 
	{

		if(n == 1) 	printArray(elements);
		else 
		{	
			for(int i = 0; i < n-1; i++) 
			{
				per(n - 1, elements);
				if(n % 2 == 0) swap(elements, i, n-1);
				else swap(elements, 0, n-1);
			}
			per(n - 1, elements);
		}
	}
	static void swap(int[] input, int a, int b) {
		int tmp = input[a];
		input[a] = input[b];
		input[b] = tmp;
	}
	static void printArray(int[] input) 
	{
		 
		for(int i=0;i<input.length;i++)
		{
			val[ptr][i]=input[i];
		}
		ptr++;
	}
}

