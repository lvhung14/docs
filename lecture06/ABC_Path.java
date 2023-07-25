package lecture06;

import java.util.*;

public class ABC_Path {
	static int max = 55;
	static int[] dr = { -1, -1, -1, 0, 0, 1, 1, 1 };
	static int[] dc = { -1, 0, 1, -1, 1, -1, 0, 1 };
	static boolean visited[][] = new boolean[max][max];
	static char[][] graph = new char[max][max];
	static int length = 0;
	static int H, W, ans, p = 0;

	public static boolean isValid(int r, int c) {
		return r >= 0 && c >= 0 && r < H && c < W;
	}

	public static void DFS(int sr, int sc, int count) {
		for (int i = 0; i < 8; i++) {
			int r = sr + dr[i];
			int c = sc + dc[i];
			if (isValid(r, c) && !visited[r][c] && graph[r][c] - graph[sr][sc] == 1) {
				{
					visited[r][c] = true;
					DFS(r, c, count + 1);
				}

			}
		}
		ans = count > ans ? count : ans;
	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		while (true) {
			ans = 0;
			H = sc.nextInt();
			W = sc.nextInt();
			// sc.nextLine();
			if (H == 0 && W == 0) {
				break;
			}
			sc.nextLine();
			for (int i = 0; i < H; i++) {
				graph[i] = sc.nextLine().toCharArray();
				for (int j = 0; j < W; j++) {
					visited[i][j] = false;
				}
			}
			for (int i = 0; i < H; i++) {
				for (int j = 0; j < W; j++) {
					if (graph[i][j] == 'A') {
						visited[i][j] = true;
						DFS(i, j, 1);
					}
				}
			}
			p++;
			System.out.println("Case " + p + ": " + ans);

		}
	}
}
