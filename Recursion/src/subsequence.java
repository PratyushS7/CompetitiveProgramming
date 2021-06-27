class subsequence
{
	public static void main(String[] args)
	{
		String a=subsequences("abc");
		System.out.println(a);
	}
	public static String subsequences(String word) 
	{
		if (word.isEmpty()) 
		{
			return ""; // base case
		} 
		else 
		{
			char firstLetter = word.charAt(0);
			String restOfWord = word.substring(1);  
			String subsequencesOfRest = subsequences(restOfWord); 
			String result = "";
			for (String subsequence : subsequencesOfRest.split(",", -1))
			{
				result += "," + subsequence;
				System.out.println(result);
				result += "," + firstLetter + subsequence;
				System.out.println(result);
			}
			result = result.substring(1); // remove extra leading comma
			return result;
		}
	}
}