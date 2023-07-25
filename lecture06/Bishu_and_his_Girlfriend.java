package lecture06;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;
import java.util.Stack;

public class Bishu_and_his_Girlfriend {
	static int MAX = 1000 + 5;
	static ArrayList<Integer> graph[] = new ArrayList[MAX];
	static int V, E;
	static boolean[] visited = new boolean[MAX];
	static int dist[] = new int[MAX];
	public static void DFS(int src) {
		Stack<Integer> s = new Stack<>();
		visited[src] = true;
		s.add(src);
		while(!s.isEmpty()) {
			int u = s.pop();
			for(int v : graph[u]) {
				if(!visited[v]) {
					visited[v] = true;
					dist[v] = dist[u] + 1;
					s.add(v);
				}
			}
		}
	}
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		V = sc.nextInt();
		E = V - 1;
		for (int i = 0; i < MAX; i++) {
			graph[i] = new ArrayList<>();
		}
		for (int i = 0; i < E; i++) {
			int u = sc.nextInt();
			int v = sc.nextInt();
			graph[u].add(v);
			graph[v].add(u);
		}
		DFS(1);
		int min_dist = Integer.MAX_VALUE;
		int id = 0;
		int Q = sc.nextInt();
		for(int i = 0; i < Q; i++) {
			int u = sc.nextInt();
			if(dist[u] < min_dist || dist[u] == min_dist && u < id) {
				min_dist = dist[u];
				id = u;
			}
		}
		System.out.println(id);
	}
}
