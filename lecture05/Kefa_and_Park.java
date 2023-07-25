package lecture05;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Kefa_and_Park {
	static int MAX = 100000 + 5;
	static int cat[] = new int[MAX];
	static int a[] = new int[MAX];
	static int n = 0, m = 0;
	static boolean visited[] = new boolean[MAX];
    static ArrayList<Integer> graph[] = new ArrayList[MAX];

	public static int bfs(int s) {
		int count = 0;
		Queue<Integer> q = new LinkedList<>();
		q.add(s);
		cat[s] = a[s];
		visited[s] = true;
		while(!q.isEmpty()) {
			int u = q.poll();
			for(int v : graph[u]) {
				if(!visited[v]) {
					visited[v] = true;
					if(a[v] == 1) {
						cat[v] = cat[u] + 1;
					}
					if(cat[v] <= m) {
						if(graph[v].size() == 1) {
							count++;
						} else q.add(v);
					}
				}
			}
		}
		return count;
	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		n = sc.nextInt();
		m = sc.nextInt();
		for (int i = 1; i <= n; i++) {
			a[i] = sc.nextInt();
			graph[i] = new ArrayList<>();
		}
		for (int i = 1; i < n; i++) {
			int u = sc.nextInt();
			int v = sc.nextInt();
			graph[u].add(v);
			graph[v].add(u);
		}
		System.out.println(bfs(1));
	}
}
