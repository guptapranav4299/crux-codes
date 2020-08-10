import java.util.Arrays;
import java.util.Scanner;

public class string {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scn = new Scanner(System.in);
		String str = new String();
		str = scn.nextLine();
//		printRLE(str);
//		toggleString(str);
//		System.out.println(stringPallindrome(str));

//		stringPallindrome(str);
//		removeDuplicates(str.toCharArray());

		System.out.println(minimumNumberOfDeletions(str));
	}

	public static void printRLE(String str) {
		for (int i = 0; i < str.length() - 1; i++) {
			int count = 1;
//			check occurences of current char
			while (i < str.length() - 1 && str.charAt(i) == str.charAt(i + 1)) {
				count++;
				i++;
			}
			System.out.print(str.charAt(i));
			System.out.print(count);
		}
	}

	public static void toggleString(String str) {
		for (int i = 0; i < str.length(); i++) {
			char c = str.charAt(i);
			if (c >= 65) {
				if (c <= 90) {
					c = (char) (c + 32);
					System.out.print(c);
					continue;
				}
				if (c >= 97) {
					if (c <= 122) {
						c = (char) (c - 32);
						System.out.print(c);
					}
				}
			}
		}
	}

	public static boolean stringPallindrome(String s) {
		StringBuilder str = new StringBuilder();
		for (int i = 0; i < s.length(); i++) {
			char c = s.charAt(s.length() - 1 - i);
			str.append(c);
		}
		if (s.equals(str.toString()))
			return true;
		else
			return false;

	}

	public static void removeDuplicates(char[] str) {
		int n = str.length;
		if (n < 2)
			return;

		int j = 0;

		for (int i = 1; i < n; i++) {
			if (str[j] != str[i]) {
				j++;
				str[j] = str[i];
			}
		}
		System.out.print(Arrays.copyOfRange(str, 0, j + 1));
	}

	static int lps(String str) {
		int n = str.length();

		// Create a table to store
		// results of subproblems
		int L[][] = new int[n][n];

		// Strings of length 1
		// are palindrome of length 1
		for (int i = 0; i < n; i++)
			L[i][i] = 1;

		// Build the table. Note
		// that the lower diagonal
		// values of table are useless
		// and not filled in the process.
		// c1 is length of substring
		for (int cl = 2; cl <= n; cl++) {
			for (int i = 0; i < n - cl + 1; i++) {
				int j = i + cl - 1;
				if (str.charAt(i) == str.charAt(j) && cl == 2)
					L[i][j] = 2;
				else if (str.charAt(i) == str.charAt(j))
					L[i][j] = L[i + 1][j - 1] + 2;
				else
					L[i][j] = Integer.max(L[i][j - 1], L[i + 1][j]);
			}
		}

		// length of longest
		// palindromic subsequence
		return L[0][n - 1];
	}

	// function to calculate minimum
	// number of deletions
	static int minimumNumberOfDeletions(String str) {
		int n = str.length();

		// Find longest palindromic
		// subsequence
		int len = lps(str);

		// After removing characters
		// other than the lps, we get
		// palindrome.
		return (n - len);
	}
}
