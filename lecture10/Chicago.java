package lecture10;

import java.util.*;

public class Chicago {
	static final int MAX = 101;
	static double dist[] = new double[MAX];
	static ArrayList<Edge> graph = new ArrayList<>();
	static int n, m, a, b, p;

	static class Edge {
		int u, v;
		double w;

		public Edge(int u, int v, double w) {
			this.u = u;
			this.v = v;
			this.w = w;
		}
	}

	public static void BellmanFord(int s, int f) {
		Arrays.fill(dist, -1);
		dist[s] = 1;
		for (int i = 0; i < n - 1; i++) {
			for (Edge edge : graph) {
				int u = edge.u;
				int v = edge.v;
				double w = edge.w;
				dist[u] = Math.max(dist[v] * w, dist[u]);
				dist[v] = Math.max(dist[u] * w, dist[v]);
			}
		}
	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		while (true) {
			n = sc.nextInt();
			if (n == 0)
				break;
			m = sc.nextInt();
			for (int i = 0; i < m; i++) {
				int u = sc.nextInt();
				int v = sc.nextInt();
				double w = sc.nextInt();
				graph.add(new Edge(u, v, w / 100.0));
				graph.add(new Edge(v, u, w / 100.0));
			}
			BellmanFord(1, n);
			System.out.printf("%.6f percent\n", dist[n] * 100.0);
		}
	}
}
