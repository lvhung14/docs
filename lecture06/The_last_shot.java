package lecture06;

import java.util.ArrayList;
import java.util.Scanner;
import java.util.Stack;

public class The_last_shot {
	static int N, M;
	static final int MAX = 10001;
	static ArrayList<Integer> graph[] = new ArrayList[MAX];

	private static int DFS(int src) {
		boolean visited[] = new boolean[N + 1];
		Stack<Integer> s = new Stack<>();
		int temp = 0;
		s.add(src);
		visited[src] = true;
		while (!s.isEmpty()) {
			int u = s.pop();
			temp++;
			for (int v : graph[u]) {
				if (!visited[v]) {
					s.add(v);
					visited[v] = true;
				}
			}
		}
		return temp;
	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		M = sc.nextInt();
		for (int i = 0; i < MAX; i++) {
			graph[i] = new ArrayList<>();
		}
		for (int i = 1; i <= M; i++) {
			int u = sc.nextInt();
			int v = sc.nextInt();
			graph[u].add(v);
		}
		int max_bombs = 0;
		for (int i = 1; i <= N; i++) {
			max_bombs = Math.max(max_bombs, DFS(i)) ;
		}
		System.out.println(max_bombs);
	}
}
