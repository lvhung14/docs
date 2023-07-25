package lecture06;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Scanner;
import java.util.Stack;


public class Lakes_in_Berland {
	static int N, M;
	static int MAX = 55;
	static boolean visited[][] = new boolean[MAX][MAX];
	static char[][] lakes = new char[MAX][MAX];
	static int[] dr = { -1, 1, 0, 0 };
	static int[] dc = { 0, 0, -1, 1 };

	static ArrayList<ArrayList<Cell>> lake = new ArrayList<ArrayList<Cell>>();
	static class Cell {
		int r;
		int c;

		public Cell(int r, int c) {
			this.r = r;
			this.c = c;
		}
	}

	public static boolean isValid(int r, int c) {
		return r < N && r >= 0 && c < M && c >= 0;
	}

	public static boolean onBorded(int r, int c) {
		return r == N - 1 || c == M - 1 || r == 0 || c == 0;
	}

	public static void dfs(Cell src) {
		Stack<Cell> s = new Stack<>();
		s.add(src);

		boolean isOcean = false;
		ArrayList<Cell> temp = new ArrayList<>();
		visited[src.r][src.c] = true;
		while (!s.isEmpty()) {
			Cell u = s.pop();
			temp.add(u);
			if (onBorded(u.r, u.c)) {
				isOcean = true;
			}
			for (int i = 0; i < 4; i++) {
				int r = u.r + dr[i];
				int c = u.c + dc[i];
				if (isValid(r, c) && lakes[r][c] == '.' && !visited[r][c]) {
					visited[r][c] = true;
					s.add(new Cell(r, c));
				}
			}
		}
		if (!isOcean) {
			lake.add(temp);
		}
	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		M = sc.nextInt();
		int k = sc.nextInt();
		sc.nextLine();
		for (int i = 0; i < N; i++) {
			lakes[i] = sc.nextLine().toCharArray();
		}

		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				if (!visited[i][j] && lakes[i][j] == '.') {
					dfs(new Cell(i, j));
				}
			}
		}
		Collections.sort(lake, new Comparator<ArrayList<Cell>>() {

			@Override
			public int compare(ArrayList<Cell> o1, ArrayList<Cell> o2) {
				return o1.size() - o2.size();
			}

		});
		int sum_cell = 0;
		for (int i = 0; i < lake.size() - k; i++) {
			sum_cell += lake.get(i).size();
			for (Cell u : lake.get(i)) {
				lakes[u.r][u.c] = '*';
			}
		}
		System.out.println(sum_cell);
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				System.out.print(lakes[i][j]);
			}
			System.out.println();
		}
	}
}
