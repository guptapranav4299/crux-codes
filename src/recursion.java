import java.util.ArrayList;
import java.util.Scanner;

public class recursion {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scn = new Scanner(System.in);
//		int n = scn.nextInt();

//		String str = scn.nextLine();
//		int x = scn.nextInt();
//		PDIskip(n);
//		System.out.println(pow(x, n));
//		int[] arr = new int[100];
//		for (int i = 0; i < n; i++)
//			arr[i] = scn.nextInt();
//		int arr[] = { 6, 8, 1, 1, 8, 3, 4 };
//		System.out.println(firstIndex(arr,0,8));
//		System.out.println(lastIndex(arr, 0, 8));
//		int[] res = AllIndices(arr, 0, 8, 0);
//		for (int i = 0; i < res.length; i++)
//			System.out.println(res[i]);
//		System.out.print(ntriangle(n));
//		int arr[] = { 1, 2, 3, 5 };
//		System.out.print(sortedarray(arr, arr.length));
//		System.out.println(fibonacci(n));
//		for (int i = 0; i < n; i++)
//			System.out.print(fib(n) + " ");

//		System.out.println(oddEven(n));

//		System.out.println(getSS(str));

//		System.out.println(getPermutation(str));

//		System.out.println(getBoardPath(0, 10).size());

//		System.out.println(getMazePath(0, 0, 2, 2));
//		System.out.println("...........................");
//		System.out.println(getMazePathDiag(0, 0, 2, 2));

//		printSS("abc", "");

//		printBoardPath(0, 10, "");
//		System.out.println(countBoardPath(0, 10));

//		printMazePath(0, 0, 2, 2, "");
//		System.out.println("...........................");
//		System.out.println(countMazePath(0, 0, 2, 2));

//		printMazePathDiag(0, 0, 2, 2, "");
//		System.out.println("...........................");
//		System.out.println(countMazePathDiag(0, 0, 2, 2));

//		boolean[][] board = new boolean[4][4];

//		System.out.println(countNqueens(board, 0));

//		printNqueens(board, 0, "");

//		printPermutation1("abc", "");

//		int n = scn.nextInt();
//		boolean[][] board = new boolean[n][n];
//		printNqueens(board, 0, "");
		
		
//		System.out.println(fastPower(2,3));
//		
		System.out.println(multiplywithoutstar(2,3));
//		
		
		
//		int [] arr= {1,2,3,4,5};
//		System.out.println(binarySearch(arr,0,4,3));
		
		
//		int n=scn.nextInt();
//		System.out.println(tilingProblem(3));
		
		printSpelling(2048);
		
		

	}

	public static void PDIskip(int n) {
		if (n == 0)
			return;

		if (n % 2 == 1)
			System.out.println(n);

		PDIskip(n - 1);

		if (n % 2 == 0)
			System.out.println(n);
	}

	public static int pow(int x, int n) {
		if (n == 0)
			return 1;

		int pnm1 = pow(x, n - 1);

		return x * pnm1;
	}

	public static int firstIndex(int[] arr, int si, int data) {

		if (si == arr.length)
			return -1;

		if (arr[si] == data)
			return si;
		else {
			int res = firstIndex(arr, si + 1, data);
			return res;
		}

	}

	public static int lastIndex(int[] arr, int si, int data) {
		if (si == arr.length)
			return -1;

		int index = lastIndex(arr, si + 1, data);
		if (index == -1) {
			if (arr[si] == data)
				return si;
			else
				return -1;
		} else
			return index;
	}

	public static int[] AllIndices(int[] arr, int si, int data, int count) {
		if (si == arr.length) {
			int base[] = new int[count];
			return base;
		}

		int indices[] = null;
		if (arr[si] == data) {
			indices = AllIndices(arr, si + 1, data, count + 1);
		} else {
			indices = AllIndices(arr, si + 1, data, count);
		}
		if (arr[si] == data)
			indices[count] = si;

		return indices;
	}

	public static int ntriangle(int n) {
		if (n <= 1)
			return n;

		return n + ntriangle(n - 1);

	}

	public static boolean sortedarray(int[] arr, int idx) {
		if (arr == null || arr.length <= 1 || idx == 1)
			return true;

		if (arr[idx - 1] < arr[idx - 2])
			return false;

		return sortedarray(arr, idx - 1);

	}

	public static int fib(int n) {
		if (n == 0)
			return 0;

		if (n == 1 || n == 2)
			return 1;

		else
			return (fib(n - 1) + fib(n - 2));
	}

	public static int oddEven(int n) {

		if (n <= 0)
			return 1;

		int number = oddEven(n - 1);
		if (number % 2 == 1) {
			return (number);
		}
		return number;

	}

	public static ArrayList<String> getSS(String str) {
		if (str.length() == 0) {
			ArrayList<String> baseResult = new ArrayList<>();
			baseResult.add("");
			return baseResult;
		}
		char cc = str.charAt(0);
		String ros = str.substring(1);
		ArrayList<String> myResult = new ArrayList<>();
		ArrayList<String> recResult = getSS(ros);
		for (int i = 0; i < recResult.size(); i++) {
			myResult.add(recResult.get(i));
			myResult.add(cc + recResult.get(i));
		}
		return myResult;
	}

	public static ArrayList<String> getPermutation(String str) {
		if (str.length() == 0) {
			ArrayList<String> baseResult = new ArrayList<>();
			baseResult.add("");
			return baseResult;
		}
		char cc = str.charAt(0);
		String ros = str.substring(1);
		ArrayList<String> recursionResult = getPermutation(ros);
		ArrayList<String> myResult = new ArrayList<>();
		for (String rrs : recursionResult) {
			for (int i = 0; i <= rrs.length(); i++) {
				String val = rrs.substring(0, i) + cc + rrs.substring(i);
				myResult.add(val);
			}
		}
		return myResult;
	}

	public static ArrayList<String> getBoardPath(int curr, int end) {
		if (curr == end) {
			ArrayList<String> baseResult = new ArrayList<>();
			baseResult.add("\n");
			return baseResult;
		}
		if (curr > end) {
			ArrayList<String> baseResult = new ArrayList<>();
			return baseResult;
		}
		ArrayList<String> myResult = new ArrayList<>();
		for (int dice = 1; dice <= 6; dice++) {
			ArrayList<String> rr = getBoardPath(curr + dice, end);
			for (String rrs : rr) {
				myResult.add(dice + rrs);
			}
		}
		return myResult;
	}

	public static ArrayList<String> getMazePath(int cr, int cc, int er, int ec) {
		if (cr == er && cc == ec) {
			ArrayList<String> baseResult = new ArrayList<>();
			baseResult.add("");
			return baseResult;
		}

		if (cc > ec || cr > er) {
			ArrayList<String> baseResult = new ArrayList<>();
			return baseResult;
		}
		ArrayList<String> myResult = new ArrayList<>();

//		horizontal traversal
		ArrayList<String> rrh = getMazePath(cr, cc + 1, er, ec);
		for (String rrhs : rrh)
			myResult.add("H" + rrhs);

//		vertical traversal

		ArrayList<String> rrv = getMazePath(cr + 1, cc, er, ec);
		for (String rrvs : rrv)
			myResult.add("V" + rrvs);

		return myResult;
	}

	public static ArrayList<String> getMazePathDiag(int cr, int cc, int er, int ec) {
		if (cr == er && cc == ec) {
			ArrayList<String> baseResult = new ArrayList<>();
			baseResult.add("");
			return baseResult;
		}

		if (cc > ec || cr > er) {
			ArrayList<String> baseResult = new ArrayList<>();
			return baseResult;
		}
		ArrayList<String> myResult = new ArrayList<>();

//		horizontal traversal
		ArrayList<String> rrh = getMazePathDiag(cr, cc + 1, er, ec);
		for (String rrhs : rrh)
			myResult.add("H" + rrhs);

//		vertical traversal

		ArrayList<String> rrv = getMazePathDiag(cr + 1, cc, er, ec);
		for (String rrvs : rrv)
			myResult.add("V" + rrvs);

//		diagnol traversal

		ArrayList<String> rrd = getMazePathDiag(cr + 1, cc + 1, er, ec);
		for (String rrds : rrd)
			myResult.add("D" + rrds);

		return myResult;
	}

	public static void printSS(String str, String result) {
		if (str.length() == 0) {
			System.out.print("" + result + " ");
			return;
		}

		char cc = str.charAt(0);
		String ros = str.substring(1);

		printSS(ros, result);

		printSS(ros, result + cc);
	}

//	to be done
	public static void printPermutation(String ques, String ans) {

	}

	public static void printBoardPath(int curr, int end, String ans) {
		if (curr == end) {
			System.out.println(ans);
			return;
		}
		if (curr > end)
			return;

		for (int dice = 1; dice <= 6; dice++)
			printBoardPath(curr + dice, end, ans + dice);
	}

	public static int countBoardPath(int curr, int end) {
		if (curr == end) {
			return 1;
		}
		if (curr > end)
			return 0;

		int count = 0;
		for (int dice = 1; dice <= 6; dice++)
			count += countBoardPath(curr + dice, end);

		return count;
	}

	public static void printMazePath(int cr, int cc, int er, int ec, String ans) {
		if (cr == er && cc == ec) {
			System.out.println(ans);
			return;
		}
		if (cr > er || cc > ec)
			return;

//		horizontal print
		printMazePath(cr, cc + 1, er, ec, "H" + ans);

//		vertical print
		printMazePath(cr + 1, cc, er, ec, "V" + ans);

	}

	public static int countMazePath(int cr, int cc, int er, int ec) {
		if (cr == er && cc == ec) {
			return 1;
		}
		if (cr > er || cc > ec)
			return 0;

//		horizontal print
		int ch = countMazePath(cr, cc + 1, er, ec);

//		vertical print
		int cv = countMazePath(cr + 1, cc, er, ec);

		return ch + cv;
	}

	public static void printMazePathDiag(int cr, int cc, int er, int ec, String ans) {
		if (cr == er && cc == ec) {
			System.out.println(ans);
			return;
		}
		if (cr > er || cc > ec)
			return;

//		horizontal print
		printMazePath(cr, cc + 1, er, ec, "H" + ans);

//		vertical print
		printMazePath(cr + 1, cc, er, ec, "V" + ans);

//		diagnol print
		printMazePath(cr + 1, cc + 1, er, ec, "D" + ans);

	}

	public static int countMazePathDiag(int cr, int cc, int er, int ec) {
		if (cr == er && cc == ec) {
			return 1;
		}
		if (cr > er || cc > ec)
			return 0;

//		horizontal print
		int ch = countMazePath(cr, cc + 1, er, ec);

//		vertical print
		int cv = countMazePath(cr + 1, cc, er, ec);

//		diagnol print
		int cd = countMazePath(cr + 1, cc + 1, er, ec);

		return ch + cv + cd;
	}

	public static int countNqueens(boolean[][] board, int row) {

		if (row == board.length)
			return 1;

		int count = 0;
		for (int col = 0; col < board[row].length; col++) {
			if (isSafe(board, row, col)) {
				board[row][col] = true;
				count = count + countNqueens(board, row + 1);
				board[row][col] = false;
			}
		}
		return count;
	}

	private static boolean isSafe(boolean[][] board, int row, int col) {
//		upper direction
		for (int i = row; i >= 0; i--)
			if (board[i][col])
				return false;

//		upper left
		for (int i = row, j = col; i >= 0 && j >= 0; i--, j--)
			if (board[i][j])
				return false;

//		upper right
		for (int i = row, j = col; i >= 0 && j < board.length; i--, j++)
			if (board[i][j])
				return false;

		return true;
	}

	public static void printNqueens(boolean[][] board, int row, String ans) {
		if (row == board.length) {
			System.out.println(ans);
			return;
		}

		for (int col = 0; col < board[row].length; col++) {
			if (isSafe(board, row, col)) {
				board[row][col] = true;
				printNqueens(board, row + 1, ans + "{" + (row + 1) + "-" + (col + 1) + "}");
				board[row][col] = false;
			}
		}
	}

	public static void printPermutation1(String ques, String ans) {
		if (ques.length() == 0) {
			System.out.println(ans);
			return;
		}
		for (int i = 0; i < ques.length(); i++) {
			char ch = ques.charAt(i);
			String roq = ques.substring(0, i) + ques.substring(i + 1);
			printPermutation1(roq, ans + ch);
		}
	}
	
	public static int fastPower(int x,int n)
	{
		if(n==0)
			return 1;
		
		if(n%2==0)
			return (int) Math.pow(fastPower(x,n/2), 2);
		else
			return x*(int) Math.pow(fastPower(x,n/2), 2);
		
	}
	
	public static int multiplywithoutstar(int a,int b) {
		if(b==0)
			return 0;
		return a+ multiplywithoutstar(a,b-1);
	}
	
	public static int binarySearch(int [] arr,int start,int end,int item)
	{
		if(start>end)
			return -1;
		
		int mid=(start+end)/2;
		
		if(arr[mid]<item)
		binarySearch(arr,mid+1,end,item);
		
		else if(arr[mid]>item)
		binarySearch(arr,start,mid+1,item);
		
		return (mid+1);
	}
	
	public static int tilingProblem(int n)
	{
		if(n==1)
			return n;
		if(n==2)
			return n;
		
		int count=0;
		
		int smallCount=tilingProblem(n-1)+tilingProblem(n-2);
		count+=smallCount;
		
		return count;
	}
	
	public static String[] str= {"one","two","three","four","five","six","seven","eight","nine"};
	public static void printSpelling(int n)
	{
		if(n==0)
			return ;
		
		printSpelling(n/10);
		int digit=n%10;
		System.out.println(str[digit-1]);
		return ;
	}

}
