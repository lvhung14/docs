package lecture02;

import java.util.ArrayList;
import java.util.Scanner;

public class Sereja_and_Dima {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		ArrayList<Integer> a = new ArrayList<>();
		for (int i = 0; i < n; i++) {
			a.add(sc.nextInt());
		}
		int l = 0, r = n - 1;
		int point1 = 0;
		int point2 = 0;
		boolean p1 = true, p2 = false;
		while (l <= r) {
			if (a.get(l) < a.get(r)) {
				if (p1) {
					point1 += a.get(r);
					p1 = false;
				} else {
					point2 += a.get(r);
					p1 = true;
				}
				r--;
			} else {
				if (p1) {
					point1 += a.get(l);
					p1 = false;
				} else {
					point2 += a.get(l);
					p1 = true;
				}
				l++;
			}

		}
		System.out.println(point1 + " " + point2);
	}
}
