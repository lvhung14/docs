package lecture10;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class SingleSource {

	static final int MAX = 5005;
	static final int INF = (int) 1e9;
	static int dist[] = new int[MAX];
	static int n, m, q, s, u, v, w;
	static ArrayList<Edge> graph = new ArrayList<>();

	static class Edge {
		int u, v, w;

		public Edge(int u, int v, int w) {
			this.u = u;
			this.v = v;
			this.w = w;
		}
	}

	private static void BellmanFord(int source) {
		Arrays.fill(dist, INF);
		dist[source] = 0;
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
		for (int i = 0; i < n - 1; i++) {
			for (int j = 0; j < m; j++) {
				int u = graph.get(j).u;
				int v = graph.get(j).v;
				int w = graph.get(j).w;
				if (dist[u] != INF && dist[u] + w < dist[v]) {
					dist[v] = -INF;
				}
			}
		}
	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		while (true) {
			graph.clear();
			n = sc.nextInt();
			m = sc.nextInt();
			q = sc.nextInt();
			s = sc.nextInt();
			if (n == 0 && m == 0 && q == 0 && s == 0) {
				break;
			}
			for (int i = 0; i < m; i++) {
				u = sc.nextInt();
				v = sc.nextInt();
				w = sc.nextInt();
				graph.add(new Edge(u, v, w));
			}
			BellmanFord(s);
			for (int i = 0; i < q; i++) {
				int a = sc.nextInt();
				if(dist[a] == INF) {
					System.out.println("Impossible");
				} else if(dist[a] == -INF) { 
					System.out.println("-Infinity");
				} else System.out.println(dist[a]);
			}
			System.out.println();
		}
	}
}
