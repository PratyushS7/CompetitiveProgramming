class binsertion 
{ 
    public static void main(String[] args) 
    { 
    	double st=System.nanoTime();
    	int a[]=new int[100000];
    	int i;
    	for(i=0;i<a.length;i++)
    		a[i]=1000000000-i;
        int n = a.length;
        for(i=1;i<n;i++)
        {
        	int pos=bins(0,i,a[i],a);
        	int v=a[i];
        	for(int j=i;j>pos;j--)
        		a[j]=a[j-1];
        	a[pos]=v;
        }
        System.out.println((System.nanoTime()-st)/1000000000); 
        //for(i=0;i<n;i++)
        	//System.out.print(a[i]+" ");
    } 
    static int bins(int lo,int hi,int v,int a[])
    {
    	while(lo<hi)
    	{
    		int m=lo + (hi-lo)/2;
    		if(a[m]>v)
    			hi=m;
    		else
    			lo=m+1;
    	}
    	return lo;
    }
} 