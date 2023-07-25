package lecture10;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class Extended_traffic {
	static int T, n, m, q;
	static int MAX = 205;
	static int[] weight = new int[MAX];
	static int[] dist = new int[MAX];
	static final int INF = (int) 1e9;
	static ArrayList<Edge> graph = new ArrayList<>();

	static class Edge {
		int u, v, w;

		public Edge(int u, int v, int w) {
			this.u = u;
			this.v = v;
			this.w = w;
		}
	}

	public static void BellmanFord(int s) {
		Arrays.fill(dist, INF);
		dist[s] = 0;
		for (int i = 0; i < n - 1; i++) {
			for (int j = 0; j < m; j++) {
				int u = graph.get(j).u;
				int v = graph.get(j).v;
				int w = graph.get(j).w;

				if (dist[u] != INF && dist[u] + w < dist[v]) {
					dist[v] = dist[u] + w;
				}
			}
		}
	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int running = 0;
		T = sc.nextInt();
		while (T-- > 0) {
			graph.clear();
			n = sc.nextInt();
			for (int i = 1; i <= n; i++) {
				weight[i] = sc.nextInt();
			}
			m = sc.nextInt();
			for (int i = 0; i < m; i++) {
				int u = sc.nextInt();
				int v = sc.nextInt();
				graph.add(new Edge(u, v, (int) Math.pow(weight[v] - weight[u], 3)));
			}
			BellmanFord(1);
			q = sc.nextInt();
			System.out.println("Case " + ++running + ":");
			for (int i = 0; i < q; i++) {
				int t = sc.nextInt();
				if(dist[t] < 3 || dist[t] == INF) {
					System.out.println("?");
				} else System.out.println(dist[t]);
			}
		}
	}
}
