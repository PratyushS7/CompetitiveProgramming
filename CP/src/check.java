import java.util.*;
class check 
{
	//Create a class with the specific details required
	static class VendorDetails
	{
		String Name,Item;
		long ItemCode;
		double price;
		int qty;
		VendorDetails(String Name, String Item, long ItemCode, double price, int qty)
		{
			this.Name=Name; this.Item=Item; this.ItemCode=ItemCode;
			this.price=price; this.qty=qty;
		}
	}
	
	public static void main(String [] args)
	{
		//Creating a HashMap for constant retrievals and storage as well.
		HashMap<Integer,VendorDetails> store=new HashMap<Integer,VendorDetails>();
		
		//Creating an example detail 
		VendorDetails test=new VendorDetails("John","Mouse",12,124.5,5);
		int vendor_code=16;
		store.put(vendor_code, test);
		
		//To retrieve the item list in constant complexity 
		VendorDetails v_get=store.get(16);
	}
	//The Map will store the line number(or the row number) corresponding to where the details are present in the 2-d matrix  
	HashMap<Integer,Integer> store=new HashMap<Integer,Integer>();
	
	//assuming the details variable contains all the data in the required format. (String for demo purposes) 
	String details[][];
	
	//This function would populate the HashMap with the proper mapping details.
	void create()
	{
		for(int row=0;row<details.length;row++)
		{
			//Get the unique vendor_id which is the first column entry
			int key=Integer.parseInt(details[row][0]);
			store.put(key, row);
		}
	}
	//function would accept the 2D matrix and the vendor_id as the parameters
	String retrieve(int key)
	{
		//Retrieve the corresponding row in Constant time
		int row = store.get(key);
		
		//append the details on the String to be returned
		String result="";
		for(int i=0;i<details[0].length;i++)
		{
			result += details[row][i]+" ";
		}
		return result;
	}
	
	
	//function for the user to enter the ID of the vendor whose details are required 
	void display_details()
	{
		Scanner sc=new Scanner(System.in);
		
		//expecting the user or the client to enter the vendor_id whose details are to be fetched.
		int vendor_id = sc.nextInt();
		String result = retrieve(vendor_id);
		
		//Printing the entire String here which contains the data in the proper structured format
		System.out.println(result);
	}
	public static void a() 
	{
		Scanner sc=new Scanner(System.in); int xor=0;
		int i; long a=0,b=0; int n=sc.nextInt();
		int ar[]=new int[n];
		for(i=0;i<n;i++) ar[i]=sc.nextInt();
		for(i=1;i<n;i++)
		{
			b= Math.max(ar[i-1], ar[i]);
			a=a+b;
		}
		System.out.println(a);
	}
}