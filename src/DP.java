import java.util.Scanner;

public class DP {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
//		Scanner scn=new Scanner(System.in);
//		int n=scn.nextInt();
//		int [] strg=new int[n+1];
//		System.out.println(fibonacci(n,strg));
//		System.out.println(countBoardPath(n,0,strg));
		
		System.out.println(lcs("abbg","agbg"));
		System.out.println("..............................");
		System.out.println(lcsI("abbg","agbg"));
		
	}
	
	public static int fibonacci(int n,int [] strg)
	{
		if(n==0)
			return n;
		if(n==1)
			return n;
		
		if(strg[n]!=0)
			return strg[n];
		
		int fnm1=fibonacci(n-1,strg);
		int fnm2=fibonacci(n-2,strg);
		int fn=fnm1+fnm2;
		strg[n]=fn;
		
		return fn;
			
	}
	
//	o(n)
	public static int countBoardPath(int end,int curr,int [] strg)
	{
		if(end==curr)
			return 1;
		if(curr>end)
			return 0;
		
		if(strg[curr]!=0)
		{
			 return strg[curr];
		}
		
		int count=0;
		for(int dice=1;dice<=6;dice++)
		{
			count=count+countBoardPath(end,curr+dice,strg);
		}
		strg[curr]=count;
		return count;
	}
	
//	o(2^n)
	public static int lcs(String str1,String str2)
	{
		if(str1.length()==0 || str2.length()==0)
			return 0;
		
		int count=0;
		String ros1=str1.substring(1);
		String ros2=str2.substring(1);
		
		if(str1.charAt(0)==str2.charAt(0))
			count=1+lcs(ros1,ros2);
		else
		{
			int f1=lcs(ros1,str2);
			int f2=lcs(str1,ros2);
			count=Math.max(f1, f2);
		}
		return count;
	}
	
//	o(str1.length*str2.length)
	public static int lcsI(String str1,String str2)
	{
		int [][] strg=new int[str1.length()+1][str2.length()+1];
		strg[str1.length()][str2.length()]=0;
		
		for(int i=str1.length();i>=0;i--)
		{
			for(int j=str2.length();j>=0;j--)
			{
				if(i==str1.length() || j==str2.length())
				{
					strg[i][j]=0;
					continue;
				}
				if(str1.charAt(i)==str2.charAt(j))
					strg[i][j]=1+strg[i+1][j+1];
				else
					strg[i][j]=Math.max(strg[i+1][j], strg[i][j+1]);
			}
		}
		return strg[0][0];
	}

	
}
