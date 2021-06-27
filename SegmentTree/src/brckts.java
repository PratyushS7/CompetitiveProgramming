import java.io.*;
import java.util.*;
class brckts
{
	public static void main(String [] args)
	{
		Scanner sc=new Scanner(System.in);
		for(int tc=1;tc<=10;tc++)
		{
			System.out.println("Test "+tc+":");
			int i; int n=sc.nextInt(); char a[]=sc.next().toCharArray();
			int m=sc.nextInt();
			SegmentTree t=new SegmentTree(a,n);
			for(i=0;i<m;i++)
			{
				int v=sc.nextInt();   
				if(v==0)
				{	
					if(t.getValue(0, a.length-1)) System.out.println("YES");
					else  System.out.println("NO");
				}
				else
				{
					if(a[v-1]=='(')
					{
						a[v-1]=')'; t.update(v-1, ')');
					}
					else
					{
						a[v-1]='(';  t.update(v-1, '('); 
					}
				}
			}
		}
	}
	static class Node
	{
		int ou,cu;
		void assignLeaf(char value) 
		{
			if(value=='(')
			{
				ou=1; cu=0;
			}
			else
			{
				cu=1; ou=0;
			}
		}
		void merge(Node left, Node right) 
		{
			int cur=Math.min(left.ou, right.cu);
			ou=left.ou+right.ou-cur;
			cu=left.cu+right.cu-cur;
		}
		boolean getValue() 
		{
			if(ou==0&&cu==0) return true;
			return false;
		}
	}
	static class SegmentTree 
	{
		int N; Node nodes[];
		SegmentTree(char arr[], int N) 
		{
			this.N=N;
			nodes = new Node[getSegmentTreeSize(N)];
			for(int i=0;i<nodes.length;i++) nodes[i]=new Node();
			buildTree(arr, 1, 0, N-1);
		}
		void buildTree(char arr[], int stIndex, int lo, int hi) 
		{
			if (lo == hi) 
			{
				nodes[stIndex].assignLeaf(arr[lo]); return;
			}
			int left = 2 * stIndex, right = left + 1, mid = (lo + hi) / 2;
			buildTree(arr, left, lo, mid);
			buildTree(arr, right, mid + 1, hi);
			nodes[stIndex].merge(nodes[left], nodes[right]);
		}
		boolean getValue(int lo, int hi)
		{
			Node result = getValue(1, 0, N-1, lo, hi);
			return result.getValue();
		}
		Node getValue(int stIndex, int left, int right, int lo, int hi) 
		{
			if (left == lo && right == hi) 	return nodes[stIndex];
			int mid = (left + right) / 2;

			if ( lo > mid) return getValue(2*stIndex+1, mid+1, right, lo, hi);	
			if (hi <= mid) return getValue(2*stIndex, left, mid, lo, hi);

			Node leftResult = getValue(2*stIndex, left, mid, lo, mid);
			Node rightResult = getValue(2*stIndex+1, mid+1, right, mid+1, hi);
			Node result=new Node();
			result.merge(leftResult, rightResult);
			return result;
		}
		void update(int index, char value) 
		{
			update(1, 0, N-1, index, value);
		}
		void update(int stIndex, int lo, int hi, int index, char value) 
		{
			if (lo == hi) 
			{
				nodes[stIndex].assignLeaf(value); return;
			}
			int left = 2 * stIndex, right = left + 1, mid = (lo + hi) / 2;
			if (index <= mid) update(left, lo, mid, index, value);
			else update(right, mid+1, hi, index, value);
			nodes[stIndex].merge(nodes[left], nodes[right]);
		}
		int getSegmentTreeSize(int N) 
		{
			int size = 1;
			for (; size < N; size <<= 1);
			return size<<1;
		}
	}
}

