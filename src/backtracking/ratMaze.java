package backtracking;

import java.util.Scanner;

public class ratMaze {

	static boolean isSafe(int[][] maze, int x, int y, int n) {

//		if x is between 0 and n and y axis is between 0 and n and rat's path is 
//		1 then return true
		return (x >= 0 && x < n && y >= 0 && y < n && maze[x][y] == 1);
	}

	static boolean solveMaze(int[][] maze, int n) {

//		make a solution matrix and insert 0s in it
		int[][] sol = new int[n][n];

//		if rat stays on 0 0 then there is no solution
		if (solveMazeUtil(maze, 0, 0, sol, n) == false) {
			System.out.print("No solution");
			return false;
		}

		printSolution(sol, n);
		return true;
	}

	static boolean solveMazeUtil(int [][] maze, int x, int y, int[][] sol, int n) {
//if rat has reached destination then return true
		if (x == n - 1 && y == n - 1) {
			sol[x][y] = 1;
			return true;
		}
//		if maze is valid
		if (isSafe(maze, x, y, n) == true) {
			sol[x][y] = 1;

//			move forward in x 
			if (solveMazeUtil(maze, x + 1, y, sol, n))
				return true;
//			move forward in y 
			if (solveMazeUtil(maze, x, y + 1, sol, n))
				return true;
//			none work then mark as not part of solution
			sol[x][y] = 0;
			return false;

		}
		return false;
	}

	static void printSolution(int[][] sol, int n) {
		for (int i = 0; i < n; i++)
			for (int j = 0; j < n; j++)
				System.out.print(" " + sol[i][j] + " ");
		System.out.println();
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scn = new Scanner(System.in);
		int m=scn.nextInt();
		int n = scn.nextInt();
		int [][] maze = new int[m][n];

		for (int i = 0; i < m; i++)
			for (int j = 0; j < n; j++)
				maze[i][j]=scn.next().charAt(0);

		solveMaze(maze, n);
	}

}
