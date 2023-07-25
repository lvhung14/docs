package lecture05;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Sheep {
	static final int MAX = 250;
	static int M, N;
	static int nWolf, nSheep;
	static char[][] sheep = new char[MAX][MAX];
	static int[] dr = { -1, 1, 0, 0 };
	static int[] dc = { 0, 0, -1, 1 };

	static class Cell {
		int r, c;

		Cell(int r, int c) {
			this.r = r;
			this.c = c;
		}
	}

	private static boolean isValid(int r, int c) {
		return r >= 0 && r < N && c >= 0 && c < M;
	}

	public static void bfs(Cell s) {
		Queue<Cell> q = new LinkedList<>();
		boolean canEscape = false;
		q.add(s);
		sheep[s.r][s.c] = '#';
		int countSheep = (sheep[s.r][s.c] == 'k' ? 1 : 0);
		int countWolf = (sheep[s.r][s.c] == 'v' ? 1 : 0);
		while (!q.isEmpty()) {
			Cell u = q.poll();
			for (int i = 0; i < 4; i++) {
				int r = u.r + dr[i];
				int c = u.c + dc[i];
				if (!isValid(r, c)) {
					canEscape = true;
					continue;
				}
				if (sheep[r][c] != '#') {
					countSheep += (sheep[r][c] == 'k' ? 1 : 0);
					countWolf += (sheep[r][c] == 'v' ? 1 : 0);
					sheep[r][c] = '#';
					q.add(new Cell(r, c));
				}
			}
		}
		if (canEscape) {
			nWolf += countWolf;
			nSheep += countSheep;
		} else {
			if (countSheep > countWolf) {
				nSheep += countSheep;
			} else
				nWolf += countWolf;
		}
	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		M = sc.nextInt();
		sc.nextLine();
		for (int i = 0; i < N; i++) {
			sheep[i] = sc.nextLine().toCharArray();
		}
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				if (sheep[i][j] != '#') {
					bfs(new Cell(i, j));
				}
			}
		}
		System.out.println(nSheep + " " + nWolf);
	}
}
