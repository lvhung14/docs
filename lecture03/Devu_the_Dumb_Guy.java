package lecture03;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.Scanner;

public class Devu_the_Dumb_Guy {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int x = sc.nextInt();
		ArrayList<Integer> a = new ArrayList<>();
		for (int i = 0; i < n; i++) {
			a.add(sc.nextInt());
		}
		Collections.sort(a, new Comparator<Integer>() {
			@Override
			public int compare(Integer o1, Integer o2) {
				return o1.compareTo(o2);
			}
		});
		long count = 0;
		for (int i = 0; i < n; i++) {
			count += 1L * x * a.get(i);
			x = Math.max(x - 1, 1);
		}
		System.out.println(count);
	}
}
