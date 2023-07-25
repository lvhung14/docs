package lecture08;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.Scanner;

public class AlmostShortagePath {
	static final int MAX = (int) 1e5 + 5;
	static final int INF = (int) 1e9 + 5;
	static int dist[] = new int[MAX];
	static int N, M, S, D;
	static int distT[] = new int[MAX];
	static int distS[] = new int[MAX];
	static ArrayList<Node> graph[] = new ArrayList[MAX];
	static ArrayList<Node> graphS[] = new ArrayList[MAX];
	static ArrayList<Node> graphT[] = new ArrayList[MAX];

	static class Node implements Comparable<Node> {
		int id, w;

		public Node(int id, int w) {
			this.id = id;
			this.w = w;
		}

		@Override
		public int compareTo(Node o) {
			// TODO Auto-generated method stub
			return this.w - o.w;
		}

	}

	private static void dijiktra(int s, int[] dist, ArrayList<Node>[] graph) {
		Arrays.fill(dist, INF);
		PriorityQueue<Node> pq = new PriorityQueue<>();
		pq.add(new Node(s, 0));
		dist[s] = 0;
		while (!pq.isEmpty()) {
			Node top = pq.poll();
			int u = top.id;
			int w = top.w;
			for (Node neighbor : graph[u]) {
				if (neighbor.w + w < dist[neighbor.id]) {
					dist[neighbor.id] = neighbor.w + w;
					pq.add(new Node(neighbor.id, dist[neighbor.id]));
				}
			}
		}
	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		while (true) {
			N = sc.nextInt();
			M = sc.nextInt();
			if(N == 0 && M == 0) return;
			S = sc.nextInt();
			D = sc.nextInt();
			for (int i = 0; i < N; i++) {
				graph[i] = new ArrayList<>();
				graphS[i] = new ArrayList<>();
				graphT[i] = new ArrayList<>();
			}
			for (int i = 0; i < M; i++) {
				int u = sc.nextInt();
				int v = sc.nextInt();
				int w = sc.nextInt();
				graphS[u].add(new Node(v, w));
				graphT[v].add(new Node(u, w));
			}
			dijiktra(S, distS, graphS);
			dijiktra(D, distT, graphT);
			for (int u = 0; u < N; u++) {
				for (Node neighbors : graphS[u]) {
					int v = neighbors.id;
					int w = neighbors.w;
					if (distS[u] + w + distT[v] != distS[D]) {
						graph[u].add(new Node(v, w));
					}
				}
			}
			dijiktra(S, dist, graph);
			System.out.println(dist[D] != INF ? dist[D] : -1);
		}
	}
}
