package dp;

import java.util.Scanner;

public class Q2225 {

	public static void main(String[] args) {
		// 입력
		Scanner sc = new Scanner(System.in);
		int num = sc.nextInt();
		int k = sc.nextInt();
		sc.close();
		
		/*
		 * 풀이
		 * d[n][k]: 0 ~ n 까지의 정수 k개를 더해서 n이 되는 경우의 수
		 * d[n][k] = sum(d[n-i][k-1]) ( n >= i >= 0 (1 아님) )
		 * 
		 * 시간 복잡도
		 * K*N*N(i)
		 */
		int[][] d = new int[num+1][k+1];
		
		for (int n = 2; n < d.length; n++) {
			for (int i = 1; i <= n; i++) {
				
			}
		}
		
		// 출력
		System.out.println(d[num]);
	}

}