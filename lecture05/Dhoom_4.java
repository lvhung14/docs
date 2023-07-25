package lecture05;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Dhoom_4 {
	static final int MAX = 100005;
	static final int MOD = 100000;
	static int key[] = new int[MAX];
	static int n;
	static int dist[] = new int[MAX];

	private static int bfs(int s, int f) {
		Arrays.fill(dist, -1);
		Queue<Integer> q = new LinkedList<>();
		q.add(s);
		dist[s] = 0;
		while (!q.isEmpty()) {
			int u = q.poll();
			for (int i = 0; i < n; i++) {
				Long temp = (1L * u * key[i]) % MOD;
				int v = temp.intValue();
				if (dist[v] == -1) {
					dist[v] = dist[u] + 1;
					q.add(v);
					if (v == f) {
						return dist[v];
					}
				}
			}
		}
		return -1;
	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int keyValue = sc.nextInt();
		int lockValue = sc.nextInt();
		n = sc.nextInt();
		for (int i = 0; i < n; i++) {
			key[i] = sc.nextInt();
		}

		System.out.println(bfs(keyValue, lockValue));
	}
}
