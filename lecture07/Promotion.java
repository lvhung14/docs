package lecture07;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Scanner;
import java.util.StringTokenizer;

public class Promotion {
	static class Bills{
		int number;
		int price;
		public Bills(int number, int price) {
			this.number = number;
			this.price = price;
		}
	}
	public static void main(String[] args) {
		MyScanner sc = new MyScanner();
		int n = sc.nextInt();
		long ans = 0;
		int nBills = 0;
		boolean [] taken = new boolean[1000000];
		PriorityQueue<Bills> pq = new PriorityQueue<>(new Comparator<Bills>() {

			@Override
			public int compare(Bills o1, Bills o2) {
				return o1.price - o2.price;
			}
		});
		PriorityQueue<Bills> pq1 = new PriorityQueue<>(new Comparator<Bills>() {

			@Override
			public int compare(Bills o1, Bills o2) {
				return o2.price - o1.price;
			}
		});
		while (n-- > 0) {
			int x = sc.nextInt();
			for(int i = 0; i < x; i++) {
				int price = sc.nextInt();
				nBills++;
				pq.add(new Bills(nBills, price));
				pq1.add(new Bills(nBills, price));
			}
			while(taken[pq.peek().number]) {
				pq.poll();
			}
			while(taken[pq1.peek().number]) {
				pq1.poll();
			}
			taken[pq.peek().number] = taken[pq1.peek().number] = true;
			ans +=  pq1.poll().price - pq.poll().price;
		}
		System.out.println(ans);
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
