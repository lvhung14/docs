package lecture05;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Guilty_Prince {
	static final int MAX = 25;
	static boolean[][] visited = new boolean[MAX][MAX];
	static int[] dr = { 1, -1, 0, 0 };
	static int[] dc = { 0, 0, -1, 1 };
	static String[] land = new String[MAX];
	static int W, H;

	static class cell {
		int c, r;

		public cell(int r, int c) {
			this.c = c;
			this.r = r;
		}
	};

	public static boolean isValid(int r, int c) {
		return c >= 0 && c < W && r < H && r >= 0;
	}

	public static int bfs(cell s) {
		Queue<cell> q = new LinkedList<>();
		visited[s.r][s.c] = true;
		q.add(s);
		int count = 1;
		while (!q.isEmpty()) {
			cell u = q.poll();
			for (int i = 0; i < 4; i++) {
				int r = u.r + dr[i];
				int c = u.c + dc[i];
				/*
				 * ....#. .....# ...... ...... ...... ...... ...... #@...# .#..#.
				 */
				if (isValid(r, c) && land[r].charAt(c) == '.' && !visited[r][c]) {
					visited[r][c] = true;
					count++;
					q.add(new cell(r, c));
				}
			}
		}
		return count;
	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		int temp = T;
		cell s = new cell(0, 0);
		while (T-- > 0) {
			W = sc.nextInt();
			H = sc.nextInt();
			sc.nextLine();
			for (int i = 0; i < H; i++) {
				land[i] = sc.nextLine();
			}
			for (int i = 0; i < H; i++) {
				for (int j = 0; j < W; j++) {
					if (land[i].charAt(j) == '@') {
						s = new cell(i, j);
					}
					visited[i][j] = false;
				}
			}
			System.out.println("Case " + (temp - T) + ": " + bfs(s));
		}
	}
}
