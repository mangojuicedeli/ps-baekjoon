package dp;

import java.util.Scanner;

public class Q15990 {

	static int[] memo = new int[100001];
	
	public static void main(String[] args) {
		// 입력
		Scanner sc = new Scanner(System.in);
		int num = sc.nextInt();
		int[] arr = new int[num];
		memo[0] = 1;
		memo[1] = 1;
		for (int i = 0; i < num; i++) {
			arr[i] = sc.nextInt();
		}
		sc.close();
		// 풀이
		for (int i = 0; i < num; i++) {
			System.out.println(solution(arr[i]));
		}
	}
	
	public static int solution(int num) {
		if (num == 1 || num == 0) return 1;
		
		for (int i = 1; i <= num; i++) {
			for (int j = 1; j <= num-i; j++) {
				if (i == j) {
					continue;
				}
				memo[num] += memo[num - (i+j)];
			}
		}
		return memo[num];
	}
}
