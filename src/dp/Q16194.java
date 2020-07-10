package dp;

import java.util.Scanner;

public class Q16194 {

	public static void main(String[] args) {
		// 입력
		Scanner sc = new Scanner(System.in);
		int num = sc.nextInt();
		int[] prices = new int[num+1];
		for (int i = 1; i < prices.length; i++) {
			prices[i] = sc.nextInt();
		}
		sc.close();
		
		int[] memo = new int[num+1];
		java.util.Arrays.fill(memo, -1); // 0으로 초기화 되어 있으면 23번째 줄에서 비교할 때 제대로 비교가 시작되지 않는다.
		memo[0] = 0;
		memo[1] = prices[1];
		for (int i = 2; i <= num; i++) {
			for (int j = 1; j <= i; j++) {
				if (memo[i] == -1 || memo[i] >= memo[i-j] + prices[j]) {
					memo[i] = memo[i-j] + prices[j];
				}
			}
		}
		System.out.println(memo[num]);
	}

}
