package lecture10;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class XYZZY {
	static final int MAX = 105;
	static final int INF = (int) -1e9;
	static int dist[] = new int[MAX];
	static int n;
	static ArrayList<Edge> graph = new ArrayList<>();
	static int Energy[] = new int[MAX];
	static boolean visited[] = new boolean[MAX];
	static class Edge {
		int u, v;

		public Edge(int u, int v) {
			this.u = u;
			this.v = v;
		}
	}

	private static boolean BellmanFord(int s, int f) {
		Arrays.fill(dist, INF);
		dist[s] = 100;
		for (int i = 0; i < n - 1; i++) {
			for(Edge edge : graph) {
				int u = edge.u;
				int v = edge.v;
				if(dist[u] > 0 && dist[u] + Energy[v] > dist[v]) {
					dist[v] = dist[u] + Energy[v];
				}
			}
		}
		for(Edge edge : graph) {
			int u = edge.u;
			int v = edge.v;
			if(dist[u] > 0 && dist[u] + Energy[v] > dist[v] && bfs(v, f)) {
				return true;
			}
		}
		return dist[f] > 0;
	}
	private static boolean bfs(int s, int f) {
		Arrays.fill(visited, false);
		Queue<Integer> q = new LinkedList<>();
		q.add(s);
		visited[s] = true;
		while(!q.isEmpty()) {
			int u = q.poll();
			for(Edge edge : graph) {
				if(edge.u == u) {
					int v = edge.v;
					if(!visited[v]) {
						visited[v] = true;
						q.add(v);
					}
					if(v == f) return true;
				}
			}
		}
		return false;
	}
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int m = 0;
		while (true) {
			graph.clear();
			n = sc.nextInt();
			if (n == -1)
				break;
			for (int i = 1; i <= n; i++) {
				Energy[i] = sc.nextInt();
				m = sc.nextInt();
				for(int j = 0; j < m; j++) {
					int v = sc.nextInt();
					graph.add(new Edge(i, v));
				}
			}
			Boolean result = BellmanFord(1, n);
			System.out.println(result ? "winnable" : "hopeless");
		}
	}
}
