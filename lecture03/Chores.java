package lecture03;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.Scanner;

public class Chores {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int a = sc.nextInt();
		int b = sc.nextInt();
		ArrayList<Integer> h = new ArrayList<>();
		for (int i = 0; i < n; i++) {
			h.add(sc.nextInt());
		}
		Collections.sort(h, new Comparator<Integer>() {
			@Override
			public int compare(Integer o1, Integer o2) {
				return o1.compareTo(o2);
			}
		});
		System.out.println(h.get(b) - h.get(b - 1));
	}
}
