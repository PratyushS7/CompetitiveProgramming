class mcm 
{ 
	static int MatrixChainOrder(int p[], int n) 
	{ 
		int m[][] = new int[n][n];
		int i, j, k, L, q;
		
		for (L = 2; L < n; L++) 
		{ 
			for (i = 0; i < n - L ; i++) 
			{ 
				j = i + L ;
				m[i][j] = Integer.MAX_VALUE; 
				for (k = i+1; k <= j - 1; k++) 
				{ 
					q = m[i][k] + m[k][j] + p[i] * p[k] * p[j]; 
					if (q < m[i][j]) m[i][j] = q;
				} 
			} 
		}
		return m[0][n - 1]; 
	} 
	public static void main(String args[]) 
	{ 
		int arr[] = new int[] { 1, 2, 3, 4,3  }; 
		int size = arr.length; 

		System.out.println( 
			"Minimum number of multiplications is "
			+ MatrixChainOrder(arr, size)); 
	} 
} 

