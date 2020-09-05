package greedyalgos;

import java.util.Arrays;
import java.util.Scanner;

public class minPlatforms {

	static int findPlatform(int[] arr, int[] dep, int n) {
		Arrays.sort(arr);
		Arrays.parallelSort(dep);

		int platNeeded = 1;
		int result = 1;
		int i = 1, j = 0;

		while (i < n && j < n) {
			if (arr[i] <= dep[j]) {
				platNeeded++;
				i++;
			} else if (arr[i] > dep[j]) {
				platNeeded--;
				j++;
			}
			if (platNeeded > result)
				result = platNeeded;
		}
		return result;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scn = new Scanner(System.in);
		int v = scn.nextInt();
		int n = scn.nextInt();

		int[] arr = new int[n];
		int[] dep = new int[n];

		for (int i = 0; i < n; i++)
			arr[i] = scn.nextInt();

		for (int i = 0; i < n; i++)
			dep[i] = scn.nextInt();

		findPlatform(arr, dep, n);
	}

}
