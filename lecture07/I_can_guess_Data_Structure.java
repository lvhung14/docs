package lecture07;

import java.io.*;
import java.util.*;

public class I_can_guess_Data_Structure {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		Stack<Integer> s = new Stack<>();
		Queue<Integer> q = new LinkedList<>();
		PriorityQueue<Integer> pq = new PriorityQueue<>();
		int isStack, isQueue, isPQ;
		while (sc.hasNext()) {
			int n = sc.nextInt();
			s.clear();
			q.clear();
			pq.clear();
			isStack = isQueue = isPQ = 1;
			for (int i = 0; i < n; i++) {
				int type = sc.nextInt();
				int value = sc.nextInt();
				if (type == 1) {
					s.add(value);
					q.add(value);
					pq.add(-value);
				} else {
					if (s.isEmpty()) {
						isPQ = isStack = isQueue = 0;
						continue;
					}
					if (s.pop() != value) {
						isStack = 0;
					}
					if (q.poll() != value) {
						isQueue = 0;
					}
					if (pq.poll() != -value) {
						isPQ = 0;
					}
				}
			}
			if (isStack + isQueue + isPQ == 0) {
				System.out.println("impossible");
			} else if (isStack + isQueue + isPQ > 1) {
				System.out.println("not sure");
			} else if (isStack == 1) {
				System.out.println("stack");
			} else if (isQueue == 1) {
				System.out.println("queue");
			} else if (isPQ == 1) {
				System.out.println("priority queue");
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
