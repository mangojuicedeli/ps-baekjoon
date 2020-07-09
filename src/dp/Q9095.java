package dp;

import java.util.Scanner;

public class Q9095 {

	public static void main(String[] args) {
		// 입력
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int[] arr = new int[n];
		for (int i = 0; i < arr.length; i++) {
			arr[i] = sc.nextInt();
		}
		sc.close();
		
		// 풀이
		int[] memo = new int[11];
		memo[0] = 1;
		memo[1] = 1;
		memo[2] = 2;
			// memo 채우기
		for (int i = 3; i < memo.length; i++) {
			memo[i] = memo[i-1] + memo[i-2] + memo[i-3];
		}
		
		// 출력
		for (int i = 0; i < arr.length; i++) {
			System.out.println(memo[arr[i]]);
		}
	}
}
