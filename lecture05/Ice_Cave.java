package lecture05;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Ice_Cave {
	static int M, N;
	static final int MAX = 500;
	static char[][] ice = new char[MAX][MAX];
	static int dr[] = { 0, 0, -1, 1 };
	static int dc[] = { -1, 1, 0, 0 };

	static class cell {
		int r;
		int c;

		cell(int r, int c) {
			this.r = r;
			this.c = c;
		}
	}

	public static boolean isValid(int r, int c) {
		return r < N && r >= 0 && c < M && c >= 0;
	}

	public static boolean bfs(cell s, cell f) {
		Queue<cell> q = new LinkedList<>();
		ice[s.r][s.c] = 'X';
		q.add(s);
		while (!q.isEmpty()) {
			cell u = q.poll();
			for (int i = 0; i < 4; i++) {
				int r = u.r + dr[i];
				int c = u.c + dc[i];
				if (f.r == r && f.c == c && ice[r][c] == 'X') {
					return true;
				}
				if (isValid(r, c) && ice[r][c] == '.') {
					ice[r][c] = 'X';
					q.add(new cell(r, c));
				}
			}
		}
		return false;
	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		M = sc.nextInt();
		sc.nextLine();
		for (int i = 0; i < N; i++) {
			ice[i] = sc.nextLine().toCharArray();
		}
		cell s = new cell(sc.nextInt() - 1, sc.nextInt() - 1);
		cell f = new cell(sc.nextInt() - 1, sc.nextInt() - 1);
		System.out.println(bfs(s, f) ? "YES" : "NO");
	}
}
