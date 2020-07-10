package dp;

import java.util.Scanner;

public class Q10844 {

	static final long MOD = 1000000000;
	
	public static void main(String[] args) {
		int answer = 0;
		Scanner sc = new Scanner(System.in);
		int num = sc.nextInt();
		
		int[][] memo = new int[num+1][10];
		memo[1][0] = 0; // 한 자리 숫자 0은 경우의 수에 포함하지 않으므로 0으로 따로 초기화한다.
		for (int i = 1; i <= 9; i++) {
			memo[1][i] = 1;
		}
		
		for (int i = 2; i <= num; i++) {
			for (int j = 0; j <= 9; j++) {
				if (j == 0) { // 예외1) 끝자리가 0인 경우, 앞 숫자에 -1이 올 수 없다.
					memo[i][j] += memo[i-1][j+1];
					memo[i][j] %= MOD;
					continue;
				}
				if (j == 9) { // 예외2) 끝자리가 9인 경우, 앞 숫자에 10이 올 수 없다.
					memo[i][j] += memo[i-1][j-1];
					memo[i][j] %= MOD;
					continue;
				}
				if (i == 2 && j == 1) { // 예외3) 2자리 숫자면서 끝자리가 1인 경우, 앞 숫자에 0이 올 수 없다.
					memo[i][j] += memo[i-1][j+1];
					memo[i][j] %= MOD;
					continue;
				}
				memo[i][j] = memo[i-1][j-1] + memo[i-1][j+1];
				memo[i][j] %= MOD;
			}
		}
		// num 자리 숫자면서 각 끝자리가 1~9인 경우를 모두 더해준다.
		for (int i = 1; i <= 9; i++) {
			answer += memo[num][i];
		}
		System.out.println(answer %= MOD);
	}
}
