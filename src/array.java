import java.util.Scanner;

public class array {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scn = new Scanner(System.in);

		int n = scn.nextInt();
		int[] arr = new int[n];
		for (int i = 0; i < n; i++)
			arr[i] = scn.nextInt();

//		long n = scn.nextLong();
//
//		long[] arr = new long[(int) n];
//		for (long i = 0; i < n; i++) {
//			arr[(int) i] = scn.nextLong();
//		}
//
//		System.out.println(max(arr));
//		System.out.println(min(arr));
//		reverseArray(arr, 0, n - 1);
//		display(arr);
	}

	public static long max(long[] arr) {
		long max = Long.MIN_VALUE;
		for (int i = 0; i < arr.length; i++) {
			if (arr[i] > max)
				max = arr[i];
		}
		return max;
	}

	public static long min(long[] arr) {
		long min = Long.MAX_VALUE;
		for (int i = 0; i < arr.length; i++) {
			if (arr[i] < min)
				min = arr[i];
		}
		return min;
	}

	public static void reverseArray(int[] arr, int start, int end) {
		int temp;
		if (start >= end)
			return;
		temp = arr[start];
		arr[start] = arr[end];
		arr[end] = temp;

		reverseArray(arr, start + 1, end - 1);

	}

	public static void display(int[] arr) {
		for (int i = 0; i < arr.length; i++)
			System.out.print(arr[i] + " ");
	}

}
