package exhaustive_search;

import java.util.Scanner;

public class Q2231 {

	// 생성자는 입력값 N보다 작고, 입력값 N은 100만 이하이기 때문에, for문을 한 번만 쓰는 완전탐색으로 가능하다.
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int answer = solution(sc.nextInt());
		
		System.out.println(answer);
	}
	
	private static int solution(int num) {
		int answer = 0;
		
		for (int i = 1; i < num; i++) {
			int tmp = 0;
			tmp += i;
			// 각 자릿수를 구해서 더해준다.
			tmp += (i / 1) % 10;
			tmp += (i / 10) % 10;
			tmp += (i / 100) % 10;
			tmp += (i / 1000) % 10;
			tmp += (i / 10000) % 10;
			tmp += (i / 100000) % 10;
			
			if (tmp == num) { // 해당 숫자 및 자릿수의 합이 num일 경우 해당 숫자가 생성자가 된다.
				answer = i;
				break;
			}
		}
		return answer;
	}
}
