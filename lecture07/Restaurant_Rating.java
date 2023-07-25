package lecture07;

import java.util.*;
import java.io.*;

public class Restaurant_Rating {
	public static void main(String[] args) {
		MyScanner sc = new MyScanner();
		PrintWriter out = new PrintWriter(System.out);
		int N = sc.nextInt();
		int nReviews = 0;
		PriorityQueue<Integer> top3 = new PriorityQueue<>();
		PriorityQueue<Integer> rest = new PriorityQueue<>();
		while (N-- > 0) {
			int type = sc.nextInt();
			if (type == 1) {
				int x = sc.nextInt();
				nReviews++;
				if(!top3.isEmpty() && top3.peek() < x) {
					rest.add(-top3.poll());
					top3.add(x);
				} else rest.add(-x);
				if(nReviews % 3 == 0) {
					top3.add(-rest.poll());
				}
			} else {
				if(top3.isEmpty()) {
					out.println("No reviews yet");
				} else {
					out.println(top3.peek());
				}
			}
		}
		out.close();
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
