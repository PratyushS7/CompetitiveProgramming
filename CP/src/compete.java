class compete 
{ 
	static int minOperations(String str, int n) 
	{ 
		int i, lastLower = -1, firstUpper = -1; 
		for (i = n - 1; i >= 0; i--) { 
			if (Character.isLowerCase(str.charAt(i))) 
			{ 
				lastLower = i; 
				break; 
			} 
		}
		for (i = 0; i < n; i++) { 
			if (Character.isUpperCase(str.charAt(i))) { 
				firstUpper = i; 
				break; 
			} 
		} 
		if (lastLower == -1 || firstUpper == -1) 
			return 0; 
		int countLower = 0; 
		for (i = firstUpper; i < n; i++) { 
			if (Character.isLowerCase(str.charAt(i))) { 
				countLower++; 
			} 
		} 
		int countUpper = 0; 
		for (i = 0; i < lastLower; i++) { 
			if (Character.isUpperCase(str.charAt(i))) { 
				countUpper++; 
			} 
		}
		return Math.min(countLower, countUpper); 
	} 
	public static void main(String args[]) 
	{ 
		String str = "pRatyU@sh"; 
		int n = str.length(); 
		System.out.println(minOperations(str, n)); 
	} 
} 
