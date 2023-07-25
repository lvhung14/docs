package lecture10;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class Wormholes {
	static final int MAX = 2000 + 5;
	static final int INF = (int) 1e9;
	static int c, m, n, x, y, t;
	static ArrayList<Edge> graph = new ArrayList<>();
	static int dist[] = new int[MAX];

	static class Edge {
		int u, v, w;

		public Edge(int u, int v, int w) {
			this.u = u;
			this.v = v;
			this.w = w;
		}
	}

	public static boolean BellmanFord(int s) {
		Arrays.fill(dist, INF);
		dist[s] = 0;
		for(int i = 0; i < n - 1; i ++) {
			for(int j = 0; j < m; j++) {
				int u = graph.get(j).u;
				int v = graph.get(j).v;
				int w = graph.get(j).w;
				
				if(dist[u] != INF && dist[u] + w < dist[v]) {
					dist[v] = dist[u] + w;
				}
			}
		}
		for(int i = 0; i < m; i++) {
			int u = graph.get(i).u;
			int v = graph.get(i).v;
			int w = graph.get(i).w;
			
			if(dist[u] != INF && dist[u] + w < dist[v]) {
				return false;
			}
		}
		return true;
	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		c = sc.nextInt();
		while (c-- > 0) {
			graph.clear();
			n = sc.nextInt();
			m = sc.nextInt();

			for (int i = 0; i < m; i++) {
				x = sc.nextInt();
				y = sc.nextInt();
				t = sc.nextInt();
				graph.add(new Edge(x, y, t));
			}
			System.out.println(!BellmanFord(0) ? "possible" : "not possible");
		}
		
	}
}
