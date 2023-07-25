package lecture03;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Scanner;

public class Eight_Point_Sets {
	final static int MAX = (int) 1e6 + 5;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		ArrayList<Point> points = new ArrayList<>();
		ArrayList<Integer> x = new ArrayList<>();
		ArrayList<Integer> y = new ArrayList<>();
		boolean[] check_y = new boolean[MAX];
		boolean[] check_x = new boolean[MAX];
		for (int i = 0; i < 8; i++) {
			int x1 = sc.nextInt(), y1 = sc.nextInt();
			points.add(new Point(x1, y1));

			if (!check_x[x1]) {
				x.add(x1);
				check_x[x1] = true;
			}
			if (!check_y[y1]) {
				y.add(y1);
				check_y[y1] = true;
			}
		}
		if (x.size() != 3 || y.size() != 3) {
			System.out.println("ugly");
			return;
		}
		Collections.sort(x);
		Collections.sort(y);
		Collections.sort(points);
		int count = 0;
		for (int i = 0; i < 3; i++) {
			for (int j = 0; j < 3; j++) {
				if (i == 1 && j == 1) {
					continue;
				}
				if (x.get(i).equals(points.get(count).x) && y.get(j).equals(points.get(count).y)) {
					count++;
				} else {
					System.out.println("ugly");
					return;
				}
			}
		}
		System.out.println("respectable");
	}
}

class Point implements Comparable<Point> {
	Integer x, y;

	public Point(int x, int y) {
		this.x = x;
		this.y = y;
	}

	@Override
	public int compareTo(Point another) {
        if (this.x.equals(another.x)) {
            return this.y.compareTo(another.y);
        }
        return this.x.compareTo(another.x);
	}

}
