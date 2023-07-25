package lecture04;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class That_is_your_Queue {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		Queue<Integer> result = new LinkedList<>();
		while (true) {
			int P = sc.nextInt();
			int C = sc.nextInt();
			if(C == 0 && P == 0) break;
			for (int i = 1; i <= Math.min(C, P); i++) {
				result.add(i);
			}
			int count = 1;
			while (count < C) {
				count++;
				char cmd = sc.next().charAt(0);
				if (cmd == 'N') {
					System.out.println(result.peek());
					result.add(result.poll());
				} else {
					int temp = sc.nextInt();
					result.add(temp);
					int n = result.size();
					for (int i = 0; i < n - 1; i++) {
						if (result.peek() != temp) {
							result.add(result.poll());
						} else result.poll();
					}
					System.out.println(result.peek());
					result.add(result.poll());
				}
			}
			if(!result.isEmpty()) {
				result.clear();
			}
		}
	}
}
