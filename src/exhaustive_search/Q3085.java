package exhaustive_search;

import java.util.Scanner;

public class Q3085 {

	public static void main(String[] args) {
		// 입력
		Scanner sc = new Scanner(System.in);
		int num = sc.nextInt();
		char[][] arr = new char[num][num];
		for (int i = 0; i < num; i++) {
			char[] tmp = sc.next().toCharArray();
			for (int j = 0; j < num; j++) {
				arr[i][j] = tmp[j];
			}
		}
		// 1. n*n 배열을 한 칸씩 이동하면서 옆 칸과 색이 같은지 다른지 비교
		// 1-A. 같다면, 다음 칸으로 넘어가서 1을 수행
		// 1-B. 다르다면, 옆 칸과 현재 칸을 바꾼다
			// ############## 오른쪽 옆 칸뿐만 아니라, 아래쪽 칸과도 바꿔야 한다 ##############
		// 1-B-a. 각 행과 각 열(예시의 경우, 5+5=> 총 10개)에서 같은 색이 몇 개 연속되는지 비교하고 제일 큰 수를 answer에 넣는다.
		int max = 0;
		for (int i = 0; i < num; i++) {
			for (int j = 0; j < num-1; j++ ) {
				if (arr[i][j] != arr[i][j+1]) {
					char tmp = arr[i][j];
					arr[i][j] = arr[i][j+1];
					arr[i][j+1] = tmp;
					// 연속된 최대 행 or 열 개수를 구한다.
					int tmpMax = count(arr);
					if (tmpMax > max) {
						max = tmpMax;
					}
					// 다시 배열을 원래대로 바꿔줌
					tmp = arr[i][j];
					arr[i][j] = arr[i][j+1];
					arr[i][j+1] = tmp;
				}
			}
		}
		System.out.println(max);
	}

	private static int count(char[][] arr) {
		int max = 0;
		// 가로행
		for (int i = 0; i < arr.length; i++) {
			int tmp = 1;
			for (int j = 0; j < arr[i].length; j++) {
				if (arr[i][j] != arr[i][j+1]) { // 인접한 두 칸이 색이 다르다면, 다음 행으로 넘어간다.
					break;
				}
				tmp++;
			}
			if (max < tmp) { // 한 행의 연산이 끝나고 이전 최댓값보다 방금 행의 연속되는 칸 개수가 크다면, 바꿔준다.
				max = tmp;
			}
		}
		// 세로행
		for (int i = 0; i < arr.length; i++) {
			int tmp = 1;
			for (int j = 0; j < arr[i].length; j++) {
				if (arr[j][i] != arr[j+1][i]) { // 인접한 두 칸이 색이 다르다면, 다음 행으로 넘어간다.
					break;
				}
				tmp++;
			}
			if (tmp > max) { // 한 행의 연산이 끝나고 이전 최댓값보다 방금 행의 연속되는 칸 개수가 크다면, 바꿔준다.
				max = tmp;
			}
		}
		return max;
	}
}
