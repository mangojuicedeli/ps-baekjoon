package dp;

import java.util.Scanner;
/*
 * 연속합 문제
 * 주어진 수열 내에서 연속하는 요소의 합의 최댓값을 구하는 문제.
 */
public class Q1912 {

	public static void main(String[] args) {
		// 입력
		Scanner sc = new Scanner(System.in);
		int[] input = new int[sc.nextInt()];
		int length = input.length;
		for (int i = 0; i < length; i++) {
			input[i] = sc.nextInt();
		}
		sc.close();
		
		/*
		 * d[i]: i번째 수로 끝나는 가장 큰 연속합
		 * d[i]는 바로 앞 수까지의 연속 합에 a[i]를 더한 수랑 a[i] 혼자인 경우 둘 중에 더 큰 수이다.
		 * 점화식: d[i] = max(a[i], d[i-1] + a[i])
		 */
		int[] d = new int[length];
		int answer = 0;
		for (int i = 0; i < d.length; i++) {
			d[i] = input[i];
			// 첫 번째는 비교하는 작업없이 넘어간다.
			if (i == 0) {
				continue;
			}
			if (d[i] < d[i-1] + input[i]) {
				d[i] = d[i-1] + input[i];
			}
		}
		
		// 정답 (d 배열에서 가장 큰 요소) 구하기
		for (int i = 0; i < d.length; i++) {
			if (i == 0) {
				answer = d[i];
				continue;
			}
			if (answer < d[i]) {
				answer = d[i];
			}
		}
		
		// 정답 출력
		System.out.println(answer);
	}
}
