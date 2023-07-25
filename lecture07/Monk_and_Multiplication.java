package lecture07;

import java.util.PriorityQueue;
import java.util.Scanner;

public class Monk_and_Multiplication {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int x, n = sc.nextInt();
		PriorityQueue<Integer> pq = new PriorityQueue<>();
		for(int i = 0; i < n; i++) {
			x = sc.nextInt();
			pq.add(-x);
			if(pq.size() < 3) {
				System.out.println(-1);
			} else {
				int first = -pq.poll();
				int second = -pq.poll();
				int third = -pq.poll();
				System.out.println(1L * first * second* third);
				pq.add(-first);
				pq.add(-second);
				pq.add(-third);
			}
		}
	}
}
