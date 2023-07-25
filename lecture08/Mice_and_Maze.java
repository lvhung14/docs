package lecture08;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Scanner;

public class Mice_and_Maze {
	static int MAX = 105;
	static int N, E, T, M;
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

	private static void Dijiktra(int s) {
		PriorityQueue<Node> pq = new PriorityQueue<>();
		pq.add(new Node(s, 0));
		dist[s] = 0;
		while (!pq.isEmpty()) {
			Node top = pq.poll();
			int u = top.id;
			int w = top.w;
			for (Node neighbor : graph[u]) {
				if (w + neighbor.w < dist[neighbor.id]) {
					dist[neighbor.id] = w + neighbor.w;
					pq.add(new Node(neighbor.id, dist[neighbor.id]));
				}
			}
		}
	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		E = sc.nextInt();
		T = sc.nextInt();
		M = sc.nextInt();
		for (int i = 0; i <= N; i++) {
			graph[i] = new ArrayList<Node>();
			dist[i] = (int)1e9 + 7;
		}
		for (int i = 0; i < M; i++) {
			int A = sc.nextInt();
			int B = sc.nextInt();
			int w = sc.nextInt();
			graph[B].add(new Node(A, w));
		}
		Dijiktra(E);
		int count = 0;
		for (int i = 1; i <= N; i++) {
			if (dist[i] <= T) {
				count++;
			}
		}
		System.out.println(count);
	}
}
