import java.io.*;
import java.util.*;
class template
{
	class Node
	{
		int v;
		void assignLeaf(int value) 
		{
			//values
		}
		void merge(Node left, Node right) 
		{
			//logic
		}
		int getValue() 
		{		
			return v;
		}
	}
	class SegmentTree 
	{
		int N; Node nodes[];
		SegmentTree(int arr[]) 
		{
			this.N=arr.length;
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
		int getValue(int lo, int hi)
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
		void update(int index, int value) 
		{
			update(1, 0, N-1, index, value);
		}
		void update(int stIndex, int lo, int hi, int index, int value) 
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
