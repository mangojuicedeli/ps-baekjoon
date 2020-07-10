package dp;

import java.util.Scanner;

public class Q2193 {

	public static void main(String[] args) {
		int answer = 0;
		Scanner sc = new Scanner(System.in);
		int num = sc.nextInt();
		sc.close();
		
		int[][] dp = new int[num+1][2];
		dp[1][0] = 0;
		dp[1][1] = 1;
		for (int i = 2; i <= num; i++) {
			for (int j = 0; j <= 1; j++) {
				if (j == 1) { // 끝에 1이 오면, 그 앞 숫자에 1이 올 수 없다.
					if (i == 2) { // 2자리 숫자면 끝이 1일 때, 앞에 0도 올 수 없다.
						continue;
					}
					dp[i][j] = dp[i-1][0];
					continue;
				}
				if (i == 2) { // 끝에 0이 오고, 2자리 숫자라면 앞에 0이 올 수 없다.
					dp[i][j] = dp[i-1][1];
					continue;
				}
				dp[i][j] = dp[i-1][0] + dp[i-1][1];
			}
		}
		answer = dp[num][0] + dp[num][1];
		System.out.println(answer);
	}
}
