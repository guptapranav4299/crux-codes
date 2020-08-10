import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Scanner;

public class maths {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
//		Scanner scn = new Scanner(System.in);
//		long n = scn.nextLong();

//		Scanner scn = new Scanner(System.in);
//		int a=scn.nextInt();
//		int b=scn.nextInt();
//		int n = scn.nextInt();
//		int[] arr = new int[n];
//		for (int i = 0; i < n; i++)
//			arr[i] = scn.nextInt();
//
//		System.out.println(findHCF(arr));
//		printTillNegative(n);
//		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//		long n = Long.parseLong(br.readLine());
//		System.out.println(reverse(n));
		prateekLovesCandy();
	}

	public static void power(int a, int b) {
		long result = 1;
		for (int i = 1; i <= b; i++) {
			result = result * a;
		}
		System.out.println(result);
	}

	public static void printTillNegative(int n) {
		Scanner scn = new Scanner(System.in);
		int sum = 0;
		while (sum >= 0) {
			sum += n;
			if (sum < 0)
				break;
			else
				System.out.print(n);
			n = scn.nextInt();
		}

	}

	public static long reverse(long n) {
		long sum = 0;
		while (n > 0) {
			long remainder = n % 10;
			sum = sum * 10 + remainder;
			n = n / 10;
		}
		return sum;
	}

	public static int findHCF(int[] arr) {
		int n = arr.length;
		int result = arr[0];
		for (int i = 0; i < n; i++)
			result = result + HCF(arr[i], result);

		return result;
	}

	private static int HCF(int a, int b) {
		// TODO Auto-generated method stub
		if (a == 0)
			return b;
		return HCF(b % a, a);
	}
	
	
    public static void prateekLovesCandy() {

        Scanner scn = new Scanner(System.in);

        int n = scn.nextInt();

        int[] cases = new int[n];
        int max = 0;

        for (int i = 0; i < cases.length; i++) {

            cases[i] = scn.nextInt();
            max = Math.max(max, cases[i]);
        }

        ArrayList<Integer> primes = getPrimes(max);

        for (int i = 0; i < cases.length; i++) {

            System.out.println(primes.get(cases[i] - 1));
        }
    }

    public static ArrayList<Integer> getPrimes(int n) {

        boolean[] board = new boolean[1_000_001];

        board[0] = true;
        board[1] = true;

        for (int table = 2; table * table <= 1_000_000; table++) {

            if (!board[table])
                for (int mult = 2; table * mult <= 1_000_000; mult++) {
                    board[table * mult] = true;
                }
        }

        ArrayList<Integer> ans = new ArrayList<>();

        int cnt = 0;
        for (int i = 2; cnt <= n; i++) {

            if (!board[i]){
                ans.add(i);
                cnt++;
            }
        }

        return ans;
    }


}
