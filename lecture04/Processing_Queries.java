package lecture04;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Processing_Queries {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int t, d;
		int n = sc.nextInt();
		int b = sc.nextInt();
		long count = 0;
		Queue<Long> queue = new LinkedList<>();
		for(int i = 0; i < n; i++) {
			t = sc.nextInt();
			d = sc.nextInt();
			while(!queue.isEmpty() && queue.peek() <= t) {
				queue.remove();
			}
			if(queue.size() <= b) {
				count = Math.max(count, t) + d;
				System.out.format("%d ", count);
				queue.add(count);
			}
			else System.out.print("-1 ");
		}
	}
}
