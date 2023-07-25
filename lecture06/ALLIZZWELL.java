package lecture06;

import java.util.Scanner;

public class ALLIZZWELL {
	static int max = 1005;
	static boolean visited[][] = new boolean[max][max];
	static char[][] graph = new char[max][max];
	static int R, C, count;
	static boolean found;
	static String term = "ALLIZZWELL";
	static int[] dr = { -1, -1, -1, 0, 0, 1, 1, 1 };
	static int[] dc = { -1, 0, 1, -1, 1, -1, 0, 1 };

	public static boolean isValid(int r, int c) {
		return r >= 0 && c >= 0 && r < R && c < C;
	}

	public static void DFS(int sr, int sc, int count) {
		if (count == term.length()) {
			found = true;
			return;
		}
		for (int i = 0; i < 8; i++) {
			int r = sr + dr[i];
			int c = sc + dc[i];

			if (isValid(r, c) && graph[r][c] == term.charAt(count) && !visited[r][c]) {
				visited[r][c] = true;
				DFS(r, c, count + 1);
				visited[r][c] = false;
			}
		}
	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int Q = sc.nextInt();
		while (Q-- > 0) {
			R = sc.nextInt();
			C = sc.nextInt();
			sc.nextLine();
			for (int i = 0; i < R; i++) {
				graph[i] = sc.nextLine().toCharArray();
				for (int j = 0; j < C; j++) {
					visited[i][j] = false;
				}
			}
			found = false;
			for (int i = 0; i < R; i++) {
				for (int j = 0; j < C; j++) {
					if (!found && graph[i][j] == term.charAt(0)) {
						DFS(i, j, 1);
					}
				}
			}
			System.out.println(found ? "YES" : "NO");

		}
	}
}
