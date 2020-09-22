package exhaustive_search;

import java.util.Scanner;

public class Q14719 {

	public static void main(String[] args) {
		
		// input
		Scanner sc = new Scanner(System.in);
		int h = sc.nextInt();
		int w = sc.nextInt();
		int[] block_height = new int[w];
		for (int i = 0; i < w; i++) {
			block_height[i] = sc.nextInt();
		}
		sc.close();

		// solve
		int max = -1;
		int[] leftMax = new int[w];
		int[] rightMax = new int[w];
		for (int i = 0; i < w; i++) {
			max = Math.max(max, block_height[i]);
			leftMax[i] = max;
		}
		max = -1;
		for (int i = w - 1; i >= 0; i--) {
			max = Math.max(max, block_height[i]);
			rightMax[i] = max;
		}
		int answer = 0;
		for (int i = 0; i < w; i++) {
			int water = Math.min(leftMax[i], rightMax[i]) - block_height[i];
			if (water > 0) {
				answer += water;
			}
		}
		System.out.println(answer);
	}
}