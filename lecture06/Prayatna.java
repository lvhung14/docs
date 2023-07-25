package lecture06;

import java.util.ArrayList;
import java.util.Scanner;
import java.util.Stack;

public class Prayatna {
	static int MAX = 100000 + 5;
	static int E, V;
	static ArrayList<Integer> graph[] = new ArrayList[MAX];
	static boolean[] visited = new boolean[MAX];

	public static void DFS(int src) {
		Stack<Integer> s = new Stack<>();
		s.add(src);
		visited[src] = true;
		while (!s.isEmpty()) {
			int u = s.pop();
			for (int v : graph[u]) {
				if (!visited[v]) {
					visited[v] = true;
					s.add(v);
				}
			}
		}
	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int Q = sc.nextInt();
		while (Q-- > 0) {
			int V = sc.nextInt();
			int E = sc.nextInt();
			for (int i = 0; i < V; i++) {
				visited[i] = false;
				graph[i] = new ArrayList<>();
			}
			for (int i = 0; i < E; i++) {
				int u = sc.nextInt();
				int v = sc.nextInt();
				graph[u].add(v);
				graph[v].add(u);
			}
			int count = 0;
			for (int i = 0; i < V; i++) {
				if (!visited[i]) {
					count++;
					DFS(i);
				}
			}
			System.out.println(count);
		}
	}
}
