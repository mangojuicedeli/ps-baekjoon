package dp;

import java.util.Scanner;

public class Q1463 {
	
	private static int[] dp;
	
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		int num = sc.nextInt();
		dp = new int[num+1];
		java.util.Arrays.fill(dp, -1);
		dp[0] = dp[1] = 0;
		
		System.out.println(bottom_up(num));
		System.out.println(top_down(num));
	}
	
	private static int bottom_up(int num) {
		
		for (int i = 2; i <= num; i++) {
			dp[i] = dp[i-1]+1;
			if (i % 2 == 0) dp[i] = Math.min(dp[i], dp[i/2]+1);
			if (i % 3 == 0) dp[i] = Math.min(dp[i], dp[i/3]+1);
		}
		return dp[num];
	}
	
	private static int top_down(int num) {
		
		if (dp[num] != -1) return dp[num];

		int min = 0x7fffffff; // 10억 대신 오버플로우를 막기 위해 썼다
		if(num%3 == 0) min = Math.min(min, top_down(num/3));
		if(num%2 == 0) min = Math.min(min, top_down(num/2));
		min = Math.min(min, top_down(num-1));

		return dp[num] = min+1;
	}
}
