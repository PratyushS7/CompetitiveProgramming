import java.util.Arrays;
import java.util.Scanner;
 class expogo
{
	public static void main (String[] args)
	 {
		Scanner sc=new Scanner(System.in);
		int i;
		int t=sc.nextInt();
		int p=t;
		while(t>0)
		{
			t--;
			int j,k;
			long x=sc.nextInt();
			long y=sc.nextInt();
	
			int b[]=new int[32];
			int x1[]=new int[31];
			int y1[]=new int[31];
			int countx=0,county=0;
			int max=0;
			char xy[]=new char[32];
			char yx[]=new char[32];
			for(i=0;i<32;i++)
			{
				if(((Math.abs(x)>>i)&1)==1)
				{
					x1[i]=1;
					countx++;
					if(x<0)
						xy[i]='W';
					else
						xy[i]='E';
				}
			}
			for(i=0;i<32;i++)
			{
				if(((Math.abs(y)>>i)&1)==1)
					y1[i]=1;
			}
			long ty=0,tx=0;
			int flag=0;
			
				for(j=0;j<31;j++)
				{
					if(ty>=Math.abs(y))
						break;
					
					else
					{
						if(y1[j]==1)
						{
							if(x1[j]==1)
							{
								flag=1;
								break;
							}
							ty+=Math.pow(2, j);
							county++;
							if(y>0)
								xy[j]='N';
							else 
								xy[j]='S';
						}
					}
				}
				if(ty==Math.abs(y))
				{
					
				}
				else
				{
					flag=0;
					county=0;
					int a=0;
					for(k=30;k>=0;k--)
					{
						if(y1[k]==1)
						{
							break;
						}
					}
					Arrays.fill(y1, 0);
					ty=(long) Math.pow(2,k+1);
					y1[k+1]=1;
					if(y>0)
						xy[k+1]='N';
					else
						xy[k+1]='S';
					county++;
					ty-=Math.abs(y);
					for(j=0;j<=30;j++)
					{
						if(((ty>>j)&1)==1)
						{
							y1[j]=1;
							county++;
						}
					}
					for(j=0;j<=k;j++)
					{
						if(y1[j]==1)
						{
							if(x1[j]==1)
							{
								flag=1;
								break;
							}
							if(y>0)
								xy[j]='S';
							else
								xy[j]='N';
						}	
					}
				}
			if(flag==1)
				max=0;
			else
				max=countx+county;
			countx=county=0;
			Arrays.fill(x1, 0);
			Arrays.fill(y1, 0);
			flag=0;
			for(i=0;i<32;i++)
			{
				if(((Math.abs(y)>>i)&1)==1)
				{
					y1[i]=1;
					county++;
					if(y<0)
						yx[i]='S';
					else
						yx[i]='N';
				}
			}
			for(i=0;i<32;i++)
			{
				if(((Math.abs(x)>>i)&1)==1)
					x1[i]=1;
			}
			
				for(j=0;j<31;j++)
				{
					if(tx>=Math.abs(x))
						break;
				
					else
					{
						if(x1[j]==1)
						{
							if(y1[j]==1)
							{
								flag=1;
								break;
							}
							tx+=Math.pow(2, j);
							countx++;
							if(x>0)
								yx[j]='E';
							else 
								yx[j]='W';
						}
					}
				}
				if(tx==Math.abs(x))
				{
					
				}
				else
				{
					flag=0;
					countx=0;
					int a=0;
					for(k=30;k>=0;k--)
					{
						if(x1[k]==1)
						{
							break;
						}
					}
					Arrays.fill(x1, 0);
					tx=(long) Math.pow(2,k+1);
					x1[k+1]=1;
					if(x>0)
						yx[k+1]='E';
					else
						yx[k+1]='W';
					countx++;
					tx-=Math.abs(x);
					for(j=0;j<=30;j++)
					{
						if(((tx>>j)&1)==1)
						{
							x1[j]=1;
							countx++;
						}
					}
					for(j=0;j<=k;j++)
					{
						if(x1[j]==1)
						{
							if(y1[j]==1)
							{
								flag=1;
								break;
							}
							if(x>0)
								yx[j]='W';
							else
								yx[j]='E';
						}	
					}
				}
			
			int temp;
			if(flag==1)
				temp=0;
			else
			 temp = county+countx;
			if(temp==0&&max==0)
				System.out.print("Case #"+(p-t)+": IMPOSSIBLE");
			else if(max>temp)
			{
				System.out.print("Case #"+(p-t)+": ");
				for(i=0;i<xy.length;i++)
				{
					System.out.print(xy[i]);
				}
				
			}
			else
			{
				System.out.print("Case #"+(p-t)+": ");
				for(i=0;i<yx.length;i++)
				{
					System.out.print(yx[i]);
				}
			}
			System.out.println();
		
			
			//System.out.println("Case #"+(p-t)+": "+ans);
		}
		
	 }
} 