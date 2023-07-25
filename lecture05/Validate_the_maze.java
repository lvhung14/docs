package lecture05;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Validate_the_maze {
	static final int MAX = 21;
	static boolean visited[][] = new boolean[MAX][MAX];
	static int n, m;
	static int[] dr = { 1, -1, 0, 0 };
	static int[] dc = { 0, 0, 1, -1 };
	static String[] s = new String[MAX];

	static class cell {
		int r, c;

		public cell(int r, int c) {
			this.r = r;
			this.c = c;
		}
	}

	public static boolean validCell(int r, int c) {
		return r >= 0 && r < n && c >= 0 && c < m;
	}

	public static boolean bfs(cell x, cell f) {
		Queue<cell> q = new LinkedList<>();
		visited[x.r][x.c] = true;
		q.add(x);
		while (!q.isEmpty()) {
			cell u = q.poll();
			if (u.r == f.r && u.c == f.c) {
				return true;
			}
			for (int i = 0; i < 4; i++) {
				int r = u.r + dr[i];
				int c = u.c + dc[i];
				if (validCell(r, c) && s[r].charAt(c) == '.' && !visited[r][c]) {
					visited[r][c] = true;
					q.add(new cell(r, c));
				}
			}
		}
		return false;
	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int t = sc.nextInt();
		while (t-- > 0) {
				n = sc.nextInt();
				m = sc.nextInt();
			sc.nextLine();
			ArrayList<cell> list = new ArrayList<>();
			for (int i = 0; i < n; i++) {
				s[i] = sc.nextLine();
			}
			for (int i = 0; i < n; i++) {
				for (int j = 0; j < m; j++) {
					visited[i][j] = false;
					if (s[i].charAt(j) == '.' && (i == 0 || i == n - 1 || j == 0 || j == m - 1)) {
						list.add(new cell(i, j));
					}
				}
			}
			if (list.size() != 2) {
				System.out.println("invalid");
				continue;
			}
			System.out.println(bfs(list.get(0), list.get(1)) ? "valid" : "invalid");
		}
		sc.close();
	}
}
