package lecture06;

import java.util.ArrayList;
import java.util.Scanner;
import java.util.Stack;

public class Benefactor {
	static int V, E, leaf;
	static final int MAX = 50000 + 2;
	static long[] dist = new long[MAX];
	static long max_dist;

	static class Place {
		int v, w;

		Place(int v, int w) {
			this.v = v;
			this.w = w;
		}
	}

	static ArrayList<Place> graph[] = new ArrayList[MAX];

	public static void DFS(int src) {
		for (int i = 0; i <= V; i++) {
			dist[i] = -1;
		}
		Stack<Integer> s = new Stack<>();
		s.add(src);
		dist[src] = 0;
		while (!s.isEmpty()) {
			int u = s.pop();
			for (Place neighbor : graph[u]) {
				int v = neighbor.v;
				int w = neighbor.w;
				if (dist[v] == -1) {
					dist[v] = dist[u] + w;
					s.add(v);
					if (dist[v] > max_dist) {
						max_dist = dist[v];
						leaf = v;
					}
				}
			}
		}
	}

	public static void main(String[] args) throws Exception {
		Scanner sc = new Scanner(System.in);
		int t = sc.nextInt();
		while (t-- > 0) {
			V = sc.nextInt();
			E = V - 1;
			for (int i = 0; i <= V; i++) {
				graph[i] = new ArrayList<>();
			}
			for (int i = 0; i < E; i++) {
				int u = sc.nextInt();
				int v = sc.nextInt();
				int w = sc.nextInt();
				graph[u].add(new Place(v, w));
				graph[v].add(new Place(u, w));
			}
			max_dist = 0;
			DFS(1);
			DFS(leaf);
			System.out.println(max_dist);
		}
	}
}
