package dp;

import java.util.Scanner;

public class Q11726 {
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int[] memo = new int[1001];
		memo[1] = 1;
		memo[2] = 2;
		for (int i = 3; i <= n; i++) {
			memo[i] = memo[i-1] + memo[i-2];
			memo[i] %= 10007; // 횟수를 나누어주는 작업을 for문 안에서 하는게 이해가 잘 안 된다... for문 안에서 하는게 밖에서 한 번 하는 것보다 나은건가?
		}
//		memo[n] %= 10007;
		System.out.println(memo[n]);
	}
}
