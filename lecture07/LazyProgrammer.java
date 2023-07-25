package lecture07;

import java.io.*;
import java.util.*;

public class LazyProgrammer {
	static final int MAX = 100005;

	static class Job implements Comparable<Job> {
		int a, b, d;

		public Job() {
			a = b = d = 0;
		}

		@Override
		public int compareTo(Job o) {
			// TODO Auto-generated method stub
			return this.d - o.d;
		}
	}

	public static void main(String[] args) {

		MyScanner sc = new MyScanner();
		int t = sc.nextInt();

		int N;

		while (t-- > 0) {
			PriorityQueue<Job> pq = new PriorityQueue<>(new Comparator<Job>() {

				@Override
				public int compare(Job o1, Job o2) {

					return o2.a - o1.a;
				}
			});
			N = sc.nextInt();
			Job[] job = new Job[MAX];
			for (int i = 0; i < N; i++) {
				job[i] = new Job();
				job[i].a = sc.nextInt();
				job[i].b = sc.nextInt();
				job[i].d = sc.nextInt();
			}
			Arrays.sort(job, 0, N);
			double min_sum = 0;
			int time = 0;
			for (int i = 0; i < N; i++) {
				time += job[i].b;
				pq.add(job[i]);
				while (time > job[i].d) {
					Job top = pq.poll();
					if (top.b > time - job[i].d) {
						min_sum += (time - job[i].d) * 1.0 / top.a;
						top.b -= time - job[i].d;
						pq.add(top);
						time = job[i].d;
					} else {
						min_sum += top.b * 1.0 / top.a;
						time -= top.b;
						top.b = 0;
					}
				}
			}
			System.out.printf("%.2f\n", min_sum);
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
