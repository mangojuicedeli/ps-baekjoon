package dp;

import java.util.Scanner;

public class Q11052 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int num = sc.nextInt();
		int[] prices = new int[num+1];
		for (int i = 1; i < prices.length; i++) {
			prices[i] = sc.nextInt();
		}
		sc.close();
		
		int[] memo = new int[num+1];
		memo[1] = prices[1]; // 1일 때 최댓값은 기저값으로 적어준다.
		for (int i = 2; i < memo.length; i++) { // 2부터 시작
			for (int j = 1; j <= i; j++) { // 핵심이 되는 로직. 이 부분을 점화식으로 세울 수 있어야 한다.
				if (memo[i] <= memo[i-j] + prices[j]) {
					memo[i] = memo[i-j] + prices[j];
				}
			}
		}
		System.out.println(memo[num]);
	}
}
