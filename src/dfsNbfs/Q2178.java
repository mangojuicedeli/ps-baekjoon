package dfsNbfs;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

class Pairs {
	
    int x;
    int y;
    
    Pairs(int x, int y) {
        this.x = x;
        this.y = y;
    }
}

public class Q2178 {
	
    public static final int[] dx = {0, 0, 1, -1};
    public static final int[] dy = {1, -1, 0, 0};
    
	public static void main(String[] args) {
		// 입력
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        int[][] a = new int[n][m];
        sc.nextLine();
        for (int i=0; i<n; i++) {
            String s = sc.nextLine();
            for (int j=0; j<m; j++) {
                a[i][j] = s.charAt(j) - '0';
            }
        }
        
        int[][] dist = new int[n][m];
        boolean[][] visited = new boolean[n][m];
        Queue<Pairs> q = new LinkedList<Pairs>();
        q.add(new Pairs(0, 0));
        visited[0][0] = true;
        dist[0][0] = 1;
        
        while (!q.isEmpty()) {
        	Pairs p = q.remove();
        	for (int i = 0; i < 4; i++) {
        		int nx = p.x + dx[i];
        		int ny = p.y + dy[i];
        		if ( 0 <= nx && nx < n && 0 <= ny && ny < m) {
        			if (visited[nx][ny] == false && a[nx][ny] == 1) {
        				visited[nx][ny] = true;
        				dist[nx][ny] = dist[p.x][p.y] + 1;
        			}
        		}
        	}
        }
        System.out.println(dist[n-1][m-1]);
	}
}
