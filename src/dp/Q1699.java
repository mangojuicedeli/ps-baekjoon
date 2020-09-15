package dp;

import java.util.Scanner;
/*
 * 제곱수의 합 문제
 * 주어진 숫자를 자연수 제곱수의 합으로 나타낼 때, 합으로 나타내는데 쓰이는 항의 최소 개수 구하기
 */
public class Q1699 {

	public static void main(String[] args) {
		// 입력
		Scanner sc = new Scanner(System.in);
		int num = sc.nextInt();
		sc.close();
		
		/*
		 * 풀이
		 * d[n]: n을 제곱수의 합으로 나타낼 때, 제일 적은 항의 개수
		 * 
		 * 점화식
		 * d[n] = d[n-i^2] + 1 ( i >= 1, n >= i^2 )
		 * 가장 작은 d[n] = min(d[n-i^2]) + 1 ( i >= 1, n >= i*i )
		 * 
		 * 시간 복잡도
		 * 1. n: num 만큼 순회한다. => num
		 * 2. i: 루트n 만큼 순회한다. => 루트 num
		 * 결론: n * 루트n
		 */
		int[] d = new int[num+1];
		d[0] = 1;
		// n: 1번째 인덱스, d 배열의 요소를 순회한다.
		for (int n = 1; n < d.length; n++) {
			/*
			 * d[n]의 값이 될 수 있는 최댓값은, 각 항이 1의 제곱으로 이루어진 경우이므로 n이다.
			 * 최솟값을 찾는 상황이므로, 최댓값인 경우를 기본값으로 설정한다.
			 * n은 d 배열의 요소에 해당하므로, 상향식이 된다.
			 */
			d[n] = n;
			// i: 2번째 인덱스, d[n-i*i]의 최솟값을 찾기 위하여, i를 가능한 범위 내에서 순회한다.
			for (int i = 1; i*i <= n; i++) {
				if (d[n] > d[n-i*i] + 1) {
					d[n] = d[n-i*i] + 1;
				}
			}
		}
		
		// 정답 출력
		System.out.println(d[num]);
//		int[] d = new int[n+1];
//		int tmp = 0;
//		d[0] = 1;
//		d[1] = 1;
//		for (int i = 1; i*i <= n; i++) {
//			// 첫 순회(i가 1인 경우)에는 값을 할당하고 넘어간다.
//			if (i == 1) {
//				tmp = d[n-i*i];
//				continue;
//			}
//			if (d[n-i*i] == 0) {
//				findMin(n-i*i);
//			}
//			// 제한 범위 내의 i를 순회하며 d[n-i*i]의 최솟값을 d[n-i*i]의 값으로 확정한다.
//			if (tmp > d[n-i*i]) {
//				tmp = d[n-i*i];
//			}
//		}
//		// 근데 d[n-i*i]에 값이 할당이 안되어있는데 어떻게 구하나?
		
		
	}
	
//	public int findMin(int num) {
//		return 0;
//	}

}
