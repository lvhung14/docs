package lecture10;

import java.util.*;

public class MonkBusinessDay {
	static int T, N, M, u, v, C;
	static int MAX = 1005;
	static int dist[] = new int[MAX];
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

	private static boolean BellmanFord(int s) {
		Arrays.fill(dist, INF);
		dist[s] = 0;
		for(int i = 0; i < N; i++) {
			for(int j = 0; j < M; j++) {
				int u = graph.get(j).u;
				int v = graph.get(j).v;
				int w = graph.get(j).w;
				if(dist[u] != INF && dist[u] + w < dist[v]) {
					dist[v] = dist[u] + w;
				}
			}
		}
		for(int i = 0; i < M; i++) {
			int u = graph.get(i).u;
			int v = graph.get(i).v;
			int w = graph.get(i).w;
			if(dist[u] != INF && dist[u] + w < dist[v]) {
				return true;
			}
		}
		return false;
	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		T = sc.nextInt();
		while (T-- > 0) {
			graph.clear();
			N = sc.nextInt();
			M = sc.nextInt();
			for (int i = 0; i < M; i++) {
				u = sc.nextInt();
				v = sc.nextInt();
				C = sc.nextInt();
				graph.add(new Edge(u, v, -C));
			}
			System.out.println(BellmanFord(1) ? "Yes" : "No");
		}
	}
}
