package dfsNbfs;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

class Pair {
    int x;
    int y;
    Pair(int x, int y) {
        this.x = x;
        this.y = y;
    }
}

public class Q2667 {
	
	public static final int[] dx = { -1, 0, 1, 0 };
	public static final int[] dy = { 0, 1, 0, -1 };

	public static void main(String[] args) {
		// 입력 설정
		Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        sc.nextLine(); // 개행 문자 없애기
        int[][] a = new int[n][n];
        for (int i=0; i<n; i++) {
            String s = sc.nextLine();
            for (int j=0; j<n; j++) {
                a[i][j] = s.charAt(j) - '0';
            }
        }
        sc.close();
        
        int cnt = 1; // 단지 번호
        int[][] complex = new int[n][n]; // 단지 번호 넣는 배열 : 0 -> 방문 안 함, 1~n -> 단지 번호
        for (int i = 0; i < n; i++) {
        	for (int j = 0; j < n; j++) {
        		if (a[i][j] == 1 && complex[i][j] == 0) {
        			bfs(a, complex, i, j, n, cnt++);
        		}
        	}
        }
        
        int[] ans = new int[cnt];
        for (int i = 0; i < a.length; i++) {
        	for (int j = 0; j < a[i].length; j++) {
        		if (complex[i][j] != 0) {
        			ans[complex[i][j]]++;
        		}
        	}
        }
        
        Arrays.sort(ans);
        System.out.println(cnt);
        for (int i=0; i<cnt; i++) {
            System.out.println(ans[i]);
        }
	}

	private static void bfs(int[][] a, int[][] complex, int i, int j, int n, int cnt) {
		Queue<Pair> q = new LinkedList<Pair>();
		q.add(new Pair(i, j));
		complex[i][j] = cnt;
		while (!q.isEmpty()) {
			Pair p = q.remove();
			for (int k = 0; k < 4; k++) {
				int nx = p.x + dx[k];
				int ny = p.y + dy[k];
				if (0 <= nx && nx < n && 0 <= ny && ny < n) {
					if (a[nx][ny] == 1 && complex[nx][ny] != 0) {
						q.add(new Pair(nx, ny));
						complex[nx][ny] = cnt;
					}
				}
			}
		}
	}

}
