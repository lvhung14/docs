package lecture08;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.Scanner;
import java.util.StringTokenizer;

public class Shortest_path {
	static int MAX = 10000;
	static int[] dist = new int[MAX];
	static ArrayList<Node> graph[] = new ArrayList[MAX];
	static ArrayList<String> City = new ArrayList<>();
	static int s, n;

	static class Node implements Comparable<Node> {
		int id;
		int w;

		public Node(int id, int w) {
			this.id = id;
			this.w = w;
		}

		@Override
		public int compareTo(Node o) {

			return this.w - o.w;
		}
	}

	private static void Dijiktra(int s, int f) {
		Arrays.fill(dist, 200000 + 5);
		PriorityQueue<Node> pq = new PriorityQueue<>();
		pq.add(new Node(s, 0));
		dist[s] = 0;
		while (!pq.isEmpty()) {
			Node top = pq.poll();
			int u = top.id;
			if(u == f) break;
			int w = top.w;
			for(Node neighbor : graph[u]) {
				if(w + neighbor.w < dist[neighbor.id]) {
					dist[neighbor.id] = w + neighbor.w;
					pq.add(new Node(neighbor.id, dist[neighbor.id]));
				}
			}
		}
	}

	public static void main(String[] args) {
		MyScanner sc = new MyScanner();
		s = sc.nextInt();
		while (s-- > 0) {
			n = sc.nextInt();
			for (int i = 0; i <= n; i++) {
				graph[i] = new ArrayList<>();
			}
			City.clear();
			for (int i = 1; i <= n; i++) {
				String name = sc.nextLine();
				int p = sc.nextInt();
				City.add(name);
				for (int j = 0; j < p; j++) {
					int u = sc.nextInt();
					int w = sc.nextInt();
					graph[i].add(new Node(u, w));
				}
			}
			int r = sc.nextInt();
			for (int k = 0; k < r; k++) {
				String source = sc.next();
				String destination = sc.next();
				int u = City.indexOf(source) + 1;
				int v = City.indexOf(destination) + 1;
				Dijiktra(u, v);
				System.out.println(dist[v]);
			}
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
