package lecture10;

import java.util.ArrayList;
import java.util.Scanner;

public class AliceInAmsterdam {
	static int MAX = 105;
	static int N, Q, U, V;
	static int dist[] = new int[MAX];
	ArrayList<Edge> graph = new ArrayList<>();
	
	static class Edge{
		int u, v, w;
		public Edge(int u, int v, int w) {
			this.u = u;
			this.v = v;
			this.w = w;
		}
	}
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		while(true) {
			N = sc.nextInt();
			if(N == 0) break;
		}
	}
}
