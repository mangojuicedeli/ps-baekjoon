package greedy;

import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;

public class Q1931 {
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int[][] arr = new int[n][2];
		for(int i = 0; i < n; i++) {
			arr[i][0] = sc.nextInt();
			arr[i][1] = sc.nextInt();
		}
		// 입력 종료
		
		Arrays.sort(arr, new Comparator<int[]>() {

			@Override
			public int compare(int[] start, int[] end) {
				
				if (start[1] == end[1]) {
					return Integer.compare(start[0], end[0]);
				}
				return Integer.compare(start[1], end[1]);
			}
		});
		// 정렬 완료

		int cnt = 0;
		int end = -1; // 회의 끝나는 시간을 dp용으로 저장
		for (int i = 0; i < n; i++) {
			if (arr[i][0] < end) continue; // 현재 종료 시간보다 시작 시간이 빠르다면 그 회의는 할 수 없다 (건너뜀)
			end = arr[i][1];
			cnt++;
		}
		System.out.println(cnt);
		
		// 풀이 완료
	}
}
