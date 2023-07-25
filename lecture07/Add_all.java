package lecture07;

import java.util.PriorityQueue;
import java.util.Scanner;

public class Add_all {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		PriorityQueue<Integer> pq = new PriorityQueue<>();
		while(true) {
			int n = sc.nextInt();
			if(n == 0) {
				return;
			}
			for(int i = 0; i < n; i++) {
				int value = sc.nextInt();
				pq.add(value);
			}
			int ans = 0;
			while(pq.size() > 1) {
				int x = pq.poll();
				int y = pq.poll();
				int sum = x + y;
				ans += sum;
				pq.add(sum);
			}
			System.out.println(ans);
			pq.remove();
		}
	}
}
