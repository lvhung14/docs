package lecture07;

import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Scanner;

public class Roy_and_TrendingTopics {
	static class Topic {
		int id;
		long old_score;
		long new_score;
		long change;

		public Topic(int id, long old_score, long new_score) {
			this.id = id;
			this.old_score = old_score;
			this.new_score = new_score;
			this.change = new_score - old_score;
		}

	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		PriorityQueue<Topic> pq = new PriorityQueue<>(new Comparator<Topic>() {

			public int compare(Topic o1, Topic o2) {
				if(o1.change < o2.change || o1.change == o2.change && o1.id < o2.id) {
					return 1;
				}
				else return -1;
			}
		});
		int N = sc.nextInt();
		for (int i = 0; i < N; i++) {
			int id = sc.nextInt();
			long old_score = sc.nextLong();
			long post = sc.nextLong();
			long like = sc.nextLong();
			long comment = sc.nextLong();
			long share = sc.nextLong();
			long new_score = post * 50 + like * 5 + comment * 10 + share * 20;
			pq.add(new Topic(id, old_score, new_score));
		}
		for(int i = 0; i < 5; i++) {
			Topic t = pq.poll();
			System.out.println(t.id + " " + t.new_score);
		}
	}
}
