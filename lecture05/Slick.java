package lecture05;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Slick {
	static int N, M;
	static int MAX = 255;
	static int[][] slick = new int[MAX][MAX];
	static int[] dx= {1, -1, 0, 0};
	static int[] dy = {0, 0, -1, 1};
	static boolean visited[][] = new boolean[MAX][MAX];

	static class Point{
		int x, y;
		Point(int x, int y){
			this.x = x;
			this.y = y;
		}
	}
	public static boolean isValid(int x, int y) {
		return x >= 0 && x < N && y >= 0 && y < M;
	}
	public static int bfs(Point s) {
		int slickCount = 1;
		Queue<Point> q = new LinkedList<>();
		q.add(s);
		visited[s.x][s.y] = true;
		while(!q.isEmpty()) {
			Point u = q.poll();
			for(int i = 0; i < 4; i++) {
				int x = u.x + dx[i];
				int y = u.y + dy[i];
				if(isValid(x, y) && slick[x][y] == 1 && !visited[x][y]) {
					slickCount++;
					visited[x][y] = true;
					q.add(new Point(x, y));
				}
			}
		}
		return slickCount;
	}
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		while (true) {
			int count = 0;
			int result[] = new int[100000 + 5];
			N = sc.nextInt();
			M = sc.nextInt();
			if (N == 0 && M == 0) {
				break;
			}
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < M; j++) {
					slick[i][j] = sc.nextInt();
					visited[i][j] = false;
				}
			}

			for (int i = 0; i < N; i++) {
				for (int j = 0; j < M; j++) {
					if(slick[i][j] == 1 && !visited[i][j]) {
						count++;
						result[bfs(new Point(i, j))]++;
					}
				}
			}
			System.out.println(count);
			for(int i = 0; i < MAX * MAX; i++) {
				if(result[i] > 0) {
					System.out.println(i + " " + result[i]);
				}
				result[i] = 0;
			}
		}
	}
}
