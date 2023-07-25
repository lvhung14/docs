package lecture04;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;
import java.util.Stack;
import static java.lang.Math.*;

public class Ferry_Loading_III {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int c = sc.nextInt();
		int[] answer = new int[10000 + 5];
		while (c-- > 0) {
			Queue<Car>[] qSide = new Queue[2];
			qSide[0] = new LinkedList<>();
			qSide[1] = new LinkedList<>();

			int n = sc.nextInt();
			int t = sc.nextInt();
			int m = sc.nextInt();
			for (int i = 1; i <= m; i++) {
				int x = sc.nextInt();
				String y = sc.next();
				if (y.equals("left")) {
					qSide[0].add(new Car(i, x));
				} else
					qSide[1].add(new Car(i, x));
			}
			int curTime = 0;
			int nextTime = 0;

			int curSide = 0;

			int waiting = ((qSide[0].isEmpty() ? 0 : 1) + (qSide[1].isEmpty() ? 0 : 1));
			while (waiting > 0) {
				if (waiting == 1) {
					nextTime = (qSide[0].isEmpty() ? qSide[1].peek().arrivalTime : qSide[0].peek().arrivalTime);
				} else
					nextTime = min(qSide[0].peek().arrivalTime, qSide[1].peek().arrivalTime);
				curTime = max(curTime, nextTime);
				int vehicle = 1;
				while (!qSide[curSide].isEmpty()) {
					Car car = qSide[curSide].peek();
					if (curTime >= car.arrivalTime && vehicle <= n) {
						answer[car.id] = curTime + t;
						vehicle++;
						qSide[curSide].remove();
					} else
						break;
				}
				curTime += t;
				curSide = 1 - curSide;
				waiting = ((qSide[0].isEmpty() ? 0 : 1) + (qSide[1].isEmpty() ? 0 : 1));
			}
			for (int i = 1; i <= m; i++) {
				System.out.println(answer[i]);
			}

			if (c > 0) {
				System.out.println();
			}
		}

	}
}

class Car {
	int arrivalTime = 0;
	int id = 0;

	Car() {
	}

	Car(int arrivalTime, int id) {
		this.arrivalTime = id;
		this.id = arrivalTime;
	}

	@Override
	public String toString() {
		return "Car [arrivalTime=" + arrivalTime + ", bank=" + id + "]";
	}
}
