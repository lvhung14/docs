package lecture05;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

import javax.security.auth.login.AccountExpiredException;

public class BFS {

	private static ArrayList<ArrayList<Integer>> graph;
	private static int V;
	private static int E;
	private static ArrayList<Integer> path;
	private static ArrayList<Boolean> visited;
	private static int[] dist = new int[10000+5];

	private static void BFS(int s) {
		Queue<Integer> q = new LinkedList<>();
		visited = new ArrayList<>();
		q.add(s);
		for(int i = 0; i <= V; i++) {
			visited.add(false);
			dist[i] = 0;
		}
		visited.set(s, true);
		while(!q.isEmpty()) {
			int u = q.poll();
			for(int v : graph.get(u)) {
				if(!visited.get(v)) {
					visited.set(v, true);
					dist[v] = dist[u] + 1;
					q.add(v);
				}
			}
		}
	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int Q = sc.nextInt();
		while (Q-- > 0) {
			V = sc.nextInt();
			E = sc.nextInt();
			graph = new ArrayList<>(V);
			for (int i = 0; i <= V; i++) {
				graph.add(new ArrayList<>());
			}
			for (int i = 0; i < E; i++) {
				int u = sc.nextInt();
				int v = sc.nextInt();
				graph.get(u).add(v);
				graph.get(v).add(u);
			}
			int s = sc.nextInt();
			BFS(s);
			for (int i = 1; i <= V; i++) {
				if (i == s) {
					continue;
				}
				System.out.print((visited.get(i) ? dist[i] * 6 : -1) + " ");
			}
			System.out.println();
		}
	}
}
