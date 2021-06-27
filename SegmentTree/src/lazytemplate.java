import java.io.*;
import java.util.*;
class lazytemplate
{
	public static void main(String []args)
	{
		
	}
	class Node
	{
		int start,end; double total;
		void assignLeaf(double value) 
		{
			total=value;
		}
		void merge(Node left, Node right) 
		{
			total=left.total+right.total;
		}
		double query() 
		{		
			return total;
		}
		void update(boolean value)
		{
			total=Math.sqrt(total);
		}
	}
	class SegmentTree 
	{
		int N; Node nodes[];
		SegmentTree(int arr[], int N) 
		{
			this.N=N;
			nodes = new Node[getSegmentTreeSize(N)];
			for(int i=0;i<nodes.length;i++) nodes[i]=new Node();
			buildTree(arr, 1, 0, N-1);
		}
		void buildTree(int arr[], int stIndex, int lo, int hi) 
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
		double getValue(int lo, int hi)
		{
			Node result = getValue(1, 0, N-1, lo, hi);
			return result.query();
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
		void update(int st,int end, boolean value) 
		{
			update(1, st, end, value);
		}
		void update(int stIndex, int start, int end, boolean value) 
		{
			  if (start == end) 
			  {
				  nodes[stIndex].update(value);  return;
			  }
			  int mid = (nodes[stIndex].start + nodes[stIndex].end) / 2,
			      leftChildIndex = 2 * stIndex,
			      rightChildIndex = leftChildIndex + 1;
			      
			  if (start > mid)  update(rightChildIndex, start, end, value);
			  else if (end <= mid) update(leftChildIndex, start, end, value);
			  else 
			  {
				  update(leftChildIndex, start, mid, value);  update(rightChildIndex, mid+1, end, value);
			  }
			  nodes[stIndex].merge(nodes[leftChildIndex], nodes[rightChildIndex]);
			}
		int getSegmentTreeSize(int N) 
		{
			int size = 1;
			for (; size < N; size <<= 1);
			return size<<1;
		}
	}
}
