package lecture06;

import java.io.BufferedOutputStream;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.Stack;
import java.util.StringTokenizer;

public class Dudu_Service_Maker {
	static int MAX = 10005;
	static int V, E;
	static ArrayList<Integer>[] graph = new ArrayList[MAX];
	static int visited[] = new int[MAX];

	public static boolean DFS(int s) {
		visited[s] = 1;
		for (int v : graph[s]) {
			if (visited[v] == 1) {
				return true;
			} else if (visited[v] == 0) {
				if (DFS(v)) {
					return true;
				}
			}
		}
		visited[s] = 2;
		return false;
	}

	public static void main(String[] args) {
		MyScanner in = new MyScanner();
        PrintWriter out = new PrintWriter(new BufferedOutputStream(System.out), true);
		int Q = in.nextInt();
		while (Q-- > 0) {
			V = in.nextInt();
			E = in.nextInt();
			for (int i = 1; i <= V; i++) {
				graph[i] = new ArrayList<Integer>();
				visited[i] = 0;
			}
			for (int i = 0; i < E; i++) {
				int u = in.nextInt();
				int v = in.nextInt();
				graph[u].add(v);
			}
			boolean isCycle = false;
			for (int i = 1; i <= V; i++) {
				if (visited[i] == 0) {
					isCycle = DFS(i);
					if (isCycle) {
						break;
					}
				}
			}
			System.out.println(isCycle ? "YES" : "NO");
		}
	}
	public static class MyScanner {
        BufferedReader br;
        StringTokenizer st;
 
        public MyScanner() {
            br = new BufferedReader(new InputStreamReader(System.in));
        }
        
        String next() {
            while (st == null || !st.hasMoreElements()) {
                try {
                    st = new StringTokenizer(br.readLine());
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            return st.nextToken();
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
