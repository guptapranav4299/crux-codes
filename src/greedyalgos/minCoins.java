package greedyalgos;

import java.util.Scanner;
import java.util.Vector;

public class minCoins {
	
	static int [] deno= {1,2,5,10,20,50,100,200,500,2000};
	static int n=deno.length;
	
	static void findMin(int v) {
		Vector<Integer> ans=new Vector<>();
		
//		find a denomination just less than the current value,then add to vector
//		and reduce from the current value
		for(int i=n-1;i>=0;i--) {
			while(v>=deno[i]) {
				v=v-deno[i];
				ans.add(deno[i]);
			}
		}
				
		for(int i=0;i<ans.size();i++)
			System.out.print(ans.elementAt(i)+" ");
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scn=new Scanner(System.in);
		int v=scn.nextInt();
		findMin(v);
	}


}
