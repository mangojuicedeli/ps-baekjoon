package exhaustive_search;

import java.util.ArrayList;
import java.util.Scanner;

public class Q10448 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int testCaseNum = sc.nextInt();
		int[] AnswerArr = new int[testCaseNum];
		for (int i = 0; i < testCaseNum; i++) {
			AnswerArr[i] = solution(sc.nextInt());
		}
		sc.close();
		for (int answer : AnswerArr) {
			System.out.println(answer);
		}
	}

	private static int solution(int input) {
		ArrayList<Integer> triNumArr = new ArrayList<Integer>();
		int isPossible = 0;
		// 모든 삼각수 구하기
		for (int i = 1; i <= 1000; i++) {
			int triNum = (i*(i+1))/2;
			if (triNum <= 1000) {
				triNumArr.add(triNum);
				continue;
			}
			break;
		}
		// 모든 삼각수의 가능한 합을 구해서 해당 input과 일치하는 값이 있는지 확인
		// 1000보다 작은 삼각수는 총 44개이고, 전체 경우의 수는 44^3 = 85184 이기 때문에 완전 탐색으로 풀어도 된다.
		loop :
		for (int i = 0; i < triNumArr.size(); i++) {
			for (int j = 0; j < triNumArr.size(); j++) {
				for (int k = 0; k < triNumArr.size(); k++) {
					int triSum = triNumArr.get(i) + triNumArr.get(j) + triNumArr.get(k);
					if (triSum > 1000) break; // 삼각수의 합이 1000보다 크면, input과 같은 값인지 비교하지 않아도 된다.
					if (triSum == input) {
						isPossible = 1;
						break loop;
					}
				}
			}
		}
		return isPossible;
	}
}
