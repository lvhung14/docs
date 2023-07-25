package lecture08;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Scanner;

public class TravelingCost {
	static int N;
	static final int MAX = 505;
	static int dist[] = new int[MAX];

	static class Node {
		int id, W;

		public Node(int id, int W) {
			this.id = id;
			this.W = W;
		}
	}

	static final int INF = (int) 1e9 + 7;
	static ArrayList<Node>[] graph = new ArrayList[MAX];

	private static void Dijsktra(int s) {
		PriorityQueue<Node> pq = new PriorityQueue<>(new Comparator<Node>() {

			@Override
			public int compare(Node o1, Node o2) {
				// TODO Auto-generated method stub
				return o2.W - o1.W;
			}
		});
		pq.add(new Node(s, 0));
		dist[s] = 0;
		while (!pq.isEmpty()) {
			Node top = pq.poll();
			int u = top.id;
			int w = top.W;
			for (Node neigbor : graph[u]) {
				if (w + neigbor.W < dist[neigbor.id]) {
					dist[neigbor.id] = w + neigbor.W;
					pq.add(new Node(neigbor.id, dist[neigbor.id]));
				}
			}
		}

	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		for (int i = 0; i < MAX; i++) {
			dist[i] = INF;
			graph[i] = new ArrayList<Node>();
		}
		for (int i = 0; i < N; i++) {
			int A = sc.nextInt();
			int B = sc.nextInt();
			int W = sc.nextInt();
			graph[A].add(new Node(B, W));
			graph[B].add(new Node(A, W));
		}
		int S = sc.nextInt();
		Dijsktra(S);
		int Q = sc.nextInt();
		for(int i = 0; i < Q; i++) {
			int x = sc.nextInt();
			System.out.println(dist[x] != INF ? dist[x] : "NO PATH");
		}
	}
}
