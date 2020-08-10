import java.util.Scanner;

public class Pattern {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scn = new Scanner(System.in);
		int n = scn.nextInt();

//		pattern-1

		System.out.println("........................");
		for (int row = 1; row <= n; row++) {
			System.out.print("*");

//			preparation
			System.out.print("\n");
		}

		System.out.println("........................");

//		pattern-2
		for (int row = 1; row <= n; row++) {
			for (int j = 1; j <= row; j++)
				System.out.print("*");

			System.out.print("\n");
		}
		System.out.println("........................");
// pattern-3		
		for (int row = 1; row <= n; row++) {

			for (int j = n; j >= row; j--)
				System.out.print("*");

			System.out.print("\n");
		}
		System.out.println("........................");
//		pattern-4
		int nsp;
		int nst;
		for (int row = 1; row <= n; row++) {
			for (nsp = 1; nsp <= n - row; nsp++)
				System.out.print(" ");

			for (nst = nsp; nst <= n; nst++)
				System.out.print("*");

			System.out.print("\n");
		}
		System.out.println("........................");
//		pattern-5
		nsp = 0;
		nst = n;

		int row = 1;
		while (row <= n) {
//			spaces work
			int csp = 1;
			while (csp <= nsp) {
				System.out.print(" ");
				csp++;
			}
//			stars work
			int cst = 1;
			while (cst <= nst) {
				System.out.print("*");
				cst++;
			}

//			preparation
			nst = nst - 1;
			nsp = nsp + 1;
			row = row + 1;
			System.out.print("\n");
		}
		System.out.println("........................");

//		pattern-6/13
		row = 1;
		nst = 1;
		while (row <= (2 * n - 1)) {

//			stars work
			int cst = 1;
			while (cst <= nst) {
				System.out.print("*");
				cst++;
			}

//			preparation
			System.out.print("\n");
			if (row < n / 2)
				nst = nst + 1;
			else
				nst = nst - 1;

			row = row + 1;
		}
	}
	
	

}
