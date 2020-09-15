package dp;

import java.util.Scanner;
/*
 * 1, 2, 3의 합으로 나타내기 문제
 * 주어진 숫자를 1, 2, 3의 합으로 나타낼 수 있는 방법의 수를 찾는 문제.
 */
public class Q9095 {

	public static void main(String[] args) {
		// 입력
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		sc.close();
		
		/*
		 * 풀이
		 * d[i] = i를 1, 2, 3의 합으로 나타내는 방법의 수
		 * 합의 맨 끝은 1, 2, 3 중 하나만 올 수 있다.
		 * 점화식: d[i] = d[i-1] + d[i-2] + d[i-3]
		 */
		int[] d = new int[n+1];
		d[0] = 1; // 1, 2, 3으로 나타낼 수 없으므로 0이라고 착각하지 말 것. 집합의 개념으로 공집합도 방법으로 치는 것에 유의.
		d[1] = 1;
		d[2] = 2; // 1+1, 2. 총 2가지
		for (int i = 3; i < d.length; i++) {
			d[i] = d[i-1] + d[i-2] + d[i-3];
		}
		
		// 정답 출력
		System.out.println(d[n]);
	}
}
