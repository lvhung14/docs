package lecture04;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Throwing_cards_away_I {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		while (true) {
			int n = sc.nextInt();
			if (n == 0)
				break;
			Queue<Integer> queue = new LinkedList<Integer>();
			for (int i = 1; i <= n; i++) {
				queue.add(i);
			}
			System.out.print("Discarded cards:");
			int count = n;
			while (count != 1) {
				if(count == n) {
					System.out.print(" ");
				}
				if (count != n)
					System.out.print(", ");
				if (!queue.isEmpty()) {
					System.out.print(queue.poll());
					queue.add(queue.poll());
					count--;
				} else
					break;
			}
			if (!queue.isEmpty()) {
				System.out.println("\nRemaining card: " + queue.peek());
			}
		}
	}
}
