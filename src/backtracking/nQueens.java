package backtracking;

import java.util.Scanner;

public class nQueens {

	public static void main(String[] args) {
		Scanner scn=new Scanner(System.in);
		int n=scn.nextInt();
		boolean [][] board=new boolean[n][n];
		
		for(int i=0;i<n;i++)
			for(int j=0;j<n;j++)
				board[i][j]=scn.nextBoolean();
		
		printNqueens(board,0,"");
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

	

}
