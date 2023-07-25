package lecture08;

import java.io.*;
import java.util.*;

public class TrafficNetwork {
	static int n, m, k, s, t, u, v, w, Q;
	static final int INF = (int) 1e9 + 7;
	static int MAX = 100000 + 5;
	static int distT[] = new int[MAX];
	static int distS[] = new int[MAX];
	static ArrayList<Node> graphT[] = new ArrayList[MAX];
	static ArrayList<Node> graphS[] = new ArrayList[MAX];

	static class Node implements Comparable<Node> {
		int id, w;

		public Node(int v, int w) {
			this.id = v;
			this.w = w;
		}

		@Override
		public int compareTo(Node o) {

			return this.w - o.w;
		}
	}

	private static void Dijiktra(ArrayList<Node> graph[], int dist[], int s) {
		PriorityQueue<Node> pq = new PriorityQueue<>();
		pq.add(new Node(s, 0));
		dist[s] = 0;
		while (!pq.isEmpty()) {
			Node top = pq.poll();
			int u = top.id;
			int w = top.w;
			for (Node neigbor : graph[u]) {
				if (neigbor.w + w < dist[neigbor.id]) {
					dist[neigbor.id] = neigbor.w + w;
					pq.add(new Node(neigbor.id, dist[neigbor.id]));
				}
			}
		}
	}

	public static void main(String[] args) {
		MyScanner sc = new MyScanner();
		Q = sc.nextInt();
		while (Q-- > 0) {
			n = sc.nextInt();
			m = sc.nextInt();
			k = sc.nextInt();
			s = sc.nextInt();
			t = sc.nextInt();
			for (int i = 1; i <= n; i++) {
				graphT[i] = new ArrayList<Node>();
				graphS[i] = new ArrayList<Node>();
				distS[i] = INF;
                distT[i] = INF;
			}
			for (int i = 0; i < m; i++) {
				u = sc.nextInt();
				v = sc.nextInt();
				w = sc.nextInt();
				graphS[u].add(new Node(v, w));
				graphT[v].add(new Node(u, w));
			}
			Dijiktra(graphS, distS, s);
			Dijiktra(graphT, distT, t);
			int res = distS[t];
			for (int i = 0; i < k; i++) {
				u = sc.nextInt();
				v = sc.nextInt();
				w = sc.nextInt();
				int a = distS[u] + w + distT[v];
				int b = distS[v] + w + distT[u];
				res = Math.min(res, Math.min(a, b));
			}
			System.out.println(res == INF ? "-1" : res);
		}
	}

	public static class MyScanner {
		BufferedReader br;
		StringTokenizer st = null;

		public MyScanner() {
			br = new BufferedReader(new InputStreamReader(System.in));
		}

		public MyScanner(InputStream stream) {
			br = new BufferedReader(new InputStreamReader(stream));
		}

		boolean hasNext() {
			while (st == null || !st.hasMoreElements()) {
				try {
					String tmp = br.readLine();
					if (tmp == null)
						return false;
					st = new StringTokenizer(tmp);
				} catch (IOException e) {
					return false;
				}
			}
			return true;
		}

		String next() {
			if (hasNext())
				return st.nextToken();
			return null;
		}

		int MyScanner() {
			return Integer.parseInt(next());
		}

		int nextInt() {
			return Integer.parseInt(next());
		}

		long nextLong() {
			return Long.parseLong(next());
		}

		double nextDouble() {
			return Double.parseDouble(next());
		}

		String nextLine() {
			String str = "";
			try {
				str = br.readLine();
			} catch (IOException e) {
				e.printStackTrace();
			}
			return str;
		}
	}
}
