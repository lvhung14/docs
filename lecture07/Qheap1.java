package lecture07;

import java.util.PriorityQueue;
import java.util.Scanner;

public class Qheap1 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int Q = sc.nextInt();
		PriorityQueue<Integer> pq = new PriorityQueue<>();
		PriorityQueue<Integer> pqRemoved = new PriorityQueue<>();
		for(int i = 0; i < Q; i++) {
			int x = sc.nextInt();
			if(x == 1) {
				int temp = sc.nextInt();
				pq.add(temp);
			} else if(x == 2) {
				int temp = sc.nextInt();
				pqRemoved.add(temp);
			}
			else{
				if(!pqRemoved.isEmpty() && (int)pqRemoved.peek() == (int)pq.peek()) {
					pqRemoved.poll();
					pq.poll();	
				}
				System.out.println(pq.peek());
			}
		}
	}
}
