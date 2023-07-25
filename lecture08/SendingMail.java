package lecture08;

import java.util.ArrayList;
import java.util.PriorityQueue;
import java.util.Scanner;

public class SendingMail {
	static int MAX = 20000 + 5;
	static int N, n, m, T, S;
	static final int INF = (int)1e9 + 7;
	static int dist[] = new int[MAX];
	static ArrayList<Node> graph[] = new ArrayList[MAX];

	static class Node implements Comparable<Node> {
		int id, w;

		public Node(int id, int w) {
			this.id = id;
			this.w = w;
		}

		@Override
		public int compareTo(Node o) {

			return this.w - o.w;
		}
	}

	private static void Dijiktra(int s, int t) {
		PriorityQueue<Node> pq = new PriorityQueue<>();
		pq.add(new Node(s, 0));
		dist[s] = 0;
		while (!pq.isEmpty()) {
			Node top = pq.poll();
			int id = top.id;
			int w = top.w;
			if (id == t)
				break;
			for (Node neigbors : graph[id]) {
				if (neigbors.w + w < dist[neigbors.id]) {
					dist[neigbors.id] = neigbors.w + w;
					pq.add(new Node(neigbors.id, dist[neigbors.id]));
				}
			}
		}
	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		int running = 0;
		while (N-- > 0) {
			n = sc.nextInt();
			m = sc.nextInt();
			T = sc.nextInt();
			S = sc.nextInt();
			for(int i = 0; i < n; i++) {
				dist[i] = INF;
				graph[i] = new ArrayList<>();
			}
			for (int i = 0; i < m; i++) {
				int u = sc.nextInt();
				int v = sc.nextInt();
				int w = sc.nextInt();
				graph[u].add(new Node(v, w));
				graph[v].add(new Node(u, w));
			}
			Dijiktra(S, T);
			System.out.print("Case #" + (++running) + ": ");
			System.out.println(dist[T] == INF ? "unreachable" : dist[T]);
		}
	}
}
